class product{

}

function submit(){
    const form = document.getElementById('formStore');
    var name = document.getElementById("name_product").value;
    var type = document.getElementById("type_product").value;
    var quan = document.getElementById("quantity_product").value;

    var product = new Object();
    product.id_product = 0;
    product.name_product = name;
    product.type_product = type;
    product.quantity_product = quan; 

    console.log(JSON.stringify(product));
        return jQuery.ajax({
        'type': 'POST',
        'url': 'http://localhost:8080/Hardware/products',
        'contentType': 'application/json',
        'data': JSON.stringify(product),
        'dataType': 'json'
        });


    
    /*fetch('http://localhost:8080/Hardware/products',{
        method : 'post',
        body : JSON.stringify(product),
        contentType: 'application/json'
    }).then(function(response){
        return response.text();
    })*/

}


function cargar(){
    const URLAPI = "http://localhost:8080/Hardware/products";
    const container = document.getElementById('tableService');
    let contentHTML = '';
    var i=0;
    fetch(URLAPI)
        .then(res => res.json())
        .then((json)=>{
            container.innerHTML = '';
            for(const product of json){
                container.innerHTML += `
                <tr>
                    <th scope="row">${product.id_product}</th>
                    <td>${product.name_product}</td>
                    <td>${product.type_product}</td>
                    <td>${product.quantity_product}</td>
                </tr>
                `;
                
            }
        })
}