$(function(){
	
	$('#btnBuscar').click(function(){
		
		var nomb=$("#nombre").val();
		
		$.ajax({
			url: "consultarTipoExamen/buscar",
			async : true,
			type: "get",
			data: {nombre: nomb},
			success: function(result){
				$("#tbConsultarTipoExamen").empty();
				$.each(result, function (index, item) {
					var row = "<tr>" +
		    		"<td><input type=\"checkbox\" idExamenClinico=\"" + item.idExamenClinico + "\"></td>" +
		    		"<td>" + item.idExamenClinico + "</td>" +
		    		"<td>" + item.nombreExamenClinico + "</td>" +
		    		"<td>" + item.descripcionExamenClinico + "</td>" + 
		    		"<td>" + item.diasCultivo + "</td>" + 
		    		"</tr>";
		    
					$("#tbConsultarTipoExamen").append(row); 
				});
			}
		});
	});
	
	$('#btnSalir').click(function(){
		window.location.href = "/TP2_Villa";
	});
	
	
});