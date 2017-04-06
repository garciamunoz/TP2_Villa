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
        	$('#formDIAG').attr('action',"/TP2_Villa/DIAG/eliminar");
        	$('#formDIAG').submit();
        }
      }
    });
    
 });

function registrar(){
	$('#formDIAG').attr('action',"/TP2_Villa/DIAG/cargarRegistrar");
	$('#formDIAG').submit();
}

function limpiar(){
	$('#formDIAG').attr('action',"/TP2_Villa/DIAG/limpiar");
	$('#formDIAG').submit();
}

function detalle(id){
	$('#idDIAG').val(id);
	$('#formDIAG').attr('action',"/TP2_Villa/DIAG/detalle");
	$('#formDIAG').submit();
}

function eliminar(id){
	$('#idDIAG').val(id);
	$('#spnDIAG').text(id);
	$('#dialog-confirm').dialog('open');
}

function buscar(){
	$('#formDIAG').attr('action',"/TP2_Villa/DIAG/cargarBuscar");
	$('#formDIAG').submit();
}

</script>


<div class="container">
	<div class="page-header">
       <h1>Gestionar Diagnóstico</h1>
    </div>

	<form class="form-horizontal" action="" id="formDIAG" method="POST">
	<input type="hidden" id="idDIAG" name="idDIAG" value="" />

    <div class="form-group">
        <input type="button" class="btn btn-default" value="BUSCAR" onclick="buscar();"/>
        <input type="button" class="btn btn-success" value="REGISTRAR" onclick="registrar();"/>
    </div>
    
    <br>
    <div class="form-group">
		<table class="table table-hover table-bordered" border="1">
        	<thead style="background-color: #bce8f1;">
            	<tr>
                	<th style="text-align: center;">CÓDIGO DIAGNÓSTICO</th>
                	<th style="text-align: center;">DESCRIPCIÓN</th>
                	<th style="text-align: center;">REGISTRADO</th>
                	<th style="text-align: center;">ACTUALIZADO</th>
                	<th style="text-align: center;" colspan="2">ACCIÓN</th>
                </tr>
            </thead>
            <tbody>
            	<c:forEach var="DIAG" items="${listaDIAG}">
	            	<tr>
	            		<td style="text-align: center;">${DIAG.idDIAG}</td>
	            		<td style="text-align: center;">${DIAG.descripcion}</td>
	            		<td style="text-align: center;">${DIAG.registrado}</td>
	            		<td style="text-align: center;">${DIAG.actualizado}</td>
	            		<td style="text-align: center;">
	            			<a href="javascript:void(0);" onclick="detalle(${DIAG.idDIAG});">Actualizar</a>
	            		</td>
	            		<td style="text-align: center;">
	            			<a href="javascript:void(0);" onclick="eliminar(${DIAG.idDIAG});">Eliminar</a>
	            		</td>
	            	</tr>
            	</c:forEach>
            	<c:if test="${empty listaDIAG}">
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
        	<input type="button" class="btn btn-info" value="LIMPIAR" onclick="limpiar();"/>
	    </div>
    </div>
</form>

<div id="dialog-confirm" title="Mensaje" style="display: none;">
  <p><span class="ui-icon ui-icon-alert" style="float:left; margin:12px 12px 20px 0;"></span>¿Está seguro de eliminar el Diagnóstico con código <span id="spnDIAG">999</span>?</p>
</div>

</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>