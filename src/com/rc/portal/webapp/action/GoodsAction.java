package com.rc.portal.webapp.action;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.rc.app.framework.webapp.action.BaseAction;
import com.rc.portal.service.ICartManager;
import com.rc.portal.service.OpenSqlManage;
import com.rc.portal.service.TCustomerCallManager;
import com.rc.portal.service.TGoodsManager;
import com.rc.portal.service.TPromItemManager;
import com.rc.portal.service.TSysParameterManager;
import com.rc.portal.vo.TCustomerCall;
import com.rc.portal.vo.TGoods;
import com.rc.portal.vo.TGoodsExtendWithBLOBs;
import com.rc.portal.vo.TGoodsImages;
import com.rc.portal.vo.TMember;
import com.rc.portal.vo.TPromItem;
import com.rc.portal.vo.TPromItemExample;
import com.rc.portal.vo.TPromotion;
import com.rc.portal.webapp.model.GoodsFormBeanModel;
import com.rc.portal.webapp.model.GoodsGroupModel;
import com.rc.portal.webapp.model.GoodsPremiumsModel;

@SuppressWarnings("unchecked")
public class GoodsAction  extends BaseAction 
{
	private static final long serialVersionUID = 1L;
	private TGoodsManager tgoodsmanager;
	//图片集合
	private List<TGoodsImages> listi;
	
	//赠品集合
	private List<GoodsPremiumsModel> listp;
	
	//组合商品集合
	private List<GoodsGroupModel> listg;
	
	//规格
	private List<Map<Long,String>> lists;
	
	//规格
	private List<Map<String,String>> listpc;
	
	//商品扩展
	private TGoodsExtendWithBLOBs goodse;
	
	//组合商品主商品id
	private String goodsgidsm;
	private GoodsFormBeanModel goodsf = new GoodsFormBeanModel();
	private OpenSqlManage opensqlmanage;
	Map<String, Object> goods =new HashMap<String, Object>();
	private TCustomerCallManager tcustomercallmanager;
	private TSysParameterManager tsysparametermanager;
	private ICartManager cartmanager;
	private TPromItemManager tpromitemmanager;
	
	//请求添加电话
	public void saveCall() throws SQLException 
	{
		ReturnData returnData = new ReturnData();
		String call = this.getRequest().getParameter("call");
		String goodsId = this.getRequest().getParameter("goodsId");
		TMember tMember = (TMember) this.getSession().getAttribute("member");
		if (tMember == null) 
		{
			returnData.setMessage("请先登录!");
			returnData.setStatus(0);
			this.writeObjectToResponse(returnData, ContentType.application_json);
			return;
		}
		if (call == null || "".equals(call.trim())) 
		{
			returnData.setMessage("请输入电话号码!");
			returnData.setStatus(0);
			this.writeObjectToResponse(returnData, ContentType.application_json);
			return;
		}
		TCustomerCall record = new TCustomerCall();
		record.setGoodsId(Long.parseLong(goodsId));
		record.setPhoneNumber(call);
		record.setCallStatus(0);
		record.setCreateTime(new Date());
		tcustomercallmanager.insertSelective(record);
		returnData.setStatus(1);
		this.writeObjectToResponse(returnData, ContentType.application_json);
	}

	//普通商品详情
	public String gn() throws Exception
	{
		String id = getRequest().getParameter("id");
		/**
		 * 1:PC
		 * 2:IOS
		 * 3:Android
		 */
		String type = "1";
		if(StringUtils.hasText(id))
		{
			goods.put("id", id);
			goods = tgoodsmanager.selectByPrimaryKey1(Long.parseLong(id),type);
			listi = (List<TGoodsImages>) goods.get("listi");
			listg = (List<GoodsGroupModel>) goods.get("listg");
			lists = (List<Map<Long, String>>) goods.get("lists");
			listpc = (List<Map<String, String>>) goods.get("listpc");
		}
		return "pc_goods_detail";
	}
	
	//处方药商品详情
	public String rx() throws Exception
	{
		String id = getRequest().getParameter("id");
		/**
		 * 1:PC
		 * 2:IOS
		 * 3:Android
		 */
		String type = "1";
		if(StringUtils.hasText(id))
		{
			goods.put("id", id);
			goods = tgoodsmanager.selectByPrimaryKey1(Long.parseLong(id),type);
			listi = (List<TGoodsImages>) goods.get("listi");
			//套餐
			listg = (List<GoodsGroupModel>) goods.get("listg");
			lists = (List<Map<Long, String>>) goods.get("lists");
			listpc = (List<Map<String, String>>) goods.get("listpc");
		}
		return "rx";
	}
	
	//异步获取商品相关信息
	public void getGoodsInfo() throws Exception
	{
		String id = getRequest().getParameter("id");
		if(StringUtils.hasText(id))
		{
		    TGoods goods = tgoodsmanager.selectByPrimaryKey(Long.parseLong(id));
		    Map<String, Object> map = new HashMap<String, Object>();
		    map.put("obj", goods);
		    Map<String, Object> valmap = new HashMap<String, Object>();
		    BigDecimal pcPrice = new BigDecimal(0);
		    if(null!=goods.getPromotionId())
		    {
	    		valmap.put("id", goods.getPromotionId());
	    		Map<String,Object> mm = (Map<String, Object>) opensqlmanage.selectForObjectByMap(valmap, "t_goods.selectPromotionByMap");
	    		map.put("promotion", mm==null?"":(String)mm.get("name"));
	    		map.put("advertise", mm==null?"":(String)mm.get("advertise"));
	    		if(null!=mm)
	    		{
	    			int type = (Integer)mm.get("type");
	    			if(1==type)
	    			{
	    				TPromItemExample example = new TPromItemExample();
	    				example.createCriteria().andTargetIdEqualTo(Long.parseLong(id)).andPidEqualTo(goods.getPromotionId());
	    				List<TPromItem> list = tpromitemmanager.selectByExample(example);
	    				if(null!=list&&0<list.size())
	    				{
	    					TPromItem tpi = list.get(0);
	    					pcPrice = tpi.getPrice();
	    				}
	    			}
	    		}
	    	}
		    else 
		    {
	    		TPromotion tp = cartmanager.getPromByGoods(Long.parseLong(id));
	    		if(null!=tp)
	    		{
	    			if(tp.getType()==3)
	    			{
	    				map.put("promotion", tp.getName());
	    	    		map.put("advertise", tp.getAdvertise());
	    			}
	    		}
			}
		    valmap.clear();
		    valmap.put("goodsno", goods.getGoodsno());
		    Map<String,Object> ykt = (Map<String, Object>) opensqlmanage.selectForObjectByMap(valmap, "t_goods.selectyktByMap");
		    if(null!=ykt)
		    {
		    	Long ids = (Long)ykt.get("id");
	    		map.put("ykt", ids==null?"0":"1");
		    }
		    else 
		    {
		    	map.put("ykt", "0");
			}
		    String yf = tsysparametermanager.getKeys("free_shippingfee_price");
		    map.put("yf", yf==null||yf==""?"":yf);
		    map.put("pcPrice", pcPrice);
		    writeObjectToResponse(map, ContentType.application_json);
		}
	}
	
	//获取商品详细信息
	public void getGoodsDetail()
	{
		Map<String,Object> result = new HashMap<String, Object>();
		String id = getRequest().getParameter("id");
		if(StringUtils.hasText(id))
		{
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("id", id);
			Map<String,Object> obj = (Map<String, Object>) opensqlmanage.selectForObjectByMap(map, "t_goods.selectyGoodsInfos");
			result.put("pcPrice", obj.get("pcPrice")+"");
			result.put("ykt", obj.get("nykt")+"");
			result.put("stock", obj.get("stock")+"");
			result.put("pc_status", obj.get("pc_status")+"");
		}
		writeObjectToResponse(result, ContentType.application_json);
	}
	
	public TGoodsManager getTgoodsmanager() 
	{
		return tgoodsmanager;
	}


	public void setTgoodsmanager(TGoodsManager tgoodsmanager) 
	{
		this.tgoodsmanager = tgoodsmanager;
	}


	public List<TGoodsImages> getListi() 
	{
		return listi;
	}


	public void setListi(List<TGoodsImages> listi) {
		this.listi = listi;
	}


	public List<GoodsPremiumsModel> getListp() 
	{
		return listp;
	}


	public void setListp(List<GoodsPremiumsModel> listp)
	{
		this.listp = listp;
	}

	public TGoodsExtendWithBLOBs getGoodse() {
		return goodse;
	}


	public void setGoodse(TGoodsExtendWithBLOBs goodse) 
	{
		this.goodse = goodse;
	}


	public String getGoodsgidsm() 
	{
		return goodsgidsm;
	}


	public void setGoodsgidsm(String goodsgidsm) 
	{
		this.goodsgidsm = goodsgidsm;
	}

	public GoodsFormBeanModel getGoodsf() 
	{
		return goodsf;
	}


	public void setGoodsf(GoodsFormBeanModel goodsf) 
	{
		this.goodsf = goodsf;
	}


	public List<Map<Long, String>> getLists() 
	{
		return lists;
	}


	public void setLists(List<Map<Long, String>> lists) 
	{
		this.lists = lists;
	}

	public List<GoodsGroupModel> getListg() 
	{
		return listg;
	}


	public void setListg(List<GoodsGroupModel> listg) 
	{
		this.listg = listg;
	}
	public List<Map<String, String>> getListpc() 
	{
		return listpc;
	}
	public void setListpc(List<Map<String, String>> listpc) 
	{
		this.listpc = listpc;
	}

	public Map<String, Object> getGoods() 
	{
		return goods;
	}

	public void setGoods(Map<String, Object> goods) 
	{
		this.goods = goods;
	}

	@Override
	public Object getModel() 
	{
		return null;
	}

	public OpenSqlManage getOpensqlmanage() 
	{
		return opensqlmanage;
	}

	public void setOpensqlmanage(OpenSqlManage opensqlmanage)
	{
		this.opensqlmanage = opensqlmanage;
	}

	public TCustomerCallManager getTcustomercallmanager()
	{
		return tcustomercallmanager;
	}
	public void setTcustomercallmanager(TCustomerCallManager tcustomercallmanager)
	{
		this.tcustomercallmanager = tcustomercallmanager;
	}
	@Override
	public void setModel(Object o)
	{
	}
	
	public TSysParameterManager getTsysparametermanager()
	{
		return tsysparametermanager;
	}
	public void setTsysparametermanager(TSysParameterManager tsysparametermanager)
	{
		this.tsysparametermanager = tsysparametermanager;
	}

	public ICartManager getCartmanager()
	{
		return cartmanager;
	}
	public void setCartmanager(ICartManager cartmanager)
	{
		this.cartmanager = cartmanager;
	}

	public TPromItemManager getTpromitemmanager()
	{
		return tpromitemmanager;
	}
	
	public void setTpromitemmanager(TPromItemManager tpromitemmanager)
	{
		this.tpromitemmanager = tpromitemmanager;
	}

	//内部类
	class ReturnData
	{
		private int status;
		private String message;

		public int getStatus()
		{
			return status;
		}

		public void setStatus(int status)
		{
			this.status = status;
		}

		public String getMessage()
		{
			return message;
		}

		public void setMessage(String message) 
		{
			this.message = message;
		}
	}
}
