<%@page import="com.threecdc.billboard.manager.UserManager"%>
<%@page import="com.threecdc.billboard.dto.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String action=request.getParameter("action");
if ("Add".equals(action) || "Update".equals(action)){
	getServletContext().getRequestDispatcher("/newuser.jsp").forward(request,response);
	
}
if ("Delete".equals(action)){
	UserManager.deleteUser(Integer.parseInt(request.getParameter("userid")));
	response.sendRedirect("/userlist.jsp");	
}
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Maint</title>
<link href="stylelog.css" rel="stylesheet" type="text/css" />
</head>
<body>
<form method="post" action="/userlist.jsp">


<table>

<%
List<User> list = UserManager.getAllUsers(); 
for (User u: list){
%>
	<tr> <td> <input type="radio" name="userid" value="<%= u.getId() %>"> <%= u.getUsername() %> </td> </tr> 
<% 
}
%>
</table>
<input type="submit" name="action" value="Add"/>
<input type="submit" name="action" value="Update"/>
<input type="submit" name="action" value="Delete"/>
<br/>
<br/>
</form>
</body>
</html>
