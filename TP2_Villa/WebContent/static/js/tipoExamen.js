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
	
	$('#idDiasCultivo').keyup(function (){
        this.value = (this.value + '').replace(/[^0-9]/g, '');
    });
	
	funcionesgenerales();
	
	$("#btnUpdate").click(function(){
        
		var req = {};
		req.especialidad = {};
		req.normativa = {};
		req.estandar = {};
		req.atributos = [];
		req.estado = {};
		
		req.idExamenClinico = $("#codigo").val();
		req.nombreExamenClinico = $("#nombre").val();
		req.descripcionExamenClinico = $("#descripcion").val();
		req.especialidad.idEspecialidad = $("#idEsp").val();
		req.normativa.idNormativa = $("#idNorm").val();
		req.estandar.idEstandar = $("#idEstandar").val();
		req.diasCultivo = $("#idDiasCultivo").val();
		req.estado.idEstado = $("#idEst").val();
		
		$("tr", "#tbATRIBUTOSXEXAMENCLINICO").each(function(i, item) {
			var atributoExamCli = {};
			atributoExamCli.idAtributo = $("input:checkbox", item).attr("idAtributo");
			atributoExamCli.observacionesAtributo = $("input:text", item).val();
			req.atributos.push(atributoExamCli);
		});
		
		$.ajax({
	        type: "post",
	        url: "/TP2_Villa/actualizarTipoExamen/actualizar",
	        data: JSON.stringify(req),
	        contentType: "application/json; charset=utf-8",
	        dataType: 'json', 
	        success: function(data) {
	            console.log(data);
	        }
	    });
		
		alert("Tipo de examen modificado correctamente");
        window.location.href = "/TP2_Villa/actualizarTipoExamen";
    });
	
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
		window.location="/TP2_Villa/actualizarTipoExamen";
	});
	
	$("#btnAgregarAtributo").click(function(){
        $("#modalAtributos").modal();
        
        $.ajax({
			url: "/TP2_Villa/actualizarTipoExamen/listaTodosAtributos",
			async : true,
			type: "get",
			success: function(respuesta){
				var contenido="";
				for(var i=0;i<respuesta.length;i++){
					contenido=contenido+"<tr>" +
						"<td class=\"bs-checkbox\">"+"<input type=\"checkbox\"" +"idAtributo=\""+respuesta[i].idAtributo+"\" nombreAtributo=\""+respuesta[i].nombreAtributo +"\">"+"</td>" +
						"<td>"+respuesta[i].idAtributo+"</td>" +
						"<td>"+respuesta[i].nombreAtributo+"</td>" +
						"<td>"+respuesta[i].descripcionAtributo+"</td>" +
						"<td>"+respuesta[i].caracteristica.descripcionCaracteristica+"</td>" +
					"</tr>";
				}
				$('#tbAtributosGenerales').html("");
				$('#tbAtributosGenerales').html(contenido);
			}
		});
    });
	
	$("#btnAgregarAtributo2").click(function(){

		$("input:checked", "#tbAtributosGenerales").each(function(i, item) {
		    var newRowContent = "<tr>" +
		    		"<td><input type=\"checkbox\" idAtributo=\"" + $(item).attr("idAtributo") + "\"></td>" +
		    		"<td>" + $(item).attr("nombreAtributo") + "</td>" +
		    		"<td><input type=\"text\" name=\"obs\"></td>" + 
		    	"</tr>";
		    
		    if(!$("input:checkbox[idAtributo='"+$(item).attr("idAtributo")+"']", "#tbATRIBUTOSXEXAMENCLINICO").length) {
		    	$("#tbATRIBUTOSXEXAMENCLINICO").append(newRowContent); 
		    }
		    
		});
		
		$('#modalAtributos').modal('toggle');
	});
	
	
	
	$("#btnEliminarAtributo").click(function(){
		
		if (!$("input:checked", "#tbATRIBUTOSXEXAMENCLINICO").length){
			alert("debe seleccionar por lo menos un atributo");
		} else {
			if(confirm("esta seguro que desea eliminar los atributos seleccionados")){
				$("input:checked", "#tbATRIBUTOSXEXAMENCLINICO").parent().parent().remove();
			}
		}
	});
	
	$("#btnSave").click(function(){
		if($("#nombre").val().length == 0) {
			alert("Debe ingresar el Nombre");
			return;
		}
		
		if($("#descripcion").val().length == 0) {
			alert("Debe ingresar la Descripción");
			return;
		}
		
		if($("#idEsp").val() == 0) {
			alert("Debe seleccionar una especialidad");
			return;
		}
		
		if($("#idNorm").val() == 0) {
			alert("Debe seleccionar una Normativa");
			return;
		}
		
		if($("#idEstandar").val() == 0) {
			alert("Debe seleccionar un Estándar");
			return;
		}
		
		if($("#idPrecio").val() == 0) {
			alert("Debe seleccionar un precio");
			return;
		}
		
		if($("#idDiasCultivo").val().length == 0) {
			alert("Debe ingresar los días de cultivo");
			return;
		}
		
		if(parseInt($("#idDiasCultivo").val()) <= 0 || parseInt($("#idDiasCultivo").val()) > 100) {
			alert("Días de cultivo invalido");
			return;
		}
		
		if($("tr", "#tbATRIBUTOSXEXAMENCLINICO").length == 0){
			alert("Debe agregar por lo menos un atributo");
			return;
		}
		
		var req = {};
		req.especialidad = {};
		req.normativa = {};
		req.estandar = {};
		req.atributos = [];
		
		req.nombreExamenClinico = $("#nombre").val();
		req.descripcionExamenClinico = $("#descripcion").val();
		req.especialidad.idEspecialidad = $("#idEsp").val();
		req.normativa.idNormativa = $("#idNorm").val();
		req.estandar.idEstandar = $("#idEstandar").val();
		req.diasCultivo = $("#idDiasCultivo").val();
		
		$("tr", "#tbATRIBUTOSXEXAMENCLINICO").each(function(i, item) {
			var atributoExamCli = {};
			atributoExamCli.idAtributo = $("input:checkbox", item).attr("idAtributo");
			atributoExamCli.observacionesAtributo = $("input:text", item).val();
			req.atributos.push(atributoExamCli);
		});
		
		$.ajax({
	        type: "post",
	        url: "/TP2_Villa/actualizarTipoExamen/registrar",
	        data: JSON.stringify(req),
	        contentType: "application/json; charset=utf-8",
	        dataType: 'json', 
	        success: function(data) {
	            //console.log(data);
	            //alert("Tipo de examen médico se grabó correctamente");
	            //window.location.href = "/TP2_Villa/actualizarTipoExamen";
	        }
	    });
		
		alert("Tipo de examen registrado correctamente");
        window.location.href = "/TP2_Villa/actualizarTipoExamen";
		
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
	