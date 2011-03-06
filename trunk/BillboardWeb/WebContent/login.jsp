<%@page import="com.threecdc.billboard.dto.User"%>
<%@page import="com.threecdc.billboard.manager.UserManager"%>
<% 
User u = null;
if (request.getParameter("actioncommand")!= null){
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	u = UserManager.authenticateUser(username, password);
	if (u != null) {
		response.sendRedirect("test.jsp");
	}
}
%>
<html>
<head>
<title>Login</title>
<link href="stylelog.css" rel="stylesheet" type="text/css" />
</head>

<body>
      <% if (u == null && request.getParameter("actioncommand")!= null){
    	  %>
      <center><h2><font color="red">Login Failed</font></h2></center>
     <%} %>
<div id="layer01_holder">
  <div id="left"></div>
  <div id="center"></div>
  <div id="right"></div>
</div>

<div id="layer02_holder">
  <div id="left"></div>
  <div id="center"></div>
  <div id="right"></div>
</div>

<div id="layer03_holder">
  <div id="left"></div>
  <div id="center">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>LOGIN<br /><br /></td>
  </tr>
  <tr>
    <td><form id="form1" name="logonform" method="post" action="">
      <label>Name
        <input name="username" type="text" id="textfield" />
      </label>
      <label>Password  
      <input type="password" name="password" id="textfield2" style="margin-top:5px;" />
      </label>
      <label>
       <input type="submit" name="actioncommand" id="button" value="Submit" />
      </label>
    </form>    </td>
  </tr>
</table>
  </div>
  <div id="right"></div>
</div>

<div id="layer04_holder">
  <div id="left"></div>
  <div id="center">
  If you forgot your password, please contact administrator or <a href="#">click here</a></div>
  <div id="right"></div>
</div>

<div id="layer05_holder">
  <div align="left">Copyright © 2007, Artfans Design</div>
</div>
</body>
</html>