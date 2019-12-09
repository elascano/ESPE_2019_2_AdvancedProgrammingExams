<%-- 
    Document   : mpgjsp
    Created on : Dec 4, 2019, 12:52:17 PM
    Author     : DenniseSandoval
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ec.edu.espe.products.model.Product"%>
<%@page import="ec.edu.espe.products.model.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product</title>
    </head>
    <body>

        <div class="container">
            <br>
            <center>
                <h2>Productos</h2><br>
            </center>
            
            <table  class="table "  id="tablaDatos">
                <tr>
                    <th class="text-center table-info">Id</th>
                    <th class="text-center table-info">Nombre</th>
                    <th class="text-center table-info">Tipo</th>
                    <th class="text-center table-info">Cantidad</th>
                   
                </tr>
                <%ProductDAO dao=new ProductDAO();
                ArrayList<Product> product=dao.getServices();
                for(Product guide: product ){ %>
         <tr>
                    <td class="text-center"><%=guide.getId()%></td>
                    <td class="text-center"><%=guide.getName()%></td>
                    <td class="text-center"><%=guide.getType()%></td>
                    <td class="text-center"><%=guide.getQuantity()%></td>
                   
                </tr>
                <%}
                %>
            </table>
        </div>
</html>