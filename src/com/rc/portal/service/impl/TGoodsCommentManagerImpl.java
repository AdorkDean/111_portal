package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.rc.portal.dao.TGoodsCommentDAO;
import com.rc.portal.service.TGoodsCommentManager;
import com.rc.portal.vo.TGoodsComment;
import com.rc.portal.vo.TGoodsCommentExample;

public class TGoodsCommentManagerImpl  implements TGoodsCommentManager {

    private TGoodsCommentDAO tgoodscommentdao;

    public TGoodsCommentManagerImpl() {
        super();
    }
    public void  setTgoodscommentdao(TGoodsCommentDAO tgoodscommentdao){
        this.tgoodscommentdao=tgoodscommentdao;
    }
    public TGoodsCommentDAO getTgoodscommentdao(){
        return this.tgoodscommentdao;
    }
    public     int countByExample(TGoodsCommentExample example) throws SQLException{
        return tgoodscommentdao. countByExample( example);
    }

    public     int deleteByExample(TGoodsCommentExample example) throws SQLException{
        return tgoodscommentdao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tgoodscommentdao. deleteByPrimaryKey( id);
    }

    public     Long insert(TGoodsComment record) throws SQLException{
        return tgoodscommentdao. insert( record);
    }

    public     Long insertSelective(TGoodsComment record) throws SQLException{
        return tgoodscommentdao. insertSelective( record);
    }

    public     List selectByExample(TGoodsCommentExample example) throws SQLException{
        return tgoodscommentdao. selectByExample( example);
    }

    public     TGoodsComment selectByPrimaryKey(Long id) throws SQLException{
        return tgoodscommentdao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TGoodsComment record, TGoodsCommentExample example) throws SQLException{
        return tgoodscommentdao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TGoodsComment record, TGoodsCommentExample example) throws SQLException{
        return tgoodscommentdao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TGoodsComment record) throws SQLException{
        return tgoodscommentdao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TGoodsComment record) throws SQLException{
        return tgoodscommentdao. updateByPrimaryKey( record);
    }
	@Override
	public List<TGoodsComment> selectGoodscommentByAjax(Map<String, Object> map) {
		List<TGoodsComment> list= tgoodscommentdao.selectGoodscommentByAjax(map);
		return list;
	}


}
