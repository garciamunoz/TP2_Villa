<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jspf"%>

<%--content--%>

<script type="text/javascript">

function regresar(){
	$('#formDESPE').attr('action',"/TP2_Villa/ESPE/inicio");
	$('#formDESPE').submit();
}

function actualizar(){
	$('#formDESPE').attr('action',"/TP2_Villa/ESPE/actualizar");
	$('#formDESPE').submit();
}

</script>

<div class="container">
	<div class="page-header" align="center">
       <h1>Detalle Especie</h1>
    </div>

	<form class="form-horizontal" action="" id="formDESPE" method="POST">
	<input type="hidden" id="hdnESPE" name="hdnESPE" value="${ESPE.idEspecie}"/>
    <div class="col-sm-12">
    	<div class="col-sm-8">
    		<div class="form-group">
		        <label class="control-label col-sm-3 col-xs-3" for="txtESPE">CÓDIGO ESPECIE:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtESPE" value="${ESPE.idEspecie}" class="form-control" disabled="disabled"/>
		        </div>
		    </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtDESC">DESCRIPCIÓN:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtDESC" value="${ESPE.descripcionEspecie}" class="form-control" disabled="disabled"/>
		        </div>
	        </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtOBS">OBSERVACIÓN:</label>
		        <div class="col-xs-5">
		        	<textarea class="form-control" id="txtOBS" name="txtOBS" rows="3" cols="100" maxlength="255">${ESPE.observacion}</textarea>
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