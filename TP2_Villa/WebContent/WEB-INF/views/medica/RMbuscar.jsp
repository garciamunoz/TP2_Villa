<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jspf"%>

<%--content--%>

<script type="text/javascript">

function buscar(){
	$('#formBRM').attr('action',"/TP2_Villa/RM/buscar");
	$('#formBRM').submit();
}

function regresar(){
	$('#formBRM').attr('action',"/TP2_Villa/RM/inicio");
	$('#formBRM').submit();
}

</script>


<div class="container">
	<div class="page-header" align="center">
       <h1>Buscar Receta Médica</h1>
    </div>

	<form class="form-horizontal" action="" id="formBRM" method="POST">

    <div class="row">
    	<div class="form-group">
	        <label class="control-label col-sm-3 col-xs-3" for="txtRM">CÓDIGO RECETA MÉDICA:</label>
	        <div class="col-sm-3 col-xs-3">
	        	<input type="text" id="txtRM" name="txtRM" class="form-control" onkeypress="return isNumeric(event);"/>
	        </div>
	    </div>
    	<div class="form-group">
	        <label class="control-label col-sm-3 col-xs-3" for="txtAM">CODIGO ATENCIÓN MÉDICA:</label>
	        <div class="col-sm-3 col-xs-3">
	            <input type="text" id="txtAM" name="txtAM" class="form-control" onkeypress="return isNumeric(event);"/>
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