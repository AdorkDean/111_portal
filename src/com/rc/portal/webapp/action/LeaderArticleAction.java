package com.rc.portal.webapp.action;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.util.StringUtils;

import com.rc.app.framework.webapp.action.BaseAction;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.commons.freemarker.UtilStatic;
import com.rc.commons.util.StringUtil;
import com.rc.portal.service.OpenSqlManage;
import com.rc.portal.service.TGoodsManager;
import com.rc.portal.service.TLeaderArticleGoodsManager;
import com.rc.portal.service.TLeaderArticleManager;
import com.rc.portal.service.TLeaderImageManager;
import com.rc.portal.service.TLeaderManager;
import com.rc.portal.service.TLeaderPharmacyManager;
import com.rc.portal.service.TLeaderQrCodeManager;
import com.rc.portal.service.TLxGoodsArticleManager;
import com.rc.portal.service.TMemberAccountManager;
import com.rc.portal.service.TSysParameterManager;
import com.rc.portal.util.InfoUtil;
import com.rc.portal.util.cookieManager;
import com.rc.portal.vo.TLeader;
import com.rc.portal.vo.TLeaderArticle;
import com.rc.portal.vo.TLeaderArticleGoods;
import com.rc.portal.vo.TLeaderExample;
import com.rc.portal.vo.TLeaderImage;
import com.rc.portal.vo.TLeaderPharmacy;
import com.rc.portal.vo.TLxGoodsArticle;
import com.rc.portal.vo.TMember;
import com.rc.portal.vo.TMemberAccount;
import com.rc.portal.webapp.util.Des;
import com.rc.portal.webapp.util.PageResult;

@SuppressWarnings("unchecked")
public class LeaderArticleAction extends BaseAction
{
	private static final long serialVersionUID = 672274541L;
	private OpenSqlManage opensqlmanage;
	private TLeaderArticleManager tleaderarticlemanager;
	private TLeaderQrCodeManager tleaderqrcodemanager;
	private TMemberAccountManager tmemberaccountmanager;
	private TLxGoodsArticleManager tlxgoodsarticlemanager;
	private TLeaderArticleGoodsManager tleaderarticlegoodsmanager;
	private TGoodsManager tgoodsmanager;
	private TLeaderManager tleadermanager;
	Condition model = new Condition();
	private PageWraper pw = new PageWraper();
	private PageResult rs = new PageResult();
	private static int PAGE_SIZE = 10;
	private final Long MAXSIZE = 1024*1024*2L;
	private final String diskPath = InfoUtil.getInstance().getInfo("img", "image.new.leader.dir");
	private TLeaderPharmacyManager tleaderpharmacymanager;
	private TLeaderImageManager tleaderimagemanager;
	private String url = null;
	
	private TSysParameterManager tsysparametermanager;
	
	/**
	 * 领秀中心
	 */
	public String index() throws Exception
	{
		TMember member = (TMember)this.getRequest().getSession().getAttribute("member");
		//获取领袖
		TLeaderExample tle = new TLeaderExample();
		tle.createCriteria().andMemberIdEqualTo(member.getId());
		List<TLeader> lists = tleadermanager.selectByExample(tle);
		TLeader tleader = lists.get(0);
		Long memberId = member.getId();
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("memberId", memberId);
		//领秀 粉、文章、药房
		Map<String,Object> leaderCount =(Map<String, Object>) this.opensqlmanage.selectForObjectByMap(paramMap, "t_leader.leader_xf_wz_yf_count");
		//领秀收益
		TMemberAccount memberAccount =tmemberaccountmanager.selectByPrimaryKey(memberId);
		
		paramMap.clear();
		paramMap.put("page_start", 0);
		paramMap.put("page_end", 4);
		//官网推荐文章
		List<TLxGoodsArticle>  articleList = opensqlmanage.selectForListByMap(paramMap,"t_lx_goods_article.select_goods_article_tj");
		
		paramMap.clear();
		paramMap.put("page_start", 0);
		paramMap.put("page_end", 3);
		paramMap.put("memberId", memberId);
		//领秀文章
		List<TLeaderArticle>  leaderArticleList = opensqlmanage.selectForListByMap(paramMap,"t_leader_article.select_leader_article_tj_2");
		//文章数
		paramMap.clear();
		paramMap.put("memberId", memberId);
		int leaderArticleListSize = (Integer) opensqlmanage.selectForObjectByMap(paramMap,"t_leader_article.select_leader_article_tj_count");
		
		//我的药库
		String  brokerage= tsysparametermanager.getKeys("fanyong_default_bili");//返佣比例默认4.5%
		paramMap.clear();
		paramMap.put("page_start", 0);
		paramMap.put("page_end", 8);
		paramMap.put("memberId", memberId);
		paramMap.put("brokerage", brokerage);
		List<Map<String,Object>> leaderGoodsList = opensqlmanage.selectForListByMap(paramMap, "t_leader_pharmacy.select_leader_goods");
		//我的药房商品数
		paramMap.clear();
		paramMap.put("leader_id", tleader.getId());
		int leaderGoodsListSize = (Integer) opensqlmanage.selectForObjectByMap(paramMap,"t_leader_article.select_leader_pharmacy_goods_count");
		
		//头像
		String headerUrl = member.getHeadPortrait();
		if(headerUrl == null || headerUrl.equals(""))
		{
			headerUrl = "http://img.zdfei.com/static/image/temp/20160127/73569e0fe07f5e60234179baddec94eb.jpg";
		}
		
		getRequest().setAttribute("headerUrl", headerUrl);
		getRequest().setAttribute("leaderCount", leaderCount);
		getRequest().setAttribute("memberAccount", memberAccount);
		getRequest().setAttribute("articleList", articleList);
		getRequest().setAttribute("leaderArticleList", leaderArticleList);
		getRequest().setAttribute("leaderArticleListSize", leaderArticleListSize);
		getRequest().setAttribute("leaderGoodsList", leaderGoodsList);
		getRequest().setAttribute("leaderGoodsListSize", leaderGoodsListSize);
		getRequest().setAttribute("tleader", tleader);
		if(this.getSession().getAttribute("leader_first")!=null){
			String leader_first =(String) this.getSession().getAttribute("leader_first");
			this.getRequest().setAttribute("leader_first", leader_first);
			this.getSession().removeAttribute("leader_first");
		}else{
			this.getRequest().setAttribute("leader_first", "0");
		}
		return "leaderCenter";
	}
	
	/**
	 * 解析参数生成二维码
	 */
	public String shareLeaderHtml() throws SQLException
	{
		String code = this.getRequest().getParameter("code"); 
		String hurl = this.getRequest().getParameter("hurl");
		String id = this.getRequest().getParameter("id");
		if(null != code && !("").equals(code) && null != hurl && !("").equals(hurl))
		{
			TLeaderExample te = new TLeaderExample();
			te.createCriteria().andCodeEqualTo(code);
			List<TLeader> list = tleadermanager.selectByExample(te);
			if(null != list && list.size()==1)
			{
				cookieManager.addCookie(this.getRequest(), this.getResponse(), "leader", code, 100000,".111yao.com");
			    url =  InfoUtil.getInstance().getInfo("config", "share.redirect.domain") + hurl+"?code="+code+"&id="+id;
			}
			else
			{
				url="/";
			}
		}
		else
		{
			url="/";
		}
		return "url";
	}
	
	
	/**
	 * 选择商品
	 */
	public void list() throws SQLException, UnsupportedEncodingException
	{
		String ratio = "4.5";
		String str = tsysparametermanager.getKeys("fanyong_default_bili");
		if(StringUtils.hasText(str))
		{
			ratio = str;
		}
		String name = getRequest().getParameter("name");
		Map<String,Object> querMap = new HashMap<String,Object>();
		if(null != name && !("").equals(name))
		{
			name = java.net.URLDecoder.decode(name, "utf-8");
			querMap.put("name", "%"+name+"%");
		}
		querMap.put("ratio", ratio);
		String offset = getRequest().getParameter("offset");
		rs.setP_curPage(Integer.parseInt(offset));
		pw = opensqlmanage.selectForPageByMap(querMap, "t_goods_brokerage.selectgoodsListPageCount", "t_goods_brokerage.selectgoodsListPage", rs.getP_curPage(), 8);
		List<Map<String, Object>> datas = pw.getResult();
		writeObjectToResponse(datas, ContentType.application_json);
	}
	
	/**
	 * 官网推荐文章列表
	 */
	public String pcRecommendArticleList(){
		TMember member =(TMember)this.getSession().getAttribute("member");//这里获取登陆的用户id
		String title = this.getRequest().getParameter("title");
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("memberId", member.getId());
		if(!StringUtil.isEmpty(title) &&!title.equals("请输入搜索的内容...")){
			paramMap.put("title", title);
		    this.getRequest().setAttribute("title", title);
		}
		this.getRequest().setAttribute("myArticleCount", this.opensqlmanage.selectObjectByObject(paramMap, "t_leader_article.select_leader_article_tj_count"));
		this.getRequest().setAttribute("pcArticleCount", this.opensqlmanage.selectObjectByObject(paramMap, "t_lx_goods_article.select_goods_article_tj_totalCount"));
		this.getRequest().setAttribute("draftArticleCount", this.opensqlmanage.selectObjectByObject(paramMap, "t_leader_article.select_draft_leader_article_count"));
		rs.setP_pageSize(10);
		this.pw = this.opensqlmanage.selectForPageByMap(paramMap, "t_lx_goods_article.select_goods_article_tj_count", "t_lx_goods_article.select_pc_goods_article", rs.getP_curPage(),  rs.getP_pageSize());
		return "pcRecommendArticle";
	}
	
	
	/**
	 * 跳转到健康领袖功能介绍
	 * @return
	 */
	public String leaderFunctionIntroduce(){
		return "leader_function_introduce";
	}
	
	
	/**
	 * 获取补全关键字
	 */
	public void getshortname()
	{
		String name = getRequest().getParameter("name");
		Map<String,Object> querMap = new HashMap<String, Object>();
		List<Object> result = new ArrayList<Object>();
		if(StringUtils.hasText(name))
		{
			querMap.put("name", name);
			List<Map<String, Object>> datas = opensqlmanage.selectForListByMap(querMap, "t_goods_brokerage.selectTipsList");
			for(Map<String,Object> m : datas)
			{
				result.add(m.get("short_name"));
			}
		}
		writeObjectToResponse(result, ContentType.application_json);
	}
	
	/**
	 * 保存文章
	 */
	public void save() throws Exception
	{
		String type = getRequest().getParameter("type");
		//参数
		String title = getRequest().getParameter("title");
		String share_image_url = getRequest().getParameter("share_image_url");
		String share_title = getRequest().getParameter("share_title");
		String goods_ids = getRequest().getParameter("goods_ids");
		String content = getRequest().getParameter("content");
		content = new Des().strDec(content, "1", "2", "3");
		
		//获取领袖ID
		TMember tm = (TMember)this.getRequest().getSession().getAttribute("member");
		TLeaderExample tle = new TLeaderExample();
		tle.createCriteria().andMemberIdEqualTo(tm.getId());
		List<TLeader> lists = tleadermanager.selectByExample(tle);
		Long leaderId = lists.get(0).getId();
		
		//保存文章
		TLeaderArticle ta = new TLeaderArticle();
		ta.setTitle(title);
		ta.setShareImageUrl(share_image_url);
		ta.setShareTitle(share_title);
		ta.setContent(content.getBytes());
		ta.setStatus(0);
		ta.setWeight(0);
		ta.setIsDelete(0);
		ta.setFormatType(1);
		ta.setClickLikeSum(0);
		ta.setLookSum(0);
		ta.setCommentSum(0);
		ta.setLeaderId(leaderId);
		if(type.equals("0"))
		{
			ta.setAuditStatus(0);
		}
		if(type.equals("1"))
		{
			ta.setAuditStatus(1);
		}
		ta.setCreateDt(new Date());
		Long articleId = tleaderarticlemanager.insert(ta);
		
		if(StringUtils.hasText(goods_ids))
		{
			String[] sArray = goods_ids.split(",");
			for(String s : sArray)
			{
				//保存文章商品
				Long goods_id_t = Long.parseLong(s);
				TLeaderArticleGoods tag = new TLeaderArticleGoods();
				tag.setGoodsId(goods_id_t);
				tag.setArticleId(articleId);
				tag.setGoodImageUrl(tgoodsmanager.selectByPrimaryKey(goods_id_t).getAbbreviationPicture());
				tag.setWeight(0);
				tleaderarticlegoodsmanager.insert(tag);
				//保存到我的药房
				//TLeaderPharmacy tlp = new TLeaderPharmacy();
				//tlp.setMemberId(tm.getId());
				//tlp.setLeaderId(leaderId);
				//tlp.setGoodsId(goods_id_t);
				//tleaderpharmacymanager.insert(tlp);
			}
			
		}
		
	}
	
	/**
	 * 更新文章
	 */
	@SuppressWarnings("unused")
	public void update() throws Exception
	{
		String type = getRequest().getParameter("type");
		//参数
		String title = getRequest().getParameter("title");
		String share_image_url = getRequest().getParameter("share_image_url");
		String share_title = getRequest().getParameter("share_title");
		String goods_ids = getRequest().getParameter("goods_ids");
		String content = getRequest().getParameter("content");
		content = new Des().strDec(content, "1", "2", "3");
		
		//获取领袖ID
		TMember tm = (TMember)this.getRequest().getSession().getAttribute("member");
		TLeaderExample tle = new TLeaderExample();
		tle.createCriteria().andMemberIdEqualTo(tm.getId());
		List<TLeader> lists = tleadermanager.selectByExample(tle);
		Long leaderId = lists.get(0).getId();
		
		String articleIdStr = getRequest().getParameter("articleId");
		if(StringUtils.hasText(articleIdStr))
		{
			Long articleId = Long.parseLong(articleIdStr);
			TLeaderArticle ta = tleaderarticlemanager.selectByPrimaryKey(articleId);
			ta.setTitle(title);
			ta.setShareImageUrl(share_image_url);
			ta.setShareTitle(share_title);
			ta.setContent(content.getBytes());
			ta.setStatus(0);
			ta.setWeight(0);
			ta.setIsDelete(0);
			ta.setFormatType(1);
			if(type.equals("0"))
			{
				ta.setAuditStatus(0);
			}
			if(type.equals("1"))
			{
				ta.setAuditStatus(1);
			}
			ta.setUpdateDt(new Date());
			tleaderarticlemanager.updateByPrimaryKeySelective(ta);
			
			//保存文章商品和我的药房
			if(StringUtils.hasText(goods_ids))
			{
				String[] sArray = goods_ids.split(",");
				for(String s : sArray)
				{
					String[] newS = s.split("-");
					int lg = newS.length;
					Long goods_id = Long.parseLong(newS[0]);
					String article_goods_id = null;
					if(lg > 1)
					{
						//更新文章商品中间表数据
						article_goods_id = newS[1];
						TLeaderArticleGoods tag = tleaderarticlegoodsmanager.selectByPrimaryKey(Long.parseLong(article_goods_id));
						tag.setGoodsId(goods_id);
						tag.setArticleId(articleId);
						tag.setGoodImageUrl(tgoodsmanager.selectByPrimaryKey(goods_id).getAbbreviationPicture());
						tleaderarticlegoodsmanager.updateByPrimaryKey(tag);
					}
					//保存
					else
					{
						//保存文章商品中间表数据
						TLeaderArticleGoods tag = new TLeaderArticleGoods();
						tag.setGoodsId(goods_id);
						tag.setArticleId(articleId);
						tag.setGoodImageUrl(tgoodsmanager.selectByPrimaryKey(goods_id).getAbbreviationPicture());
						tag.setWeight(0);
						tleaderarticlegoodsmanager.insert(tag);
						
						//保存到我的药房中间表数据
						//TLeaderPharmacy tlp = new TLeaderPharmacy();
						//tlp.setMemberId(tm.getId());
						//tlp.setLeaderId(leaderId);
						//tlp.setGoodsId(goods_id);
						//tleaderpharmacymanager.insert(tlp);
					}
				}
			}
		}
	}
	
	/**
	 * 删除已选择的商品
	 */
	public void delag() throws NumberFormatException, Exception
	{
		TMember tm = (TMember) this.getRequest().getSession().getAttribute("member");
		if(tm != null)
		{
			String article_goods_id = getRequest().getParameter("article_goods_id");
			if(StringUtils.hasText(article_goods_id))
			{
				//TLeaderArticleGoods tag = tleaderarticlegoodsmanager.selectByPrimaryKey(Long.parseLong(article_goods_id));
				//删除商品药房中间表数据
				//Map<String, Object> map = new HashMap<String, Object>();
				//map.put("memberId", tm.getId());
				//map.put("goodsId", tag.getGoodsId());
				//Map<String, Object> data = (Map<String, Object>) opensqlmanage.selectForObjectByMap(map, "t_goods_brokerage.selectPharmacyByMemberIdAndGoodsId");
				//Long t_leader_pharmacy_id = Long.parseLong(data.get("id").toString());
				//tleaderpharmacymanager.deleteByPrimaryKey(t_leader_pharmacy_id);
				//商品文章商品中间表数据
				tleaderarticlegoodsmanager.deleteByPrimaryKey(Long.parseLong(article_goods_id));
			}
		}
	}
	
	/**
	 * 删除我的药房里面的商品
	 */
	public void delPharmacyGoods() throws Exception
	{
		int rs = 0;
		String pharmacy_goods_id_str = getRequest().getParameter("pharmacy_goods_id");
		if(StringUtils.hasText(pharmacy_goods_id_str))
		{
			Long pharmacy_goods_id = Long.parseLong(pharmacy_goods_id_str);
			int resutl = tleaderpharmacymanager.deleteByPrimaryKey(pharmacy_goods_id);
			if(resutl > 0)
			{
				rs = 1;
			}
		}
		writeObjectToResponse(rs, ContentType.application_json);
	}
	
	/**
	 * 弹出编辑页面
	 */
	public String edit() throws Exception
	{
		String articleIdStr = getRequest().getParameter("articleId");
		if(StringUtils.hasText(articleIdStr))
		{
			Long articleId = Long.parseLong(articleIdStr);
			TLeaderArticle tleaderarticle = tleaderarticlemanager.selectByPrimaryKey(articleId);
			Map<String, Object> querMap = new HashMap<String, Object>();
			querMap.put("article_id", articleId);
			List<Map<String, Object>> datas = opensqlmanage.selectForListByMap(querMap, "t_goods_brokerage.selectArticleGoodsByArticleId");
			String content = new String(tleaderarticle.getContent());
			getRequest().setAttribute("tleaderarticle", tleaderarticle);
			getRequest().setAttribute("content", content);
			getRequest().setAttribute("datas", datas);
		}
		return "edit";
	}
	
	
	/**
	 * 保存单个图片
	 */
	public void saveImage() throws IOException
	{
		String imgUrl = null;
		this.getRequest().setCharacterEncoding("utf-8");
		this.getResponse().setContentType("text/html;charset=utf-8");
		String basePath = this.getRequest().getSession().getServletContext().getRealPath("/");
		File file = model.getImgfile();
		String fullName = null;
		String filename = model.getImgfileFileName();
		String fileType = FilenameUtils.getExtension(filename);
		if(file.length() < MAXSIZE)
		{
			String fullPath = diskPath + getDiskName() + "/" + DigestUtils.md5Hex(String.valueOf(System.currentTimeMillis()));
			imgUrl = fullPath+"."+fileType;
			fullName = basePath+imgUrl;
			File uploadFile = new File(fullName);
			FileUtils.copyFile(file, uploadFile);
		}
		writeObjectToResponse(imgUrl, ContentType.text_html);
	}
	
	/**
	 * 预览文章弹出二维码
	 */
	public void preview() throws SQLException
	{
		//获取健康领袖
		TMember tm = (TMember)this.getRequest().getSession().getAttribute("member");
		TLeaderExample tle = new TLeaderExample();
		tle.createCriteria().andMemberIdEqualTo(tm.getId());
		//List<TLeader> lists = tleadermanager.selectByExample(tle);
		//Long leaderId = lists.get(0).getId();
		//0：标识系统文章  1：标识用户文章
		String type = getRequest().getParameter("type");
		Long articleId = Long.parseLong(getRequest().getParameter("articleId"));
		TLeaderArticle tla = tleaderarticlemanager.selectByPrimaryKey(articleId);
		String content = "";
		byte[] bContent = tla.getContent();
		if(bContent != null)
		{
			content = new String(bContent);
		}
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("articleid", articleId);
		String sql = "t_lx_goods_article.selecctTuiJianGoodsByArticleId_1";
		if(type.equals("0"))
		{
			sql = "t_lx_goods_article.selecctTuiJianGoodsByArticleId_0";
		}
		List<Map<String, Object>> datas = opensqlmanage.selectForListByMap(p, sql);
		Map<Object, Object> root = new HashMap<Object, Object>();
		root.put("tla", tla);
		root.put("acontent", content);
		root.put("datas", datas);
		String base = getRequest().getSession().getServletContext().getRealPath("/");
		String staticPageUrl = base + "/static/leader/user/preview.html";
		String visitUrl = getRequest().getContextPath() + "/static/leader/user/preview.html";
		String fileName = "view1.ftl";
		UtilStatic.doTemplatePage(root,base + "/WEB-INF/pages/member/leaderarticle/",fileName,staticPageUrl);
		writeObjectToResponse(visitUrl, ContentType.application_json);
	}
	
	/**
	 * 管理中心:我的秀粉
	 */
	public String myLeaderFans()
	{
		TMember member =(TMember)this.getSession().getAttribute("member");
		if(member != null)
		{
			Long memberId = member.getId();
			Map<String,Object> paramMap = new HashMap<String,Object>();
			//1: 按照下单次数倒序   2:按照累计收益倒序
			String orderbyStr = getRequest().getParameter("orderby");
			String orderby = "";
			if(StringUtils.hasText(orderbyStr))
			{
				orderby = getRequest().getParameter("orderby");
			}
			String sqlCount = "t_member.leaderPowderListCountByMemberId";
			paramMap.put("orderby", orderby);
			paramMap.put("memberId", memberId);
			rs.setP_pageSize(10);
			pw = this.opensqlmanage.selectForPageByMap(paramMap,sqlCount,"t_member.leaderPowderListByMemberId", rs.getP_curPage(), rs.getP_pageSize());
			int size = (Integer) opensqlmanage.selectForObjectByMap(paramMap, sqlCount);
			getRequest().setAttribute("size", size);
			getRequest().setAttribute("orderby", orderby);
		}
		return "myLeaderFans";
	}
	
	/**
	 * 我的文章列表
	 */
	public String leaderArticleList(){
		TMember member =(TMember)this.getSession().getAttribute("member");//这里获取登陆的用户id
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("memberId", member.getId());
		
		this.getRequest().setAttribute("pcArticleCount", this.opensqlmanage.selectObjectByObject(paramMap, "t_lx_goods_article.select_goods_article_tj_totalCount"));
		this.getRequest().setAttribute("myArticleCount", this.opensqlmanage.selectObjectByObject(paramMap, "t_leader_article.select_leader_article_tj_count"));
		this.getRequest().setAttribute("draftArticleCount", this.opensqlmanage.selectObjectByObject(paramMap, "t_leader_article.select_draft_leader_article_count"));
		this.pw = this.opensqlmanage.selectForPageByMap(paramMap, "t_leader_article.select_leader_article_tj_count", "t_leader_article.select_leader_article_tj", rs.getP_curPage(), PAGE_SIZE);
		return "leaderArticleList";
	}
	
	/**
	 * 删除我的文章
	 */
	public void deleteMyArticle() throws Exception{
		int flag=-1;
		PrintWriter out =  getResponse().getWriter();
		String articleId = this.getRequest().getParameter("articleId");//这里获取领秀文章id
		if(articleId!=null && !"".equals(articleId)){
			TLeaderArticle leaderArticle = tleaderarticlemanager.selectByPrimaryKey(Long.valueOf(articleId));
			leaderArticle.setIsDelete(1);
			tleaderarticlemanager.updateByPrimaryKeySelective(leaderArticle);
			flag=1;
		}else{
			flag=2;
		}
		out.print(flag);
		out.close();
	}
	
	/**
	 * 待发布文章列表
	 */
	public String draftLeaderArticleList(){
		TMember member =(TMember)this.getSession().getAttribute("member");//这里获取登陆的用户id
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("memberId", member.getId());
		
		this.getRequest().setAttribute("pcArticleCount", this.opensqlmanage.selectObjectByObject(paramMap, "t_lx_goods_article.select_goods_article_tj_totalCount"));
		this.getRequest().setAttribute("myArticleCount", this.opensqlmanage.selectObjectByObject(paramMap, "t_leader_article.select_leader_article_tj_count"));
		this.getRequest().setAttribute("draftArticleCount", this.opensqlmanage.selectObjectByObject(paramMap, "t_leader_article.select_draft_leader_article_count"));
		this.pw = this.opensqlmanage.selectForPageByMap(paramMap, "t_leader_article.select_draft_leader_article_count", "t_leader_article.select_draft_leader_article", rs.getP_curPage(), PAGE_SIZE);
		return "draftLeaderArticleList";
	}
	/**
	 * 领秀药房 列表
	 * @return
	 * @throws Exception
	 */
	public String leaderPharmacy() throws Exception{
		TMember member =(TMember)this.getSession().getAttribute("member");//这里获取登陆的用户id
		String  brokerage= tsysparametermanager.getKeys("fanyong_default_bili");//返佣比例默认4.5%
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("brokerage", brokerage);
		paramMap.put("memberId", member.getId());
		rs.setP_pageSize(8);
		this.pw = this.opensqlmanage.selectForPageByMap(paramMap, "t_leader_pharmacy.select_leader_pharmacy_count", "t_leader_pharmacy.select_leader_pharmacy_list", rs.getP_curPage(), rs.getP_pageSize());
		return "leaderPharmacyList";
	}
	
	/*
	 * 领秀药房商品列表
	 */
	public String leaderPharmacyGoodsList() throws Exception{
		String name = getRequest().getParameter("name");
		String  brokerage= tsysparametermanager.getKeys("fanyong_default_bili");//返佣比例默认4.5%
		Map<String,Object> querMap = new HashMap<String,Object>();
		querMap.put("brokerage",brokerage);
		if(null != name && !("").equals(name)&&!name.equals("请输入搜索的内容..."))
		{
			querMap.put("name", "%"+name+"%");
			this.getRequest().setAttribute("name", name);
		}
		rs.setP_pageSize(8);
		pw = opensqlmanage.selectForPageByMap(querMap, "t_goods_brokerage.selectLeaderGoodsListCount", "t_goods_brokerage.selectLeaderGoodsList", rs.getP_curPage(), rs.getP_pageSize());
		return "leaderPharmacyGoodsList";
	}
	
	/**
	 *  领秀药房添加商品
	 * @throws Exception
	 */
	public void leaderPharmacyAddGoods() throws Exception{
		int flag=-1;
		String  leader_goods_size= tsysparametermanager.getKeys("leader_goods_size");//领秀商品数量
		this.getRequest().setAttribute("leader_goods_size", leader_goods_size);
		PrintWriter out =  getResponse().getWriter();
		TMember member =(TMember)this.getSession().getAttribute("member");//这里获取登陆的用户id
		String goodsId = this.getRequest().getParameter("goodsId");//商品id
		//获取领袖ID
		TLeaderExample tle = new TLeaderExample();
		tle.createCriteria().andMemberIdEqualTo(member.getId());
		List<TLeader> lists = tleadermanager.selectByExample(tle);
		Long leaderId = lists.get(0).getId();
		
		Map<String,Object> querMap = new HashMap<String,Object>();
		querMap.put("leaderId", leaderId);
		querMap.put("goodsId", goodsId);
		Map<String,Object> limitquerMap = new HashMap<String,Object>();
		limitquerMap.put("leaderId", leaderId);
		limitquerMap.put("memberId", member.getId());
		int goodsCount = (Integer) opensqlmanage.selectObjectByObject(querMap, "t_leader_pharmacy.select_leader_pharmacy_goods_count");
		int leadergoodsCount = (Integer) opensqlmanage.selectObjectByObject(limitquerMap, "t_leader_pharmacy.select_leader_pharmacy_limit_goods_count");
		try{
			if(leadergoodsCount>=Integer.parseInt(leader_goods_size)){
				flag=Integer.parseInt(leader_goods_size);//超过添加商品数量
			}else{
				if(StringUtils.hasText(goodsId) && goodsCount==0){
					TLeaderExample leaderExample = new TLeaderExample();
					leaderExample.createCriteria().andMemberIdEqualTo(member.getId());
					List<TLeader> leaderList =this.tleadermanager.selectByExample(leaderExample);
					if(leaderList!=null&&leaderList.size()>0){
						TLeaderPharmacy leaderPharmacy = new TLeaderPharmacy();
						leaderPharmacy.setMemberId(member.getId());
						leaderPharmacy.setGoodsId(Long.valueOf(goodsId.trim()));
						leaderPharmacy.setLeaderId(leaderList.get(0).getId());
						this.tleaderpharmacymanager.insertSelective(leaderPharmacy);
						flag=1;//添加成功
					}
				}else{
					flag=2;//已添加过此商品
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		out.print(flag);
		out.close();
	}
	
	/**
	 * 管理中心:身份认证
	 */
	public String leaderIdentity() throws Exception
	{
		TMember tm = (TMember) this.getSession().getAttribute("member");
		if(tm != null)
		{
			//获取领袖信息
			TLeaderExample tle = new TLeaderExample();
			tle.createCriteria().andMemberIdEqualTo(tm.getId());
			List<TLeader> lists = tleadermanager.selectByExample(tle);
			TLeader tleader = lists.get(0);
			getRequest().setAttribute("tleader", tleader);
			//获取领袖图片
			Map<String, Object> querMap = new HashMap<String, Object>();
			querMap.put("leader_id", tleader.getId());
			List<Map<String, Object>> datas = opensqlmanage.selectForListByMap(querMap, "t_goods_brokerage.select_t_leader_images");
			getRequest().setAttribute("datas", datas);
			getRequest().setAttribute("size", datas.size());
		}
		return "leaderIdentity";
	}
	
	/**
	 * 管理中心：身份认证
	 */
	public void saveIdentity() throws Exception 
	{
		int result = 0;
		String identityIdCard = this.getRequest().getParameter("identityIdCard");
		String your_self_photo = this.getRequest().getParameter("your_self_photo");
		String your_belong_photo_1 = this.getRequest().getParameter("your_belong_photo_1");
		String your_belong_photo_2 = this.getRequest().getParameter("your_belong_photo_2");
		String your_belong_photo_3 = this.getRequest().getParameter("your_belong_photo_3");
		String your_belong_photo_4 = this.getRequest().getParameter("your_belong_photo_4");
		String your_belong_photo_5 = this.getRequest().getParameter("your_belong_photo_5");
		String leader_image_id_1 = this.getRequest().getParameter("leader_image_id_1");
		String leader_image_id_2 = this.getRequest().getParameter("leader_image_id_2");
		String leader_image_id_3 = this.getRequest().getParameter("leader_image_id_3");
		String leader_image_id_4 = this.getRequest().getParameter("leader_image_id_4");
		String leader_image_id_5 = this.getRequest().getParameter("leader_image_id_5");
		
		String your_sfz_photo_1 = this.getRequest().getParameter("your_sfz_photo_1");
		String your_sfz_photo_2 = this.getRequest().getParameter("your_sfz_photo_2");
		TMember tm = (TMember) this.getSession().getAttribute("member");
		if(tm != null)
		{
			//更新领袖表数据
			TLeaderExample tle = new TLeaderExample();
			tle.createCriteria().andMemberIdEqualTo(tm.getId());
			List<TLeader> lists = tleadermanager.selectByExample(tle);
			TLeader tleader = lists.get(0);
			Long tleaderId = tleader.getId();
			tleader.setCardCode(identityIdCard);
			tleader.setHeadUrl(your_self_photo);
			tleader.setCardFirstUrl(your_sfz_photo_1);
			tleader.setCardTwoUrl(your_sfz_photo_2);
			tleadermanager.updateByPrimaryKey(tleader);
			//保存领袖图片表数据
			List<Map<String, Object>> imageUrlList = new ArrayList<Map<String, Object>>();
			if(StringUtils.hasText(your_belong_photo_1))
			{
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("your_belong_photo_1", your_belong_photo_1);
				m.put("leader_image_id_1", leader_image_id_1);
				imageUrlList.add(m);
			}
			if(StringUtils.hasText(your_belong_photo_2))
			{
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("your_belong_photo_2", your_belong_photo_2);
				m.put("leader_image_id_2", leader_image_id_2);
				imageUrlList.add(m);
			}
			if(StringUtils.hasText(your_belong_photo_3))
			{
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("your_belong_photo_3", your_belong_photo_3);
				m.put("leader_image_id_3", leader_image_id_3);
				imageUrlList.add(m);
			}
			if(StringUtils.hasText(your_belong_photo_4))
			{
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("your_belong_photo_4", your_belong_photo_4);
				m.put("leader_image_id_4", leader_image_id_4);
				imageUrlList.add(m);
			}
			if(StringUtils.hasText(your_belong_photo_5))
			{
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("your_belong_photo_5", your_belong_photo_5);
				m.put("leader_image_id_5", leader_image_id_5);
				imageUrlList.add(m);
			}
			for(int i=1; i<=imageUrlList.size(); i++)
			{
				TLeaderImage tLeaderImage = null;
				String leader_image_id_str = imageUrlList.get(i-1).get("leader_image_id_"+i).toString();
				String your_belong_photo = imageUrlList.get(i-1).get("your_belong_photo_"+i).toString();
				if(StringUtils.hasText(leader_image_id_str))
				{
					Long leader_image_id = Long.parseLong(leader_image_id_str);
					tLeaderImage = tleaderimagemanager.selectByPrimaryKey(leader_image_id);
					tLeaderImage.setImageUrl(your_belong_photo);
					tleaderimagemanager.updateByPrimaryKey(tLeaderImage);
				}
				else
				{
					tLeaderImage = new TLeaderImage();
					tLeaderImage.setLeaderId(tleaderId);
					tLeaderImage.setImageUrl(your_belong_photo);
					tleaderimagemanager.insertSelective(tLeaderImage);
				}
			}
			result = 1;
		}
		writeObjectToResponse(result, ContentType.application_json);
	}
	
	/**
	 * 删除领袖资质图片
	 */
	public void delLeaderImage() throws Exception
	{
		int result = 0;
		String leader_image_id_str = getRequest().getParameter("leader_image_id");
		if(StringUtils.hasText(leader_image_id_str))
		{
			Long leader_image_id = Long.parseLong(leader_image_id_str);
			result = tleaderimagemanager.deleteByPrimaryKey(leader_image_id);
		}
		writeObjectToResponse(result, ContentType.application_json);
	}
	
	/**
	 * 查看用户文章详情
	 */
	public void lookArticleDetail() throws Exception 
	{
		String article_id_str = getRequest().getParameter("article_id");
		String contents = "";
		if(StringUtils.hasText(article_id_str))
		{
			Long article_id = Long.parseLong(article_id_str);
			TLeaderArticle tleaderarticle = tleaderarticlemanager.selectByPrimaryKey(article_id);
			byte[] content = tleaderarticle.getContent();
			if(content != null)
			{
				contents = new String(content);
			}
		}
		writeObjectToResponse(contents, ContentType.application_json);
	}
	
	/**
	 * 查看系统文章详情
	 */
	public void lookArticleDetail2() throws Exception 
	{
		String article_id_str = getRequest().getParameter("article_id");
		String contents = "";
		if(StringUtils.hasText(article_id_str))
		{
			Long article_id = Long.parseLong(article_id_str);
			TLxGoodsArticle tlxgoodsarticle = tlxgoodsarticlemanager.selectByPrimaryKey(article_id);
			byte[] content = tlxgoodsarticle.getContent();
			if(content != null)
			{
				contents = new String(content);
			}
		}
		writeObjectToResponse(contents, ContentType.application_json);
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
	
	public TLeaderArticleManager getTleaderarticlemanager() 
	{
		return tleaderarticlemanager;
	}
	public void setTleaderarticlemanager(TLeaderArticleManager tleaderarticlemanager) 
	{
		this.tleaderarticlemanager = tleaderarticlemanager;
	}
	public TLeaderQrCodeManager getTleaderqrcodemanager() 
	{
		return tleaderqrcodemanager;
	}
	public void setTleaderqrcodemanager(TLeaderQrCodeManager tleaderqrcodemanager) 
	{
		this.tleaderqrcodemanager = tleaderqrcodemanager;
	}
	
	public TMemberAccountManager getTmemberaccountmanager() {
		return tmemberaccountmanager;
	}

	public void setTmemberaccountmanager(TMemberAccountManager tmemberaccountmanager) {
		this.tmemberaccountmanager = tmemberaccountmanager;
	}
	
	
	
	public TLxGoodsArticleManager getTlxgoodsarticlemanager() {
		return tlxgoodsarticlemanager;
	}

	public void setTlxgoodsarticlemanager(
			TLxGoodsArticleManager tlxgoodsarticlemanager) {
		this.tlxgoodsarticlemanager = tlxgoodsarticlemanager;
	}



	public class Condition
	{
		private File imgfile;
		private String imgfileFileName;
		public File getImgfile()
		{
			return imgfile;
		}
		public void setImgfile(File imgfile)
		{
			this.imgfile = imgfile;
		}
		public String getImgfileFileName()
		{
			return imgfileFileName;
		}
		public void setImgfileFileName(String imgfileFileName)
		{
			this.imgfileFileName = imgfileFileName;
		}
	}

	/**
	 * 显示添加文章页面
	 */
	public String add()
	{
		return "add";
	}
	
	public static String getDiskName()
	{
		String diskname = "";
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		diskname = df.format(new Date());
		return diskname;
	}
	
	public TLeaderArticleGoodsManager getTleaderarticlegoodsmanager() {
		return tleaderarticlegoodsmanager;
	}

	public void setTleaderarticlegoodsmanager(
			TLeaderArticleGoodsManager tleaderarticlegoodsmanager) {
		this.tleaderarticlegoodsmanager = tleaderarticlegoodsmanager;
	}

	public TGoodsManager getTgoodsmanager() {
		return tgoodsmanager;
	}

	public void setTgoodsmanager(TGoodsManager tgoodsmanager) {
		this.tgoodsmanager = tgoodsmanager;
	}

	public TLeaderManager getTleadermanager() {
		return tleadermanager;
	}

	public void setTleadermanager(TLeaderManager tleadermanager) {
		this.tleadermanager = tleadermanager;
	}

	@Override
	public Object getModel()
	{
		return this.model;
	}
	@Override
	public void setModel(Object o)
	{
		this.model = (Condition) o;
	}

	public TLeaderPharmacyManager getTleaderpharmacymanager() {
		return tleaderpharmacymanager;
	}

	public void setTleaderpharmacymanager(
			TLeaderPharmacyManager tleaderpharmacymanager) {
		this.tleaderpharmacymanager = tleaderpharmacymanager;
	}

	public TLeaderImageManager getTleaderimagemanager() {
		return tleaderimagemanager;
	}

	public void setTleaderimagemanager(TLeaderImageManager tleaderimagemanager) {
		this.tleaderimagemanager = tleaderimagemanager;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public TSysParameterManager getTsysparametermanager() {
		return tsysparametermanager;
	}

	public void setTsysparametermanager(TSysParameterManager tsysparametermanager) {
		this.tsysparametermanager = tsysparametermanager;
	}
	
	
	
}
