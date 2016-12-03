package com.rc.portal.vo;

public class TGoodsExtendWithBLOBs extends TGoodsExtend {
    private byte[] goodsDescribe;

    private byte[] instruction;

    public byte[] getGoodsDescribe() {
        return goodsDescribe;
    }

    public void setGoodsDescribe(byte[] goodsDescribe) {
        this.goodsDescribe = goodsDescribe;
    }

    public byte[] getInstruction() {
        return instruction;
    }

    public void setInstruction(byte[] instruction) {
        this.instruction = instruction;
    }
}