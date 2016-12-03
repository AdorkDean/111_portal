package com.rc.portal.webapp.util;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;


public class MailSenderInfo {
// 发送邮件的服务器的IP和端口
 private String mailServerHost;
private String mailServerPort = "25";
 // 邮件发送者的地址　　　
private String fromAddress;
//邮件接收者的地址
private String toAddress;
// 登陆邮件发送服务器的用户名和密码
private String userName;
private String password;
// 是否需要身份验证
private boolean validate = false;
// 邮件主题
private String subject;
// 邮件的文本内容
private String content;
//邮件模板 路径
private String path;
// 邮件附件的文件名
private String[] attachFileNames;
private Address[] tos;
/** *//**
* 获得邮件会话属性
*/
public Properties getProperties(){
 Properties p = new Properties();
 System.out.println(this.mailServerHost);
 System.out.println(this.mailServerPort);
 p.put("mail.smtp.host", this.mailServerHost);
 p.put("mail.smtp.port", this.mailServerPort);
 p.put("mail.smtp.socketFactory.port", 465);
 p.put("mail.smtp.auth", validate ? "true" : "false");
 p.put("mail.smtp.starttls.enable", "true"); 
 
 p.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
 p.setProperty("mail.smtp.socketFactory.fallback", "false");
 p.setProperty("mail.smtp.port", "465");
 p.setProperty("mail.smtp.socketFactory.port", "465");




 return p;
}
public String getMailServerHost() {
	return mailServerHost;
}
public void setMailServerHost(String mailServerHost) {
	this.mailServerHost = mailServerHost;
}
public String getMailServerPort() {
	return mailServerPort;
}
public void setMailServerPort(String mailServerPort) {
	this.mailServerPort = mailServerPort;
}
public String getFromAddress() {
	return fromAddress;
}
public void setFromAddress(String fromAddress) {
	this.fromAddress = fromAddress;
}
public String getToAddress() {
	return toAddress;
}
public void setToAddress(String toAddress) {
	this.toAddress = toAddress;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public boolean isValidate() {
	return validate;
}
public void setValidate(boolean validate) {
	this.validate = validate;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String[] getAttachFileNames() {
	return attachFileNames;
}
public void setAttachFileNames(String[] attachFileNames) {
	this.attachFileNames = attachFileNames;
}

/**
 * 设置收件者
 * 
 * @param str
 * @return
 */
public boolean setTos(String str) {
    if (str != null && !"".equals(str)) {
        String[] to = str.split(",");
        Address[] addr = new Address[to.length];
        InternetAddress inter = null;
        for (int i = 0; i < to.length; i++) {
            try {
                inter = new InternetAddress(to[i]);
                addr[i] = inter;
            } catch (AddressException e) {
                e.printStackTrace();
            }
        }
        this.tos = addr;
        return true;
    } else {
        return false;
    }
}
/**
 * @return the to
 */
public Address[] getTos() {
    return tos;
}
public String getPath() {
	return path;
}
public void setPath(String path) {
	this.path = path;
}


}