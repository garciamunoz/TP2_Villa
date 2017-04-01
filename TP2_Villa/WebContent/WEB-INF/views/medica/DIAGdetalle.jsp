<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jspf"%>

<%--content--%>

<script type="text/javascript">

function regresar(){
	$('#formDDIAG').attr('action',"/TP2_Villa/DIAG/inicio");
	$('#formDDIAG').submit();
}

function actualizar(){
	$('#formDDIAG').attr('action',"/TP2_Villa/DIAG/actualizar");
	$('#formDDIAG').submit();
}

</script>

<div class="container">
	<div class="page-header" align="center">
       <h1>Detalle Diagnóstico</h1>
    </div>

	<form class="form-horizontal" action="" id="formDDIAG" method="POST">
	<input type="hidden" id="hdnDIAG" name="hdnDIAG" value="${diag.idDIAG}"/>
    <div class="col-sm-12">
    	<div class="col-sm-8">
    		<div class="form-group">
		        <label class="control-label col-sm-3 col-xs-3" for="txtDIAG">CÓDIGO DIAGNÓSTICO:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtDIAG" value="${diag.idDIAG}" class="form-control" disabled="disabled"/>
		        </div>
		    </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtDESC">DESCRIPCIÓN:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtDESC" value="${diag.descripcion}" class="form-control" disabled="disabled"/>
		        </div>
	        </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtOBS">OBSERVACIÓN:</label>
		        <div class="col-xs-5">
		        	<textarea class="form-control" id="txtOBS" name="txtOBS" rows="3" cols="100" maxlength="255">${diag.observacion}</textarea>
		        </div>
	        </div>
	    </div>
    </div>
    
    <br>
    <div class="form-group">
        <div class="col-sm-3" align="center">
        	<input type="button" class="btn btn-primary" value="REGRESAR" onclick="regresar();"/>
        </div>
        <div class="col-sm-3" align="center">
        	<input type="button" class="btn btn-success" value="ACTUALIZAR" onclick="actualizar();"/>
        </div>
    </div>
</form>
</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>