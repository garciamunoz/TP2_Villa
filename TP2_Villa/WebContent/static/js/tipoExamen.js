$(function(){
	var date_input=$('input[name="date"]');
	var date_input2=$('input[name="date2"]');//our date input has the name "date"
	var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
	date_input.datepicker({
		format: 'dd/mm/yyyy',
		container: container,
		todayHighlight: true,
		autoclose: true,
	});
	date_input2.datepicker({
		format: 'dd/mm/yyyy',
		container: container,
		todayHighlight: true,
		autoclose: true,
	});
	funcionesgenerales();
	
});


function funcionesgenerales(){

    $('#btnSelecto').click(function () {
    	 var $table = $('#table-methods-table');
    	// alert('seleccion: ' + JSON.stringify($table.bootstrapTable('getSelections')));
        //alert('Selected values: ' + JSON.stringify($('#table-methods-table').bootstrapTable('getSelections')));
    });

	
    $("#myBtn").click(function(){
        $("#myModal").modal();
    });
	$('#modBtnSearch').click(function(){
		var fechaInicial = $("#date").val();
		var fechaFinal =$("#date2").val();
		var moneda=$("input[name=optradio]:checked").val();
		
		
		$.ajax({
			
			url: "/TP2_Villa/actualizarTipoExamen/buscarPrecios",
			async : true,
			type: "get",
			data: {
				mon: moneda,
				startDate: fechaInicial,
				endDate: fechaFinal
			},
			success: function(result){
				crearFormulario(result);
			}
		});
	});
	
	$("#btnCancel").click(function(){
		window.location="/TP2_Villa/";
	});
}

function crearFormulario(respuesta) {
	var contenido="";
	for(var i=0;i<respuesta.listaPrecios.length;i++){
		var fechaInicial=convertDate(respuesta.listaPrecios[i].fechaInicial);
		var fechaFinal=convertDate(respuesta.listaPrecios[i].fechaFinal); 
		contenido=contenido+"<tr class=\"selected\"><td class=\"bs-checkbox\"><input data-index=\""+respuesta.listaPrecios[i].idPrecio+"\" name=\"btSelectItem\" type=\"checkbox\"></td><td style=\"\">"+respuesta.listaPrecios[i].moneda+"</td><td style=\"\">"+fechaInicial+"</td><td style=\"\">"+fechaFinal+"</td><td style=\"\">"+respuesta.listaPrecios[i].precio+"</td></tr>";	}
	$('#tbPrice').html("");
	$('#tbPrice').html(contenido);
}

function convertDate(inputFormat) {
	  function pad(s) { return (s < 10) ? '0' + s : s; }
	  var d = new Date(inputFormat);
	  return [pad(d.getDate()), pad(d.getMonth()+1), d.getFullYear()].join('/');
	}
	