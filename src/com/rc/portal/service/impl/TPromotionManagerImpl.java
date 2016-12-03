package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TPromotionDAO;
import com.rc.portal.service.TPromotionManager;
import com.rc.portal.vo.TPromotion;
import com.rc.portal.vo.TPromotionExample;

public class TPromotionManagerImpl  implements TPromotionManager {

    private TPromotionDAO tpromotiondao;

    public TPromotionManagerImpl() {
        super();
    }
    public void  setTpromotiondao(TPromotionDAO tpromotiondao){
        this.tpromotiondao=tpromotiondao;
    }
    public TPromotionDAO getTpromotiondao(){
        return this.tpromotiondao;
    }
    public     int countByExample(TPromotionExample example) throws SQLException{
        return tpromotiondao. countByExample( example);
    }

    public     int deleteByExample(TPromotionExample example) throws SQLException{
        return tpromotiondao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tpromotiondao. deleteByPrimaryKey( id);
    }

    public     Long insert(TPromotion record) throws SQLException{
        return tpromotiondao. insert( record);
    }

    public     Long insertSelective(TPromotion record) throws SQLException{
        return tpromotiondao. insertSelective( record);
    }

    public     List selectByExample(TPromotionExample example) throws SQLException{
        return tpromotiondao. selectByExample( example);
    }

    public     TPromotion selectByPrimaryKey(Long id) throws SQLException{
        return tpromotiondao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TPromotion record, TPromotionExample example) throws SQLException{
        return tpromotiondao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TPromotion record, TPromotionExample example) throws SQLException{
        return tpromotiondao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TPromotion record) throws SQLException{
        return tpromotiondao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TPromotion record) throws SQLException{
        return tpromotiondao. updateByPrimaryKey( record);
    }


}
