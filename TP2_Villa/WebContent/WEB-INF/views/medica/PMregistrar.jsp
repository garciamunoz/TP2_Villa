<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jspf"%>

<%--content--%>

<script type="text/javascript">

function regresar(){
	$('#formRESPE').attr('action',"/TP2_Villa/ESPE/inicio");
	$('#formRESPE').submit();
}

function registrar(){
	$('#formRESPE').attr('action',"/TP2_Villa/ESPE/registrar");
	$('#formRESPE').submit();	
}

</script>

<div class="container">
	<div class="page-header" align="center">
       <h1>Registrar Especie</h1>
    </div>

	<form class="form-horizontal" action="" id="formRESPE" method="POST">

    <div class="col-sm-12">
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtDESC">DESCRIPCIÓN:</label>
		        <div class="col-xs-5" align="right">
		            <input type="text" id="txtDESC" name="txtDESC" class="form-control" value=""/>
		        </div>
		    </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtOBS">OBSERVACIÓN:</label>
		        <div class="col-xs-5">
		        	<textarea class="form-control" id="txtOBS" name="txtOBS" rows="3" cols="100" maxlength="255"></textarea>
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