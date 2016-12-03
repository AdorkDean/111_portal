package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TShortOrderDAO;
import com.rc.portal.service.TShortOrderManager;
import com.rc.portal.vo.TShortOrder;
import com.rc.portal.vo.TShortOrderExample;

public class TShortOrderManagerImpl  implements TShortOrderManager {

    private TShortOrderDAO tshortorderdao;

    public TShortOrderManagerImpl() {
        super();
    }
    public void  setTshortorderdao(TShortOrderDAO tshortorderdao){
        this.tshortorderdao=tshortorderdao;
    }
    public TShortOrderDAO getTshortorderdao(){
        return this.tshortorderdao;
    }
    public     int countByExample(TShortOrderExample example) throws SQLException{
        return tshortorderdao. countByExample( example);
    }


    public     int deleteByExample(TShortOrderExample example) throws SQLException{
        return tshortorderdao. deleteByExample( example);
    }


    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tshortorderdao. deleteByPrimaryKey( id);
    }


    public     Long insert(TShortOrder record) throws SQLException{
        return tshortorderdao. insert( record);
    }


    public     Long insertSelective(TShortOrder record) throws SQLException{
        return tshortorderdao. insertSelective( record);
    }


    public     List selectByExample(TShortOrderExample example) throws SQLException{
        return tshortorderdao. selectByExample( example);
    }


    public     TShortOrder selectByPrimaryKey(Long id) throws SQLException{
        return tshortorderdao. selectByPrimaryKey( id);
    }


    public     int updateByExampleSelective(TShortOrder record, TShortOrderExample example) throws SQLException{
        return tshortorderdao. updateByExampleSelective( record, example);
    }


    public     int updateByExample(TShortOrder record, TShortOrderExample example) throws SQLException{
        return tshortorderdao. updateByExample( record, example);
    }


    public     int updateByPrimaryKeySelective(TShortOrder record) throws SQLException{
        return tshortorderdao. updateByPrimaryKeySelective( record);
    }


    public     int updateByPrimaryKey(TShortOrder record) throws SQLException{
        return tshortorderdao. updateByPrimaryKey( record);
    }



}
