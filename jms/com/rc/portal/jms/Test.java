package com.rc.portal.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;


/**
 * @Title: Test.java
 * @Description:
 * @author yinbinhome@163.com
 * @date 2012-1-30 下午04:08:54
 * @version V1.0
 */

public class Test {

	/**
	 * @param args
	 * @throws Exception 
	 * @throws JMSException 
	 */
	public static void main(String[] args) throws JMSException, Exception {
		ConnectionFactory factory =  new ActiveMQConnectionFactory("http://localhost:8088/111_yao_jms/");
		Connection connection = factory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue("12"); 
		MessageProducer producer = session.createProducer(destination); 
		System.out.println(producer);
		
		
//		System.out.println("初始化spring！准备开始接收！");
//		 ApplicationContext context = new
//		 ClassPathXmlApplicationContext("applicationContext-send.xml");
//		 MessageSender	 dd=(MessageSender)context.getBean("topicMessageSender");
//		 dd.sendMessage(new MessageModel("v2","dfasdf"));
//		 Thread.sleep(2000);
//		 dd.sendMessage(new MessageModel("v2","dfa1111sdf"));


	}

}
