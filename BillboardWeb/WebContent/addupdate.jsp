<%@page import="com.threecdc.billboard.manager.BillboardManager"%>
<%@page import="com.threecdc.billboard.dto.Billboard"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String action = request.getParameter("action");
Billboard b = new Billboard();
if ("Update".equals(action)){
	b = BillboardManager.getBillboard(Integer.parseInt(request.getParameter("billboardid")));
} 
else if("Cancel".equals(action)){
	response.sendRedirect("/test.jsp");
}
else if("Save".equals(action)){
	String id = request.getParameter("id");
	String displaytext = request.getParameter("displaytext");
	b = new Billboard();
	b.setId(Integer.parseInt(id));
	b.setDisplayText(displaytext);	
	BillboardManager.saveBillboard(b);
	response.sendRedirect("/test.jsp");
}

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add/Update</title>
<link href="stylelog.css" rel="stylesheet" type="text/css" />
</head>
<body>
<form method="post" action="/addupdate.jsp">
<input type="hidden" name="id" value="<%= b.getId() %>">
<input type="text" name="displaytext" value="<%= b.getDisplayText() %>">
<br><input type="submit" name="action" value="Save"> 
<input type="submit" name="action" value="Cancel">
</form>
</body>
</html>