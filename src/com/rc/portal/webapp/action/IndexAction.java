package com.rc.portal.webapp.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.util.StringUtils;

import com.rc.app.framework.webapp.action.BaseAction;
import com.rc.dst.client.util.ClientSubmitPublic;
import com.rc.portal.service.OpenSqlManage;
import com.rc.portal.service.TMemberBaseMessageExtManager;
import com.rc.portal.service.TMemberCollectManager;
import com.rc.portal.service.TSysParameterManager;
import com.rc.portal.vo.TMember;
import com.rc.portal.vo.TMemberBaseMessageExt;
import com.rc.portal.vo.TMemberCollect;

/**
 * 首页异步调用控制器
 * @author LGP
 * @date 2015年8月19日
 */
@SuppressWarnings("unchecked")
public class IndexAction extends BaseAction 
{
	private static final long serialVersionUID = 5294821245374431258L;
	private OpenSqlManage opensqlmanage;
	private TMemberCollectManager tmembercollectmanager;
	private TMemberCollect tMemberCollect;
	private TSysParameterManager tsysparametermanager;
	private TMemberBaseMessageExtManager tmemberbasemessageextmanager;
	
	/**
	 * 最新评论
	 */
	public void newcomment() throws IOException, SQLException
	{
		List<Map<String, Object>> datas = opensqlmanage.selectForListByMap(null, "t_goods_comment.selectNewCommentListByMap");
		writeObjectToResponse(datas, ContentType.application_json);
	}
	
	/**
	 * 最新咨询
	 */
	public void newconsult() throws IOException, SQLException
	{
		this.getResponse().setContentType("text/html; charset=utf-8");
		this.getRequest().setCharacterEncoding("utf-8");
		List<Map<String, Object>> datas = opensqlmanage.selectForListByMap(new HashMap<String, Object>(), "t_goods_consult.selectNewConsultListByMap");
		if(datas != null && datas.size() > 0)
		{
			JSONArray jsons = JSONArray.fromObject(datas);
			reJSON(jsons.toString(), this.getRequest(), this.getResponse());
		}
	}
	
	/**
	 * 推荐商品
	 */
	public void recommendpro() throws IOException, SQLException
	{
		Map<String,Object> map = new HashMap<String, Object>();
		TMember tm = (TMember)this.getRequest().getSession().getAttribute("member");
		if(tm != null)
		{
			map.put("memberId", tm.getId());
		}
		writeObjectToResponse(opensqlmanage.selectForListByMap(map, "t_goods.selectreconmendProListMap"), ContentType.application_json);
	}
	
	/**
	 * Getting goods's shortname for searching keyword
	 */
	public void getshortname() throws IOException, SQLException
	{
		String shortname = getRequest().getParameter("shortname");
		Map<String,Object> map = new HashMap<String, Object>();
		List<Object> rs = new ArrayList<Object>();
		if(StringUtils.hasText(shortname))
		{
			map.put("shortname", java.net.URLDecoder.decode(shortname, "utf-8"));
			List<Map<String,Object>> datas = opensqlmanage.selectForListByMap(map, "t_goods.selectSearchListMap");
			for(Map<String,Object> m : datas)
			{
				rs.add(m.get("short_name"));
			}
		}
		writeObjectToResponse(rs, ContentType.application_json);
	}
	
	/**
	 * 关注、取消商品
	 */
	public void attentionpro() throws NumberFormatException, SQLException, IOException
	{
		//商品ID
		String proid = this.getRequest().getParameter("proid");
		//收藏类型
		String ctype = this.getRequest().getParameter("ctype");
		
		if(proid != null && !proid.trim().equals(""))
		{
			//获取用户对象
			TMember tm = (TMember)this.getRequest().getSession().getAttribute("member");
			if(tm != null)
			{
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("relevance_id", proid);
				map.put("collect_type", ctype);
				map.put("member_id", tm.getId());
				List<Map<String, Object>> datas = opensqlmanage.selectForListByMap(map, "t_member_collect.selectTmcollectListMap");
				//取消关注
				if(datas != null && datas.size() > 0)
				{
					tmembercollectmanager.deleteByPrimaryKey(Long.parseLong(String.valueOf(datas.get(0).get("id"))));
					this.writeObjectToResponse("0", ContentType.application_json);
				}
				//继续关注
				else
				{
					TMemberCollect tct = new TMemberCollect();
					tct.setCreateDate(new Date());
					tct.setMemberId(tm.getId());
					tct.setCollectType(0);
					tct.setRelevanceId(Long.valueOf(proid));
					tmembercollectmanager.insert(tct);
					this.writeObjectToResponse("1", ContentType.application_json);
				}
			}
		}
		else
		{
			this.writeObjectToResponse("2", ContentType.application_json);
		}
	}
	
	/**
	 * Juding the attention about user
	 */
	public void isuserattentioned() throws NumberFormatException, SQLException, IOException
	{
		String proid = this.getRequest().getParameter("proid");
		String ctype = this.getRequest().getParameter("ctype");
		if(proid != null && !proid.trim().equals(""))
		{
			TMember tm = (TMember)this.getRequest().getSession().getAttribute("member");
			if(tm != null)
			{
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("relevance_id", proid);
				map.put("collect_type", ctype);
				map.put("member_id", tm.getId());
				List<Map<String, Object>> datas = opensqlmanage.selectForListByMap(map, "t_member_collect.selectTmcollectListMap");
				if(datas != null && datas.size() > 0)
				{
					this.writeObjectToResponse("0", ContentType.application_json);
				}
				else
				{
					this.writeObjectToResponse("1", ContentType.application_json);
				}
			}
			else
			{
				this.writeObjectToResponse("2", ContentType.application_json);
			}
		}
		else
		{
			this.writeObjectToResponse("3", ContentType.application_json);
		}
	}
	
	/**
	 * 热销商品/按产品的销量倒序排列
	 */
	public void hotpros() throws IOException, SQLException
	{
		List<Map<String, Object>> datas = opensqlmanage.selectForListByMap(null, "t_goods.selectHotsProListMap2");
		writeObjectToResponse(datas, ContentType.application_json);
	}
	
	/**
	 * checking the status of user's login
	 */
	public void clogin() throws Exception
	{
		this.getResponse().setContentType("text/html; charset=utf-8");
		this.getRequest().setCharacterEncoding("utf-8");
		PrintWriter out = this.getResponse().getWriter();
		TMember tm = (TMember)this.getRequest().getSession().getAttribute("member");
		if(tm != null)
		{
			/** the user is logined */
			out.println(1);
		}
		else
		{
			/** the user is logouted */
			out.println(2);
		}
		out.flush();
		out.close();
	}
	
	@Override
	public Object getModel() 
	{
		return null;
	}
	@Override
	public void setModel(Object o) 
	{
	}
	public OpenSqlManage getOpensqlmanage()
	{
		return opensqlmanage;
	}
	public void setOpensqlmanage(OpenSqlManage opensqlmanage)
	{
		this.opensqlmanage = opensqlmanage;
	}

	/**
	 * 给客户端返回JSON数据
	 */
	public void reJSON(String txt,ServletRequest request,ServletResponse response) throws IOException
	{
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = null;
		out = response.getWriter();		
		out.print(txt);
		out.flush();
		out.close();
	}
	
	/**
	 * 其它平台获取商品价格
	 */
	public void countpricebyplatform() throws IOException
	{
		long start = System.currentTimeMillis();
		System.out.println("开始时间：："+start);
		getResponse().setCharacterEncoding("utf-8");
		PrintWriter out =  getResponse().getWriter();
		
		//解析JSONP参数组
		String jsoncallback = getRequest().getParameter("jsoncallback");
		String params = getRequest().getParameter("params");
		JSONArray jsonarray = JSONArray.fromObject(params);
		List<Map<String,Object>> paramsarray =  (List<Map<String, Object>>) JSONArray.toCollection(jsonarray, Map.class);
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		
		if(paramsarray != null)
		{
			for(Map<String, Object> m : paramsarray)
			{
				//商品ID
				String goodsId = String.valueOf(m.get("goodsId"));
				//平台
				String platform = String.valueOf(m.get("platform"));
				//HTML元素ID
				String htmlObjId = String.valueOf(m.get("htmlObjId"));
				
				Map<String, Object> nowDatas = null;
				Map<String, Object> map = new HashMap<String, Object>();
				try 
				{
					Map<String, Object> p = new HashMap<String, Object>();
					p.put("id", goodsId);
					nowDatas = (Map<String, Object>) opensqlmanage.selectForListByMap(p, "t_goods.selectGoodsPriceById").get(0);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
				if(nowDatas != null)
				{
					String price = null;
					if(platform.equals("1"))
					{
						price = String.valueOf(nowDatas.get("pc_price"));
					}
					if(platform.equals("2"))
					{
						price = String.valueOf(nowDatas.get("wap_price"));
					}
					if(platform.equals("3"))
					{
						price = String.valueOf(nowDatas.get("app_price"));
					}
					map.put("goodsId", goodsId);
					map.put("nowPrice", price);
					map.put("platform", platform);
					map.put("htmlObjId", htmlObjId);
					result.add(map);
				}
				else
				{
					result.add(m);
				}
			}
			out.println(jsoncallback+"("+JSONArray.fromObject(result)+");");
		}
		else
		{
			out.println(jsoncallback+"([{error:'0'}]);");
		}
		out.flush();
		out.close();
		long end = System.currentTimeMillis();
		System.out.println("消耗时间：：：："+(end-start));
	}
	
	/**
	 * PC平台获取商品价格
	 */
	public void countpricefrompc() throws IOException
	{
		long start = System.currentTimeMillis();
		System.out.println("开始时间：："+start);
		//解析参数组
		String params = getRequest().getParameter("params");
		JSONArray jsonarray = JSONArray.fromObject(params);
		List<Map<String,Object>> paramsarray =  (List<Map<String, Object>>) JSONArray.toCollection(jsonarray, Map.class);
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		
		if(paramsarray != null)
		{
			for(Map<String, Object> m : paramsarray)
			{
				//商品ID
				String goodsId = String.valueOf(m.get("goodsId"));
				//平台
				String platform = String.valueOf(m.get("platform")).trim();
				//HTML元素ID
				String htmlObjId = String.valueOf(m.get("htmlObjId"));
				
				Map<String, Object> nowDatas = null;
				Map<String, Object> map = new HashMap<String, Object>();
				try 
				{
					Map<String, Object> p = new HashMap<String, Object>();
					p.put("id", goodsId);
					nowDatas = (Map<String, Object>) opensqlmanage.selectForListByMap(p, "t_goods.selectGoodsPriceById").get(0);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
				
				if(nowDatas != null)
				{
					String price = null;
					if(platform.equals("1"))
					{
						price = String.valueOf(nowDatas.get("pc_price"));
					}
					if(platform.equals("2"))
					{
						price = String.valueOf(nowDatas.get("wap_price"));
					}
					if(platform.equals("3"))
					{
						price = String.valueOf(nowDatas.get("app_price"));
					}
					map.put("goodsId", goodsId);
					map.put("nowPrice", price);
					map.put("platform", platform);
					map.put("htmlObjId", htmlObjId);
					result.add(map);
				}
				else
				{
					result.add(m);
				}
			}
			writeObjectToResponse(result, ContentType.application_json);
		}
		else
		{
			writeObjectToResponse("params null", ContentType.application_json);
		}
		long end = System.currentTimeMillis();
		System.out.println("消耗时间：：：："+(end-start));
	}

	/**
	 * 首页加载时获取优惠券列表
	 * @throws SQLException 
	 */
	public void getCouponList() throws SQLException
	{
		String reqUrl = tsysparametermanager.getKeys("public_service_url");
		String resultJsonstr = null;
		String result = null;
        Map<String, String> publicMap = new HashMap<String, String>();
        TMember tm = (TMember)this.getRequest().getSession().getAttribute("member");
        if(tm != null)
        {
        	publicMap.put("member_id", String.valueOf(tm.getId()));
        }
		try
		{
			resultJsonstr = ClientSubmitPublic.getPublicService(publicMap, reqUrl+"couponListService");
			JSONObject jsonObject = JSONObject.fromObject(resultJsonstr);
			if(null != jsonObject)
			{
				result = jsonObject.get("list").toString();
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		System.out.println(result);
		writeObjectToResponse(result, ContentType.application_json);
	}
	
	//动态获取商品价格
	public void getPriceDynamic() throws IOException
	{
		long start = System.currentTimeMillis();
		System.out.println("开始时间：："+start);
		getResponse().setCharacterEncoding("utf-8");
		PrintWriter out =  getResponse().getWriter();
		
		//解析JSONP参数组
		String jsoncallback = getRequest().getParameter("jsoncallback");
		String params = getRequest().getParameter("params");
		JSONArray jsonarray = JSONArray.fromObject(params);
		List<Map<String,Object>> paramsarray =  (List<Map<String, Object>>) JSONArray.toCollection(jsonarray, Map.class);
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		
		if(paramsarray != null)
		{
			for(Map<String, Object> m : paramsarray)
			{
				//商品ID
				String goodsId = String.valueOf(m.get("goodsId"));
				//平台
				String platform = String.valueOf(m.get("platform"));
				
				Map<String, Object> nowDatas = null;
				Map<String, Object> map = new HashMap<String, Object>();
				try 
				{
					Map<String, Object> p = new HashMap<String, Object>();
					p.put("id", goodsId);
					nowDatas = (Map<String, Object>) opensqlmanage.selectForListByMap(p, "t_goods.selectGoodsPriceById").get(0);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
				if(nowDatas != null)
				{
					String price = null;
					if(platform.equals("1"))
					{
						price = String.valueOf(nowDatas.get("pc_price"));
					}
					if(platform.equals("2"))
					{
						price = String.valueOf(nowDatas.get("wap_price"));
					}
					if(platform.equals("3"))
					{
						price = String.valueOf(nowDatas.get("app_price"));
					}
					map.put("goodsId", goodsId);
					map.put("nowPrice", price);
					result.add(map);
				}
				else
				{
					result.add(m);
				}
			}
			out.println(jsoncallback+"("+JSONArray.fromObject(result)+");");
		}
		else
		{
			out.println(jsoncallback+"([{error:'0'}]);");
		}
		out.flush();
		out.close();
		long end = System.currentTimeMillis();
		System.out.println("消耗时间：：：："+(end-start));
	}
	
	//根据商品ID判断库存
	public void isStockNotNull()
	{
		String id = getRequest().getParameter("id");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		List<Map<String, Object>> datas = opensqlmanage.selectForListByMap(map, "t_goods.jugeStock");
		if(datas != null && datas.size() > 0)
		{
			String result = String.valueOf(datas.get(0).get("stock"));
			int newResult = 0;
			if(result.equals("1"))
			{
				newResult = 1;
			}
			writeObjectToResponse(newResult, ContentType.application_json);
		}
		else
		{
			writeObjectToResponse(0, ContentType.application_json);
		}
	}
	
	//根据商品ID判断库存、上下架状态
	public void jugeStatus()
	{
		String id = getRequest().getParameter("id");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		List<Map<String, Object>> datas = opensqlmanage.selectForListByMap(map, "t_goods.jugeStatus");
		if(datas != null && datas.size() > 0)
		{
			String result = String.valueOf(datas.get(0).get("pcstatus"));
			int newResult = 0;
			//上架
			if(result.equals("1"))
			{
				newResult = 1;
				String stock = String.valueOf(datas.get(0).get("stock"));
				//有库存
				if(stock.equals("3"))
				{
					newResult = 3;
				}
				//无库存
				else
				{
					newResult = 4;
				}
			}
			//下架
			else
			{
				newResult = 2;
			}
			writeObjectToResponse(newResult, ContentType.application_json);
		}
		else
		{
			writeObjectToResponse(0, ContentType.application_json);
		}
	}
	
	//获取已登录用户名
	public void getMemberUserName() throws SQLException
	{
		TMember tm = (TMember)this.getRequest().getSession().getAttribute("member");
		if(tm != null)
		{
			TMemberBaseMessageExt tmbme = tmemberbasemessageextmanager.selectByPrimaryKey(tm.getId());
			Map<String, Object> map = new HashMap<String, Object>();
			String headUrl = tm.getHeadPortrait();
			String disPlayName = "";
			String nickName = null;
			String realName = null;
			if(tmbme != null)
			{
				nickName = tmbme.getNickName();
				realName = tmbme.getRealName();
			}
			String userName = tm.getUserName();
			String mobile = tm.getMobile();
			if(nickName != null && !nickName.equals(""))
			{
				disPlayName = nickName;
			}
			else
			{
				if(userName != null && !userName.equals(""))
				{
					disPlayName = userName;
				}
				else
				{
					if(mobile != null && !mobile.equals(""))
					{
						disPlayName = mobile;
					}
					else
					{
						if(realName != null && !realName.equals(""))
						{
							disPlayName = realName;
						}
					}
				}
			}
			map.put("disPlayName", disPlayName);
			map.put("headUrl", headUrl);
			writeObjectToResponse(map, ContentType.application_json);
		}
		else
		{
			writeObjectToResponse(0, ContentType.application_json);
		}
	}
	
	public void getMemberId()
	{
		TMember tm = (TMember)this.getRequest().getSession().getAttribute("member");
		Long id = 0L;
		if(tm != null)
		{
			id = tm.getId();
		}
		writeObjectToResponse(id, ContentType.application_json);
	}
	
	public TMemberCollectManager getTmembercollectmanager()
	{
		return tmembercollectmanager;
	}

	public void setTmembercollectmanager(TMemberCollectManager tmembercollectmanager)
	{
		this.tmembercollectmanager = tmembercollectmanager;
	}

	public TMemberCollect gettMemberCollect()
	{
		return tMemberCollect;
	}

	public void settMemberCollect(TMemberCollect tMemberCollect)
	{
		this.tMemberCollect = tMemberCollect;
	}

	public TSysParameterManager getTsysparametermanager() {
		return tsysparametermanager;
	}

	public void setTsysparametermanager(TSysParameterManager tsysparametermanager) {
		this.tsysparametermanager = tsysparametermanager;
	}

	public TMemberBaseMessageExtManager getTmemberbasemessageextmanager() {
		return tmemberbasemessageextmanager;
	}

	public void setTmemberbasemessageextmanager(
			TMemberBaseMessageExtManager tmemberbasemessageextmanager) {
		this.tmemberbasemessageextmanager = tmemberbasemessageextmanager;
	}
	
}
