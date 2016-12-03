<%@ page contentType="image/jpeg"
	import="java.awt.*,java.awt.image.*,java.util.*,javax.imageio.*,com.rc.portal.webapp.util.zxing.QRCodeZXingUtil"%>

<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
    String url =  request.getParameter("url");
    out.println(url);
	QRCodeZXingUtil.encoderQRCoder(url,response.getOutputStream(), 220);
	response.getOutputStream().close();
	out.clear();
	out = pageContext.pushBody();
%>
<%=url%>