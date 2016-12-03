<%--
  Created by IntelliJ IDEA.
  User: ws
  Date: 2015/4/10
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.rc.portal.util.SmsMessagesConfig"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    SmsMessagesConfig.smsMessagesConfigProperties = null;
    System.gc();
    out.println("ok!");
%>

</body>
</html>
