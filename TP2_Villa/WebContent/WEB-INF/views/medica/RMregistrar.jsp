<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jspf"%>

<%--content--%>

<script type="text/javascript">

var listaDatos;
var valido = false;

function regresar(){
	$('#formRRM').attr('action',"/TP2_Villa/RM/inicio");
	$('#formRRM').submit();
}

function validar(){
	valido = false;
	$.ajax({
		type:'GET',
		url: '/TP2_Villa/RM/validar',
		data: {
			txtAM: $('#txtAM').val(),
		},
		success: function(data){
			listaDatos = data;
			if(data.length > 0){
				valido = true;
				mensajeModal("Atención Médica encontrada.");
			}else{
				mensajeModal("Atención Médica no encontrada.");
			}
		},
		error: function(e){
			console.log("error: " + e);
		}
	});
}

function mascota(id){
	$('#hdnIDHC').val('');
	$('#txtHC').val('');
	
	$.each(listaDatos,function( index, element ) {
		if(element.idMascota == id){
			$('#hdnIDHC').val(element.idHC);
			$('#txtHC').val(element.idHC);
			return false;
		}
	});
}

function registrar(){
	if(valido){
		
		var medicamentos = $("#tablaMedicamento :input[type=text]");
		if(medicamentos.length < 1){
			mensajeModal("Ingrese algun Medicamento");return false;
		}
		var exito = false;
		medicamentos.each(function(){
			var input = $(this);
			exito = false
			if(input.val() == ""){
				var text = input.attr('title');
				mensajeModal("Ingresar el Campo: "+text);
				return false;
			}
			exito = true;
		});
		
		if(exito){
			$('#formRRM').attr('action',"/TP2_Villa/RM/registrar");
			$('#formRRM').submit();
		}
	}else{
		mensajeModal("Atención Médica no encontrada.");	
	}
}

function agregar(){
	var now = new Date().getTime();
	$('#tablaMedicamento > tbody:last-child').append("<tr>"+
			"<td style='text-align: center;'><input type='text' title='NOMBRE MEDICAMENTO' name='nombreMedicamento' value='' /></td>"+
    		"<td style='text-align: center;'><input type='text' title='VIA' name='via' value='' /></td>"+
    		"<td style='text-align: center;'><input type='text' title='DOSIS' name='dosis' value='' /></td>"+
    		"<td style='text-align: center;'><input type='text' title='INDICACIÓN' name='indicacion' value='' /></td>"+
    		"<td style='text-align: center;'><input type='text' title='DURACIÓN' name='duracion' value='' /></td>"+
    		"<td style='text-align: center;'><input type='text' title='CANTIDAD' name='cantidad' value='' onkeypress='return isNumeric(event);'/></td>"+
    		"<td style='text-align: center;'><input type='button' id='"+now+"' value='ELIMINAR' onclick='eliminar("+now+");' /></td>"+
        "</tr>");
}

function eliminar(idRow){
	$('#'+idRow).parent().parent().remove();
}

$(document).ready(function(){
	agregar();
});

</script>


<div class="container">
	<div class="page-header" align="center">
       <h1>Registrar Receta Médica</h1>
    </div>

	<form class="form-horizontal" action="" id="formRRM" method="POST">

    <div class="col-sm-12">
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtAM">CÓDIGO ATENCIÓN MÉDICA:</label>
		        <div class="col-xs-5" align="right">
		            <input type="text" id="txtAM" name="txtAM" class="form-control" value="" onblur="validar();" onkeypress="return isNumeric(event);"/>
		        </div>
		    </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtOBS">OBSERVACIÓN:</label>
		        <div class="col-xs-5">
		        	<textarea class="form-control" id="txtOBS" name="txtOBS" rows="3" cols="100" maxlength="255"></textarea>
		        </div>
	        </div>
	        <div class="form-group">
	        	<input type="button" id="btnAgregar" value="AGREGAR MEDICINA" class="btn btn-info" onclick="agregar();"/>
				<table id="tablaMedicamento" class="table table-hover table-bordered" border="1">
        		<thead style="background-color: #bce8f1;">
            	<tr>
                	<th style="text-align: center;">MEDICAMENTO</th>
                	<th style="text-align: center;">VIA</th>
                	<th style="text-align: center;">DOSIS</th>
                	<th style="text-align: center;">INDICACIÓN</th>
                	<th style="text-align: center;">DURACIÓN</th>
                	<th style="text-align: center;">CANTIDAD</th>
                	<th style="text-align: center;">ACCIÓN</th>
                </tr>
	            </thead>
	            <tbody>
		        </tbody>
	         	</table>
	            		
	        </div>
    </div>
    
    <br>
    <div class="form-group">
        <div class="col-sm-3" align="left">
        	<input type="button" class="btn btn-primary" value="REGRESAR" onclick="regresar();"/>
	    </div>
        <div class="col-sm-3" align="center">
        	<input type="button" class="btn btn-success" value="GRABAR" onclick="registrar();"/>
        </div>
    </div>
</form>
</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>