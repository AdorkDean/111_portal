package com.rc.portal.util;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by ws on 2015/4/9.
 */
public class PropertiesUtil {

    public static Properties readPropertiesFile( String propertiesFileName )
    {
        return readPropertiesFile( propertiesFileName, "UTF-8" );
    }

    public static Properties readPropertiesFile( String propertiesFileName, String charset )
    {
        if( StringUtil.isNull( propertiesFileName ) )
        {
            return null;
        }
        if( StringUtil.isNull( charset ) )
        {
            charset = "utf-8";
        }

        String filePath = PropertiesUtil.class.getResource("/").getPath().replaceAll("file:/", "") + propertiesFileName;
        Properties properties = new Properties();
        InputStreamReader inputStream = null;

        try {

            inputStream = new InputStreamReader(new FileInputStream(filePath), charset );
            properties.load(inputStream);

        } catch (Exception e) {
            e.printStackTrace();
        } finally{

            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    //e.printStackTrace();
                }
            }

        }

        return properties;

    }




    public static String getPropertyValue(String propertiesFileName, String propertyName) {
        if (StringUtil.isNull(propertiesFileName) || StringUtil.isNull(propertyName))
        {
            return "";
        }
        String value = "";
        try {
            value = (String) readPropertiesFile(propertiesFileName).get(propertyName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }

    public static String getPropertyValue( Properties properties, String propertyName) {
        if ( null == properties || StringUtil.isNull(propertyName) )
        {
            return "";
        }
        String value = "";
        try {
            value = (String) properties.get(propertyName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }


}
