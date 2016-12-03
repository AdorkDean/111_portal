package com.rc.portal.webapp.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.rc.app.framework.webapp.action.BaseAction;
import com.rc.app.framework.webapp.model.page.PageInfo;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.dst.client.util.ClientSubmit;
import com.rc.portal.service.OpenSqlManage;
import com.rc.portal.service.TBrandManager;
import com.rc.portal.service.TCategoryManager;
import com.rc.portal.service.TGoodsManager;
import com.rc.portal.service.TGoodsPriceManager;
import com.rc.portal.service.TGroupGoodsKeywordManager;
import com.rc.portal.service.TMemberCollectManager;
import com.rc.portal.util.InfoUtil;
import com.rc.portal.vo.TBrand;
import com.rc.portal.vo.TCategory;
import com.rc.portal.vo.TGoods;
import com.rc.portal.vo.TGoodsPrice;
import com.rc.portal.vo.TGoodsPriceExample;
import com.rc.portal.vo.TGroupGoodsKeyword;
import com.rc.portal.vo.TGroupGoodsKeywordExample;
import com.rc.portal.vo.TMember;
import com.rc.portal.vo.TMemberCollect;
import com.rc.portal.vo.TMemberCollectExample;
import com.rc.portal.webapp.model.GroupGoodsModel;
import com.rc.portal.webapp.util.PageResult;

public class GoodsListAction extends BaseAction {
	private Condition model = new Condition();
	private PageWraper pw = new PageWraper();
	private PageResult rs = new PageResult(); 
	private OpenSqlManage opensqlmanage;
	private TCategoryManager tcategorymanager;
	private TGroupGoodsKeywordManager tgroupgoodskeywordmanager;
	private TGoodsPriceManager tgoodspricemanager;
	private TBrandManager tbrandmanager;
	private TGoodsManager tgoodsmanager;
	private TMemberCollectManager tmembercollectmanager;
	private List<TCategory> cateList;
	private List<Map> cate1List=new ArrayList<Map>();
	private List<Map> brandList=new ArrayList<Map>();
	private List<GroupGoodsModel> groupList;
	private TBrand brand;
	private String Url_A;
	private String Url_B;
	private String Url_C;
	private String Url_D;
	private String Url_E;
	private String Url_F;
	private String Url_G;
	private String Url_H;
	private String Url_I;
	private String Url_J;
	private String Url_K;
	private String Url_L;
	
	
	public String getGoodsList() throws Exception{
		rs.setP_pageSize(40);
		Map map=getCondition();
		Map mapTem=new HashMap();
		if(model.getCategoryid()!=null&&!"".equals(model.getCategoryid().trim())&&!"0".equals(model.getCategoryid().trim())){
			mapTem.put("categoryid", model.getCategoryid().trim());
			String allPra=(String)opensqlmanage.selectForObjectByMap(mapTem, "t_goods.selectparentByID");
			if(allPra!=null&&!"".equals(allPra.trim())){
				String[] ss = allPra.split(",");
				for(int i=1;i<ss.length;i++){
					TCategory category = tcategorymanager.selectByPrimaryKey(new Long(ss[i].trim()));
					if(category!=null){	
						Map mapp=new HashMap();
						mapp.put("id", category.getId());
						mapp.put("categoryName", category.getCategoryName());
						mapp.put("level", category.getCategoryLevel());
						cate1List.add(mapp);
					}
				}
			}
			TCategory ca = tcategorymanager.selectByPrimaryKey(new Long(model.getCategoryid().trim()));
			if(ca!=null){
				Map mapp1=new HashMap();
				mapp1.put("id", ca.getId());
				mapp1.put("categoryName", ca.getCategoryName());
				mapp1.put("level", ca.getCategoryLevel());
				cate1List.add(mapp1);
			}
		}
		/*TCategoryExample tce=new TCategoryExample();
		tce.createCriteria().andIsPcEqualTo(1);
		cateList = tcategorymanager.selectByExample(tce);*/
		brandList=opensqlmanage.selectForListByMap(map, "t_goods.selectBrandListByCategoryid");
		pw=opensqlmanage.selectForPageByMap(map, "t_goods.selectGoodsFirstCount", "t_goods.selectGoodsFirstList", rs.getP_curPage(), rs.getP_pageSize());
		if(model.getBrandcate()!=null&&model.getBrandcate()!=0){
			return "getYiyaoGoodsList";
		}else{
			return "getGoodsList";
		}
	}
	
	public Map getCondition(){
		HashMap param=new HashMap();
		if(model.getCategoryid()!=null&&!"".equals(model.getCategoryid().trim())&&!"0".equals(model.getCategoryid().trim())){
			Url_A=""+model.getCategoryid();
			param.put("categoryid",model.getCategoryid().trim());
		}
		if(model.getKeyword()!=null&&!"".equals(model.getKeyword().trim())){
			Url_B=""+model.getKeyword();
			param.put("keyword", model.getKeyword().trim());
		}
		if(model.getBrandkey()!=null&&!"".equals(model.getBrandkey().trim())){
			Url_C=""+model.getBrandkey();
			param.put("brandkey", model.getBrandkey().trim());
		}
		if(model.getBrandcate()!=null&&model.getBrandcate()!=0){
			Url_D=""+model.getBrandcate();
			param.put("bctype", 1);
		}else{
			
			param.put("bctype", 2);
		}
//		Url_B = "-a";// 分类id
//		Url_C = "-b";// 二级分类
//		Url_D = "-c";// 三级分类
		Url_E = "-d";// 药品类型
		Url_F = "-e";// 品牌
		Url_G = "-f";// 价格起始
		Url_H="-g";//价格结束
		Url_I="-h";//排序方式
		Url_J="-i";//排序规则
		Url_K="-j";//分页页数
		Url_L="-k";//每页显示条数
		if(model.getUrl()!=null&&!"".equals(model.getUrl().trim())){
			String url = model.getUrl().trim();
			String[] urls=url.split("-");
			for(int i=1;i<urls.length;i++){
				String s=urls[i].substring(0,1);//得到字母标示
				String s1=urls[i].substring(1);//得到值
				if("d".equals(s.trim())){
					model.setType(s1.trim());
				}else if("e".equals(s.trim())){
					model.setBrandid(s1.trim());
				}else if("f".equals(s.trim())){
					model.setPricea(s1.trim());
				}else if("g".equals(s.trim())){
					model.setPriceb(s1.trim());
				}else if("h".equals(s.trim())){
					model.setSort(s1.trim());
				}else if("i".equals(s.trim())){
					if(!"".equals(s1.trim())){
						model.setOrderby(s1.trim());
					}else{
						model.setOrderby("1");
					}
				}else if("j".equals(s.trim())){
					rs.setP_curPage(Integer.parseInt(s1.trim()));
				}else if("k".equals(s.trim())){
					rs.setP_pageSize(Integer.parseInt(s1.trim()));
				}
			}
			
			
		}
		if(model.getType()!=null&&!"".equals(model.getType().trim())){
			param.put("type", model.getType().trim());
		}else{
			Url_E="";
		}
		if(model.getBrandid()!=null&&!"".equals(model.getBrandid().trim())){
			param.put("brandid", model.getBrandid().trim());
		}else{
			Url_F="";
		}
		if(model.getPricea()!=null&&!"".equals(model.getPricea().trim())){
			param.put("pricea", can0(model.getPricea()).trim());
			model.setPricea(can0(model.getPricea()).trim());
		}else{
			param.put("pricea", "0");
			Url_G="";
		}
		if(model.getPriceb()!=null&&!"".equals(model.getPriceb().trim())){
			param.put("priceb", can0(model.getPriceb()).trim());
			model.setPriceb(can0(model.getPriceb()).trim());
		}else{
			param.put("priceb","999999");
			Url_H="";
		}
		if(model.getSort()!=null&&!"".equals(model.getSort().trim())){
			param.put("sort", model.getSort().trim());
		}else{
			param.put("sort", "0");
			Url_I="";
		}
		if(model.getOrderby()!=null&&!"".equals(model.getOrderby().trim())){
			param.put("orderby", model.getOrderby().trim());
		}else{
			param.put("orderby", "1");
			Url_J="";
		}
		TMember tm = (TMember)this.getRequest().getSession().getAttribute("member");
		if(tm!=null&&tm.getId()!=null){
			param.put("islogin", 1);
			param.put("memberid", tm.getId());
		}
		return param;
	}
	public String can0(String str){
	String newStr="0";
		if(str!=null){
			if(!"0".equals(str)){
				newStr=str.replaceFirst("^0*", ""); 
			}
		}
		return newStr;
	}
//	关键字搜索
	/*
 	map.put("parnterid", "1001");固定参数
	map.put("method", "search");固定参数
 map.put("from", "1"); 来源 1-pc 2-wap 3-app
map.put("sort", "1"); 排序字段 1-销量 2-评论 3-价格 4-折扣
map.put("order", "2"); 排序 1-升序 2-降序
map.put("pricea", "0"); 价格区间 低价格
map.put("priceb", "9000"); 价格区间 高价格
map.put("typeid", "-1"); 药品类型 0-OTC 1-处方A 2-非药
map.put("brandid", "-1"); 品牌id
map.put("keyword","显瘦简约百"); 搜索关键字
map.put("filtertype","1"); 搜索类型 1-返回搜索结果 2-返回品牌的集合 
map.put("page", "1"); 分页 页码
map.put("size", "20"); 分页 每页数量*/
	public String getGoodListByKeyword() throws Exception{
		rs.setP_pageSize(40);
		Map map=getCondition();
		Map mapt=new HashMap();
		mapt.put("parnterid", "1001");
		mapt.put("method", "search");
		mapt.put("from","1");
		
		if(model.getSort()!=null&&!"-1".equals(model.getSort().trim())){
			if("0".equals(model.getSort().trim())){
				mapt.put("sort", "-1");	
			}else if("1".equals(model.getSort().trim())){
				mapt.put("sort", "2");
			}else if("2".equals(model.getSort().trim())){
				mapt.put("sort", "3");
			}else if("3".equals(model.getSort().trim())){
				mapt.put("sort", "1");
			}
		}else{
			mapt.put("sort", "-1");
		}
		if(model.getOrderby()!=null&&!"".equals(model.getOrderby().trim())){
			mapt.put("order", model.getOrderby());
		}else{
			mapt.put("order", "1");
			
		}
		if(model.getPricea()!=null&&!"".equals(model.getPricea().trim())){
			mapt.put("pricea", can0(model.getPricea()).trim());
			model.setPricea(can0(model.getPricea()).trim());
		}else{
			mapt.put("pricea", "0");
		}
		if(model.getPriceb()!=null&&!"".equals(model.getPriceb().trim())){
			mapt.put("priceb", can0(model.getPriceb()).trim());
			model.setPriceb(can0(model.getPriceb()).trim());
		}else{
			mapt.put("priceb", "99999999");
		}
		if(model.getType()!=null&&!"".equals(model.getType().trim())){
			mapt.put("typeid", model.getType().trim());
		}else{
			mapt.put("typeid", "-1");
		}
		if(model.getBrandid()!=null&&!"".equals(model.getBrandid().trim())){
			mapt.put("brandid", model.getBrandid().trim());
		}else{
			mapt.put("brandid", "-1");
		}
		if(model.getKeyword()!=null&&!"".equals(model.getKeyword().trim())){
			mapt.put("keyword", model.getKeyword().trim());
		}else{
			mapt.put("keyword", "");
		}
		mapt.put("filtertype","1");
		mapt.put("page", rs.getP_curPage().toString()); 
		mapt.put("size", rs.getP_pageSize().toString());
		String YAO_GATEWAY_URL = InfoUtil.getInstance().getInfo("config", "yao_geteway_url");
		
		String requestByUrl = ClientSubmit.buildRequestForSearch(mapt,YAO_GATEWAY_URL);
		System.out.println("============="+requestByUrl);
		if(requestByUrl!=null&&!"".equals(requestByUrl)){
			JSONObject jsonObject = JSONObject.fromObject(requestByUrl);
			JSONArray jsonArray = jsonObject.getJSONArray("models");
			String count=(String) jsonObject.get("count");
			System.out.println("============="+count);
			PageInfo pageInfo=new PageInfo();
			pageInfo.setCount(Integer.parseInt(count));
			pageInfo.setPage(rs.getP_curPage());
			pageInfo.setPageSize(rs.getP_pageSize());
			pageInfo=PageInfo.resetPageInfo(pageInfo);
			pw.setPageInfo(pageInfo);
			List<Map> ll = (List<Map>) jsonArray.toCollection(jsonArray, Map.class);
			for(int i=0;i<ll.size();i++){
				Map map1=new HashMap();
				map1.put("id", ll.get(i).get("goodsid"));
				map1.put("abbreviation_picture", ll.get(i).get("imgpath"));
				map1.put("goods_name", ll.get(i).get("fullname"));
				map1.put("pc_price", ll.get(i).get("realprice"));
				map1.put("price", ll.get(i).get("price"));
				map1.put("type", ll.get(i).get("isrx"));
				pw.getResult().add(map1);
			}
			
		}
//		t.id,t.short_name,t.pc_price,t.price,t.abbreviation_picture,t.pc_status
//		groupList = getGroupGoodsList();
		brandList = getBrandListByKeyword();
		return "getGoodListByKeyword";
	}
	public List<Map> getBrandListByKeyword() throws Exception{
		getCondition();
		Map mapt=new HashMap();
		mapt.put("parnterid", "1001");
		mapt.put("method", "search");
		mapt.put("from","1");
		mapt.put("sort", "-1");	
	    mapt.put("order", "-1");
		if(model.getPricea()!=null&&!"".equals(model.getPricea().trim())){
			mapt.put("pricea", can0(model.getPricea()).trim());
		}else{
			mapt.put("pricea", "0");
		}
		if(model.getPriceb()!=null&&!"".equals(model.getPriceb().trim())){
			mapt.put("priceb", can0(model.getPriceb()).trim());
		}else{
			mapt.put("priceb", "99999999");
		}
		if(model.getType()!=null&&!"".equals(model.getType().trim())){
			mapt.put("typeid", model.getType().trim());
		}else{
			mapt.put("typeid", "-1");
		}
			mapt.put("brandid", "-1");
		if(model.getKeyword()!=null&&!"".equals(model.getKeyword().trim())){
			mapt.put("keyword", model.getKeyword().trim());
		}else{
			mapt.put("keyword", "");
		}
		mapt.put("filtertype","2");
		mapt.put("page", "1"); 
		mapt.put("size", "100");
		String YAO_GATEWAY_URL = InfoUtil.getInstance().getInfo("config", "yao_geteway_url");
		String requestByUrl = ClientSubmit.buildRequestForSearchFilter(mapt,YAO_GATEWAY_URL);
		System.out.println("============="+requestByUrl);
		if(requestByUrl!=null&&!"".equals(requestByUrl)){
			JSONObject jsonObject = JSONObject.fromObject(requestByUrl);
			JSONArray jsonArray = jsonObject.getJSONArray("brandlist");
			List<Map> ll = (List<Map>) jsonArray.toCollection(jsonArray, Map.class);
			for(int i=0;i<ll.size();i++){
				if(ll.get(i).get("brandid")!=null&&!"0".equals(ll.get(i).get("brandid"))&&!"".equals(ll.get(i).get("brandid"))){
					Map mapb=new HashMap();
					mapb.put("brand_name", ll.get(i).get("brandname"));
					mapb.put("id", ll.get(i).get("brandid"));
					brandList.add(mapb);
				}
			}
			
		}
		return brandList;
	}
//品牌列表
	public String getGoodListByBrand() throws Exception{
		rs.setP_pageSize(40);
		Map map=getCondition();
		if(model.getBrandkey()!=null&&!"".equals(model.getBrandkey().trim())){
			brand=tbrandmanager.selectByPrimaryKey(new Long(model.getBrandkey().trim()));
			pw=opensqlmanage.selectForPageByMap(map, "t_goods.selectGoodsByBrandKeyCount", "t_goods.selectGoodsByBrandKey", rs.getP_curPage(), rs.getP_pageSize());
		}
		return "getGoodListByBrand";
	}
	
	public List<GroupGoodsModel> getGroupGoodsList() throws Exception{
		List<GroupGoodsModel> gList=new ArrayList<GroupGoodsModel>();
		if(model.getKeyword()!=null&&!"".equals(model.getKeyword().trim())){
			TGroupGoodsKeywordExample ggke=new TGroupGoodsKeywordExample();
			ggke.createCriteria().andKeywordLike(model.getKeyword().trim());
			List<TGroupGoodsKeyword> groupgoods = tgroupgoodskeywordmanager.selectByExample(ggke);
			for(TGroupGoodsKeyword goods:groupgoods){
				GroupGoodsModel gModel=new GroupGoodsModel();
				Map map=new HashMap();
				List<Map> groupList=new ArrayList<Map>();
				map.put("groupid", goods.getGoodsId());
				TGoods group= tgoodsmanager.selectByPrimaryKey(goods.getGoodsId());
				TGoodsPriceExample tgp=new TGoodsPriceExample();
				tgp.createCriteria().andGoodsIdEqualTo(goods.getGoodsId()).andPlatformTypeEqualTo("111yao").andPriceTypeEqualTo("pc");
				List<TGoodsPrice> tlist = tgoodspricemanager.selectByExample(tgp);
				groupList=opensqlmanage.selectForListByMap(map, "t_goods.selectGroupGoods");
				Map phMap = (Map)opensqlmanage.selectForObjectByMap(map, "t_goods.selectGroupGoodsComment");
				gModel.setId(group.getId());
				gModel.setName(group.getShortName());
				if(tlist!=null){
					TGoodsPrice price = tlist.get(0);
					gModel.setPcPrice(price.getPrice());
				}
				gModel.setPrice(group.getPrice());
				gModel.setPhMap(phMap);
				gModel.setGoodsList(groupList);
				gList.add(gModel);
			}
		}
		return gList;
	}
	public void getRelevanceForSearch() throws Exception{
		getResponse().setContentType("text/html;charset=utf-8");
		PrintWriter write = getResponse().getWriter();
		String json="";
		TMember tm = (TMember)this.getRequest().getSession().getAttribute("member");
		if(tm!=null&&tm.getId()!=null){
			TMemberCollectExample tmce=new TMemberCollectExample();
			tmce.createCriteria().andCollectTypeEqualTo(0).andMemberIdEqualTo(tm.getId());
			List<TMemberCollect> listTem = tmembercollectmanager.selectByExample(tmce);
			if(listTem!=null&&listTem.size()>0){
				for(TMemberCollect tmc:listTem){
					if(tmc!=null&&tmc.getRelevanceId()!=null){
						json+=","+tmc.getRelevanceId();
					}
				}
			}
		}
		write.write(json);
		write.close();
	}
	public class Condition {
//		private String basecate;//根级分类
		private String categoryid;//分类
//		private String secondcate;//二级分类
//		private String thirdcate;//三级分类
		private String type;//1:OTC,2处方药A，3处方药B
		private String brandid;//品牌
		private String pricea;//价格区间起始
		private String priceb;//价格区间结束
		private String sort;//排序方式  0默认，1 药师点评 2价格 3销量
		private String orderby;//排序规则1升序  2降序
		private String url;//路径
		private String keyword;
		private String brandkey;//品牌列表搜索
		private Long brandcate;//品牌馆根级
		
		
		
		public Long getBrandcate() {
			return brandcate;
		}
		public void setBrandcate(Long brandcate) {
			this.brandcate = brandcate;
		}
		public String getBrandkey() {
			return brandkey;
		}
		public void setBrandkey(String brandkey) {
			this.brandkey = brandkey;
		}
		public String getKeyword() {
			return keyword;
		}
		public void setKeyword(String keyword) {
			this.keyword = keyword;
		}
		public String getCategoryid() {
			return categoryid;
		}
		public void setCategoryid(String categoryid) {
			this.categoryid = categoryid;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getBrandid() {
			return brandid;
		}
		public void setBrandid(String brandid) {
			this.brandid = brandid;
		}
		public String getPricea() {
			return pricea;
		}
		public void setPricea(String pricea) {
			this.pricea = pricea;
		}
		public String getPriceb() {
			return priceb;
		}
		public void setPriceb(String priceb) {
			this.priceb = priceb;
		}
		public String getSort() {
			return sort;
		}
		public void setSort(String sort) {
			this.sort = sort;
		}
		public String getOrderby() {
			return orderby;
		}
		public void setOrderby(String orderby) {
			this.orderby = orderby;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		
		
	}
	
	@Override
	public Object getModel() {
		return this.model;
	}

	@Override
	public void setModel(Object o) {
		this.model = (Condition) o;
	}

	public PageWraper getPw() {
		return pw;
	}

	public void setPw(PageWraper pw) {
		this.pw = pw;
	}

	public PageResult getRs() {
		return rs;
	}

	public void setRs(PageResult rs) {
		this.rs = rs;
	}

	public OpenSqlManage getOpensqlmanage() {
		return opensqlmanage;
	}

	public void setOpensqlmanage(OpenSqlManage opensqlmanage) {
		this.opensqlmanage = opensqlmanage;
	}

	public String getUrl_A() {
		return Url_A;
	}

	public void setUrl_A(String url_A) {
		Url_A = url_A;
	}


	public String getUrl_E() {
		return Url_E;
	}

	public void setUrl_E(String url_E) {
		Url_E = url_E;
	}

	public String getUrl_F() {
		return Url_F;
	}

	public void setUrl_F(String url_F) {
		Url_F = url_F;
	}

	public String getUrl_G() {
		return Url_G;
	}

	public void setUrl_G(String url_G) {
		Url_G = url_G;
	}

	public String getUrl_H() {
		return Url_H;
	}

	public void setUrl_H(String url_H) {
		Url_H = url_H;
	}

	public String getUrl_I() {
		return Url_I;
	}

	public void setUrl_I(String url_I) {
		Url_I = url_I;
	}

	public String getUrl_J() {
		return Url_J;
	}

	public void setUrl_J(String url_J) {
		Url_J = url_J;
	}

	public TCategoryManager getTcategorymanager() {
		return tcategorymanager;
	}

	public void setTcategorymanager(TCategoryManager tcategorymanager) {
		this.tcategorymanager = tcategorymanager;
	}

	public List<TCategory> getCateList() {
		return cateList;
	}

	public void setCateList(List<TCategory> cateList) {
		this.cateList = cateList;
		
	}

	public TBrandManager getTbrandmanager() {
		return tbrandmanager;
	}

	public void setTbrandmanager(TBrandManager tbrandmanager) {
		this.tbrandmanager = tbrandmanager;
	}


	public List<Map> getCate1List() {
		return cate1List;
	}

	public void setCate1List(List<Map> cate1List) {
		this.cate1List = cate1List;
	}

	public String getUrl_K() {
		return Url_K;
	}

	public void setUrl_K(String url_K) {
		Url_K = url_K;
	}

	public String getUrl_L() {
		return Url_L;
	}

	public void setUrl_L(String url_L) {
		Url_L = url_L;
	}

	public List<Map> getBrandList() {
		return brandList;
	}

	public void setBrandList(List<Map> brandList) {
		this.brandList = brandList;
	}

	public String getUrl_B() {
		return Url_B;
	}

	public void setUrl_B(String url_B) {
		Url_B = url_B;
	}

	public TGroupGoodsKeywordManager getTgroupgoodskeywordmanager() {
		return tgroupgoodskeywordmanager;
	}

	public void setTgroupgoodskeywordmanager(
			TGroupGoodsKeywordManager tgroupgoodskeywordmanager) {
		this.tgroupgoodskeywordmanager = tgroupgoodskeywordmanager;
	}

	public TGoodsManager getTgoodsmanager() {
		return tgoodsmanager;
	}

	public void setTgoodsmanager(TGoodsManager tgoodsmanager) {
		this.tgoodsmanager = tgoodsmanager;
	}

	public List<GroupGoodsModel> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<GroupGoodsModel> groupList) {
		this.groupList = groupList;
	}

	public String getUrl_C() {
		return Url_C;
	}

	public void setUrl_C(String url_C) {
		Url_C = url_C;
	}

	public TBrand getBrand() {
		return brand;
	}

	public void setBrand(TBrand brand) {
		this.brand = brand;
	}

	public String getUrl_D() {
		return Url_D;
	}

	public void setUrl_D(String url_D) {
		Url_D = url_D;
	}

	public TMemberCollectManager getTmembercollectmanager() {
		return tmembercollectmanager;
	}

	public void setTmembercollectmanager(TMemberCollectManager tmembercollectmanager) {
		this.tmembercollectmanager = tmembercollectmanager;
	}

	public TGoodsPriceManager getTgoodspricemanager() {
		return tgoodspricemanager;
	}

	public void setTgoodspricemanager(TGoodsPriceManager tgoodspricemanager) {
		this.tgoodspricemanager = tgoodspricemanager;
	}


	
}
