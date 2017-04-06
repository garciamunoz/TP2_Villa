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
        	$('#formRAZA').attr('action',"/TP2_Villa/RAZA/eliminar");
        	$('#formRAZA').submit();
        }
      }
    });
    
 });

function registrar(){
	$('#formRAZA').attr('action',"/TP2_Villa/RAZA/cargarRegistrar");
	$('#formRAZA').submit();
}

function limpiar(){
	$('#formRAZA').attr('action',"/TP2_Villa/RAZA/limpiar");
	$('#formRAZA').submit();
}

function detalle(id){
	$('#idRAZA').val(id);
	$('#formRAZA').attr('action',"/TP2_Villa/RAZA/detalle");
	$('#formRAZA').submit();
}

function eliminar(id){
	$('#idRAZA').val(id);
	$('#spnRAZA').text(id);
	$('#dialog-confirm').dialog('open');
}

function buscar(){
	$('#formRAZA').attr('action',"/TP2_Villa/RAZA/cargarBuscar");
	$('#formRAZA').submit();
}

</script>

<div class="container">
	<div class="page-header">
       <h1>Gestionar Raza</h1>
    </div>

	<form class="form-horizontal" action="" id="formRAZA" method="POST">
	<input type="hidden" id="idRAZA" name="idRAZA" value="" />

    <div class="form-group">
        <input type="button" class="btn btn-default" value="BUSCAR" onclick="buscar();"/>
        <input type="button" class="btn btn-success" value="REGISTRAR" onclick="registrar();"/>
    </div>
    
    <br>
    <div class="form-group">
		<table class="table table-hover table-bordered" border="1">
        	<thead style="background-color: #bce8f1;">
            	<tr>
                	<th style="text-align: center;">CÓDIGO RAZA</th>
                	<th style="text-align: center;">DESCRIPCIÓN</th>
                	<th style="text-align: center;">ESPECIE</th>
                	<th style="text-align: center;">REGISTRADO</th>
                	<th style="text-align: center;">ACTUALIZADO</th>
                	<th style="text-align: center;" colspan="2">ACCIÓN</th>
                </tr>
            </thead>
            <tbody>
            	<c:forEach var="RAZA" items="${listaRAZA}">
	            	<tr>
	            		<td style="text-align: center;">${RAZA.idRaza}</td>
	            		<td style="text-align: center;">${RAZA.descripcionRaza}</td>
	            		<td style="text-align: center;">${RAZA.descripcionEspecie}</td>
	            		<td style="text-align: center;">${RAZA.registrado}</td>
	            		<td style="text-align: center;">${RAZA.actualizado}</td>
	            		<td style="text-align: center;">
	            			<a href="javascript:void(0);" onclick="detalle(${RAZA.idRaza});">Actualizar</a>
	            		</td>
	            		<td style="text-align: center;">
	            			<a href="javascript:void(0);" onclick="eliminar(${RAZA.idRaza});">Eliminar</a>
	            		</td>
	            	</tr>
            	</c:forEach>
            	<c:if test="${empty listaRAZA}">
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
  <p><span class="ui-icon ui-icon-alert" style="float:left; margin:12px 12px 20px 0;"></span>¿Está seguro de eliminar la RAZA con código <span id="spnRAZA">999</span>?</p>
</div>

</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>