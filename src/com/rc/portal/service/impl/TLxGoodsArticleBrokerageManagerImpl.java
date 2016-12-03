package com.rc.portal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rc.portal.dao.TLxGoodsArticleBrokerageDAO;
import com.rc.portal.service.TLxGoodsArticleBrokerageManager;
import com.rc.portal.vo.TLxGoodsArticleBrokerage;
import com.rc.portal.vo.TLxGoodsArticleBrokerageExample;

public class TLxGoodsArticleBrokerageManagerImpl  implements TLxGoodsArticleBrokerageManager {

    private TLxGoodsArticleBrokerageDAO tlxgoodsarticlebrokeragedao;

    public TLxGoodsArticleBrokerageManagerImpl() {
        super();
    }
    public void  setTlxgoodsarticlebrokeragedao(TLxGoodsArticleBrokerageDAO tlxgoodsarticlebrokeragedao){
        this.tlxgoodsarticlebrokeragedao=tlxgoodsarticlebrokeragedao;
    }
    public TLxGoodsArticleBrokerageDAO getTlxgoodsarticlebrokeragedao(){
        return this.tlxgoodsarticlebrokeragedao;
    }
    public     int countByExample(TLxGoodsArticleBrokerageExample example) throws SQLException{
        return tlxgoodsarticlebrokeragedao. countByExample( example);
    }

    public     int deleteByExample(TLxGoodsArticleBrokerageExample example) throws SQLException{
        return tlxgoodsarticlebrokeragedao. deleteByExample( example);
    }

    public     int deleteByPrimaryKey(Long id) throws SQLException{
        return tlxgoodsarticlebrokeragedao. deleteByPrimaryKey( id);
    }

    public     Long insert(TLxGoodsArticleBrokerage record) throws SQLException{
        return tlxgoodsarticlebrokeragedao. insert( record);
    }

    public     Long insertSelective(TLxGoodsArticleBrokerage record) throws SQLException{
        return tlxgoodsarticlebrokeragedao. insertSelective( record);
    }

    public     List selectByExample(TLxGoodsArticleBrokerageExample example) throws SQLException{
        return tlxgoodsarticlebrokeragedao. selectByExample( example);
    }

    public     TLxGoodsArticleBrokerage selectByPrimaryKey(Long id) throws SQLException{
        return tlxgoodsarticlebrokeragedao. selectByPrimaryKey( id);
    }

    public     int updateByExampleSelective(TLxGoodsArticleBrokerage record, TLxGoodsArticleBrokerageExample example) throws SQLException{
        return tlxgoodsarticlebrokeragedao. updateByExampleSelective( record, example);
    }

    public     int updateByExample(TLxGoodsArticleBrokerage record, TLxGoodsArticleBrokerageExample example) throws SQLException{
        return tlxgoodsarticlebrokeragedao. updateByExample( record, example);
    }

    public     int updateByPrimaryKeySelective(TLxGoodsArticleBrokerage record) throws SQLException{
        return tlxgoodsarticlebrokeragedao. updateByPrimaryKeySelective( record);
    }

    public     int updateByPrimaryKey(TLxGoodsArticleBrokerage record) throws SQLException{
        return tlxgoodsarticlebrokeragedao. updateByPrimaryKey( record);
    }


}
