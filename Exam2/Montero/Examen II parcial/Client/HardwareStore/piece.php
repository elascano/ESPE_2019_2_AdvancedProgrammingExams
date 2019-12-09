<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>


</body>
</html>


<?php
$opcion=$_POST['opcion'];
if ($opcion =='Register'):
    //$url = "http://localhost:1024//FreightTransport/project/client/addClient";
    
    $url = "http://localhost:8080/Exam2Product/web/product/addPiece";
    $idPiece = $_POST['id'];
    $namePiece = $_POST['name'];
    $categoryPiece = $_POST['type'];
    $descPiece = $_POST['quantity'];
  
    //$addressCustomer = $_POST['addressCustomer'];

    $data =array('id'=>$idPiece, 'name'=>$namePiece ,
                'type'=>$categoryPiece,'quantity'=>$descPiece  );    
    
    $cli=curl_init($url);
    curl_setopt($cli, CURLOPT_RETURNTRANSFER, true);
    //curl_setopt($cli, CURLOPT_URL,$url);
    curl_setopt($cli, CURLOPT_POST,true);
    curl_setopt($cli, CURLOPT_HTTPHEADER, array('Content-Type: application/json'));
    curl_setopt($cli, CURLOPT_POSTFIELDS,json_encode($data));

    $respone = curl_exec($cli);
    print_r($respone);
    
    if($respone == true){    
        echo"<center> <h1>Piece Si Registrado</h1></center>";
       echo $namePiece;
    }else{
        echo"<center> <h1>Piece No Registrado</h1></center>";
        echo $idPiece;
        echo "precio es: $pricePiece <br>";
 
    }
    
    curl_close($cli);
    
    elseif ($opcion == 'show'):
        echo " <center><h1>SHOW Pieces</h1></center>";
        $data = json_decode(file_get_contents("http://localhost:8080/Exam2Product/web/product"),true);
        ?>
        <center><table border="15" >
                <tr>
                    <td>Id Piece</td>
                    <td>Name Piece</td>
                    <td>Category Piece</td>
                    <td>Description Piece</td>
                    <td>Price Piece</td>
                    <td>Quantity Piece</td>	
                    
                </tr>

                <?php 
                foreach ($data as $d){
                ?>
                <tr>
                    <td><?php echo $d['id'] ?></td>
                    <td><?php echo $d['name'] ?></td>
                    <td><?php echo $d['type'] ?></td>
                    <td><?php echo $d['quantity']?></td>
                   
                    
                </tr>
                <?php 
                }
                ?>
                </table>
                        
            </center>
            <?php 
            
       endif;
         ?>