package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TMemberArchivesMedicalRecordDAO;
import com.rc.portal.service.TMemberArchivesMedicalRecordManager;
import com.rc.portal.vo.TMemberArchivesMedicalRecord;
import com.rc.portal.vo.TMemberArchivesMedicalRecordExample;

public class TMemberArchivesMedicalRecordManagerImpl  implements TMemberArchivesMedicalRecordManager {

    private TMemberArchivesMedicalRecordDAO tmemberarchivesmedicalrecorddao;

    public TMemberArchivesMedicalRecordManagerImpl() {
        super();
    }
    public void  setTmemberarchivesmedicalrecorddao(TMemberArchivesMedicalRecordDAO tmemberarchivesmedicalrecorddao){
        this.tmemberarchivesmedicalrecorddao=tmemberarchivesmedicalrecorddao;
    }
    public TMemberArchivesMedicalRecordDAO getTmemberarchivesmedicalrecorddao(){
        return this.tmemberarchivesmedicalrecorddao;
    }
    public     int countByExample(TMemberArchivesMedicalRecordExample example) throws SQLException{
        return tmemberarchivesmedicalrecorddao. countByExample( example);
    }

    public     int deleteByExample(TMemberArchivesMedicalRecordExample example) throws SQLException{
        return tmemberarchivesmedicalrecorddao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tmemberarchivesmedicalrecorddao. deleteByPrimaryKey( id);
    }

    public     Long insert(TMemberArchivesMedicalRecord record) throws SQLException{
        return tmemberarchivesmedicalrecorddao. insert( record);
    }

    public     Long insertSelective(TMemberArchivesMedicalRecord record) throws SQLException{
        return tmemberarchivesmedicalrecorddao. insertSelective( record);
    }

    public     List selectByExample(TMemberArchivesMedicalRecordExample example) throws SQLException{
        return tmemberarchivesmedicalrecorddao. selectByExample( example);
    }

    public     TMemberArchivesMedicalRecord selectByPrimaryKey(Long id) throws SQLException{
        return tmemberarchivesmedicalrecorddao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TMemberArchivesMedicalRecord record, TMemberArchivesMedicalRecordExample example) throws SQLException{
        return tmemberarchivesmedicalrecorddao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TMemberArchivesMedicalRecord record, TMemberArchivesMedicalRecordExample example) throws SQLException{
        return tmemberarchivesmedicalrecorddao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TMemberArchivesMedicalRecord record) throws SQLException{
        return tmemberarchivesmedicalrecorddao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TMemberArchivesMedicalRecord record) throws SQLException{
        return tmemberarchivesmedicalrecorddao. updateByPrimaryKey( record);
    }


}
