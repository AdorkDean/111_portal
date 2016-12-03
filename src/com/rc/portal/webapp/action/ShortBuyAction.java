package com.rc.portal.webapp.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rc.app.framework.webapp.action.BaseAction;
import com.rc.portal.service.OpenSqlManage;
import com.rc.portal.service.TShortBuyManager;
import com.rc.portal.service.TShortGoodsManager;
import com.rc.portal.service.TShortOrderManager;
import com.rc.portal.vo.TShortBuy;
import com.rc.portal.webapp.model.NotEnoughException;
import com.rc.portal.webapp.model.TimeString;

public class ShortBuyAction extends BaseAction {
	
	private  TShortBuyManager tshortbuymanager;
	private TShortGoodsManager tshortgoodsmanager;
	private OpenSqlManage opensqlmanage;
	private TShortOrderManager tshortordermanager;
	
	
	/**
	 * @param args
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws SQLException, IOException {
		
		ShortBuyAction o = new ShortBuyAction();
	    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext*.xml");

	     o.tshortbuymanager = (TShortBuyManager) context.getBean("tshortbuymanager");
	     o.opensqlmanage = (OpenSqlManage) context.getBean("opensqlmanage");
	     o.tshortgoodsmanager = (TShortGoodsManager) context.getBean("tshortgoodsmanager");
	     
//	     o.getCurrentShortBuy();
	     o.shortBuy();
	     
	}
	
	
	public void shortBuy() throws SQLException, IOException{
		
		
		PrintWriter out = this.getResponse().getWriter();
		
		long killid = 1;
		int killcount = 0;
		long memberId = 100;
		long goodsId = 1000;
		
		
		
		TShortBuy tsb = (TShortBuy)opensqlmanage.selectForObjectByMap(null, "t_short_buy.getCurrentShortBuy");
		if(tsb.getStatus()==1){	// 还没有开始
			out.print(-1);
			out.close();
			return;
		}
		if(tsb.getStatus()==3){		// 结束 
			out.print(-2);
			out.close();
			return;
		}
		
		
		Map param = new HashMap();
		
		param.put("killid", killid);
		param.put("killcount", killcount);
		param.put("memberid",memberId);
		param.put("goodsid", goodsId);
		
		long n;
		try {
			n = tshortbuymanager.shortBug(param);
		} catch (NotEnoughException e) {
			n = 0;
			e.printStackTrace();
		}
		if(n==0){ // 库存不足
			out.print(-3);
			out.close();
			return;
		}
		
		out.print(n);
		out.close();
		
		return;
	}
	
	
	public void getCurrentShortBuy() throws IOException, SQLException{
		
		PrintWriter  out = this.getResponse().getWriter();
		TShortBuy tsb = (TShortBuy)opensqlmanage.selectForObjectByMap(null, "t_short_buy.getCurrentShortBuy");
		
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		
//		TShortGoodsExample example = new TShortGoodsExample();
//		example.createCriteria().andShortBuyIdEqualTo(tsb.getId());
//		List<TShortGoods> list= tshortgoodsmanager.selectByExample(example);
		
		TimeString ts = new TimeString();
		ts.setStatus(tsb.getStatus());
		ts.setStime(format.format(tsb.getStartTime()));
		ts.setEtime(format.format(tsb.getEndTime()));
		JSONObject json = JSONObject.fromObject(ts);
		
		out.print(json.toString());
		out.close();
		
	}
	
	
	public int shortToOrder(long orderId,long killId){
		
		
		
		return 0;
		
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setModel(Object o) {
		// TODO Auto-generated method stub

	}

	

	public void setTshortbuymanager(TShortBuyManager tshortbuymanager) {
		this.tshortbuymanager = tshortbuymanager;
	}

	public void setTshortgoodsmanager(TShortGoodsManager tshortgoodsmanager) {
		this.tshortgoodsmanager = tshortgoodsmanager;
	}

	public void setOpensqlmanage(OpenSqlManage opensqlmanage) {
		this.opensqlmanage = opensqlmanage;
	}

	public void setTshortordermanager(TShortOrderManager tshortordermanager) {
		this.tshortordermanager = tshortordermanager;
	}

	

}
