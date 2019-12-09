<?php
$opcion=$_POST['option'];
if ($opcion =='Register'):
    $url = "http://localhost:8080/ExamVillegasVivas/webresources/product/addProduct";
    
    $id = $_POST['idproduct'];
    $name = $_POST['nameproduct'];
    $type = $_POST['selectType'];
    $quantity = $_POST['quantityproduct'];
    $data =array('idProduct' =>$id, 'nameProduct'=>$name, 'typeProduct'=>$type,'quantityProduct'=>$quantity);    
    echo $id;
    echo $name;
    echo $type;
    echo $quantity;

    $cli=curl_init($url);
    curl_setopt($cli, CURLOPT_RETURNTRANSFER, true);
    //curl_setopt($cli, CURLOPT_URL,$url);
    curl_setopt($cli, CURLOPT_POST,true);
    curl_setopt($cli, CURLOPT_HTTPHEADER, array('Content-Type: application/json'));
    curl_setopt($cli, CURLOPT_POSTFIELDS,json_encode($data));

    $respone = curl_exec($cli);
    
    if($respone == false){    
        echo"<center> <h1>Cliente Registrado</h1></center>";
       echo $name;
    }else{
        echo"<center> <h1>Cliente Registrado</h1></center>";
        echo $id;
        
    }
    
elseif ($opcion == 'Search'):
        echo " <center><h1>SHOW PRODUCTS</h1></center>";
        $data = json_decode(file_get_contents("http://localhost:8080/ExamVillegasVivas/webresources/product/allProduct"),true);
        ?>
        <center><table border="1" >
                <tr>
                    <td>id</td>
                    <td>name</td>
                    <td>quantity</td>
                    <td>type</td>	
                </tr>

                <?php 
                foreach ($data as $d){
                ?>
                <tr>
                    <td><?php echo $d['idProduct'] ?></td>
                    <td><?php echo $d['nameProduct'] ?></td>
                    <td><?php echo $d['quantityProduct'] ?></td>
                    <td><?php echo $d['typeProduct']?></td>

                </tr>
                <?php 
                }
                ?>
                </table>
                        
            </center>
            <?php 
            elseif ($opcion == 'Buscar'):
                $id = $_POST['idguide'];
                echo " <center><h1>SHOW GUIDES</h1></center>";
                $dataId = json_decode(file_get_contents("http://localhost:1024/FreightTransport/project/guide/showguidebyid/$id"),true);
                ?>
                <center><table border="1" >
                        <tr>
                            <td>idguide</td>
                            <td>datesent</td>
                            <td>datereceive</td>
                            <td>quantityguide</td>
                            <td>totalguide</td>
                            <td>idcustomer</td>	
                            <td>idcarrier</td>
                            <td>codezone</td>		
                        </tr>
        
                        <tr>
                            <td><?php echo $dataId['guideId'] ?></td>
                            <td><?php echo $dataId['sendDate'] ?></td>
                            <td><?php echo $dataId['deliverDate'] ?></td>
                            <td><?php echo $dataId['quantity']?></td>
                            <td><?php echo $dataId['total']?></td>
                            <td><?php echo $dataId['customerId'] ?></td>
                            <td><?php echo $dataId['carrierCard']?></td>
                            <td><?php echo $dataId['zoneCode']?></td>
                        </tr>
                        <?php 
                        
                        ?>
                        </table>
                                
                    </center>
                    <?php 
       endif;
		 ?>