package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.rc.portal.dao.CLocationCityDAO;
import com.rc.portal.service.CLocationCityManager;
import com.rc.portal.vo.CLocationCity;
import com.rc.portal.vo.CLocationCityExample;

public class CLocationCityManagerImpl  implements CLocationCityManager {

    private CLocationCityDAO clocationcitydao;

    public CLocationCityManagerImpl() {
        super();
    }
    public void  setClocationcitydao(CLocationCityDAO clocationcitydao){
        this.clocationcitydao=clocationcitydao;
    }
    public CLocationCityDAO getClocationcitydao(){
        return this.clocationcitydao;
    }
    public     int countByExample(CLocationCityExample example) throws SQLException{
        return clocationcitydao. countByExample( example);
    }

    public     int deleteByExample(CLocationCityExample example) throws SQLException{
        return clocationcitydao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Integer id) throws SQLException{
        return clocationcitydao. deleteByPrimaryKey( id);
    }

    public     Long insert(CLocationCity record) throws SQLException{
        return clocationcitydao. insert( record);
    }

    public     Long insertSelective(CLocationCity record) throws SQLException{
        return clocationcitydao. insertSelective( record);
    }

    public     List selectByExample(CLocationCityExample example) throws SQLException{
        return clocationcitydao. selectByExample( example);
    }

    public     CLocationCity selectByPrimaryKey(Integer id) throws SQLException{
        return clocationcitydao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(CLocationCity record, CLocationCityExample example) throws SQLException{
        return clocationcitydao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(CLocationCity record, CLocationCityExample example) throws SQLException{
        return clocationcitydao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(CLocationCity record) throws SQLException{
        return clocationcitydao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(CLocationCity record) throws SQLException{
        return clocationcitydao. updateByPrimaryKey( record);
    }

    public String selectAreaName(long id) throws SQLException {
		String allAreaName ="";
		List<CLocationCity> locationList = new ArrayList<CLocationCity>();
		locationList =selectAllArea(id,locationList);
		for (int i = locationList.size()-1; i >=0; i--) {
			allAreaName=allAreaName+locationList.get(i).getName()+"-";
		}
		if(StringUtils.hasText(allAreaName)){
			allAreaName = allAreaName.substring(0,allAreaName.length()-1);
		}
		return allAreaName;
	}
	public List<CLocationCity> selectAllArea(long id,List<CLocationCity> locationList) throws SQLException{
		CLocationCity location = this.clocationcitydao.selectByPrimaryKey(Integer.valueOf(String.valueOf(id)));
		locationList.add(location);
		if(location.getParentid()!=-1){
			selectAllArea(location.getParentid(),locationList);
		}else{
			return locationList;
		}
		return locationList;
	}

}
