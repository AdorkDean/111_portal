package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TMemberGradeDAO;
import com.rc.portal.service.TMemberGradeManager;
import com.rc.portal.vo.TMemberGrade;
import com.rc.portal.vo.TMemberGradeExample;

public class TMemberGradeManagerImpl  implements TMemberGradeManager {

    private TMemberGradeDAO tmembergradedao;

    public TMemberGradeManagerImpl() {
        super();
    }
    public void  setTmembergradedao(TMemberGradeDAO tmembergradedao){
        this.tmembergradedao=tmembergradedao;
    }
    public TMemberGradeDAO getTmembergradedao(){
        return this.tmembergradedao;
    }
    public     int countByExample(TMemberGradeExample example) throws SQLException{
        return tmembergradedao. countByExample( example);
    }

    public     int deleteByExample(TMemberGradeExample example) throws SQLException{
        return tmembergradedao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tmembergradedao. deleteByPrimaryKey( id);
    }

    public     Long insert(TMemberGrade record) throws SQLException{
        return tmembergradedao. insert( record);
    }

    public     Long insertSelective(TMemberGrade record) throws SQLException{
        return tmembergradedao. insertSelective( record);
    }

    public     List selectByExample(TMemberGradeExample example) throws SQLException{
        return tmembergradedao. selectByExample( example);
    }

    public     TMemberGrade selectByPrimaryKey(Long id) throws SQLException{
        return tmembergradedao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TMemberGrade record, TMemberGradeExample example) throws SQLException{
        return tmembergradedao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TMemberGrade record, TMemberGradeExample example) throws SQLException{
        return tmembergradedao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TMemberGrade record) throws SQLException{
        return tmembergradedao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TMemberGrade record) throws SQLException{
        return tmembergradedao. updateByPrimaryKey( record);
    }


}
