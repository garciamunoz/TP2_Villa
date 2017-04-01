<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jspf"%>

<%--content--%>

<script type="text/javascript">

function regresar(){
	$('#formDAM').attr('action',"/TP2_Villa/AM/inicio");
	$('#formDAM').submit();
}

$(document).ready(function(){
	$('#txtEXAMEN').attr('disabled', 'disabled');
	$('#txtDIAG').attr('disabled', 'disabled');
});

</script>

<div class="container">
	<div class="page-header" align="center">
       <h1>Detalle Atención Médica</h1>
    </div>

	<form class="form-horizontal" action="" id="formDAM" method="POST">

    <div class="col-sm-12">
    	<div class="col-sm-8">
    		<div class="form-group">
		        <label class="control-label col-sm-3 col-xs-3" for="txtHC">CÓDIGO AM:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtHC" value="${am.idAM}" class="form-control" disabled="disabled"/>
		        </div>
		    </div>
		    <!-- 
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtTIPODOC">TIPO DOCUMENTO:</label>
		        <div class="col-xs-5">
		        	<input type="text" id="txtTIPODOC" value="${am}" class="form-control" disabled="disabled"/>
		        </div>
		    </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtNUMDOC">NÚMERO DOCUMENTO:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtNUMDOC" value="${am}" class="form-control" disabled="disabled"/>
		        </div>
		    </div>
		     -->
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtCLIENTE">CLIENTE:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtCLIENTE" value="${am.datosCliente}" class="form-control" disabled="disabled"/>
		        </div>
	        </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtPACIENTE">MASCOTA:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtPACIENTE" value="${am.datosMascota}" class="form-control" disabled="disabled"/>
		        </div>
	        </div>
	        <div class="form-group">
		        <label class="control-label col-xs-3" for="txtHC">NÚMERO HISTORIA CLÍNICA:</label>
		        <div class="col-xs-5" align="right">
		            <input type="text" id="txtHC" name="txtHC" class="form-control" value="${am.idHC}" disabled="disabled"/>
		        </div>
		    </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtMEDICO">MÉDICO:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtMEDICO" class="form-control" value="${am.desMedico}" disabled="disabled"/>
		        </div>
	        </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtDEPO">DEPOSICIONES AL DÍA:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtDEPO" name="txtDEPO" class="form-control" value="${am.deposiciones}" disabled="disabled"/>
		        </div>
	        </div>
	        <div class="form-group">
		        <label class="control-label col-xs-3" for="txtPESO">PESO KG:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtPESO" name="txtPESO" class="form-control" value="${am.peso}" disabled="disabled"/>
		        </div>
	        </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtTEMP">TEMPERATURA C°:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtTEMP" name="txtTEMP" class="form-control" maxlength="3" value="${am.temperatura}" disabled="disabled"/>
		        </div>
	        </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtVITAL">PULSOS POR MINUTO:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtVITAL" name="txtVITAL" class="form-control" maxlength="3" value="${am.signovital}" disabled="disabled"/>
		        </div>
	        </div>
	        <div class="form-group">
		        <label class="control-label col-xs-3" for="txtDIAG">DIAGNÓSTICO:</label>
		        <div class="col-xs-8">
		            <select id="txtDIAG" name="txtDIAG" class="form-control">
			            <option value="-1">Seleccione</option>	
		            <c:forEach items="${listaDiagnostico}" var="diag">
			            <option value="${diag.idDIAG}" <c:if test="${diag.idDIAG == am.idDIAG}">selected="selected"</c:if> 
			            	>${diag.descripcion}</option>		            
		            </c:forEach>		            	
		            </select>
		        </div>
		    </div>
	        <div class="form-group">
		        <label class="control-label col-xs-3" for="txtEXAMEN">ORDEN MÉDICA:</label>
		        <div class="col-xs-8">
		            <select id="txtEXAMEN" name="txtEXAMEN" class="form-control">
			            <option value="-1">Seleccione</option>	
		            <c:forEach items="${listaExamenes}" var="exam">
			            <option value="${exam.idEXAM}" <c:if test="${exam.idEXAM == am.idEXAM}">selected="selected"</c:if>  
			            	>${exam.descripcion}</option>		            
		            </c:forEach>		            	
		            </select>
		        </div>
		    </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtOBS">OBSERVACIÓN:</label>
		        <div class="col-xs-5">
		        	<textarea class="form-control" id="txtOBS" name="txtOBS" rows="3" cols="100" maxlength="255" disabled="disabled">${am.observacion}</textarea>
		        </div>
	        </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtCOMMENT">COMENTARIOS:</label>
		        <div class="col-xs-5">
		        	<textarea class="form-control" id="txtCOMMENT" name="txtCOMMENT" rows="3" cols="100" maxlength="255" disabled="disabled">${am.comentario}</textarea>
		        </div>
	        </div>
	        <!-- 
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtESPECIE">ESPECIE:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtESPECIE" value="{am.descripcionEspecie}" class="form-control" disabled="disabled"/>
		        </div>
	        </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtRAZA">RAZA:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtRAZA" value="{am.descripcionRaza}" class="form-control" disabled="disabled"/>
		        </div>
	        </div>
	        <div class="form-group">
		        <label class="control-label col-xs-3" for="txtGENERO">GENERO:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtGENERO" value="{am.descripcionGenMascota}" class="form-control" disabled="disabled"/>
		        </div>
	        </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtEDAD">EDAD:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtEDAD" value="{am.edad}" class="form-control" disabled="disabled"/>
		        </div>
	        </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtOBS">OBSERVACIÓN:</label>
		        <div class="col-xs-5">
		        	<textarea class="form-control" id="txtOBS" rows="3" cols="100" maxlength="255" disabled="disabled">{am.observaciones}</textarea>
		        </div>
	        </div>
	        -->
	    </div>
        <div class="col-sm-4" align="left">
        	<img class="thumbnail" alt="IMG" src="/TP2_Villa/static/img/x.png" width="150px" height="150px">
        </div>
    </div>
    
    <br>
    <div class="form-group">
        <div class="col-sm-3" align="center">
        	<input type="button" class="btn btn-primary" value="REGRESAR" onclick="regresar();"/>
        </div>
    </div>
</form>
</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>