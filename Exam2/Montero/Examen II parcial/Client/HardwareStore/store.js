function validar(){

	if(isNaN(document.getElementById("quantity").value)){
		alert ("MUST BE A NUMBER");
		return false;
	}
	else{
		document.getElementById('form').action = "./store.php";
		return true;
	}
}

function validarId(){

	if(isNaN(document.getElementById("id").value)){
		alert ("MUST BE A NUMBER");
		return false;
	}
	else{
		document.getElementById('form').action = "./store.php";
		return true;
	}
}