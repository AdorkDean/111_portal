package com.rc.portal.dao.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.portal.dao.IDaoManager;
import com.rc.portal.dao.TPromGiftDAO;
import com.rc.portal.vo.TPromItem;
import com.rc.portal.vo.TPromItemExample;
import com.rc.portal.vo.TPromotion;
import com.rc.portal.webapp.model.cart.CartGift;
import com.rc.portal.webapp.model.cart.CartParam;
import com.rc.portal.webapp.model.cart.CartPromModel;
import com.rc.portal.webapp.model.cart.GoodsPrice;

public class CartDaoImpl implements IDaoManager {
	
	private SqlMapClient sqlMapClient;
	private TPromItemDAOImpl tpromitemdao;
	private TPromotionDAOImpl tpromotiondao;
	private TPromGiftDAO tpromgiftdao;

    public static void main(String[] args) throws SQLException {
        
    	CartDaoImpl o = new CartDaoImpl();
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext*.xml");
    	o.sqlMapClient = (SqlMapClient) context.getBean("sqlMapClient");
    	o.tpromotiondao = (TPromotionDAOImpl) context.getBean("tpromotiondao");
    	o.tpromitemdao = (TPromItemDAOImpl) context.getBean("tpromitemdao");
    	
    	String key = "08AF9493-B205-4F2C-B48B-4F088FA869FBs";
    	
    	CartParam arg = new CartParam();
//    	arg.setCartkey(key);
    	arg.setGoodsId(320);
    	arg.setUserId(100L);
//    	arg.setIslogin(true);
    	
//    	Map map = o.accounts(arg);
//    	
//    	System.out.println("应付金额----"+map.get("money"));
//    	System.out.println("优惠金额----"+map.get("youhui"));
    	
//    	o.synCart(100, "F6CE1A34-A7E3-45E0-B742-DFE0D73BB2B6");
    	
    	
    	
    	
    }
    

	/**
	 * 查询一个商品是否在搞促销
	 * @param goodsid
	 * @return
	 * @throws SQLException
	 */
	public TPromotion getPromByGoods(long goodsid) throws SQLException{
		TPromotion prom = (TPromotion) sqlMapClient.queryForObject("mycart.is-goods-promotion", goodsid);
		if(prom==null){		// 该商品的分类是否在搞促销
			 prom = (TPromotion) sqlMapClient.queryForObject("mycart.is-category-promotion", goodsid);
		}
		return prom;
	}
	
	

	
	/**
	 * 计算机购物车的方法
	 * CartParam arg: 是一个对象，传商品ID，用户ID等信息
	 */
	public Map<String, Object> accounts(CartParam arg) throws SQLException {
		long ArgUserId = arg.getUserId();
		if (ArgUserId != 0) {
			arg.setIslogin(true);
		} else {
			arg.setIslogin(false);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> result = new HashMap<String, Object>();
		BigDecimal total = new BigDecimal(0); // 总数
		BigDecimal minmoney = new BigDecimal(0); // 满减的钱(所的类型促销所有的满减加起来的值
		List<Long> giftList = new ArrayList<Long>();
		Map<Long, Integer> cnt = new HashMap<Long, Integer>(); // 数量记数 key=id
		if (arg.isIslogin()) {
			map.put("userid", arg.getUserId());
		} else {
			map.put("uuid", arg.getCartkey());
		}
		if (StringUtils.hasText(arg.getCartType())) {
			map.put("is_ykt_good", arg.getCartType());
		}
		List<CartPromModel> cartlist = sqlMapClient.queryForList("mycart.prom_cart", map);
		System.out.println("购物车大小--->" + cartlist.size());
		int count = 0;
		List<CartPromModel> normal = new ArrayList<CartPromModel>();
		List<CartPromModel> single = new ArrayList<CartPromModel>();
		Map<Long, List<CartPromModel>> MixMap = new HashMap<Long, List<CartPromModel>>();
		// Map<Long, List<CartPromModel>> CategoryMap = new HashMap<Long,
		// List<CartPromModel>>();
		List<Long> category = new ArrayList<Long>(); // 存放父分类在促销的商品
		TPromotion prom = null;
		for (CartPromModel m : cartlist) {
			cnt.put(m.getGoods_id(), m.getQuantity());
			if (m.getPromotion_id() == null) {
				// 商品不为单品，也没有满返，分类是否在促销
				prom = getPromByGoods(m.getGoods_id());
				if (prom == null) {
					normal.add(m); // 正常商品
				} else { // 分类在促销
					if (prom.getType() == 3)
						category.add(m.getGoods_id());
				}
			} else {
				// 如果在促销中，促销是否正在进行
				prom = tpromotiondao.selectByPrimaryKey(m.getPromotion_id());
				if (prom != null) {
					if (prom.getStatus() != 2) { // 如果促销还没有开始
						normal.add(m); // 正常商品处理
					} else {
						if (m.getType() == 1) { // 单品
							single.add(m);
						} else if (m.getType() == 2) { // 满返
							boolean cont = MixMap.containsKey(m.getPromotion_id());
							if (cont) {
								MixMap.get(m.getPromotion_id()).add(m);
							} else {
								List<CartPromModel> list = new ArrayList<CartPromModel>();
								list.add(m);
								MixMap.put(m.getPromotion_id(), list);
							}
						} else if (m.getType() == 3) { // 分类促销
							category.add(m.getGoods_id());
						}
					}
				}

			}
			count = count + m.getQuantity();
			total = total.add(m.getPc_price().multiply(new BigDecimal(m.getQuantity())));
			// map1.put(m.getGoods_id(), m.getQuantity());
		}
		// 算单品
		TPromItemExample example = new TPromItemExample();
		for (CartPromModel cp : single) {
			example.createCriteria().andPidEqualTo(cp.getPromotion_id()).andTargetIdEqualTo(cp.getGoods_id());
			List<TPromItem> list = tpromitemdao.selectByExample(example);
			if (list.size() > 0) {
				TPromItem item = list.get(0);
				if (item != null) {
					minmoney = minmoney.add((cp.getPc_price().subtract(item.getPrice())).multiply(new BigDecimal(cp
							.getQuantity())));
				}
			}
			example.clear();
			// 查询赠品
			CartGift gift = (CartGift) sqlMapClient.queryForObject("mycart.cart-prom-gift", cp.getPromotion_id());
			if (gift != null) {
				// giftMap.put(cp.getPromotion_id(), gift);
			}
		}

		// 算满返
		Set<Long> keys = MixMap.keySet();
		List<CartPromModel> l = null;
		Map<Long, BigDecimal> mp = new HashMap<Long, BigDecimal>();
		GoodsPrice goodsPrice = null;
		BigDecimal bigdc = new BigDecimal(0);
		for (Long k : keys) {
			l = MixMap.get(k);

			for (CartPromModel cpm : l) {
				goodsPrice = getGoodsPrice(cpm.getGoods_id().longValue());
				bigdc = bigdc.add(goodsPrice.getPc_price().multiply(new BigDecimal(cpm.getQuantity())));
			}
			mp.put(k, bigdc);
		}
		BigDecimal dem = null;
		for (Long k : keys) {
			dem = mp.get(k);
			prom = tpromotiondao.selectByPrimaryKey(k);
			int com = dem.compareTo(prom.getMinAmount()); // 与相应的促销最低消费值比较
			if (com == 0 || com == 1) { // 如果达最低消费金额
				minmoney = minmoney.add(prom.getAmount());
				giftList.add(prom.getId());
			} else {
				giftList.remove(prom.getId());
			}
		}
		System.out.println("category==============" + category.size());
		// 算分类
		Map<Long, Long> map1 = new HashMap<Long, Long>();
		TPromotion p = null;
		for (Long goosdid : category) {
			System.out.println("========++++++++++++=========>" + goosdid);
			p = getPromByGoods(goosdid);
			if (p != null && p.getType() == 3) {// 查询促销所有分类
				map1.put(goosdid, p.getId());
			}
		}

		Map<Long, List<Long>> map2 = new HashMap<Long, List<Long>>();
		List<Long> valueGoodsId = new ArrayList<Long>();
		if (map1.size() > 0) {
			long promIdKey;
			Set<Long> set = map1.keySet(); // key=商品ID
			for (Long goodsid : set) {
				promIdKey = map1.get(goodsid);
				valueGoodsId.add(goodsid);
				if (map2.containsKey(promIdKey)) { // 存在ID该促销的的KEY
					map2.get(promIdKey).add(goodsid);
				} else {
					valueGoodsId = new ArrayList<Long>();
					valueGoodsId.add(goodsid);
					map2.put(promIdKey, valueGoodsId);
				}
			}
		}

		if (map2.size() > 0) {
			Set<Long> set = map2.keySet();
			TPromotion promotion = null;
			BigDecimal cateMenoy = new BigDecimal(0);
			List<Long> valGoodsIdList = null;
			for (Long promid : set) {// 促销ID
				valGoodsIdList = map2.get(promid);
				for (long goodsid : valGoodsIdList) {
					cateMenoy = cateMenoy.add(getGoodsPrice(goodsid).getPc_price().multiply(
							new BigDecimal(cnt.get(goodsid))));
				}
				promotion = tpromotiondao.selectByPrimaryKey(promid);
				int com = cateMenoy.compareTo(promotion.getMinAmount()); // 与相应的促销最低消费值比较
				System.out.println("cateMenoy=" + cateMenoy + " promotion.getMinAmount()=" + promotion.getMinAmount());
				if (com == 0 || com == 1) { // 如果达最低消费金额
					minmoney = minmoney.add(promotion.getAmount());
				}
				cateMenoy = new BigDecimal(0);
			}
		}
		// map2的格式： key=促销ID List:value=商品ID1,商品ID2,商品ID3
		StringBuilder sbl = new StringBuilder("0");
		for (Long id : giftList) {
			sbl.append("," + id);
		}
		map.put("giftpid", sbl.toString());
		List<CartGift> giftlist = sqlMapClient.queryForList("mycart.many-prom-gift", map);
		System.out.println("===========>" + minmoney);
		result.put("count", count);
		result.put("money", total.subtract(minmoney));
		result.put("youhui", minmoney);
		result.put("gift", giftlist);
		return result;
	}

	public GoodsPrice getGoodsPrice(long id) throws SQLException{
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("goodsid",id);
		GoodsPrice goodsprice = (GoodsPrice) sqlMapClient.queryForObject("mycart.get-goods-price",m);
		return goodsprice;
	}
	
	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public TPromItemDAOImpl getTpromitemdao() {
		return tpromitemdao;
	}

	public void setTpromitemdao(TPromItemDAOImpl tpromitemdao) {
		this.tpromitemdao = tpromitemdao;
	}

	public TPromotionDAOImpl getTpromotiondao() {
		return tpromotiondao;
	}

	public void setTpromotiondao(TPromotionDAOImpl tpromotiondao) {
		this.tpromotiondao = tpromotiondao;
	}



	public TPromGiftDAO getTpromgiftdao() {
		return tpromgiftdao;
	}



	public void setTpromgiftdao(TPromGiftDAO tpromgiftdao) {
		this.tpromgiftdao = tpromgiftdao;
	}
	
	
	
	

}
