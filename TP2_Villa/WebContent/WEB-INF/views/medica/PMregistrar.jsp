<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jspf"%>

<%--content--%>

<script type="text/javascript">

var valido = false;

function regresar(){
	$('#formRPM').attr('action',"/TP2_Villa/PM/inicio");
	$('#formRPM').submit();
}

function registrar(){
	
	var tp = $('#txtTP').val();
	if(tp == "-1"){
		mensajeModal("Seleccione un Tipo de Procedimiento.");
		return;
	}
	if(valido){
		$('#formRPM').attr('action',"/TP2_Villa/PM/registrar");
		$('#formRPM').submit();	
	}else{
		mensajeModal("Atención Médica no encontrada.");	
	}
}

function validar(){
	valido = false;
	$.ajax({
		type:'GET',
		url: '/TP2_Villa/PM/validar',
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

</script>

<div class="container">
	<div class="page-header" align="center">
       <h1>Registrar Procedimiento Médico</h1>
    </div>

	<form class="form-horizontal" action="" id="formRPM" method="POST">
	
    <div class="col-sm-12">
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtAM">CODIGO ATENCIÓN MÉDICA:</label>
		        <div class="col-xs-5" align="right">
		            <input type="text" id="txtAM" name="txtAM" class="form-control" value="" onblur="validar();" onkeypress="return isNumeric(event);"/>
		        </div>
		    </div>
		    <div class="form-group">
		        <label class="control-label col-xs-3" for="txtTP">TIPO PROCEDIMIENTO:</label>
		        <div class="col-xs-5">
		            <select id="txtTP" name="txtTP" class="form-control">
			            <option value="-1">Seleccione</option>
			           	<option value="Anatomia Patologica">Anatomia Patologica</option>
						<option value="Alergologia">Alergologia</option>
						<option value="Cardiologia">Cardiologia</option>
						<option value="Cirugia Cardiaca">Cirugia Cardiaca</option>
						<option value="Cirugia General">Cirugia General</option>
						<option value="Cirugia Plastica">Cirugia Plastica</option>
						<option value="Cirugia Maxilofacial">Cirugia Maxilofacial</option>
						<option value="Cirugia Vascular">Cirugia Vascular</option>
						<option value="Dermatologia">Dermatologia</option>
						<option value="Endocrinologia y Nutricion">Endocrinologia y Nutricion</option>
						<option value="Gastroenterologia- Digestivo">Gastroenterologia- Digestivo</option>
						<option value="Genetica">Genetica</option>
						<option value="Geriatria">Geriatria</option>
						<option value="Hematologia">Hematologia</option>
						<option value="Enfermedades del Higado (Hepatologia)">Enfermedades del Higado (Hepatologia)</option>
						<option value="Enfermedades Infecciosas">Enfermedades Infecciosas</option>
						<option value="Medicina Interna">Medicina Interna</option>
						<option value="Nefrologia">Nefrologia</option>
						<option value="Neumologia">Neumologia</option>
						<option value="Neurologia">Neurologia</option>
						<option value="Neurocirugia">Neurocirugia</option>
						<option value="Oftalmologia">Oftalmologia</option>
						<option value="Otorrinolaringologia">Otorrinolaringologia</option>
						<option value="Oncologia">Oncologia</option>
						<option value="Pediatria">Pediatria</option>
						<option value="Proctologia">Proctologia</option>
						<option value="Psiquiatria">Psiquiatria</option>
						<option value="Rehabilitacion y M. Deportiva">Rehabilitacion y M. Deportiva</option>
						<option value="Reumatologia">Reumatologia</option>
						<option value="Traumatologia">Traumatologia</option>
						<option value="Otros">Otros</option>    
		            </select>
		        </div>
		    </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtDESC">DESCRIPCIÓN:</label>
		        <div class="col-xs-5" align="right">
		            <input type="text" id="txtDESC" name="txtDESC" class="form-control" value="" maxlength="255"/>
		        </div>
		    </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtOBS">OBSERVACIÓN:</label>
		        <div class="col-xs-5">
		        	<textarea class="form-control" id="txtOBS" name="txtOBS" rows="3" cols="100" maxlength="255"></textarea>
		        </div>
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