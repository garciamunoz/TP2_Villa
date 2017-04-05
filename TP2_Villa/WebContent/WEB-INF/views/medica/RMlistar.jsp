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
        	$('#formRM').attr('action',"/TP2_Villa/RM/eliminar");
        	$('#formRM').submit();
        }
      }
    });
    
 });

function registrar(){
	$('#formRM').attr('action',"/TP2_Villa/RM/cargarRegistrar");
	$('#formRM').submit();
}

function limpiar(){
	$('#formRM').attr('action',"/TP2_Villa/RM/limpiar");
	$('#formRM').submit();
}

function detalle(id){
	$('#idRM').val(id);
	$('#formRM').attr('action',"/TP2_Villa/RM/detalle");
	$('#formRM').submit();
}

function eliminar(id){
	$('#idRM').val(id);
	$('#spnRM').text(id);
	$('#dialog-confirm').dialog('open');
}

function buscar(){
	$('#formRM').attr('action',"/TP2_Villa/RM/cargarBuscar");
	$('#formRM').submit();
}

</script>


<div class="container">
	<div class="page-header">
       <h1>Gestionar Receta Médica</h1>
    </div>

	<form class="form-horizontal" action="" id="formRM" method="POST">
	<input type="hidden" id="idRM" name="idRM" value="" />

    <div class="form-group">
        <input type="button" class="btn btn-default" value="BUSCAR" onclick="buscar();"/>
        <input type="button" class="btn btn-success" value="REGISTRAR" onclick="registrar();"/>
    </div>
    
    <br>
    <div class="form-group">
		<table class="table table-hover table-bordered" border="1">
        	<thead style="background-color: #bce8f1;">
            	<tr>
                	<th style="text-align: center;">CÓDIGO RECETA</th>
                	<th style="text-align: center;">CÓDIGO ATENCIÓN MÉDICA</th>
                	<th style="text-align: center;">OBSERVACIÓN</th>
                	<th style="text-align: center;">REGISTRADO</th>
                	<th style="text-align: center;" colspan="2">ACCIÓN</th>
                </tr>
            </thead>
            <tbody>
            	<c:forEach var="RM" items="${listaRM}">
	            	<tr>
	            		<td style="text-align: center;">${RM.idReceta}</td>
	            		<td style="text-align: center;">${RM.idAM}</td>
	            		<td style="text-align: center;">${RM.observacion}</td>
	            		<td style="text-align: center;">${RM.registrado}</td>
	            		<td style="text-align: center;">
	            			<a href="javascript:void(0);" onclick="detalle(${RM.idReceta});">Detalle</a>
	            		</td>
	            		<td style="text-align: center;">
	            			<a href="javascript:void(0);" onclick="eliminar(${RM.idReceta});">Eliminar</a>
	            		</td>
	            	</tr>
            	</c:forEach>
            	<c:if test="${empty listaRM}">
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
  <p><span class="ui-icon ui-icon-alert" style="float:left; margin:12px 12px 20px 0;"></span>¿Está seguro de eliminar la Receta Médica con código <span id="spnRM">999</span>?</p>
</div>

</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>