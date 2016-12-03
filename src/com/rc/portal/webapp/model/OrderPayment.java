package com.rc.portal.webapp.model;

import java.io.Serializable;
import java.util.Date;

import com.rc.portal.vo.TOrder;

/**
 * 订单和支付实体合并
 * @author 刘天灵
 *
 */
public class OrderPayment extends TOrder implements Serializable{

	private static final long serialVersionUID = 3523534251L;
	
	private Long id;

    private String name;

    private Integer paymentWay;

    private String icon;

    private Integer timeout;

    private String intro;

    private String content;

    private Integer sort;

    private Date createTime;

    private String paymentCode;
    
    private int reviews;
    
    private int rxOrder;
    
    
    
    public int getRxOrder() {
		return rxOrder;
	}

	public void setRxOrder(int rxOrder) {
		this.rxOrder = rxOrder;
	}

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

    public Integer getPaymentWay() {
        return paymentWay;
    }

    public void setPaymentWay(Integer paymentWay) {
        this.paymentWay = paymentWay;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

	public int getReviews() {
		return reviews;
	}

	public void setReviews(int reviews) {
		this.reviews = reviews;
	}
}
