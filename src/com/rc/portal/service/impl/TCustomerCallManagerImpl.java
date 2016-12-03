package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TCustomerCallDAO;
import com.rc.portal.service.TCustomerCallManager;
import com.rc.portal.vo.TCustomerCall;
import com.rc.portal.vo.TCustomerCallExample;

public class TCustomerCallManagerImpl  implements TCustomerCallManager {

    private TCustomerCallDAO tcustomercalldao;

    public TCustomerCallManagerImpl() {
        super();
    }
    public void  setTcustomercalldao(TCustomerCallDAO tcustomercalldao){
        this.tcustomercalldao=tcustomercalldao;
    }
    public TCustomerCallDAO getTcustomercalldao(){
        return this.tcustomercalldao;
    }
    public     int countByExample(TCustomerCallExample example) throws SQLException{
        return tcustomercalldao. countByExample( example);
    }

    public     int deleteByExample(TCustomerCallExample example) throws SQLException{
        return tcustomercalldao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tcustomercalldao. deleteByPrimaryKey( id);
    }

    public     Long insert(TCustomerCall record) throws SQLException{
        return tcustomercalldao. insert( record);
    }

    public     Long insertSelective(TCustomerCall record) throws SQLException{
        return tcustomercalldao. insertSelective( record);
    }

    public     List selectByExample(TCustomerCallExample example) throws SQLException{
        return tcustomercalldao. selectByExample( example);
    }

    public     TCustomerCall selectByPrimaryKey(Long id) throws SQLException{
        return tcustomercalldao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TCustomerCall record, TCustomerCallExample example) throws SQLException{
        return tcustomercalldao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TCustomerCall record, TCustomerCallExample example) throws SQLException{
        return tcustomercalldao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TCustomerCall record) throws SQLException{
        return tcustomercalldao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TCustomerCall record) throws SQLException{
        return tcustomercalldao. updateByPrimaryKey( record);
    }


}
