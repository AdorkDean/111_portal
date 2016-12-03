package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TLxArticleDAO;
import com.rc.portal.service.TLxArticleManager;
import com.rc.portal.vo.TLxArticle;
import com.rc.portal.vo.TLxArticleExample;
import com.rc.portal.vo.TLxArticleWithBLOBs;

public class TLxArticleManagerImpl  implements TLxArticleManager {

    private TLxArticleDAO tlxarticledao;

    public TLxArticleManagerImpl() {
        super();
    }
    public void  setTlxarticledao(TLxArticleDAO tlxarticledao){
        this.tlxarticledao=tlxarticledao;
    }
    public TLxArticleDAO getTlxarticledao(){
        return this.tlxarticledao;
    }
    public     int countByExample(TLxArticleExample example) throws SQLException{
        return tlxarticledao. countByExample( example);
    }

    public     int deleteByExample(TLxArticleExample example) throws SQLException{
        return tlxarticledao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Integer id) throws SQLException{
        return tlxarticledao. deleteByPrimaryKey( id);
    }

    public     Long insert(TLxArticleWithBLOBs record) throws SQLException{
        return tlxarticledao. insert( record);
    }

    public     Long insertSelective(TLxArticleWithBLOBs record) throws SQLException{
        return tlxarticledao. insertSelective( record);
    }

    public     List selectByExampleWithBLOBs(TLxArticleExample example) throws SQLException{
        return tlxarticledao. selectByExampleWithBLOBs( example);
    }

    public     List selectByExampleWithoutBLOBs(TLxArticleExample example) throws SQLException{
        return tlxarticledao. selectByExampleWithoutBLOBs( example);
    }

    public     TLxArticleWithBLOBs selectByPrimaryKey(Integer id) throws SQLException{
        return tlxarticledao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TLxArticleWithBLOBs record, TLxArticleExample example) throws SQLException{
        return tlxarticledao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TLxArticleWithBLOBs record, TLxArticleExample example) throws SQLException{
        return tlxarticledao. updateByExample( record, example);
    }

    public     int updateByExample(TLxArticle record, TLxArticleExample example) throws SQLException{
        return tlxarticledao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TLxArticleWithBLOBs record) throws SQLException{
        return tlxarticledao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TLxArticleWithBLOBs record) throws SQLException{
        return tlxarticledao. updateByPrimaryKey( record);
    }

    public     int updateByPrimaryKey(TLxArticle record) throws SQLException{
        return tlxarticledao. updateByPrimaryKey( record);
    }


}
