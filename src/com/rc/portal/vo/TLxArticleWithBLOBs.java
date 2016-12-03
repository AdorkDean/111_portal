package com.rc.portal.vo;

public class TLxArticleWithBLOBs extends TLxArticle {
    private String content;

    private byte[] shareTile;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public byte[] getShareTile() {
        return shareTile;
    }

    public void setShareTile(byte[] shareTile) {
        this.shareTile = shareTile;
    }
}