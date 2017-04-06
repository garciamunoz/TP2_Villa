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
        	$('#formESPE').attr('action',"/TP2_Villa/ESPE/eliminar");
        	$('#formESPE').submit();
        }
      }
    });
    
 });

function registrar(){
	$('#formESPE').attr('action',"/TP2_Villa/ESPE/cargarRegistrar");
	$('#formESPE').submit();
}

function limpiar(){
	$('#formESPE').attr('action',"/TP2_Villa/ESPE/limpiar");
	$('#formESPE').submit();
}

function detalle(id){
	$('#idESPE').val(id);
	$('#formESPE').attr('action',"/TP2_Villa/ESPE/detalle");
	$('#formESPE').submit();
}

function eliminar(id){
	$('#idESPE').val(id);
	$('#spnESPE').text(id);
	$('#dialog-confirm').dialog('open');
}

function buscar(){
	$('#formESPE').attr('action',"/TP2_Villa/ESPE/cargarBuscar");
	$('#formESPE').submit();
}

</script>


<div class="container">
	<div class="page-header">
       <h1>Gestionar Especie</h1>
    </div>

	<form class="form-horizontal" action="" id="formESPE" method="POST">
	<input type="hidden" id="idESPE" name="idESPE" value="" />

    <div class="form-group">
        <input type="button" class="btn btn-default" value="BUSCAR" onclick="buscar();"/>
        <input type="button" class="btn btn-success" value="REGISTRAR" onclick="registrar();"/>
    </div>
    
    <br>
    <div class="form-group">
		<table class="table table-hover table-bordered" border="1">
        	<thead style="background-color: #bce8f1;">
            	<tr>
                	<th style="text-align: center;">CÓDIGO ESPECIE</th>
                	<th style="text-align: center;">DESCRIPCIÓN</th>
                	<th style="text-align: center;">REGISTRADO</th>
                	<th style="text-align: center;">ACTUALIZADO</th>
                	<th style="text-align: center;" colspan="2">ACCIÓN</th>
                </tr>
            </thead>
            <tbody>
            	<c:forEach var="ESPE" items="${listaESPE}">
	            	<tr>
	            		<td style="text-align: center;">${ESPE.idEspecie}</td>
	            		<td style="text-align: center;">${ESPE.descripcionEspecie}</td>
	            		<td style="text-align: center;">${ESPE.registrado}</td>
	            		<td style="text-align: center;">${ESPE.actualizado}</td>
	            		<td style="text-align: center;">
	            			<a href="javascript:void(0);" onclick="detalle(${ESPE.idEspecie});">Actualizar</a>
	            		</td>
	            		<td style="text-align: center;">
	            			<a href="javascript:void(0);" onclick="eliminar(${ESPE.idEspecie});">Eliminar</a>
	            		</td>
	            	</tr>
            	</c:forEach>
            	<c:if test="${empty listaESPE}">
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
  <p><span class="ui-icon ui-icon-alert" style="float:left; margin:12px 12px 20px 0;"></span>¿Está seguro de eliminar la ESPECIE con código <span id="spnESPE">999</span>?</p>
</div>

</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>