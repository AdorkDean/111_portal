package com.rc.portal.webapp.model;

public class GoodsPremiumsModel {
	private Long id;
	private Long premiums_id;
	private Integer goodsum;
	private String short_name;
	private String spec;
	private String abbreviation_picture;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getGoodsum() {
		return goodsum;
	}
	public void setGoodsum(Integer goodsum) {
		this.goodsum = goodsum;
	}
	public String getShort_name() {
		return short_name;
	}
	public void setShort_name(String shortName) {
		short_name = shortName;
	}
	public String getAbbreviation_picture() {
		return abbreviation_picture;
	}
	public void setAbbreviation_picture(String abbreviationPicture) {
		abbreviation_picture = abbreviationPicture;
	}
	public Long getPremiums_id() {
		return premiums_id;
	}
	public void setPremiums_id(Long premiumsId) {
		premiums_id = premiumsId;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	
}
