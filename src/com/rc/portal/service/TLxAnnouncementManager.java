package com.rc.portal.service;



import java.sql.SQLException;
import java.util.List;

import com.rc.portal.vo.TLxAnnouncement;
import com.rc.portal.vo.TLxAnnouncementExample;

public interface TLxAnnouncementManager {
    int countByExample(TLxAnnouncementExample example) throws SQLException;

    int deleteByExample(TLxAnnouncementExample example) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    Long insert(TLxAnnouncement record) throws SQLException;

    Long insertSelective(TLxAnnouncement record) throws SQLException;

    List selectByExample(TLxAnnouncementExample example) throws SQLException;

    TLxAnnouncement selectByPrimaryKey(Long id) throws SQLException;

    int updateByExampleSelective(TLxAnnouncement record, TLxAnnouncementExample example) throws SQLException;

    int updateByExample(TLxAnnouncement record, TLxAnnouncementExample example) throws SQLException;

    int updateByPrimaryKeySelective(TLxAnnouncement record) throws SQLException;

    int updateByPrimaryKey(TLxAnnouncement record) throws SQLException;



}
