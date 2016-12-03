package com.rc.portal.vo;

import java.util.Date;

public class TCart {
    private Long id;

    private String cartKey;

    private Date createTime;

    private Long memberId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCartKey() {
        return cartKey;
    }

    public void setCartKey(String cartKey) {
        this.cartKey = cartKey;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
}