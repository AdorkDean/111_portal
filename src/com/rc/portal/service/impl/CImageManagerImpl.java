package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.CImageDAO;
import com.rc.portal.service.CImageManager;
import com.rc.portal.vo.CImage;
import com.rc.portal.vo.CImageExample;

public class CImageManagerImpl  implements CImageManager {

    private CImageDAO cimagedao;

    public CImageManagerImpl() {
        super();
    }
    public void  setCimagedao(CImageDAO cimagedao){
        this.cimagedao=cimagedao;
    }
    public CImageDAO getCimagedao(){
        return this.cimagedao;
    }
    public     int countByExample(CImageExample example) throws SQLException{
        return cimagedao. countByExample( example);
    }

    public     int deleteByExample(CImageExample example) throws SQLException{
        return cimagedao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Integer id) throws SQLException{
        return cimagedao. deleteByPrimaryKey( id);
    }

    public     Long insert(CImage record) throws SQLException{
        return cimagedao. insert( record);
    }

    public     Long insertSelective(CImage record) throws SQLException{
        return cimagedao. insertSelective( record);
    }

    public     List selectByExample(CImageExample example) throws SQLException{
        return cimagedao. selectByExample( example);
    }

    public     CImage selectByPrimaryKey(Integer id) throws SQLException{
        return cimagedao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(CImage record, CImageExample example) throws SQLException{
        return cimagedao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(CImage record, CImageExample example) throws SQLException{
        return cimagedao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(CImage record) throws SQLException{
        return cimagedao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(CImage record) throws SQLException{
        return cimagedao. updateByPrimaryKey( record);
    }


}
