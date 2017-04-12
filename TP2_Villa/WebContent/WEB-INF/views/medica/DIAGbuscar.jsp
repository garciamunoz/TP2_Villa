<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jspf"%>

<%--content--%>

<script type="text/javascript">

function buscar(){
	$('#formBDIAG').attr('action',"/TP2_Villa/DIAG/buscar");
	$('#formBDIAG').submit();
}

function regresar(){
	$('#formBDIAG').attr('action',"/TP2_Villa/DIAG/inicio");
	$('#formBDIAG').submit();
}

</script>


<div class="container">
	<div class="page-header" align="center">
       <h1>Buscar Diagnóstico</h1>
    </div>

	<form class="form-horizontal" action="" id="formBDIAG" method="POST">

    <div class="row">
    	<div class="form-group">
	        <label class="control-label col-sm-3 col-xs-3" for="txtDIAG">CÓDIGO DIAGNÓSTICO:</label>
	        <div class="col-sm-3 col-xs-3">
	        	<input type="text" id="txtDIAG" name="txtDIAG" class="form-control" onkeypress="return isNumeric(event);"/>
	        </div>
	    </div>
    	<div class="form-group">
	        <label class="control-label col-sm-3 col-xs-3" for="txtDESC">DESCRIPCIÓN:</label>
	        <div class="col-sm-3 col-xs-3">
	            <input type="text" id="txtDESC" name="txtDESC" class="form-control"/>
	        </div>
	    </div>
    </div>
    
    <br>
    <div class="form-group">
        <div class="col-sm-3" align="left">
        	<input type="button" class="btn btn-primary" value="REGRESAR" onclick="regresar();"/>
        </div>
        <div class="col-sm-3" align="left">
        	<input type="button" class="btn btn-success" value="BUSCAR" onclick="buscar();"/>
        </div>
    </div>
</form>
</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>