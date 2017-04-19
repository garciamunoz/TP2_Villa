<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jspf"%>

<%--content--%>

<script type="text/javascript">

var listaDatos;

function regresar(){
	$('#formRDIAG').attr('action',"/TP2_Villa/DIAG/inicio");
	$('#formRDIAG').submit();
}

function validar(){
	$('#hdnIDHC').val('');
	$('#txtHC').val('');
	$('#txtCLIENTE').val('');
	$('#txtMASCOTA').empty().append($('<option>', { 
        value: "-1",
        text : "Seleccione" 
    }));
	
	$.ajax({
		type:'GET',
		url: '/TP2_Villa/DIAG/validar',
		data: {
			tipoDoc: $('#txtTIPODOC').val(),
			numDoc: $('#txtNUMDOC').val()
		},
		success: function(data){
			listaDatos = data;
			if(data.length > 0){
				datos = data[0];
				$('#txtCLIENTE').val(datos.datosCliente);
				
				$.each(data,function( index, element ) {
					if(element.idHC != 0 && element.idMascota != 0){
						$('#txtMASCOTA').append($('<option>', { 
					        value: element.idMascota,
					        text : element.datosMascota 
					    }));
					}
				});
			}else{
				mensajeModal("Cliente no encontrado.");
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
	var desc = $('#txtDESC').val();
	
	if(desc == ''){
		mensajeModal("Ingrese una Descripción.");return false;
	}
	
	$('#formRDIAG').attr('action',"/TP2_Villa/DIAG/registrar");
	$('#formRDIAG').submit();	
}

</script>


<div class="container">
	<div class="page-header" align="center">
       <h1>Registrar Diagnóstico</h1>
    </div>

	<form class="form-horizontal" action="" id="formRDIAG" method="POST">

    <div class="col-sm-12">
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