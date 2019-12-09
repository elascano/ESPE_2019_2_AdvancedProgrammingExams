<%-- 
    Document   : productos
    Created on : 09-dic-2019, 13:13:32
    Author     : Melissa
--%>
<%@page import="javax.ws.rs.core.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ec.edu.espe.hardware.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        

        <div class="container">
            <table  class="table table-bordered"  id="tablaDatos">
                <tr>
                    <th class="text-center">Id</th>
                    <th class="text-center">Name</th>
                    <th class="text-center">Type</th>
                    <th class="text-center">Quantity</th>
                    
                </tr>
                <%ProductoDAO dao=new ProductoDAO();
                ArrayList<ProductoVO> trans=dao.getServices();
                for(ProductoVO transres: trans ){ %>
         <tr>
                    <td class="text-center"><%=transres.getId()%></td>
                    <td class="text-center"><%=transres.getNombre()%></td>
                    <td class="text-center"><%=transres.getTipo()%></td>
                    <td class="text-center"><%=transres.getCantidad()%></td>
                    
                </tr>
                <%}
                %>
            </table>
        </div>
    </body>
</html>
