<%@page import="com.threecdc.billboard.manager.TickerTextManager"%>
<%@page import="com.threecdc.billboard.manager.BillboardManager"%>
<%@page import="com.threecdc.billboard.dto.Billboard"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String action=request.getParameter("action");
if ("Add".equals(action) || "Update".equals(action)){
	getServletContext().getRequestDispatcher("/addupdate.jsp").forward(request,response);
	
}
if ("Delete".equals(action)){
	BillboardManager.deleteBillboard(Integer.parseInt(request.getParameter("billboardid")));
	response.sendRedirect("/test.jsp");
	
}
if ("SaveTicker".equals(action)){
	TickerTextManager.saveTickerText((request.getParameter("tickertext")));
	response.sendRedirect("/test.jsp");
	
}
if ("OutputPage".equals(action)){
	response.sendRedirect("/output.jsp");
	
}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test JSP</title>
</head>
<body>
<form method="post" action="/test.jsp">

<table>

<%
List<Billboard> list = BillboardManager.getAllBillboards(); 
for (Billboard b: list){
%>
	<tr> <td> <input type="radio" name="billboardid" value="<%= b.getId() %>"> <%= b.getDisplayText() %> </td> </tr> 
<% 
}
%>
</table>
<input type="submit" name="action" value="Add"/>
<input type="submit" name="action" value="Update"/>
<input type="submit" name="action" value="Delete"/>
<input type="submit" name="action" value="OutputPage"/>
<br/>
<br/>
<textarea name="tickertext" rows="5" cols="60"><%= TickerTextManager.getNextTicker().getTickerText() %></textarea>
<br/>
<input type="submit" name="action" value="SaveTicker">

</body>
</form>
</html>