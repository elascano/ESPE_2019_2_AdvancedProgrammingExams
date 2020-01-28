<?php
include("db_config.php");

function insertData($brand,$model){
	global $db;
	$result=mysqli_query($db , "INSERT INTO vehicle(brand,model) VALUES('$brand','$model')")or die(mysqli_error($db));
	return $result;
}

function displayAll(){
	global $db;
	$result=mysqli_query($db , "SELECT * FROM vehicle")or die(mysqli_error($db));
	return $result;
}

function deleteData($id){
	global $db;
	$result=mysqli_query($db , "DELETE FROM vehicle WHERE id = '$id'")or die(mysqli_error($db));
	return $result;
}

function updateData($brand,$model){
	global $db;
	$result=mysqli_query($db , "UPDATE `vehicle` SET
	`brand`='$brand', `model`='$model' WHERE id = '$id'")or die(mysqli_error($db));
	return $result;
}
?>