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

Billboard bc = null;
String id=request.getParameter("id");
List<Billboard> list = BillboardManager.getAllBillboards(u.getId()); 
for (Billboard b: list){
	if (id==null || Integer.parseInt(id)<b.getId()){
		bc=b;
		break;
	}
}
if (bc==null){
	bc=list.get(0);
}
%>

<meta http-equiv="refresh" content="10;url=/showbillboard.jsp?id=<%= bc.getId() %>"/>
<html>
<link href="CSS_Template_<%= getServletContext().getAttribute("style") %>.css" rel="stylesheet" type="text/css" />
<body style="background-color: transparent;">

<div style="text-align:center;">
<div class = "BillboardText">
<%= bc.getDisplayText() %>
</div>
</div>

</body>
</html>