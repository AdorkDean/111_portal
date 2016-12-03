package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TCouponRelevanceDAO;
import com.rc.portal.service.TCouponRelevanceManager;
import com.rc.portal.vo.TCouponRelevance;
import com.rc.portal.vo.TCouponRelevanceExample;

public class TCouponRelevanceManagerImpl  implements TCouponRelevanceManager {

    private TCouponRelevanceDAO tcouponrelevancedao;

    public TCouponRelevanceManagerImpl() {
        super();
    }
    public void  setTcouponrelevancedao(TCouponRelevanceDAO tcouponrelevancedao){
        this.tcouponrelevancedao=tcouponrelevancedao;
    }
    public TCouponRelevanceDAO getTcouponrelevancedao(){
        return this.tcouponrelevancedao;
    }
    public     int countByExample(TCouponRelevanceExample example) throws SQLException{
        return tcouponrelevancedao. countByExample( example);
    }

    public     int deleteByExample(TCouponRelevanceExample example) throws SQLException{
        return tcouponrelevancedao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tcouponrelevancedao. deleteByPrimaryKey( id);
    }

    public     Long insert(TCouponRelevance record) throws SQLException{
        return tcouponrelevancedao. insert( record);
    }

    public     Long insertSelective(TCouponRelevance record) throws SQLException{
        return tcouponrelevancedao. insertSelective( record);
    }

    public     List selectByExample(TCouponRelevanceExample example) throws SQLException{
        return tcouponrelevancedao. selectByExample( example);
    }

    public     TCouponRelevance selectByPrimaryKey(Long id) throws SQLException{
        return tcouponrelevancedao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TCouponRelevance record, TCouponRelevanceExample example) throws SQLException{
        return tcouponrelevancedao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TCouponRelevance record, TCouponRelevanceExample example) throws SQLException{
        return tcouponrelevancedao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TCouponRelevance record) throws SQLException{
        return tcouponrelevancedao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TCouponRelevance record) throws SQLException{
        return tcouponrelevancedao. updateByPrimaryKey( record);
    }


}
