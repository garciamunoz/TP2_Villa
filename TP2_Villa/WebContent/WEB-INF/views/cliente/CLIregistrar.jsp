<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jspf"%>

<%--content--%>

<script type="text/javascript">

var valido = false;

function regresar(){
	$('#formRCLI').attr('action',"/TP2_Villa/CLI/inicio");
	$('#formRCLI').submit();
}

function registrar(){
	obligatorio();
	if(!valido)return false;
	var dateRegex = /^(?=\d)(?:(?:31(?!.(?:0?[2469]|11))|(?:30|29)(?!.0?2)|29(?=.0?2.(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00)))(?:\x20|$))|(?:2[0-8]|1\d|0?[1-9]))([-.\/])(?:1[012]|0?[1-9])\1(?:1[6-9]|[2-9]\d)?\d\d(?:(?=\x20\d)\x20|$))?(((0?[1-9]|1[012])(:[0-5]\d){0,2}(\x20[AP]M))|([01]\d|2[0-3])(:[0-5]\d){1,2})?$/;
	var fecha = $('#fecNacCliente').val();
	if(fecha.length < 10){
		mensajeModal("El Formato para la Fecha de Nacimiento es dd/mm/aaaa");
		return false;
	}
	var valFecha = dateRegex.test(fecha);
	if(!valFecha){
		mensajeModal("El Formato para la Fecha de Nacimiento es dd/mm/aaaa");
		return false;
	}
	
	var fechaArray = fecha.split("/");
	var dia = fechaArray[0];
	var mes = fechaArray[1];
	var ano = fechaArray[2];
	 
	var fecha_hoy = new Date();
	var ahora_ano = fecha_hoy.getYear();
	var ahora_mes = fecha_hoy.getMonth();
	var ahora_dia = fecha_hoy.getDate();
	var edad = (ahora_ano + 1900) - ano;
	    
	    if ( ahora_mes < (mes - 1)){
	      edad--;
	    }
	    if (((mes - 1) == ahora_mes) && (ahora_dia < dia)){ 
	      edad--;
	    }
	    if (edad > 1900){
	        edad -= 1900;
	    }
	
	if(edad < 18){
		mensajeModal("La Fecha de Nacimiento no puede ser menor a 18 años.");
		return false;
	}
	    
	if(valido){
		$('#formRCLI').attr('action',"/TP2_Villa/CLI/registrar");
		$('#formRCLI').submit();	
	}
}

function obligatorio(){
	$("form#formRCLI :input[type=text]").each(function(){
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
	$.ajax({
		type:'GET',
		url: '/TP2_Villa/CLI/validar',
		async: false,
		data: {
			txtNROCLI: $('#nroDocumento').val()
		},
		success: function(data){
			listaDatos = data;
			if(data.length > 0){
				mensajeModal("Número de Documento ya existente.");
				$('#nroDocumento').val('');
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
       <h1>Registrar Cliente</h1>
    </div>

	<form class="form-horizontal" action="" id="formRCLI" method="POST">
	
    <div class="col-sm-12">
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="idTipoCliente">Tipo Cliente:</label>
		        <div class="col-xs-5">
		            <select id="idTipoCliente" name="idTipoCliente" class="form-control">
			            <option value="1">NATURAL</option>
			            <option value="2">EMPRESA</option>
			            <option value="3">ONG</option>		            
		            </select>
		        </div>
		    </div>
		    <div class="form-group">
		        <label class="control-label col-xs-3" for="idTipoDocumento">Tipo Documento:</label>
		        <div class="col-xs-5">
		            <select id="idTipoDocumento" name="idTipoDocumento" class="form-control">
		            <c:forEach items="${listaTipoDoc}" var="doc">
			            <option value="${doc.id}">${doc.desc}</option>		            
		            </c:forEach>		            	
		            </select>
		        </div>
		    </div>
		    <div class="form-group">
		        <label class="control-label col-xs-3" for="nroDocumento">Número de Documento:</label>
		        <div class="col-xs-5" align="right">
		            <input type="text" id="nroDocumento" name="nroDocumento" class="form-control" value="" onblur="validar();"/>
		        </div>
		    </div>
		    <div class="form-group">
		        <label class="control-label col-xs-3" for="nomCliente">Nombre Cliente:</label>
		        <div class="col-xs-5" align="right">
		            <input type="text" id="nomCliente" name="nomCliente" class="form-control" value=""/>
		        </div>
		    </div>
		    <div class="form-group">
		        <label class="control-label col-xs-3" for="apePaternoCliente">Apellido Paterno del Cliente:</label>
		        <div class="col-xs-5" align="right">
		            <input type="text" id="apePaternoCliente" name="apePaternoCliente" class="form-control" value=""/>
		        </div>
		    </div>
		    <div class="form-group">
		        <label class="control-label col-xs-3" for="apeMaternoCliente">Apellido Materno del Cliente:</label>
		        <div class="col-xs-5" align="right">
		            <input type="text" id="apeMaternoCliente" name="apeMaternoCliente" class="form-control" value=""/>
		        </div>
		    </div>
		    <div class="form-group">
		        <label class="control-label col-xs-3" for="idGeneroCliente">Género:</label>
		        <div class="col-xs-5">
		            <select id="idGeneroCliente" name="idGeneroCliente" class="form-control">
			            <option value="1">MASCULINO</option>
			            <option value="2">FEMENINO</option>
			            <option value="3">OTROS</option>		            
		            </select>
		        </div>
		    </div>
		    <div class="form-group">
		        <label class="control-label col-xs-3" for="fecNacCliente">Fecha de Nacimiento:</label>
		        <div class="col-xs-5" align="right">
		            <input type="text" id="fecNacCliente" name="fecNacCliente" class="form-control" value="" maxlength="10"/>
		        </div>
		    </div>
		    <div class="form-group">
		        <label class="control-label col-xs-3" for="idSede">Sede:</label>
		        <div class="col-xs-5">
		            <select id="idSede" name="idSede" class="form-control">
			            <option value="1">SALAMANCA</option>
			            <option value="2">PACHACAMAC</option>
			            <option value="3">MIRAFLORES</option>	
			            <option value="4">LA MOLINA</option>		            
		            </select>
		        </div>
		    </div>
		    <div class="form-group">
		        <label class="control-label col-xs-3" for="idDistrito">Distrito:</label>
		        <div class="col-xs-5">
		            <select id="idDistrito" name="idDistrito" class="form-control">
			            <option value="1">SALAMANCA</option>
			            <option value="2">PACHACAMAC</option>
			            <option value="3">MIRAFLORES</option>	
			            <option value="4">LA MOLINA</option>		            
		            </select>
		        </div>
		    </div>
		    <div class="form-group">
		        <label class="control-label col-xs-3" for="direcCliente">Dirección del Cliente:</label>
		        <div class="col-xs-5" align="right">
		            <input type="text" id="direcCliente" name="direcCliente" class="form-control" value=""/>
		        </div>
		    </div>
		    <div class="form-group">
		        <label class="control-label col-xs-3" for="celCliente">Celular del Cliente:</label>
		        <div class="col-xs-5" align="right">
		            <input type="text" id="celCliente" name="celCliente" class="form-control" value=""/>
		        </div>
		    </div>
		    <div class="form-group">
		        <label class="control-label col-xs-3" for="telfDomCliente">Teléfono del Domicilio:</label>
		        <div class="col-xs-5" align="right">
		            <input type="text" id="telfDomCliente" name="telfDomCliente" class="form-control" value=""/>
		        </div>
		    </div>
		    <div class="form-group">
		        <label class="control-label col-xs-3" for="telfTraCliente">Teléfono de Trabajo:</label>
		        <div class="col-xs-5" align="right">
		            <input type="text" id="telfTraCliente" name="telfTraCliente" class="form-control" value=""/>
		        </div>
		    </div>
		    <div class="form-group">
		        <label class="control-label col-xs-3" for="indNotificaciones">Notificación de Promociones:</label>
		        <div class="col-xs-5">
		            <select id="indNotificaciones" name="indNotificaciones" class="form-control">
			            <option value="1">Si</option>
			            <option value="0">No</option>
		            </select>
		        </div>
		    </div>
		    <div class="form-group">
		        <label class="control-label col-xs-3" for="correoElectCliente">Correo Eléctronico:</label>
		        <div class="col-xs-5" align="right">
		            <input type="text" id="correoElectCliente" name="correoElectCliente" class="form-control" value=""/>
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