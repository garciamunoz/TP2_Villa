<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jspf"%>

<%--content--%>

<script type="text/javascript">

function buscar(){
	$('#formBESPE').attr('action',"/TP2_Villa/ESPE/buscar");
	$('#formBESPE').submit();
}

function regresar(){
	$('#formBESPE').attr('action',"/TP2_Villa/ESPE/inicio");
	$('#formBESPE').submit();
}

</script>


<div class="container">
	<div class="page-header" align="center">
       <h1>Buscar Especie</h1>
    </div>

	<form class="form-horizontal" action="" id="formBESPE" method="POST">

    <div class="row">
    	<div class="form-group">
	        <label class="control-label col-sm-3 col-xs-3" for="txtESPE">CÓDIGO ESPECIE:</label>
	        <div class="col-sm-3 col-xs-3">
	        	<input type="text" id="txtESPE" name="txtESPE" class="form-control"/>
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