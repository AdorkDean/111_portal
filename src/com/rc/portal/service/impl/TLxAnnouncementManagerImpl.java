package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TLxAnnouncementDAO;
import com.rc.portal.service.TLxAnnouncementManager;
import com.rc.portal.vo.TLxAnnouncement;
import com.rc.portal.vo.TLxAnnouncementExample;

public class TLxAnnouncementManagerImpl  implements TLxAnnouncementManager {

    private TLxAnnouncementDAO tlxannouncementdao;

    public TLxAnnouncementManagerImpl() {
        super();
    }
    public void  setTlxannouncementdao(TLxAnnouncementDAO tlxannouncementdao){
        this.tlxannouncementdao=tlxannouncementdao;
    }
    public TLxAnnouncementDAO getTlxannouncementdao(){
        return this.tlxannouncementdao;
    }
    public     int countByExample(TLxAnnouncementExample example) throws SQLException{
        return tlxannouncementdao. countByExample( example);
    }

    public     int deleteByExample(TLxAnnouncementExample example) throws SQLException{
        return tlxannouncementdao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tlxannouncementdao. deleteByPrimaryKey( id);
    }

    public     Long insert(TLxAnnouncement record) throws SQLException{
        return tlxannouncementdao. insert( record);
    }

    public     Long insertSelective(TLxAnnouncement record) throws SQLException{
        return tlxannouncementdao. insertSelective( record);
    }

    public     List selectByExample(TLxAnnouncementExample example) throws SQLException{
        return tlxannouncementdao. selectByExample( example);
    }

    public     TLxAnnouncement selectByPrimaryKey(Long id) throws SQLException{
        return tlxannouncementdao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TLxAnnouncement record, TLxAnnouncementExample example) throws SQLException{
        return tlxannouncementdao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TLxAnnouncement record, TLxAnnouncementExample example) throws SQLException{
        return tlxannouncementdao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TLxAnnouncement record) throws SQLException{
        return tlxannouncementdao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TLxAnnouncement record) throws SQLException{
        return tlxannouncementdao. updateByPrimaryKey( record);
    }


}
