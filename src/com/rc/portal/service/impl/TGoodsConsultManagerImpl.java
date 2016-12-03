package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.rc.portal.dao.TGoodsConsultDAO;
import com.rc.portal.service.TGoodsConsultManager;
import com.rc.portal.vo.TGoodsConsult;
import com.rc.portal.vo.TGoodsConsultExample;

public class TGoodsConsultManagerImpl  implements TGoodsConsultManager {

    private TGoodsConsultDAO tgoodsconsultdao;

    public TGoodsConsultManagerImpl() {
        super();
    }
    public void  setTgoodsconsultdao(TGoodsConsultDAO tgoodsconsultdao){
        this.tgoodsconsultdao=tgoodsconsultdao;
    }
    public TGoodsConsultDAO getTgoodsconsultdao(){
        return this.tgoodsconsultdao;
    }
    public     int countByExample(TGoodsConsultExample example) throws SQLException{
        return tgoodsconsultdao. countByExample( example);
    }

    public     int deleteByExample(TGoodsConsultExample example) throws SQLException{
        return tgoodsconsultdao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tgoodsconsultdao. deleteByPrimaryKey( id);
    }

    public     Long insert(TGoodsConsult record) throws SQLException{
        return tgoodsconsultdao. insert( record);
    }

    public     Long insertSelective(TGoodsConsult record) throws SQLException{
        return tgoodsconsultdao. insertSelective( record);
    }

    public     List selectByExample(TGoodsConsultExample example) throws SQLException{
        return tgoodsconsultdao. selectByExample( example);
    }

    public     TGoodsConsult selectByPrimaryKey(Long id) throws SQLException{
        return tgoodsconsultdao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TGoodsConsult record, TGoodsConsultExample example) throws SQLException{
        return tgoodsconsultdao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TGoodsConsult record, TGoodsConsultExample example) throws SQLException{
        return tgoodsconsultdao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TGoodsConsult record) throws SQLException{
        return tgoodsconsultdao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TGoodsConsult record) throws SQLException{
        return tgoodsconsultdao. updateByPrimaryKey( record);
    }
    
    
    
	@Override
	public List<TGoodsConsult> initAjaxGoodsConsult(Map<String, Object> map) throws SQLException {
		List<TGoodsConsult> list = tgoodsconsultdao.initAjaxGoodsConsult(map);
		return list;
	}
	@Override
	public int initAjaxGoodsConsultCount(Map<String, Object> map) throws SQLException {
		int cout = tgoodsconsultdao.initAjaxGoodsConsultCount(map);
		return cout;
	}


}
