<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jspf"%>

<%--content--%>

<script type="text/javascript">

function regresar(){
	$('#formDRAZA').attr('action',"/TP2_Villa/RAZA/inicio");
	$('#formDRAZA').submit();
}

function actualizar(){
	$('#formDRAZA').attr('action',"/TP2_Villa/RAZA/actualizar");
	$('#formDRAZA').submit();
}

</script>

<div class="container">
	<div class="page-header" align="center">
       <h1>Detalle Raza</h1>
    </div>

	<form class="form-horizontal" action="" id="formDRAZA" method="POST">
	<input type="hidden" id="hdnRAZA" name="hdnRAZA" value="${RAZA.idRaza}"/>
    <div class="col-sm-12">
    	<div class="col-sm-8">
    		<div class="form-group">
		        <label class="control-label col-sm-3 col-xs-3" for="txtRAZA">CÓDIGO RAZA:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtRAZA" value="${RAZA.idRaza}" class="form-control" disabled="disabled"/>
		        </div>
		    </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtDESC">DESCRIPCIÓN:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtDESC" value="${RAZA.descripcionRaza}" class="form-control" disabled="disabled"/>
		        </div>
	        </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtOBS">OBSERVACIÓN:</label>
		        <div class="col-xs-5">
		        	<textarea class="form-control" id="txtOBS" name="txtOBS" rows="3" cols="100" maxlength="255">${RAZA.observacion}</textarea>
		        </div>
	        </div>
	        <div class="form-group">
		        <label class="control-label col-xs-3" for="txtESPE">ESPECIE:</label>
		        <div class="col-xs-5">
		            <select id="txtESPE" name="txtESPE" class="form-control">
		            <c:forEach items="${listaESPE}" var="ESPE">
			            <option value="${ESPE.idEspecie}" <c:if test="${ESPE.idEspecie == RAZA.idEspecie}">selected="selected"</c:if> 
			            	>${ESPE.descripcionEspecie}</option>		            
		            </c:forEach>		            	
		            </select>
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