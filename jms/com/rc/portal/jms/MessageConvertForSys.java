package com.rc.portal.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import com.rc.commons.jms.MessageModel;

/**
 * @Title: MessageConvertForSys.java
 * @Description:
 * @author yinbinhome@163.com
 * @date 2011-11-22 上午09:53:12
 * @version V1.0
 */

public class MessageConvertForSys implements MessageConverter {
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.jms.support.converter.MessageConverter#toMessage(
	 * java.lang.Object, javax.jms.Session)
	 */
	public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
		ObjectMessage objectMessage = session.createObjectMessage();
		// objectMessage.setJMSExpiration(1000);
		objectMessage.setObject((MessageModel) object);
		return objectMessage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.jms.support.converter.MessageConverter#fromMessage
	 * (javax.jms.Message)
	 */
	public Object fromMessage(Message message) throws JMSException, MessageConversionException {
		System.out.println("[fromMessage]");
		ObjectMessage objectMessage = (ObjectMessage) message;

		return objectMessage.getObjectProperty("key1");
	}
}
