<%@page import="com.threecdc.billboard.manager.TickerTextManager"%>
<%@page import="com.threecdc.billboard.dto.TickerText"%>
<%@page import="com.threecdc.billboard.manager.BillboardManager"%>
<%@page import="com.threecdc.billboard.dto.Billboard"%>
<%@page import="com.threecdc.billboard.dto.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
User u =(User)request.getSession().getAttribute("user");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Output</title>
<link href="CSS_Template_<%= getServletContext().getAttribute("style") %>.css" rel="stylesheet" type="text/css" />
<link href="stylelog.css" rel="stylesheet" type="text/css" />
</head>

<body>
<table border="0" style="background-image:url('background.jpg')" height="288" width="512" cellspacing="0" cellpadding="0">
<tr>
<td width="256" height="258"><img src="/images/<%=String.valueOf(u.getId()) %>bannerimage.jpg"/></td>
<td width="256" height="258">
<iframe allowtransparency="true" scrolling="no" frameborder="0" height="50%" width="256" src="showbillboard.jsp">
</iframe>
</td>
</tr>
<tr>
<td colspan="2" width="512" height="30"> <DIV ID="TICKER" STYLE="overflow:hidden; width:512px">
     <%= TickerTextManager.getNextTicker(u.getId()).getTickerText() %>
    </DIV>
    <script type="text/javascript" src="webticker_lib.js"></script></td>
</tr>

</table>
<p align="right">
<a href="http://localhost:8080/test.jsp">Back</a>
</p>
</body>
</html>