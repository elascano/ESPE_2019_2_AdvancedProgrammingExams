var URI="http://localhost:8085/products/webresources/rest.product/01";
$(document).ready(function() {
    $("#btnConsultarTabla").on("click", function() {
      alert("Bien");
      consultarListaAutor();
      });
});


function consultarListaAutor()
{
    $.ajax({
        url: URI,
        type: "GET",
        contentType: "application/json",
        success: function(autorResult) {
          var str = "";
          console.log(autorResult);
          autorResult.Result.forEach(function(response) {
            str = str + "<tr><td>" + response.idProduct + "</td>";
            str = str + "<td>" + response.nameProduct  + "</td>";
            str = str + "<td>" + response.stpckProduct + "</td>";
            str = str + "<td>" + response.typeProduct  + "</td>";
          });
          $("#product").html(str);
        },
        error: function(error) { 
          alert("Error en la Consulta de Producto");
        }
      });

}
