<%-- 
    Document   : login
    Created on : Sep 10, 2008, 1:45:52 PM
    Author     : sandeep kumar suman
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
   <%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <f:view>
            <h:form id="LoginForm">
                <h:panelGrid id="lpg" columns="2">
                    
                    <h:outputText value="User ID"/>
                    <h:inputText size="25"/>                    
                    <h:outputText value=""/>
                    <h:commandButton value="Login"/>
                    
                </h:panelGrid>
            </h:form>
        </f:view>
     </body>
</html>