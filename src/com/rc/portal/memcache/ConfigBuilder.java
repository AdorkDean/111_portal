package com.rc.portal.memcache;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 * 
 * @author luoweifeng
 * 
 */
public class ConfigBuilder {
	private static final String FSPROPERTY = "config.properties";
	private Properties paraProps = new Properties();

	public ConfigBuilder() {
		loadFile(FSPROPERTY);
	}

	public ConfigBuilder(String confFile) {
		loadFile(confFile);
	}

	private void loadFile(String confFile) {
		if (confFile != null && confFile.trim().length() > 0) {
			InputStream is = this.getClass()
					.getResourceAsStream("/" + confFile);
			try {
				paraProps.load(is);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.err.println("不能读取配置文件" + FSPROPERTY + "请确保文件路径正确");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public String getProperty(String key, String defaultValue) {
		return paraProps.getProperty(key, defaultValue);
	}

	public String getProperty(String proName) {
		return paraProps.getProperty(proName);
	}

	public long getLongProperty(String proName) {
		String vString = this.getProperty(proName);
		if (vString != null && !vString.trim().equals("")) {
			long vLong = Long.parseLong(vString.trim());
			return vLong;
		} else {
			return 0;
		}
	}

	public long getLongProperty(String proName, long defaultV) {
		String vString = this.getProperty(proName);
		if (vString == null) {
			return defaultV;
		} else {
			if (!vString.trim().equals("")) {
				long vLong = Long.parseLong(vString.trim());
				return vLong;
			} else {
				return defaultV;
			}
		}
	}

	public int getIntProperty(String proName) {
		String vString = this.getProperty(proName);
		if (vString != null && !vString.trim().equals("")) {
			int vInt = Integer.parseInt(vString.trim());
			return vInt;
		} else {
			return 0;
		}
	}

	public int getIntProperty(String proName, int defaultV) {
		String vString = this.getProperty(proName);
		if (vString == null) {
			return defaultV;
		} else {
			if (!vString.trim().equals("")) {
				int vInt = Integer.parseInt(vString.trim());
				return vInt;
			} else {
				return defaultV;
			}
		}
	}

	public String setProperty(String vKey, String vValue) {
		Object oVal = paraProps.put(vKey, vValue);
		if (oVal != null) {
			return oVal.toString();
		} else {
			return null;
		}
	}

	public void setProperty(Map<String, String> proPerties) {
		if (proPerties != null && proPerties.size() > 0) {
			paraProps.putAll(proPerties);
		}
	}

	public void clear() {
		paraProps.clear();
	}

	public Properties getAllProperties() {
		return (Properties) paraProps.clone();
	}

	public String remove(String key) {
		Object vObj = paraProps.remove(key);
		if (vObj != null) {
			return vObj.toString();
		} else {
			return null;
		}
	}
    
	public void toStoreXMLFile(String fileName) throws IOException {
		if (fileName.lastIndexOf("/") > 0) {
			File dfile = new File(fileName.substring(0, fileName
					.lastIndexOf("/")));
			if (!dfile.exists())
				dfile.mkdirs();
			File file = new File(fileName);
			FileOutputStream writer = new FileOutputStream(file);
			paraProps.storeToXML(writer, null, "UTF-8");
		}
	}
	
	public void toStoreFile(String fileName) throws IOException {
		if (fileName.lastIndexOf("/") > 0) {
			File dfile = new File(fileName.substring(0, fileName
					.lastIndexOf("/")));
			if (!dfile.exists())
				dfile.mkdirs();
			
			File file = new File(fileName);
			FileOutputStream writer = new FileOutputStream(file);
			paraProps.store(writer, null);
		}
	}
}