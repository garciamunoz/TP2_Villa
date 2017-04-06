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
        	$('#formPM').attr('action',"/TP2_Villa/PM/eliminar");
        	$('#formPM').submit();
        }
      }
    });
    
 });

function registrar(){
	$('#formPM').attr('action',"/TP2_Villa/PM/cargarRegistrar");
	$('#formPM').submit();
}

function limpiar(){
	$('#formPM').attr('action',"/TP2_Villa/PM/limpiar");
	$('#formPM').submit();
}

function detalle(id){
	$('#idPM').val(id);
	$('#formPM').attr('action',"/TP2_Villa/PM/detalle");
	$('#formPM').submit();
}

function eliminar(id){
	$('#idPM').val(id);
	$('#spnPM').text(id);
	$('#dialog-confirm').dialog('open');
}

function buscar(){
	$('#formPM').attr('action',"/TP2_Villa/PM/cargarBuscar");
	$('#formPM').submit();
}

</script>


<div class="container">
	<div class="page-header">
       <h1>Gestionar Procedimiento Médico</h1>
    </div>

	<form class="form-horizontal" action="" id="formPM" method="POST">
	<input type="hidden" id="idPM" name="idPM" value="" />

    <div class="form-group">
        <input type="button" class="btn btn-default" value="BUSCAR" onclick="buscar();"/>
        <input type="button" class="btn btn-success" value="REGISTRAR" onclick="registrar();"/>
    </div>
    
    <br>
    <div class="form-group">
		<table class="table table-hover table-bordered" border="1">
        	<thead style="background-color: #bce8f1;">
            	<tr>
                	<th style="text-align: center;">CÓDIGO PROCEDIMIENTO MÉDICO</th>
                	<th style="text-align: center;">CODIGO ATENCIÓN MÉDICA</th>
                	<th style="text-align: center;">TIPO PROCEDIMIENTO</th>
                	<th style="text-align: center;">ACTUALIZADO</th>
                	<th style="text-align: center;">REGISTRADO</th>
                	<th style="text-align: center;" colspan="2">ACCIÓN</th>
                </tr>
            </thead>
            <tbody>
            	<c:forEach var="PM" items="${listaPM}">
	            	<tr>
	            		<td style="text-align: center;">${PM.idProcedimiento}</td>
	            		<td style="text-align: center;">${PM.idAM}</td>
	            		<td style="text-align: center;">${PM.tipoProcedimiento}</td>
	            		<td style="text-align: center;">${PM.actualizado}</td>
	            		<td style="text-align: center;">${PM.registrado}</td>
	            		<td style="text-align: center;">
	            			<a href="javascript:void(0);" onclick="detalle(${PM.idProcedimiento});">Actualizar</a>
	            		</td>
	            		<td style="text-align: center;">
	            			<a href="javascript:void(0);" onclick="eliminar(${PM.idProcedimiento});">Eliminar</a>
	            		</td>
	            	</tr>
            	</c:forEach>
            	<c:if test="${empty listaPM}">
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
  <p><span class="ui-icon ui-icon-alert" style="float:left; margin:12px 12px 20px 0;"></span>¿Está seguro de eliminar el Procedimiento Médico con código <span id="spnPM">999</span>?</p>
</div>

</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>