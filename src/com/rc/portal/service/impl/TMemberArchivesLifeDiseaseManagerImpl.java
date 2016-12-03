package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TMemberArchivesLifeDiseaseDAO;
import com.rc.portal.service.TMemberArchivesLifeDiseaseManager;
import com.rc.portal.vo.TMemberArchivesLifeDisease;
import com.rc.portal.vo.TMemberArchivesLifeDiseaseExample;

public class TMemberArchivesLifeDiseaseManagerImpl  implements TMemberArchivesLifeDiseaseManager {

    private TMemberArchivesLifeDiseaseDAO tmemberarchiveslifediseasedao;

    public TMemberArchivesLifeDiseaseManagerImpl() {
        super();
    }
    public void  setTmemberarchiveslifediseasedao(TMemberArchivesLifeDiseaseDAO tmemberarchiveslifediseasedao){
        this.tmemberarchiveslifediseasedao=tmemberarchiveslifediseasedao;
    }
    public TMemberArchivesLifeDiseaseDAO getTmemberarchiveslifediseasedao(){
        return this.tmemberarchiveslifediseasedao;
    }
    public     int countByExample(TMemberArchivesLifeDiseaseExample example) throws SQLException{
        return tmemberarchiveslifediseasedao. countByExample( example);
    }

    public     int deleteByExample(TMemberArchivesLifeDiseaseExample example) throws SQLException{
        return tmemberarchiveslifediseasedao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tmemberarchiveslifediseasedao. deleteByPrimaryKey( id);
    }

    public     Long insert(TMemberArchivesLifeDisease record) throws SQLException{
        return tmemberarchiveslifediseasedao. insert( record);
    }

    public     Long insertSelective(TMemberArchivesLifeDisease record) throws SQLException{
        return tmemberarchiveslifediseasedao. insertSelective( record);
    }

    public     List selectByExample(TMemberArchivesLifeDiseaseExample example) throws SQLException{
        return tmemberarchiveslifediseasedao. selectByExample( example);
    }

    public     TMemberArchivesLifeDisease selectByPrimaryKey(Long id) throws SQLException{
        return tmemberarchiveslifediseasedao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TMemberArchivesLifeDisease record, TMemberArchivesLifeDiseaseExample example) throws SQLException{
        return tmemberarchiveslifediseasedao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TMemberArchivesLifeDisease record, TMemberArchivesLifeDiseaseExample example) throws SQLException{
        return tmemberarchiveslifediseasedao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TMemberArchivesLifeDisease record) throws SQLException{
        return tmemberarchiveslifediseasedao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TMemberArchivesLifeDisease record) throws SQLException{
        return tmemberarchiveslifediseasedao. updateByPrimaryKey( record);
    }


}
