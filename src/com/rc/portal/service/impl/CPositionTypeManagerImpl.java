package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.CPositionTypeDAO;
import com.rc.portal.service.CPositionTypeManager;
import com.rc.portal.vo.CPositionType;
import com.rc.portal.vo.CPositionTypeExample;

public class CPositionTypeManagerImpl  implements CPositionTypeManager {

    private CPositionTypeDAO cpositiontypedao;

    public CPositionTypeManagerImpl() {
        super();
    }
    public void  setCpositiontypedao(CPositionTypeDAO cpositiontypedao){
        this.cpositiontypedao=cpositiontypedao;
    }
    public CPositionTypeDAO getCpositiontypedao(){
        return this.cpositiontypedao;
    }
    public     int countByExample(CPositionTypeExample example) throws SQLException{
        return cpositiontypedao. countByExample( example);
    }

    public     int deleteByExample(CPositionTypeExample example) throws SQLException{
        return cpositiontypedao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return cpositiontypedao. deleteByPrimaryKey( id);
    }

    public     Long insert(CPositionType record) throws SQLException{
        return cpositiontypedao. insert( record);
    }

    public     Long insertSelective(CPositionType record) throws SQLException{
        return cpositiontypedao. insertSelective( record);
    }

    public     List selectByExample(CPositionTypeExample example) throws SQLException{
        return cpositiontypedao. selectByExample( example);
    }

    public     CPositionType selectByPrimaryKey(Long id) throws SQLException{
        return cpositiontypedao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(CPositionType record, CPositionTypeExample example) throws SQLException{
        return cpositiontypedao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(CPositionType record, CPositionTypeExample example) throws SQLException{
        return cpositiontypedao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(CPositionType record) throws SQLException{
        return cpositiontypedao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(CPositionType record) throws SQLException{
        return cpositiontypedao. updateByPrimaryKey( record);
    }


}
