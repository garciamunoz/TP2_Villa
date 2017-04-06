<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jspf"%>

<%--content--%>

<script type="text/javascript">

function regresar(){
	$('#formDRM').attr('action',"/TP2_Villa/RM/inicio");
	$('#formDRM').submit();
}

function actualizar(){
	$('#formDRM').attr('action',"/TP2_Villa/RM/actualizar");
	$('#formDRM').submit();
}

</script>

<div class="container">
	<div class="page-header" align="center">
       <h1>Detalle Receta Médica</h1>
    </div>

	<form class="form-horizontal" action="" id="formDRM" method="POST">
	<input type="hidden" id="hdnRM" name="hdnRM" value="${RM.idReceta}"/>
    <div class="col-sm-12">
    	<div class="col-sm-8">
    		<div class="form-group">
		        <label class="control-label col-sm-3 col-xs-3" for="txtRM">CÓDIGO RECETA MÉDICA:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtRM" value="${RM.idReceta}" class="form-control" disabled="disabled"/>
		        </div>
		    </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtOBS">OBSERVACIÓN:</label>
		        <div class="col-xs-5">
		        	<textarea class="form-control" id="txtOBS" name="txtOBS" rows="3" cols="100" maxlength="255" disabled="disabled">${RM.observacion}</textarea>
		        </div>
	        </div>
	        <div class="form-group">
		        <table class="table table-hover table-bordered" border="1">
        		<thead style="background-color: #bce8f1;">
            	<tr>
                	<th style="text-align: center;">MEDICAMENTO</th>
                	<th style="text-align: center;">VIA</th>
                	<th style="text-align: center;">DOSIS</th>
                	<th style="text-align: center;">INDICACIÓN</th>
                	<th style="text-align: center;">DURACIÓN</th>
                	<th style="text-align: center;">CANTIDAD</th>
                </tr>
	            </thead>
	            <tbody>
	            	<c:forEach var="RM" items="${listaRM}">
	            	<tr>
	            		<td style="text-align: center;">${RM.nombreMedicamento}</td>
	            		<td style="text-align: center;">${RM.via}</td>
	            		<td style="text-align: center;">${RM.dosis}</td>
	            		<td style="text-align: center;">${RM.indicacion}</td>
	            		<td style="text-align: center;">${RM.duracion}</td>
	            		<td style="text-align: center;">${RM.cantidad}</td>
	            	</tr>
	            	</c:forEach>
		        </tbody>
	         	</table>
	        </div>
	    </div>
    </div>
    
    <br>
    <div class="form-group">
        <div class="col-sm-3" align="center">
        	<input type="button" class="btn btn-primary" value="REGRESAR" onclick="regresar();"/>
        </div>
<!--         <div class="col-sm-3" align="center"> -->
<!--         	<input type="button" class="btn btn-success" value="ACTUALIZAR" onclick="actualizar();"/> -->
<!--         </div> -->
    </div>
</form>
</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>