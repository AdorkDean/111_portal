package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.rc.portal.dao.CLocationDAO;
import com.rc.portal.service.CLocationManager;
import com.rc.portal.vo.CLocation;
import com.rc.portal.vo.CLocationExample;

public class CLocationManagerImpl  implements CLocationManager {

    private CLocationDAO clocationdao;

    public CLocationManagerImpl() {
        super();
    }
    public void  setClocationdao(CLocationDAO clocationdao){
        this.clocationdao=clocationdao;
    }
    public CLocationDAO getClocationdao(){
        return this.clocationdao;
    }
    public     int countByExample(CLocationExample example) throws SQLException{
        return clocationdao. countByExample( example);
    }

    public     int deleteByExample(CLocationExample example) throws SQLException{
        return clocationdao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Integer id) throws SQLException{
        return clocationdao. deleteByPrimaryKey( id);
    }

    public     Long insert(CLocation record) throws SQLException{
        return clocationdao. insert( record);
    }

    public     Long insertSelective(CLocation record) throws SQLException{
        return clocationdao. insertSelective( record);
    }

    public     List selectByExample(CLocationExample example) throws SQLException{
        return clocationdao. selectByExample( example);
    }

    public     CLocation selectByPrimaryKey(Integer id) throws SQLException{
        return clocationdao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(CLocation record, CLocationExample example) throws SQLException{
        return clocationdao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(CLocation record, CLocationExample example) throws SQLException{
        return clocationdao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(CLocation record) throws SQLException{
        return clocationdao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(CLocation record) throws SQLException{
        return clocationdao. updateByPrimaryKey( record);
    }
	public String selectAreaName(long id) throws SQLException {
		String allAreaName ="";
		List<CLocation> locationList = new ArrayList<CLocation>();
		locationList =selectAllArea(id,locationList);
		for (int i = locationList.size()-1; i >=0; i--) {
			allAreaName=allAreaName+locationList.get(i).getName()+"-";
		}
		if(StringUtils.hasText(allAreaName)){
			allAreaName = allAreaName.substring(0,allAreaName.length()-1);
		}
		return allAreaName;
	}

	public List<CLocation> selectAllArea(long id,List<CLocation> locationList) throws SQLException{
		CLocation location = this.clocationdao.selectByPrimaryKey(Integer.valueOf(String.valueOf(id)));
		locationList.add(location);
		if(location.getParentid()!=-1){
			selectAllArea(location.getParentid(),locationList);
		}else{
			return locationList;
		}
		return locationList;
	}
	
	/**
	 * 根据地区ID查所有子地区
	 * @throws SQLException 
	 */
	@Override
	public List<CLocation> selectAllChildrenByParendId(Integer id) throws SQLException {
		List<CLocation> list = null;
		if(id>0){
			CLocationExample example = new CLocationExample();
			example.createCriteria().andParentidEqualTo(id);
			list = this.clocationdao.selectByExample(example);
		}
		return list;
	}

}
