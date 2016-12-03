package com.rc.portal.memcache;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

public class MemCached {
	protected static final MemCachedClient mcc = new MemCachedClient();

	static {
		String serversV = ConfigBuilderFactory.getConfigBuilder().getProperty("MEMCACHE_SERVERS");
		String weightsV = ConfigBuilderFactory.getConfigBuilder().getProperty("MEMCACHE_WEIGHTS");

		String[] servers = serversV.split(",");

		String[] weightsi = weightsV.split(",");
		Integer[] weights = new Integer[weightsi.length];

		for (int i = 0; i < weightsi.length; i++) {
			weights[i] = Integer.parseInt(weightsi[i]);
		}

		// 创建一个实例对象SockIOPool
		SockIOPool pool = SockIOPool.getInstance();
		// 设置Memcached Server
		pool.setServers(servers);
		pool.setWeights(weights);
		// set some basic pool settings
		// 5 initial, 5 min, and 250 max conns
		// and set the max idle time for a conn to 3 hours
		pool.setInitConn(5);
		pool.setMinConn(5);
		pool.setMaxConn(250);
		pool.setMaxIdle(1000 * 60 * 60 * 3);
		// set the sleep for the maint thread
		// it will wake up every x seconds and
		// maintain the pool size
		pool.setMaintSleep(2000);
		// Tcp的规则就是在发送一个包之前，本地机器会等待远程主机
		// 对上一次发送的包的确认信息到来；这个方法就可以关闭套接字的缓存
		// 以至这个包准备好了就发
		pool.setNagle(false);
		// 连接建立后对超时的控制
		pool.setSocketTO(3000);
		// 连接建立时对超时的控制
		pool.setSocketConnectTO(0);
		// initialize the connection pool
		// 初始化一些值并与MemcachedServer段建立连接
		pool.initialize();
		// lets set some compression on for the client
		// compress anything larger than 64k
		mcc.setCompressEnable(true);
		mcc.setCompressThreshold(64 * 1024);
	}

	public static MemCachedClient getmcc() {
		return mcc;
	}

	public static void main(String arvg[]) {
		for(int  i=0;i<50;i++){
			MemCachedClient sm = MemCached.getmcc();
			System.out.println("n="+i+sm.getCounter("zhangyong"));
		}
		System.out.println(MemCached.getmcc().add("test", "zhangyong"));
		System.out.println(MemCached.getmcc().get("tk_areaweight_isupdate"));
		System.out.println(MemCached.getmcc().get("test"));
	}
}
