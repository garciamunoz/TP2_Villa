<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jspf"%>

<%--content--%>

<script type="text/javascript">

function Regresar(){
	$('#formRHC').attr('action',"/TP2_Villa/HC/listar");
	$('#formRHC').submit();
}

</script>


<div class="container">
	<div class="page-header" align="center">
       <h1>Registrar Historia Clínica</h1>
    </div>

	<form class="form-horizontal" action="" id="formRHC" method="POST">

    <div class="col-sm-12">
    	<div class="col-sm-8">
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtTIPODOC">TIPO DOCUMENTO:</label>
		        <div class="col-xs-5">
		            <select id="txtTIPODOC" class="form-control">
		            <c:forEach items="${listaTipoDoc}" var="doc">
			            <option value="${doc.id}">${doc.desc}</option>		            
		            </c:forEach>		            	
		            </select>
		        </div>
		    </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtNUMDOC">NÚMERO:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtNUMDOC" class="form-control" placeholder="1234567"/>
		        </div>
		    </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtCLIENTE">CLIENTE:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtCLIENTE" class="form-control" disabled="disabled"/>
		        </div>
	        </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtMASCOTA">MASCOTA:</label>
		        <div class="col-xs-5">
		            <select type="text" id="txtMASCOTA" class="form-control"></select>
		        </div>
	        </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtESPECIE">ESPECIE:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtESPECIE" class="form-control" disabled="disabled"/>
		        </div>
	        </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtRAZA">RAZA:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtRAZA" class="form-control" disabled="disabled"/>
		        </div>
	        </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtEDAD">EDAD:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtEDAD" class="form-control"/>
		        </div>
	        </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtOBS">OBSERVACIÓN:</label>
		        <div class="col-xs-5">
		        	<textarea class="form-control" id="txtOBS" rows="3" cols="100" maxlength="255"></textarea>
		        </div>
	        </div>
	    </div>
        <div class="col-sm-4" align="left">
        	<img class="thumbnail" alt="IMG" src="/TP2_Villa/static/img/x.png" width="150px" height="150px">
        </div>
    </div>
    
    <br>
    <div class="form-group">
        <div class="col-sm-3" align="left">
        	<input type="button" class="btn btn-primary" value="REGRESAR" onclick="Regresar();"/>
	    </div>
        <div class="col-sm-3" align="center">
        	<input type="button" class="btn btn-success" value="GRABAR"/>
        </div>
    </div>
</form>
</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>