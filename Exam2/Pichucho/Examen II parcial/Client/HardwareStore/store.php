<?php
    $url = "http://localhost:8080/HardwareStore/store/products";
    $id = $_POST['id'];
    $name = $_POST['name'];
    $type = $_POST['type'];
    $quantity = $_POST['quantity'];
    $data =array('id' => $id, 'name' => $name, 'type'=>$type, 'quantity' => $quantity);    
    $cli=curl_init($url);
    curl_setopt($cli, CURLOPT_HTTPHEADER, array('Content-Type: application/json'));
    curl_setopt($cli, CURLOPT_POST,true);
    curl_setopt($cli, CURLOPT_POSTFIELDS,json_encode($data));
    curl_setopt($cli, CURLOPT_RETURNTRANSFER, true);
    $respone = curl_exec($cli);
    curl_close($cli);
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
         <?php 
            if(strcmp($respone,"Register")==0){
                echo('<h1> Product register</h1>');
            }
            else{
                echo("<h1> You have an Error:  {$respone}</p>");                  
            }
         ?>
        </div>        
    </body>
</html>