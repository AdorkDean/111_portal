package com.rc.portal.vo;

import java.math.BigDecimal;

public class CDeliveryWay {
    private Long id;

    private String name;

    private BigDecimal initWeight;

    private BigDecimal addWeight;

    private BigDecimal initPrice;

    private BigDecimal addPrice;

    private String icon;

    private String instro;

    private Integer sort;

    private Integer isFree;

    private String deliveryCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getInitWeight() {
        return initWeight;
    }

    public void setInitWeight(BigDecimal initWeight) {
        this.initWeight = initWeight;
    }

    public BigDecimal getAddWeight() {
        return addWeight;
    }

    public void setAddWeight(BigDecimal addWeight) {
        this.addWeight = addWeight;
    }

    public BigDecimal getInitPrice() {
        return initPrice;
    }

    public void setInitPrice(BigDecimal initPrice) {
        this.initPrice = initPrice;
    }

    public BigDecimal getAddPrice() {
        return addPrice;
    }

    public void setAddPrice(BigDecimal addPrice) {
        this.addPrice = addPrice;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getInstro() {
        return instro;
    }

    public void setInstro(String instro) {
        this.instro = instro;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getIsFree() {
        return isFree;
    }

    public void setIsFree(Integer isFree) {
        this.isFree = isFree;
    }

    public String getDeliveryCode() {
        return deliveryCode;
    }

    public void setDeliveryCode(String deliveryCode) {
        this.deliveryCode = deliveryCode;
    }
    /**
   	 * 计算运费
   	 * 
   	 * @param weight
   	 *            重量
   	 * @return 运费
   	 */
   	public BigDecimal calculateFreight(BigDecimal weight) {
   		BigDecimal freight = new BigDecimal(0);
   		if (weight != null) {
   			if (weight.compareTo(getInitWeight()) <= 0 || getAddPrice().compareTo(new BigDecimal(0)) == 0) {
   				freight = getInitPrice();
   			} else {
   				double contiuneWeightCount = Math.ceil((weight.subtract(getInitWeight())).divide(getAddWeight()).doubleValue());
   				freight = getInitPrice().add(getAddPrice().multiply(new BigDecimal(contiuneWeightCount)));
   			}
   		}
   		return freight;
   	}
}