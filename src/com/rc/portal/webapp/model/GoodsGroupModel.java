package com.rc.portal.webapp.model;

import java.math.BigDecimal;
import java.util.List;

public class GoodsGroupModel {
	private Long id; //组合id
	private BigDecimal price;
    private BigDecimal pcPrice;
    private BigDecimal wapPrice;
    private BigDecimal appPrice;
    private String comment_content;
    private Integer is_view;//是否显示 0 显示 1  不显示
    private String real_name;
    private String work_year;
    private String head_url;
    private List<GroupModel> list;
    
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String commentContent) {
		comment_content = commentContent;
	}
	public Integer getIs_view() {
		return is_view;
	}
	public void setIs_view(Integer isView) {
		is_view = isView;
	}
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String realName) {
		real_name = realName;
	}
	public String getWork_year() {
		return work_year;
	}
	public void setWork_year(String workYear) {
		work_year = workYear;
	}
	public String getHead_url() {
		return head_url;
	}
	public void setHead_url(String headUrl) {
		head_url = headUrl;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getPcPrice() {
		return pcPrice;
	}
	public void setPcPrice(BigDecimal pcPrice) {
		this.pcPrice = pcPrice;
	}
	public BigDecimal getWapPrice() {
		return wapPrice;
	}
	public void setWapPrice(BigDecimal wapPrice) {
		this.wapPrice = wapPrice;
	}
	public BigDecimal getAppPrice() {
		return appPrice;
	}
	public void setAppPrice(BigDecimal appPrice) {
		this.appPrice = appPrice;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<GroupModel> getList() {
		return list;
	}
	public void setList(List<GroupModel> list) {
		this.list = list;
	}
	
}
