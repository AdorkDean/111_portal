package com.rc.portal.memcache;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.security.AccessController;

import sun.security.action.GetPropertyAction;


/**
 * 
 * @author luoweifeng
 * 
 */

public class ConfigBuilderFactory {
	private static final String CONF_CACHE_PRENAME = "_cms_configfile";
	private static final String FSPROPERTY = "config.properties";
	
	public static String getConfigBuilderCacheName(String name) {
		return CONF_CACHE_PRENAME + "_" + name;
	}
	
	public static long getFileLastModified(String dir_path)
			throws FileNotFoundException {
		if (dir_path != null && dir_path.trim().length() > 0) {
			File file = new File(dir_path);

			if (!file.exists()) {
				throw new FileNotFoundException();
			}

			if (file.isDirectory()) {
				throw new FileNotFoundException();
			}

			return file.lastModified();
		} else {
			throw new FileNotFoundException();
		}
	}
	
	public static long getConfigFileLMTime(String name) {
		if (name != null && name.trim().length() > 0) {
			URL url = ConfigBuilderFactory.class.getResource(name);
			if (url != null) {
				String filePath = url.getPath();
				String ureDecodeFilePath = "";
				try {
					String urlEncodeName = (String) AccessController
							.doPrivileged(new GetPropertyAction("file.encoding"));

					ureDecodeFilePath = URLDecoder.decode(filePath,
							urlEncodeName);
				} catch (UnsupportedEncodingException e1) {
					ureDecodeFilePath = filePath;
					e1.printStackTrace();
				}

				try {
					return getFileLastModified(ureDecodeFilePath);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					return 0;
				}
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}
	
	public static long getConfigFileLMTime() {
		return getConfigFileLMTime("/" + FSPROPERTY);
	}
	
	public static ConfigBuilder getConfigBuilder() {
		return getConfigBuilder(FSPROPERTY);
	}
	
	public static ConfigBuilder getConfigBuilder(String fileName) {
		long lmTime = getConfigFileLMTime("/" + fileName);
		if (lmTime > 0) {
			String cacheName = getConfigBuilderCacheName(fileName);
			ICacheEntry chEntry = BaseModifyTimeCachePool
					.get(cacheName, lmTime);
			if (chEntry != null) {
				Object ceV = chEntry.getCeObject();
				if (ceV != null) {
					return (ConfigBuilder) ceV;
				} else {
					ConfigBuilder vObj = new ConfigBuilder(fileName);
					BaseModifyTimeCachePool.put(cacheName, vObj, lmTime);
					return vObj;
				}
			} else {
				ConfigBuilder vObj = new ConfigBuilder(fileName);
				BaseModifyTimeCachePool.put(cacheName, vObj, lmTime);
				return vObj;
			}
		} else {
			ConfigBuilder vObj = new ConfigBuilder(fileName);
			return vObj;
		}
	}
	
	public static void main(String[] argv) {
		getConfigFileLMTime();
	}
}