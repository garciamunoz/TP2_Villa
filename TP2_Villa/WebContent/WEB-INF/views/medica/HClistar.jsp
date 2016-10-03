<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jspf"%>

<%--content--%>

<script type="text/javascript">

$( function() {
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
        	$('#formHC').attr('action',"/TP2_Villa/HC/eliminar");
        	$('#formHC').submit();
        }
      }
    });
  } );

function registrar(){
	$('#formHC').attr('action',"/TP2_Villa/HC/cargarRegistrar");
	$('#formHC').submit();
}

function limpiar(){
	$('#formHC').attr('action',"/TP2_Villa/HC/limpiar");
	$('#formHC').submit();
}

function detalle(id){
	$('#formHC').attr('action',"/TP2_Villa/HC/detalle");
	$('#formHC').submit();
}

function eliminar(id){
	$('#dialog-confirm').dialog('open');
}

function buscar(){
	$('#formHC').attr('action',"/TP2_Villa/HC/cargarBuscar");
	$('#formHC').submit();
}

</script>


<div class="container">
	<div class="page-header">
       <h1>Gestionar Historia Clínica</h1>
    </div>

	<form class="form-horizontal" action="" id="formHC" method="POST">

    <div class="form-group">
        <input type="button" class="btn btn-default" value="BUSCAR" onclick="buscar();"/>
        <input type="button" class="btn btn-success" value="REGISTRAR" onclick="registrar();"/>
    </div>
    
    <br>
    <div class="form-group">
		<table class="table table-hover table-bordered" border="1">
        	<thead style="background-color: #bce8f1;">
            	<tr>
                	<th style="text-align: center;">CÓDIGO</th>
                	<th style="text-align: center;">CLIENTE</th>
                	<th style="text-align: center;">MASCOTA</th>
                	<th style="text-align: center;">REGISTRADO</th>
                	<th style="text-align: center;">ACTUALIZADO</th>
                	<th style="text-align: center;" colspan="2">ACCIÓN</th>
                </tr>
            </thead>
            <tbody>
            	<tr>
            		<td style="text-align: center;">1</td>
            		<td style="text-align: center;">yo</td>
            		<td style="text-align: center;">pet</td>
            		<td style="text-align: center;">01</td>
            		<td style="text-align: center;">02</td>
            		<td style="text-align: center;">
            			<a href="#" onclick="detalle(1);">Ver Detalle</a>
            		</td>
            		<td style="text-align: center;">
            			<a href="#" onclick="eliminar('YES');">Eliminar</a>
            		</td>
            </tbody>
        </table>
    </div>

    <br>
    <div class="form-group">
        <div class="col-sm-12" align="left">
	        <div class="col-sm-6" align="left">
	        	<input type="button" class="btn btn-info" value="LIMPIAR" onclick="limpiar();"/>
	        </div>
	        <div class="col-sm-6" align="right">
	        	<input type="button" class="btn btn-primary" value="REGRESAR"/>
	        </div>
	    </div>
    </div>
</form>

<div id="dialog-confirm" title="Mensaje" style="display: none;">
  <p><span class="ui-icon ui-icon-alert" style="float:left; margin:12px 12px 20px 0;"></span>¿Está seguro de eliminar la Historia Clínica con código <span id="spnHC">999</span>?</p>
</div>

</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>