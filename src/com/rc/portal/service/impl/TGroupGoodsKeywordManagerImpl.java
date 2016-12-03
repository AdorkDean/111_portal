package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TGroupGoodsKeywordDAO;
import com.rc.portal.service.TGroupGoodsKeywordManager;
import com.rc.portal.vo.TGroupGoodsKeyword;
import com.rc.portal.vo.TGroupGoodsKeywordExample;

public class TGroupGoodsKeywordManagerImpl  implements TGroupGoodsKeywordManager {

    private TGroupGoodsKeywordDAO tgroupgoodskeyworddao;

    public TGroupGoodsKeywordManagerImpl() {
        super();
    }
    public void  setTgroupgoodskeyworddao(TGroupGoodsKeywordDAO tgroupgoodskeyworddao){
        this.tgroupgoodskeyworddao=tgroupgoodskeyworddao;
    }
    public TGroupGoodsKeywordDAO getTgroupgoodskeyworddao(){
        return this.tgroupgoodskeyworddao;
    }
    public     int countByExample(TGroupGoodsKeywordExample example) throws SQLException{
        return tgroupgoodskeyworddao. countByExample( example);
    }

    public     int deleteByExample(TGroupGoodsKeywordExample example) throws SQLException{
        return tgroupgoodskeyworddao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tgroupgoodskeyworddao. deleteByPrimaryKey( id);
    }

    public     Long insert(TGroupGoodsKeyword record) throws SQLException{
        return tgroupgoodskeyworddao. insert( record);
    }

    public     Long insertSelective(TGroupGoodsKeyword record) throws SQLException{
        return tgroupgoodskeyworddao. insertSelective( record);
    }

    public     List selectByExample(TGroupGoodsKeywordExample example) throws SQLException{
        return tgroupgoodskeyworddao. selectByExample( example);
    }

    public     TGroupGoodsKeyword selectByPrimaryKey(Long id) throws SQLException{
        return tgroupgoodskeyworddao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TGroupGoodsKeyword record, TGroupGoodsKeywordExample example) throws SQLException{
        return tgroupgoodskeyworddao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TGroupGoodsKeyword record, TGroupGoodsKeywordExample example) throws SQLException{
        return tgroupgoodskeyworddao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TGroupGoodsKeyword record) throws SQLException{
        return tgroupgoodskeyworddao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TGroupGoodsKeyword record) throws SQLException{
        return tgroupgoodskeyworddao. updateByPrimaryKey( record);
    }


}
