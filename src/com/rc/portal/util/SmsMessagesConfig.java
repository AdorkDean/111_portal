package com.rc.portal.util;


import java.util.Properties;

import net.sf.json.JSONObject;

/**
 * Created by ws on 2015/8/21.
 */
public class SmsMessagesConfig {

    public static Properties smsMessagesConfigProperties;

    static {
    	smsMessagesConfigProperties = PropertiesUtil.readPropertiesFile("smsmessagesconfig.properties");
    }

    public static Properties getProperties()
    {
        if( smsMessagesConfigProperties == null )
        {
        	smsMessagesConfigProperties = PropertiesUtil.readPropertiesFile("smsmessagesconfig.properties");
        }

        return smsMessagesConfigProperties;
    }

    public static void main(String[] args) {
    	String sendResult = "{\"retCode\":\"success\",\"msg\":\"ok\",\"msgId\":212474683,\"openId\":\"operHjsGlrnh6homXBcJ-EBOtXjM\"}";
    	JSONObject sendResultJson = JSONObject.fromObject(sendResult);
    	System.out.println(sendResultJson.get("retCode"));
		
	}
}
