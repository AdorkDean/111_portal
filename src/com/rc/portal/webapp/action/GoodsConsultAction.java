package com.rc.portal.webapp.action;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.action.BaseAction;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.portal.service.OpenSqlManage;
import com.rc.portal.service.TGoodsConsultManager;
import com.rc.portal.service.TGoodsManager;
import com.rc.portal.service.TMemberManager;
import com.rc.portal.vo.TGoods;
import com.rc.portal.vo.TGoodsConsult;
import com.rc.portal.vo.TGoodsConsultExample;
import com.rc.portal.vo.TMember;
import com.rc.portal.webapp.util.PageResult;

/**
 * 商品咨询(前台action)
 * @author user00 && LGP
 * @createTime 2015-8-17 上午11:07:23
 */
public class GoodsConsultAction extends BaseAction
{
	private static final long serialVersionUID = 5294821245374431258L;
	private OpenSqlManage opensqlmanage;
	private PageWraper pw = new PageWraper();
	private PageResult rs = new PageResult();
	private TGoodsConsultManager tgoodsconsultmanager;
	private TGoodsManager tgoodsmanager;
	private TMemberManager tmembermanager;
	private TGoodsConsult tGoodsConsult;
	private TMember tMember;
	private TGoods tGoods;
	private String userName;
	private String consultContent;

	//我的咨询列表
	public String myGoodsConsultPage() 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		TMember tMember = (TMember) this.getSession().getAttribute("member");
		if (tMember == null) 
		{
			return ERROR;
		}
		Long memberId = tMember.getId();
		map.put("memberId", memberId);
		rs.setP_pageSize(5);
		pw = opensqlmanage.selectForPageByMap(map, "t_goods_consult.selectCountByMap","t_goods_consult.selectListByMap", rs.getP_curPage(), rs.getP_pageSize());
		return "my_goods_consult_page";
	}

	//删除
	public void delGoodsConsult() throws NumberFormatException, SQLException 
	{
		String id = this.getRequest().getParameter("id");
		ReturnData returnData = new ReturnData();
		if (id == null || "".equals(id.trim())) 
		{
			returnData.setStatus(0);
			returnData.setMessage("请选择正确的咨询数据!");
			this.getResponse().setCharacterEncoding("UTF-8");
		} 
		else 
		{
			tGoodsConsult = tgoodsconsultmanager.selectByPrimaryKey(Long.valueOf(id));
			if (tGoodsConsult == null) 
			{
				returnData.setStatus(0);
				returnData.setMessage("您选择的咨询数据不存在,请确认!");
			} 
			else 
			{
				tgoodsconsultmanager.deleteByPrimaryKey(Long.valueOf(id));
				returnData.setStatus(1);
				returnData.setMessage("删除成功!");
			}
		}
		this.writeObjectToResponse(returnData, ContentType.application_json);
	}

	//请求添加咨询
	@SuppressWarnings("unchecked")
	public void saveGoodsConsult() throws SQLException 
	{
		ReturnData returnData = new ReturnData();
		String consultContent = this.getRequest().getParameter("consultContent");
		String goodsId = this.getRequest().getParameter("goodsId");
		tMember = (TMember) this.getSession().getAttribute("member");
		if (tMember == null) 
		{
			returnData.setMessage("请先登录!");
			returnData.setStatus(0);
			this.writeObjectToResponse(returnData, ContentType.application_json);
			return;
		}
		Long memberId = tMember.getId();
		if (consultContent == null || "".equals(consultContent.trim())) 
		{
			returnData.setMessage("请输入咨询信息!");
			returnData.setStatus(2);
			this.writeObjectToResponse(returnData, ContentType.application_json);
			return;
		}
		TGoodsConsultExample _tGoodsConsultExample = new TGoodsConsultExample();
		_tGoodsConsultExample.createCriteria().andMemberIdEqualTo(memberId).andGoodsIdEqualTo(Long.valueOf(goodsId));
		List<TGoodsConsult> _list = tgoodsconsultmanager.selectByExample(_tGoodsConsultExample);
		if (_list != null && _list.size() > 0) 
		{
			returnData.setMessage("您已咨询过该商品!");
			returnData.setStatus(3);
			this.writeObjectToResponse(returnData, ContentType.application_json);
			return;
		}

		TGoodsConsult tGoodsConsult = new TGoodsConsult();
		tGoodsConsult.setConsultContent(consultContent.trim());
		tGoodsConsult.setCreateDate(new Date());
		tGoodsConsult.setGoodsId(goodsId == null ? null : Long.valueOf(goodsId));
		tGoodsConsult.setIsShow(0);//默认不显示
		tGoodsConsult.setMemberId(memberId);
		tgoodsconsultmanager.insertSelective(tGoodsConsult);
		returnData.setMessage("保存成功");
		returnData.setStatus(1);
		this.writeObjectToResponse(returnData, ContentType.application_json);
	}

	//请求是否咨询过该商品
	@SuppressWarnings("unchecked")
	public void ifConsultGoods() throws SQLException 
	{
		ReturnData returnData = new ReturnData();
		String goodsId = this.getRequest().getParameter("goodsId");
		tMember = (TMember) this.getSession().getAttribute("member");
		if (tMember == null) 
		{
			returnData.setMessage("请先登录!");
			returnData.setStatus(0);
			this.writeObjectToResponse(returnData, ContentType.application_json);
			return;
		}
		if (goodsId == null || "".equals(goodsId)) 
		{
			returnData.setMessage("请选择正确商品信息!");
			returnData.setStatus(0);
			this.writeObjectToResponse(returnData, ContentType.application_json);
			return;
		}
		Long memberId = tMember.getId();
		TGoodsConsultExample _tGoodsConsultExample = new TGoodsConsultExample();
		_tGoodsConsultExample.createCriteria().andMemberIdEqualTo(memberId).andGoodsIdEqualTo(Long.valueOf(goodsId));
		List<TGoodsConsult> _list = tgoodsconsultmanager.selectByExample(_tGoodsConsultExample);
		if (_list != null && _list.size() > 0) 
		{
			returnData.setMessage("您已咨询过该商品!");
			returnData.setStatus(0);
			this.writeObjectToResponse(returnData, ContentType.application_json);
			return;
		} 
		else 
		{
			returnData.setMessage("您未咨询过该商品!");
			returnData.setStatus(1);
			this.writeObjectToResponse(returnData, ContentType.application_json);
			return;
		}
	}
	
	
	//判断是否登录
	public void ifLogin()
	{
		ReturnData returnData = new ReturnData();
		tMember = (TMember) this.getSession().getAttribute("member");
		if (tMember == null) 
		{
			returnData.setMessage("请先登录!");
			returnData.setStatus(0);
			this.writeObjectToResponse(returnData, ContentType.application_json);
		}
		else
		{
			returnData.setMessage("");
			returnData.setStatus(1);
			this.writeObjectToResponse(returnData, ContentType.application_json);
		}
	}

	//单个商品的咨询信息
	public String goodsConsultPage() throws Exception 
	{
		String goodsId = this.getRequest().getParameter("goodsId");
		Map<String, Object> map = new HashMap<String, Object>();
		if (goodsId == null || "".equals(goodsId)) 
		{
			throw new Exception("商品ID不能为空");
		} 
		else 
		{
			map.put("goodsId", goodsId);
			pw = opensqlmanage.selectForPageByMap(map, "t_goods_consult.selectCountByMap",
					"t_goods_consult.selectListByMap", rs.getP_curPage(), rs.getP_pageSize());
		}
		return "goods_consult_page";
	}
    
	//商品咨询数据
	public void initAjaxGoodsConsult() throws SQLException 
	{
		String goodsId = this.getRequest().getParameter("goodsId");
		List<TGoodsConsult> list = null;
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (goodsId == null || "".equals(goodsId.trim())) 
		{
			resultMap.put("list", list);
			resultMap.put("count", 0);
		} 
		else 
		{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("goodsId", Long.valueOf(goodsId));
			map.put("start", 0);
			map.put("pageSize", 10);
			list = tgoodsconsultmanager.initAjaxGoodsConsult(map);
			int count = tgoodsconsultmanager.initAjaxGoodsConsultCount(map);
			resultMap.put("list", list);
			resultMap.put("count", count);
			resultMap.put("pages", count % 10 == 0 ? count / 10 : count / 10 + 1);
		}
		this.writeObjectToResponse(resultMap, ContentType.application_json);
	}
	
	//商品咨询数据加载
	@SuppressWarnings("unchecked")
	public void showGoodsConsults() throws SQLException 
	{
		String pageNo = getRequest().getParameter("pageNo");
		String pageSize = getRequest().getParameter("pageSize");
		String goodsId = this.getRequest().getParameter("goodsId");
		
		rs.setP_curPage(Integer.parseInt(pageNo));
		rs.setP_pageSize(Integer.parseInt(pageSize));
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("goodsId", Long.valueOf(goodsId));
		
		pw = opensqlmanage.selectForPageByMap(map, "t_goods_consult.selectListPageCount", "t_goods_consult.selectListPage", rs.getP_curPage(), rs.getP_pageSize());
		List<TGoodsConsult> list = pw.getResult();
		this.writeObjectToResponse(list, ContentType.application_json);
	}

	//ajax请求分页
	public void ajaxGoodsConsultByPage() throws SQLException 
	{
		String goodsId = this.getRequest().getParameter("goodsId");
		String currentPage = this.getRequest().getParameter("currentPage");
		String pageSize = this.getRequest().getParameter("pageSize");

		Map<String, Object> paramMap = new HashMap<String, Object>();
		if (currentPage == null || "".equals(currentPage.trim())) 
		{
			currentPage = "1";
		}
		if (pageSize == null || "".equals(pageSize.trim())) 
		{
			pageSize = "10";
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (goodsId == null || "".equals(goodsId.trim())) 
		{
			resultMap.put("list", null);
		} 
		else 
		{
			paramMap.put("goodsId", Long.valueOf(goodsId));
			paramMap.put("start", (Integer.valueOf(currentPage) - 1) * Integer.valueOf(pageSize));
			paramMap.put("pageSize", Integer.valueOf(pageSize));
			List<TGoodsConsult> list = tgoodsconsultmanager.initAjaxGoodsConsult(paramMap);
			resultMap.put("list", list);
		}
		this.writeObjectToResponse(resultMap, ContentType.application_json);
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

	public PageWraper getPw() 
	{
		return pw;
	}

	public void setPw(PageWraper pw) 
	{
		this.pw = pw;
	}

	public PageResult getRs() 
	{
		return rs;
	}

	public void setRs(PageResult rs)
	{
		this.rs = rs;
	}

	public TGoodsConsultManager getTgoodsconsultmanager() 
	{
		return tgoodsconsultmanager;
	}

	public void setTgoodsconsultmanager(TGoodsConsultManager tgoodsconsultmanager) 
	{
		this.tgoodsconsultmanager = tgoodsconsultmanager;
	}

	public TGoodsConsult gettGoodsConsult() 
	{
		return tGoodsConsult;
	}

	public void settGoodsConsult(TGoodsConsult tGoodsConsult) 
	{
		this.tGoodsConsult = tGoodsConsult;
	}

	public String getUserName() 
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getConsultContent() 
	{
		return consultContent;
	}

	public void setConsultContent(String consultContent) 
	{
		this.consultContent = consultContent;
	}

	public TGoodsManager getTgoodsmanager() 
	{
		return tgoodsmanager;
	}

	public void setTgoodsmanager(TGoodsManager tgoodsmanager) 
	{
		this.tgoodsmanager = tgoodsmanager;
	}

	public TMemberManager getTmembermanager() 
	{
		return tmembermanager;
	}

	public void setTmembermanager(TMemberManager tmembermanager) 
	{
		this.tmembermanager = tmembermanager;
	}

	public TMember gettMember()
	{
		return tMember;
	}

	public void settMember(TMember tMember) 
	{
		this.tMember = tMember;
	}

	public TGoods gettGoods() 
	{
		return tGoods;
	}

	public void settGoods(TGoods tGoods) 
	{
		this.tGoods = tGoods;
	}

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
