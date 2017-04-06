<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jspf"%>

<%--content--%>

<script type="text/javascript">

$(function() {
    $('#dialog-confirm').dialog({
      autoOpen: false,
      resizable: false,
      height: "auto",
      width: 400,
      modal: true,
      buttons: {
        "Cancelar": function() {
          $( this ).dialog( "close" );
        },
        "Eliminar": function() {
        	$('#formCLI').attr('action',"/TP2_Villa/CLI/eliminar");
        	$('#formCLI').submit();
        }
      }
    });
    
 });

function registrar(){
	$('#formCLI').attr('action',"/TP2_Villa/CLI/cargarRegistrar");
	$('#formCLI').submit();
}

function limpiar(){
	$('#formCLI').attr('action',"/TP2_Villa/CLI/limpiar");
	$('#formCLI').submit();
}

function detalle(id){
	$('#idCLI').val(id);
	$('#formCLI').attr('action',"/TP2_Villa/CLI/detalle");
	$('#formCLI').submit();
}

function eliminar(id){
	$('#idCLI').val(id);
	$('#spnCLI').text(id);
	$('#dialog-confirm').dialog('open');
}

function buscar(){
	$('#formCLI').attr('action',"/TP2_Villa/CLI/buscar");
	$('#formCLI').submit();
}

</script>


<div class="container">
	<div class="page-header">
       <h1>Gestionar Cliente</h1>
    </div>

	<form class="form-horizontal" action="" id="formCLI" method="POST">
	<input type="hidden" id="idCLI" name="idCLI" value="" />

	<div class="row">
    	<div class="form-group">
	        <label class="control-label col-xs-3" for="txtTIPODOC">Tipo Documento:</label>
		        <div class="col-xs-3">
		            <select id="txtTIPODOC" name="txtTIPODOC" class="form-control">
		            <c:forEach items="${listaTipoDoc}" var="doc">
			            <option value="${doc.id}">${doc.desc}</option>		            
		            </c:forEach>		            	
		            </select>
		        </div>
	        <label class="control-label col-sm-3 col-xs-3" for="txtNOMBRE">Nombre:</label>
	        <div class="col-sm-3 col-xs-3">
	            <input type="text" id="txtNOMBRE" name="txtNOMBRE" class="form-control"/>
	        </div>
	    </div>
    </div>

	<div class="row">
    	<div class="form-group">
	        <label class="control-label col-sm-3 col-xs-3" for="txtNRODOC">N° de Documento:</label>
	        <div class="col-sm-3 col-xs-3">
	        	<input type="text" id="txtNRODOC" name="txtNRODOC" class="form-control"/>
	        </div>
	        <label class="control-label col-sm-3 col-xs-3" for="txtAP">Apellido Paterno:</label>
	        <div class="col-sm-3 col-xs-3">
	            <input type="text" id="txtAP" name="txtAP" class="form-control"/>
	        </div>
	    </div>
    </div>

	<div class="row">
    	<div class="form-group">
	        <label class="control-label col-sm-3 col-xs-3" for="txtCOD">Código:</label>
	        <div class="col-sm-3 col-xs-3">
	        	<input type="text" id="txtCOD" name="txtCOD" class="form-control"/>
	        </div>
	        <label class="control-label col-sm-3 col-xs-3" for="txtAM">Apellido Materno:</label>
	        <div class="col-sm-3 col-xs-3">
	            <input type="text" id="txtAM" name="txtAM" class="form-control"/>
	        </div>
	    </div>
    </div>

    <div class="form-group" align="center">
        <input type="button" class="btn btn-default" value="Buscar Cliente" onclick="buscar();"/>
    </div>
    
    <br>
    <div class="form-group">
        <input type="button" class="btn btn-success" value="+ Agregar Cliente" onclick="registrar();"/><br>
		<table class="table table-hover table-bordered" border="1">
        	<thead style="background-color: #bce8f1;">
            	<tr>
                	<th style="text-align: center;">CÓDIGO</th>
                	<th style="text-align: center;">TIPO CLIENTE</th>
                	<th style="text-align: center;">DOCUMENTO</th>
                	<th style="text-align: center;">NOMBRE COMPLETO</th>
                	<th style="text-align: center;" colspan="2">ACCIÓN</th>
                </tr>
            </thead>
            <tbody>
            	<c:forEach var="CLI" items="${listaCLI}">
	            	<tr>
	            		<td style="text-align: center;">${CLI.idCliente}</td>
	            		<td style="text-align: center;">${CLI.descripcionTipoCliente}</td>
	            		<td style="text-align: center;">${CLI.documentoCompleto}</td>
	            		<td style="text-align: center;">${CLI.nombreCompleto}</td>
	            		<td style="text-align: center;">
	            			<a href="javascript:void(0);" onclick="detalle(${CLI.idCliente});">Actualizar</a>
	            		</td>
	            		<td style="text-align: center;">
	            			<a href="javascript:void(0);" onclick="eliminar(${CLI.idCliente});">Eliminar</a>
	            		</td>
	            	</tr>
            	</c:forEach>
            	<c:if test="${empty listaCLI}">
            		<tr><td colspan="9" style="text-align: center;">
            			No hay datos para mostrar.
            		</td></tr>
            	</c:if>
            </tbody>
        </table>
    </div>

    <br>
    <div class="form-group">
        <div class="col-sm-12" align="left">
        	<input type="button" class="btn btn-info" value="Limpiar" onclick="limpiar();"/>
	    </div>
    </div>
</form>

<div id="dialog-confirm" title="Mensaje" style="display: none;">
  <p><span class="ui-icon ui-icon-alert" style="float:left; margin:12px 12px 20px 0;"></span>¿Está seguro de eliminar el Cliente con código <span id="spnCLI">999</span>?</p>
</div>

</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>