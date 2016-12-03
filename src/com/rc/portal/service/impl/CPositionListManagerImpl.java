package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.CPositionListDAO;
import com.rc.portal.service.CPositionListManager;
import com.rc.portal.vo.CPositionList;
import com.rc.portal.vo.CPositionListExample;

public class CPositionListManagerImpl  implements CPositionListManager {

    private CPositionListDAO cpositionlistdao;

    public CPositionListManagerImpl() {
        super();
    }
    public void  setCpositionlistdao(CPositionListDAO cpositionlistdao){
        this.cpositionlistdao=cpositionlistdao;
    }
    public CPositionListDAO getCpositionlistdao(){
        return this.cpositionlistdao;
    }
    public     int countByExample(CPositionListExample example) throws SQLException{
        return cpositionlistdao. countByExample( example);
    }

    public     int deleteByExample(CPositionListExample example) throws SQLException{
        return cpositionlistdao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Integer id) throws SQLException{
        return cpositionlistdao. deleteByPrimaryKey( id);
    }

    public     Long insert(CPositionList record) throws SQLException{
        return cpositionlistdao. insert( record);
    }

    public     Long insertSelective(CPositionList record) throws SQLException{
        return cpositionlistdao. insertSelective( record);
    }

    public     List selectByExample(CPositionListExample example) throws SQLException{
        return cpositionlistdao. selectByExample( example);
    }

    public     CPositionList selectByPrimaryKey(Integer id) throws SQLException{
        return cpositionlistdao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(CPositionList record, CPositionListExample example) throws SQLException{
        return cpositionlistdao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(CPositionList record, CPositionListExample example) throws SQLException{
        return cpositionlistdao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(CPositionList record) throws SQLException{
        return cpositionlistdao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(CPositionList record) throws SQLException{
        return cpositionlistdao. updateByPrimaryKey( record);
    }


}
