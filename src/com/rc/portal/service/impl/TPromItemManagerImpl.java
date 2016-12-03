package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TPromItemDAO;
import com.rc.portal.service.TPromItemManager;
import com.rc.portal.vo.TPromItem;
import com.rc.portal.vo.TPromItemExample;

public class TPromItemManagerImpl  implements TPromItemManager {

    private TPromItemDAO tpromitemdao;

    public TPromItemManagerImpl() {
        super();
    }
    public void  setTpromitemdao(TPromItemDAO tpromitemdao){
        this.tpromitemdao=tpromitemdao;
    }
    public TPromItemDAO getTpromitemdao(){
        return this.tpromitemdao;
    }
    public     int countByExample(TPromItemExample example) throws SQLException{
        return tpromitemdao. countByExample( example);
    }

    public     int deleteByExample(TPromItemExample example) throws SQLException{
        return tpromitemdao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tpromitemdao. deleteByPrimaryKey( id);
    }

    public     Long insert(TPromItem record) throws SQLException{
        return tpromitemdao. insert( record);
    }

    public     Long insertSelective(TPromItem record) throws SQLException{
        return tpromitemdao. insertSelective( record);
    }

    public     List selectByExample(TPromItemExample example) throws SQLException{
        return tpromitemdao. selectByExample( example);
    }

    public     TPromItem selectByPrimaryKey(Long id) throws SQLException{
        return tpromitemdao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TPromItem record, TPromItemExample example) throws SQLException{
        return tpromitemdao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TPromItem record, TPromItemExample example) throws SQLException{
        return tpromitemdao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TPromItem record) throws SQLException{
        return tpromitemdao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TPromItem record) throws SQLException{
        return tpromitemdao. updateByPrimaryKey( record);
    }


}
