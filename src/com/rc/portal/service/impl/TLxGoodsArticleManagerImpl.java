package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TLxGoodsArticleDAO;
import com.rc.portal.service.TLxGoodsArticleManager;
import com.rc.portal.vo.TLxGoodsArticle;
import com.rc.portal.vo.TLxGoodsArticleExample;

public class TLxGoodsArticleManagerImpl  implements TLxGoodsArticleManager {

    private TLxGoodsArticleDAO tlxgoodsarticledao;

    public TLxGoodsArticleManagerImpl() {
        super();
    }
    public void  setTlxgoodsarticledao(TLxGoodsArticleDAO tlxgoodsarticledao){
        this.tlxgoodsarticledao=tlxgoodsarticledao;
    }
    public TLxGoodsArticleDAO getTlxgoodsarticledao(){
        return this.tlxgoodsarticledao;
    }
    public     int countByExample(TLxGoodsArticleExample example) throws SQLException{
        return tlxgoodsarticledao. countByExample( example);
    }

    public     int deleteByExample(TLxGoodsArticleExample example) throws SQLException{
        return tlxgoodsarticledao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tlxgoodsarticledao. deleteByPrimaryKey( id);
    }

    public     Long insert(TLxGoodsArticle record) throws SQLException{
        return tlxgoodsarticledao. insert( record);
    }

    public     Long insertSelective(TLxGoodsArticle record) throws SQLException{
        return tlxgoodsarticledao. insertSelective( record);
    }

    public     List selectByExampleWithBLOBs(TLxGoodsArticleExample example) throws SQLException{
        return tlxgoodsarticledao. selectByExampleWithBLOBs( example);
    }

    public     List selectByExampleWithoutBLOBs(TLxGoodsArticleExample example) throws SQLException{
        return tlxgoodsarticledao. selectByExampleWithoutBLOBs( example);
    }

    public     TLxGoodsArticle selectByPrimaryKey(Long id) throws SQLException{
        return tlxgoodsarticledao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TLxGoodsArticle record, TLxGoodsArticleExample example) throws SQLException{
        return tlxgoodsarticledao. updateByExampleSelective( record, example);
    }

    public     int updateByExampleWithBLOBs(TLxGoodsArticle record, TLxGoodsArticleExample example) throws SQLException{
        return tlxgoodsarticledao. updateByExampleWithBLOBs( record, example);
    }

    public     int updateByExampleWithoutBLOBs(TLxGoodsArticle record, TLxGoodsArticleExample example) throws SQLException{
        return tlxgoodsarticledao. updateByExampleWithoutBLOBs( record, example);
    }

    public     int updateByPrimaryKeySelective(TLxGoodsArticle record) throws SQLException{
        return tlxgoodsarticledao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKeyWithBLOBs(TLxGoodsArticle record) throws SQLException{
        return tlxgoodsarticledao. updateByPrimaryKeyWithBLOBs( record);
    }

    public     int updateByPrimaryKeyWithoutBLOBs(TLxGoodsArticle record) throws SQLException{
        return tlxgoodsarticledao. updateByPrimaryKeyWithoutBLOBs( record);
    }


}
