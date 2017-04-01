$(function(){
	funcionesgenerales();
});

function funcionesgenerales(){
	$('#btnBuscar').click(function(){
		
		var nomb=$("#nombre").val();
		var descrip=$("#descripcion").val();
		var idEsta=$("#idEst").val();
		var idEspe=$("#idEsp").val();
		
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
	
	$('#btnNuevo').click(function(){
		window.location="actualizarTipoExamen/nuevoTipoExamen";
	});
	$('#btnExit').click(function(){
		window.location="/TP2_Villa/";
	});
	
}

function crearFormulario(respuesta) {
	var contenido="";
	for(var i=0;i<respuesta.listaTiposExamenesMedicos.length;i++){
		contenido=contenido+"<tr class=\"odd gradeX\">" +
								"<td><a href=\"/TP2_Villa/actualizarTipoExamen/editarTipoExamen?idExamenClinico="+respuesta.listaTiposExamenesMedicos[i].idExamenClinico+"\" >"+respuesta.listaTiposExamenesMedicos[i].idExamenClinico+"</a></td>" +
								"<td>"+respuesta.listaTiposExamenesMedicos[i].nombreExamenClinico+"</td>" +
								"<td>"+respuesta.listaTiposExamenesMedicos[i].descripcionExamenClinico+"</td>" +
								"<td>"+respuesta.listaTiposExamenesMedicos[i].especialidad.nombreEspecialidad+"</td>" +
								"<td>"+respuesta.listaTiposExamenesMedicos[i].estado.nombreEstado+"</td>" +
							"</tr>";
		
	}
	$('#tbDetalleOrdenCompra').html("");
	$('#tbDetalleOrdenCompra').html(contenido);
	
}
