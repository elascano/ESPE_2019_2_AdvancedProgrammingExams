<?php
    $data = json_decode(file_get_contents("http://localhost:8080/HardwareStore/store/Product/getproducts"),true);
    
    foreach ($data as $d){
        echo("<b> Id: {$d['id']} </b>"); 
        echo("<br>Name: {$d['name']}");               
        echo("<br>Type: {$d['type']}"); 
        echo("<br>Quantity: {$d['quantity']}<br><br>");   
    }
?>

<!DOCTYPE html>
<html>
    <head>
        <title>PRODUCT</title>
        <meta charset="windows-1254">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">        
    </head>
    <body>
        <div class="container my-3">
        </div>        
    </body>
</html>