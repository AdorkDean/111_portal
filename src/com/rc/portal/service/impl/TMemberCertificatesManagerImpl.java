package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TMemberCertificatesDAO;
import com.rc.portal.service.TMemberCertificatesManager;
import com.rc.portal.vo.TMemberCertificates;
import com.rc.portal.vo.TMemberCertificatesExample;

public class TMemberCertificatesManagerImpl  implements TMemberCertificatesManager {

    private TMemberCertificatesDAO tmembercertificatesdao;

    public TMemberCertificatesManagerImpl() {
        super();
    }
    public void  setTmembercertificatesdao(TMemberCertificatesDAO tmembercertificatesdao){
        this.tmembercertificatesdao=tmembercertificatesdao;
    }
    public TMemberCertificatesDAO getTmembercertificatesdao(){
        return this.tmembercertificatesdao;
    }
    public     int countByExample(TMemberCertificatesExample example) throws SQLException{
        return tmembercertificatesdao. countByExample( example);
    }

    public     int deleteByExample(TMemberCertificatesExample example) throws SQLException{
        return tmembercertificatesdao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tmembercertificatesdao. deleteByPrimaryKey( id);
    }

    public     Long insert(TMemberCertificates record) throws SQLException{
        return tmembercertificatesdao. insert( record);
    }

    public     Long insertSelective(TMemberCertificates record) throws SQLException{
        return tmembercertificatesdao. insertSelective( record);
    }

    public     List selectByExample(TMemberCertificatesExample example) throws SQLException{
        return tmembercertificatesdao. selectByExample( example);
    }

    public     TMemberCertificates selectByPrimaryKey(Long id) throws SQLException{
        return tmembercertificatesdao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TMemberCertificates record, TMemberCertificatesExample example) throws SQLException{
        return tmembercertificatesdao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TMemberCertificates record, TMemberCertificatesExample example) throws SQLException{
        return tmembercertificatesdao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TMemberCertificates record) throws SQLException{
        return tmembercertificatesdao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TMemberCertificates record) throws SQLException{
        return tmembercertificatesdao. updateByPrimaryKey( record);
    }


}
