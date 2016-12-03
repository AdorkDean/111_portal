package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.RxTOrderDAO;
import com.rc.portal.service.RxTOrderManager;
import com.rc.portal.vo.RxTOrder;
import com.rc.portal.vo.RxTOrderExample;

public class RxTOrderManagerImpl  implements RxTOrderManager {

    private RxTOrderDAO rxtorderdao;

    public RxTOrderManagerImpl() {
        super();
    }
    public void  setRxtorderdao(RxTOrderDAO rxtorderdao){
        this.rxtorderdao=rxtorderdao;
    }
    public RxTOrderDAO getRxtorderdao(){
        return this.rxtorderdao;
    }
    public     int countByExample(RxTOrderExample example) throws SQLException{
        return rxtorderdao. countByExample( example);
    }

    public     int deleteByExample(RxTOrderExample example) throws SQLException{
        return rxtorderdao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return rxtorderdao. deleteByPrimaryKey( id);
    }

    public     Long insert(RxTOrder record) throws SQLException{
        return rxtorderdao. insert( record);
    }

    public     Long insertSelective(RxTOrder record) throws SQLException{
        return rxtorderdao. insertSelective( record);
    }

    public     List selectByExample(RxTOrderExample example) throws SQLException{
        return rxtorderdao. selectByExample( example);
    }

    public     RxTOrder selectByPrimaryKey(Long id) throws SQLException{
        return rxtorderdao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(RxTOrder record, RxTOrderExample example) throws SQLException{
        return rxtorderdao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(RxTOrder record, RxTOrderExample example) throws SQLException{
        return rxtorderdao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(RxTOrder record) throws SQLException{
        return rxtorderdao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(RxTOrder record) throws SQLException{
        return rxtorderdao. updateByPrimaryKey( record);
    }


}
