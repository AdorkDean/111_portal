package com.rc.portal.webapp.filter;

import javax.servlet.ServletContext;

import com.opensymphony.webwork.views.freemarker.FreemarkerManager;
import com.rc.app.framework.webapp.util.CurrencyMethod;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 * 货币处理
 * @author 刘天灵
 *
 */
public class ExtendFreemarkerManager extends FreemarkerManager{
	
	 protected Configuration createConfiguration(ServletContext servletContext)
		        throws TemplateException{
		 
        Configuration configuration = new Configuration();
        configuration.setTemplateLoader(getTemplateLoader(servletContext));
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
        
        configuration.setSharedVariable("currency", CurrencyMethod.getInstance());
        
        configuration.setObjectWrapper(getObjectWrapper());
        if(com.opensymphony.webwork.config.Configuration.isSet("webwork.i18n.encoding"))
            configuration.setDefaultEncoding(com.opensymphony.webwork.config.Configuration.getString("webwork.i18n.encoding"));
        loadSettings(servletContext, configuration);
        return configuration;
    }

}
