$(function(){
	funcionesgenerales();
});

function funcionesgenerales(){
	$('#btnBuscar').click(function(){
		function clearFormulario(){
			$("#bod").html("");
		}
		var nomb=$("#nombre").val();
		var descrip=$("#descripcion").val();
		var idEsta=$("#idEst").val();
		var idEspe=$("#idEsp").val();
		
		/*$.get("actualizarTipoExamen/buscar",{
			nombre: nomb,
			descripcion: descrip,
			idEst: idEsta,
			idEsp: idEspe
		},function(respuesta){
			crearFormulario(respuesta);
		});*/
		$.ajax({
			
			url: "actualizarTipoExamen/buscar",
			async : true,
			type: "get",
			data: {
				nombre: nomb,
				descripcion: descrip,
				idEst: idEsta,
				idEsp: idEspe
			},
			success: function(result){
				crearFormulario(result);
			}
		});
	});
	
}

function crearFormulario(respuesta) {
	$("#bod").html(respuesta);
}