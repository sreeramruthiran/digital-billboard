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

if ("SetStyle".equals(action)){
	getServletContext().setAttribute("style",request.getParameter("cssid"));
	System.out.println("requestgetparameter="+request.getParameter("cssid"));
}

if ("SetPicture".equals(action)){
}

String cssbutton = (String)getServletContext().getAttribute("style");
System.out.println("cssbutton="+cssbutton);

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Billboard Application</title>
<link href="stylelog.css" rel="stylesheet" type="text/css" />
</head>
<body>
<font color="#FFFFFF">
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
</font>
<textarea name="tickertext" rows="5" cols="60"><%= TickerTextManager.getNextTicker().getTickerText() %></textarea>
<br/>
<input type="submit" name="action" value="SaveTicker">

</form>

<form name="csstemplate" method="post" action="/test.jsp" id="csstemplate">
<input onClick="document.csstemplate.submit()" type="radio" name="cssid" value="1" <%= "1".equals(cssbutton)?"checked":"" %>>CSSTemplate1
<input onClick="document.csstemplate.submit()" type="radio" name="cssid" value="2" <%= "2".equals(cssbutton)?"checked":"" %>>CSSTemplate2
<input type="hidden" name="action" value="SetStyle"/>
</form>
</br>
</br>

<p>
<h1>
Picture Upload
</h1>
</p>
<FORM ENCTYPE='multipart/form-data' name="pictureupload" method="post" action="/single_upload_page.jsp" id="pictureupload">
<input type="file" name="picture1"/>
</br>
<input type="submit" name="action" value="SetPicture"/>

</form>

</br>
</br>
<table border="0" style="background-image:url('background.jpg')" height="288" width="512" cellspacing="0" cellpadding="0">
<tr>
<td width="256" height="258"><img src="/images/bannerimage.jpg"/></td>
<td width="256" height="258">
<iframe allowtransparency="true" scrolling="no" frameborder="0" height="50%" width="256" src="showbillboard.jsp">
</iframe>
</td>
</tr>
<tr>
<td colspan="2" width="512" height="30"> <DIV ID="TICKER" STYLE="overflow:hidden; width:512px">
     <%= TickerTextManager.getNextTicker().getTickerText() %>
    </DIV>
    <script type="text/javascript" src="webticker_lib.js"></script></td>
</tr>

</table>
</body>
</html>