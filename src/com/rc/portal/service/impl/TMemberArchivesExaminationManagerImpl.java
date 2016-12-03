package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TMemberArchivesExaminationDAO;
import com.rc.portal.service.TMemberArchivesExaminationManager;
import com.rc.portal.vo.TMemberArchivesExamination;
import com.rc.portal.vo.TMemberArchivesExaminationExample;

public class TMemberArchivesExaminationManagerImpl  implements TMemberArchivesExaminationManager {

    private TMemberArchivesExaminationDAO tmemberarchivesexaminationdao;

    public TMemberArchivesExaminationManagerImpl() {
        super();
    }
    public void  setTmemberarchivesexaminationdao(TMemberArchivesExaminationDAO tmemberarchivesexaminationdao){
        this.tmemberarchivesexaminationdao=tmemberarchivesexaminationdao;
    }
    public TMemberArchivesExaminationDAO getTmemberarchivesexaminationdao(){
        return this.tmemberarchivesexaminationdao;
    }
    public     int countByExample(TMemberArchivesExaminationExample example) throws SQLException{
        return tmemberarchivesexaminationdao. countByExample( example);
    }

    public     int deleteByExample(TMemberArchivesExaminationExample example) throws SQLException{
        return tmemberarchivesexaminationdao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tmemberarchivesexaminationdao. deleteByPrimaryKey( id);
    }

    public     Long insert(TMemberArchivesExamination record) throws SQLException{
        return tmemberarchivesexaminationdao. insert( record);
    }

    public     Long insertSelective(TMemberArchivesExamination record) throws SQLException{
        return tmemberarchivesexaminationdao. insertSelective( record);
    }

    public     List selectByExample(TMemberArchivesExaminationExample example) throws SQLException{
        return tmemberarchivesexaminationdao. selectByExample( example);
    }

    public     TMemberArchivesExamination selectByPrimaryKey(Long id) throws SQLException{
        return tmemberarchivesexaminationdao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TMemberArchivesExamination record, TMemberArchivesExaminationExample example) throws SQLException{
        return tmemberarchivesexaminationdao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TMemberArchivesExamination record, TMemberArchivesExaminationExample example) throws SQLException{
        return tmemberarchivesexaminationdao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TMemberArchivesExamination record) throws SQLException{
        return tmemberarchivesexaminationdao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TMemberArchivesExamination record) throws SQLException{
        return tmemberarchivesexaminationdao. updateByPrimaryKey( record);
    }


}
