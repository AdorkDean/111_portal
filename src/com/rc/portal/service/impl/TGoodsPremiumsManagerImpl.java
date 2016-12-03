package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TGoodsPremiumsDAO;
import com.rc.portal.service.TGoodsPremiumsManager;
import com.rc.portal.vo.TGoodsPremiums;
import com.rc.portal.vo.TGoodsPremiumsExample;

public class TGoodsPremiumsManagerImpl  implements TGoodsPremiumsManager {

    private TGoodsPremiumsDAO tgoodspremiumsdao;

    public TGoodsPremiumsManagerImpl() {
        super();
    }
    public void  setTgoodspremiumsdao(TGoodsPremiumsDAO tgoodspremiumsdao){
        this.tgoodspremiumsdao=tgoodspremiumsdao;
    }
    public TGoodsPremiumsDAO getTgoodspremiumsdao(){
        return this.tgoodspremiumsdao;
    }
    public     int countByExample(TGoodsPremiumsExample example) throws SQLException{
        return tgoodspremiumsdao. countByExample( example);
    }

    public     int deleteByExample(TGoodsPremiumsExample example) throws SQLException{
        return tgoodspremiumsdao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tgoodspremiumsdao. deleteByPrimaryKey( id);
    }

    public     Long insert(TGoodsPremiums record) throws SQLException{
        return tgoodspremiumsdao. insert( record);
    }

    public     Long insertSelective(TGoodsPremiums record) throws SQLException{
        return tgoodspremiumsdao. insertSelective( record);
    }

    public     List selectByExample(TGoodsPremiumsExample example) throws SQLException{
        return tgoodspremiumsdao. selectByExample( example);
    }

    public     TGoodsPremiums selectByPrimaryKey(Long id) throws SQLException{
        return tgoodspremiumsdao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TGoodsPremiums record, TGoodsPremiumsExample example) throws SQLException{
        return tgoodspremiumsdao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TGoodsPremiums record, TGoodsPremiumsExample example) throws SQLException{
        return tgoodspremiumsdao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TGoodsPremiums record) throws SQLException{
        return tgoodspremiumsdao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TGoodsPremiums record) throws SQLException{
        return tgoodspremiumsdao. updateByPrimaryKey( record);
    }


}
