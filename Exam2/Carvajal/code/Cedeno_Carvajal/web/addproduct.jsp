<%-- 
    Document   : addproduct
    Created on : 09-dic-2019, 13:28:12
    Author     : Melissa
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ec.edu.espe.hardware.model.ProductoVO"%>
<%@page import="ec.edu.espe.hardware.model.ProductoDAO"%>
<%@page import="java.awt.TrayIcon.MessageType"%>
<%@page import="java.sql.*"%>
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
            <h1>Agregar Producto</h1>
            <hr>
            <form action="" method="post" class="form-control" style="width: 500px; height: 400px">
                    
                            <label for="cedula">Id:</label>
                            <input type="text" class="form-control" placeholder="1" name="cedula" />
                       
                            <label for="cedula">Nombre:</label>
                            <input type="text" class="form-control" placeholder="Hammer" name="nombre" />
                       
                            <label for="direccion">Tipo:</label>
                            <input type="text" class="form-control" placeholder="Hardware" name="direccion" />
                       
                            <label for="cedula">Cantidad:</label>
                            <input type="text" class="form-control" placeholder="1" name="telefono" />
                   
                <input type="submit" value="Guardar" />
                <%ProductoDAO dao=new ProductoDAO();
                String id, nom,dir,telf;
                id=request.getParameter("cedula");
                 nom=request.getParameter("nombre");
             dir=request.getParameter("direccion");
                 telf=request.getParameter("telefono");
                 ProductoVO produc=new ProductoVO(1,nom,dir,1);
                 dao.setServices(produc);
                 %>
            </form>
        </div>
    </body>
</html>



















