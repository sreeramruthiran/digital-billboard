<%@page import="com.threecdc.billboard.manager.TickerTextManager"%>
<%@page import="com.threecdc.billboard.dto.TickerText"%>
<%@page import="com.threecdc.billboard.manager.BillboardManager"%>
<%@page import="com.threecdc.billboard.dto.Billboard"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% Billboard bc = null;
String id=request.getParameter("id");
List<Billboard> list = BillboardManager.getAllBillboards(); 
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
<body style="background-color: transparent;">

<div style="text-align:center;">
<font size="5">
<%= bc.getDisplayText() %>
</font>
</div>

</body>
</html>