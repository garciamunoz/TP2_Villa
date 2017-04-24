<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jspf"%>

<%--content--%>

<script type="text/javascript">

var valido = false;
var listaDatos;

function regresar(){
	$('#formRMA').attr('action',"/TP2_Villa/MA/inicio");
	$('#formRMA').submit();
}

function registrar(){
	
	validar();
	
	obligatorio();
	
	var dateRegex = /^(?=\d)(?:(?:31(?!.(?:0?[2469]|11))|(?:30|29)(?!.0?2)|29(?=.0?2.(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00)))(?:\x20|$))|(?:2[0-8]|1\d|0?[1-9]))([-.\/])(?:1[012]|0?[1-9])\1(?:1[6-9]|[2-9]\d)?\d\d(?:(?=\x20\d)\x20|$))?(((0?[1-9]|1[012])(:[0-5]\d){0,2}(\x20[AP]M))|([01]\d|2[0-3])(:[0-5]\d){1,2})?$/;
	var valFecha = dateRegex.test($('#fechaNacMascota').val());
	if(!valFecha){
		mensajeModal("El Formato para la Fecha de Nacimiento es dd/mm/aaaa");
		return false;
	}
	
	if(valido){
		$('#formRMA').attr('action',"/TP2_Villa/MA/registrar");
		$('#formRMA').submit();	
	}
}

function obligatorio(){
	$("form#formRMA :input[type=text]").each(function(){
		var input = $(this);
		valido = false
		if(input.val() == ""){
			var id = input.attr('id');
			var label = $("label[for='"+id+"']");
			var text = label.text();
			mensajeModal("Ingresar el Campo: "+text.substring(0,text.length-1));
			return false;
		}
		valido = true;
	});
}

function validar(){
	$('#hdnIDCLIENTE').val('');
	$('#txtCLIENTE').val('');
	
	if($('#txtNUMDOC').val() == ''){
		return false;
	}
	
	$.ajax({
		type:'GET',
		url: '/TP2_Villa/MA/validar',
		async: false,
		data: {
			tipoDoc: $('#txtTIPODOC').val(),
			numDoc: $('#txtNUMDOC').val()
		},
		success: function(data){
			listaDatos = data;
			if(data.length > 0){
				datos = data[0];
				$('#hdnIDCLIENTE').val(datos.idCliente);
				$('#txtCLIENTE').val(datos.nombreCompleto);
			}else{
				mensajeModal("Cliente no encontrado.");
				$('#txtNUMDOC').val('');
			}
		},
		error: function(e){
			console.log("error: " + e);
		}
	});
}

function cargarRaza(idEspecie){
	$('#idRaza').empty().append($('<option>', { 
        value: "-1",
        text : "Seleccione" 
    }));
	
	if(idEspecie == '-1'){
		return false;
	}
	
	$.ajax({
		type:'GET',
		url: '/TP2_Villa/MA/buscarRaza',
		async: false,
		data: {
			idEspecie: idEspecie
		},
		success: function(data){
			listaDatos = data;
			if(data.length > 0){
				$.each(data,function( index, element ) {
					$('#idRaza').append($('<option>', { 
				        value: element.idRaza,
				        text : element.descripcionRaza 
				    }));
				});
			}else{
				mensajeModal("Razas no encontradas.");
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
       <h1>Registrar Mascota</h1>
    </div>

	<form class="form-horizontal" action="" id="formRMA" method="POST">
	<input type="hidden" id="hdnIDCLIENTE" name="hdnIDCLIENTE" value=""/>
	
    <div class="col-sm-12">
    		
			<div class="form-group">
		        <label class="control-label col-xs-3" for="txtTIPODOC">Tipo Documento del Cliente:</label>
		        <div class="col-xs-5">
		            <select id="txtTIPODOC" class="form-control">
		            <c:forEach items="${listaTipoDoc}" var="doc">
			            <option value="${doc.id}">${doc.desc}</option>		            
		            </c:forEach>		            	
		            </select>
		        </div>
		    </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtNUMDOC">Documento del Cliente:</label>
		        <div class="col-xs-5" align="right">
		            <input type="text" id="txtNUMDOC" name="txtNUMDOC" class="form-control" value="" onkeydown="return isNumeric(event);" onblur="validar();"/>
<!-- 		            <input type="button" id="btnVALIDAR" value="VALIDAR" class="btn btn-info" onclick="validar();"/> -->
		        </div>
		    </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtCLIENTE">Datos del Cliente:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtCLIENTE" class="form-control" disabled="disabled"/>
		        </div>
	        </div>
	        <div class="form-group">
		        <label class="control-label col-xs-3" for="idRelClienteMascota">Relación con la Mascota:</label>
		        <div class="col-xs-5">
		            <select id="idRelClienteMascota" name="idRelClienteMascota" class="form-control">
			            <option value="1">DUEÑO</option>
			            <option value="2">CONTACTO ANONIMO</option>
		            </select>
		        </div>
		    </div>
		    <div class="form-group">
		        <label class="control-label col-xs-3" for="nomMascota">Nombre Mascota:</label>
		        <div class="col-xs-5" align="right">
		            <input type="text" id="nomMascota" name="nomMascota" class="form-control" value=""/>
		        </div>
		    </div>
		    <div class="form-group">
		        <label class="control-label col-xs-3" for="txtESPE">ESPECIE:</label>
		        <div class="col-xs-5">
		            <select id="txtESPE" name="txtESPE" class="form-control" onchange="cargarRaza(this.value);">
			            <option value="-1">Seleccione</option>
			            <c:forEach items="${listaESPE}" var="ESPE">
				            <option value="${ESPE.idEspecie}">${ESPE.descripcionEspecie}</option>		            
			            </c:forEach>		            	
		            </select>
		        </div>
		    </div>
		    <div class="form-group">
		        <label class="control-label col-xs-3" for="idRaza">Raza:</label>
		        <div class="col-xs-5">
		            <select id="idRaza" name="idRaza" class="form-control">
		            	<option value="-1">Seleccione</option>
		            </select>
		        </div>
		    </div>
		    <div class="form-group">
		        <label class="control-label col-xs-3" for="idGeneroMascota">Género Mascota:</label>
		        <div class="col-xs-5">
		            <select id="idGeneroMascota" name="idGeneroMascota" class="form-control">
			            <option value="1">MACHO</option>
			            <option value="2">HEMBRA</option>
		            </select>
		        </div>
		    </div>
		    <div class="form-group">
		        <label class="control-label col-xs-3" for="fechaNacMascota">Fecha de Nacimiento:</label>
		        <div class="col-xs-5" align="right">
		            <input type="text" id="fechaNacMascota" name="fechaNacMascota" class="form-control" value="" maxlength="10"/>
		        </div>
		    </div>
<!-- 		    <div class="form-group"> -->
<!-- 		        <label class="control-label col-xs-3" for="fotoMascota">Foto:</label> -->
<!-- 		        <div class="col-xs-5" align="right"> -->
<!-- 		            <input type="text" id="fotoMascota" name="fotoMascota" class="form-control" value=""/> -->
<!-- 		        </div> -->
<!-- 		    </div> -->
		    <div class="form-group">
		        <label class="control-label col-xs-3" for="descMascota">Características Generales:</label>
		        <div class="col-xs-5" align="right">
		            <input type="text" id="descMascota" name="descMascota" class="form-control" value=""/>
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