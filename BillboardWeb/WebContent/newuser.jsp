<%@page import="com.threecdc.billboard.manager.UserManager"%>
<%@page import="com.threecdc.billboard.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String action = request.getParameter("action");
User u = new User();
if ("Update".equals(action)){
	u = UserManager.getUser(Integer.parseInt(request.getParameter("userid")));
} 
else if("Cancel".equals(action)){
	response.sendRedirect("/userlist.jsp");
}
else if("Save".equals(action)){
	String id = request.getParameter("id");
	String username = request.getParameter("username");
	u = new User();
	u.setId(Integer.parseInt(id));
	u.setUsername(username);
	u.setPassword(request.getParameter("password"));
	UserManager.saveUser(u);
	response.sendRedirect("/userlist.jsp");
}

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add/Update</title>
<link href="stylelog.css" rel="stylesheet" type="text/css" />
</head>
<body>
<form method="post" action="/newuser.jsp">
<input type="hidden" name="id" value="<%= u.getId() %>">
<input type="text" name="username" value="<%= u.getUsername() %>">
<input type="password" name="password" value="<%= u.getPassword() %>">
<br><input type="submit" name="action" value="Save"> 
<input type="submit" name="action" value="Cancel">
</form>
</body>
</html>