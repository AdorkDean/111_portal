package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TLeaderArticleDAO;
import com.rc.portal.service.TLeaderArticleManager;
import com.rc.portal.vo.TLeaderArticle;
import com.rc.portal.vo.TLeaderArticleExample;

public class TLeaderArticleManagerImpl  implements TLeaderArticleManager {

    private TLeaderArticleDAO tleaderarticledao;

    public TLeaderArticleManagerImpl() {
        super();
    }
    public void  setTleaderarticledao(TLeaderArticleDAO tleaderarticledao){
        this.tleaderarticledao=tleaderarticledao;
    }
    public TLeaderArticleDAO getTleaderarticledao(){
        return this.tleaderarticledao;
    }
    public     int countByExample(TLeaderArticleExample example) throws SQLException{
        return tleaderarticledao. countByExample( example);
    }

    public     int deleteByExample(TLeaderArticleExample example) throws SQLException{
        return tleaderarticledao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tleaderarticledao. deleteByPrimaryKey( id);
    }

    public     Long insert(TLeaderArticle record) throws SQLException{
        return tleaderarticledao. insert( record);
    }

    public     Long insertSelective(TLeaderArticle record) throws SQLException{
        return tleaderarticledao. insertSelective( record);
    }

    public     List selectByExampleWithBLOBs(TLeaderArticleExample example) throws SQLException{
        return tleaderarticledao. selectByExampleWithBLOBs( example);
    }

    public     List selectByExampleWithoutBLOBs(TLeaderArticleExample example) throws SQLException{
        return tleaderarticledao. selectByExampleWithoutBLOBs( example);
    }

    public     TLeaderArticle selectByPrimaryKey(Long id) throws SQLException{
        return tleaderarticledao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TLeaderArticle record, TLeaderArticleExample example) throws SQLException{
        return tleaderarticledao. updateByExampleSelective( record, example);
    }

    public     int updateByExampleWithBLOBs(TLeaderArticle record, TLeaderArticleExample example) throws SQLException{
        return tleaderarticledao. updateByExampleWithBLOBs( record, example);
    }

    public     int updateByExampleWithoutBLOBs(TLeaderArticle record, TLeaderArticleExample example) throws SQLException{
        return tleaderarticledao. updateByExampleWithoutBLOBs( record, example);
    }

    public     int updateByPrimaryKeySelective(TLeaderArticle record) throws SQLException{
        return tleaderarticledao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKeyWithBLOBs(TLeaderArticle record) throws SQLException{
        return tleaderarticledao. updateByPrimaryKeyWithBLOBs( record);
    }

    public     int updateByPrimaryKeyWithoutBLOBs(TLeaderArticle record) throws SQLException{
        return tleaderarticledao. updateByPrimaryKeyWithoutBLOBs( record);
    }


}
