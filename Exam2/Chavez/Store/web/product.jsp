<%-- 
    Document   : product
    Created on : 09/12/2019, 12:56:37
    Author     : nycha
--%>

<%@page import="javax.ws.rs.core.MediaType"%>
<%@page import="javax.ws.rs.client.ClientBuilder"%>
<%@page import="javax.ws.rs.client.WebTarget"%>
<%@page import="javax.ws.rs.client.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
<% 
        
        Client client = ClientBuilder.newClient();
        
        WebTarget target = client.target("http://localhost:8080/AssJSP/person/WSPerson/allPersons");
        out.print(""+target.request(MediaType.APPLICATION_JSON).get(String.class));
        %>
    </body>
</html>
