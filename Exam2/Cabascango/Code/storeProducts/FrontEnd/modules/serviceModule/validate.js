

function cargar(){
    const URLAPI = "http://localhost:8080/storeProducts/Products";
    const container = document.getElementById('tableProduct');
    let contentHTML = '';
    var i=0;
    fetch(URLAPI)
        .then(res => res.json())
        .then((json)=>{
            container.innerHTML = '';
            for(const service of json){
                i++;
                container.innerHTML += `
                <tr>
                    <td>${service.id}</td>
                    <td>${service.name}</td>
                    <td>${service.type}</td>
                    <td>${service.quatity}</td>

                    <td><a data-toggle='tooltip' data-placement='top' title='Update' style='margin-right:5px' class='btn btn-success btn-sm'>
                    <i class="material-icons">build</i>
                    </a></td>
                </tr>
                `;
                
            }
        })
}