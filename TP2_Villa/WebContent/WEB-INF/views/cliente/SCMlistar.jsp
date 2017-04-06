<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jspf"%>

<%--content--%>

<script type="text/javascript">

// $(function() {
//     $('#dialog-confirm').dialog({
//       autoOpen: false,
//       resizable: false,
//       height: "auto",
//       width: 400,
//       modal: true,
//       buttons: {
//         "Cancelar": function() {
//           $( this ).dialog( "close" );
//         },
//         "Eliminar": function() {
//         	$('#formSCM').attr('action',"/TP2_Villa/SCM/eliminar");
//         	$('#formSCM').submit();
//         }
//       }
//     });
    
//  });

function registrar(){
	$('#formSCM').attr('action',"/TP2_Villa/SCM/cargarRegistrar");
	$('#formSCM').submit();
}

function limpiar(){
	$('#formSCM').attr('action',"/TP2_Villa/SCM/limpiar");
	$('#formSCM').submit();
}

// function detalle(id){
// 	$('#idSCM').val(id);
// 	$('#formSCM').attr('action',"/TP2_Villa/SCM/detalle");
// 	$('#formSCM').submit();
// }

// function eliminar(id){
// 	$('#idSCM').val(id);
// 	$('#spnSCM').text(id);
// 	$('#dialog-confirm').dialog('open');
// }

function buscar(){
	$('#formSCM').attr('action',"/TP2_Villa/SCM/buscar");
	$('#formSCM').submit();
}

function exportar(){
	var lista = "";
	$('input:checked').each(function() {
		lista += $(this).attr('id') + ",";    
	});
	if(lista.length > 1){lista = lista.substring(0,lista.length-1)}
	else{mensajeModal("Seleccione por lo menos 1 registro.");return false;}
	$('#lista').val(lista);
	$('#formSCM').attr('action',"/TP2_Villa/SCM/exportar");
	$('#formSCM').submit();
}
</script>


<div class="container">
	<div class="page-header">
       <h1>Gestionar Seguimiento y Control de Mascotas</h1>
    </div>

	<form class="form-horizontal" action="" id="formSCM" method="POST">
	<input type="hidden" id="idCLI" name="idCLI" value="" />
	<input type="hidden" id="lista" name="lista" value="" />

    	<div class="form-group">
	        <label class="control-label col-xs-1" for="txtFILTRO">Filtros:</label>
		        <div class="col-xs-3">
		            <select id="txtFILTRO" name="txtFILTRO" class="form-control">
			            <option value="1">Atención Médica</option>
			            <option value="2">Servicio de Baño y Peluquería</option>		            
		            </select>
		        </div>
        	<input type="button" class="btn btn-info" value="Buscar" onclick="buscar();"/>
	    </div>

    	<div class="form-group" align="center">
	        <input type="button" class="btn btn-primary" value="Exportar" onclick="exportar();"/>
<!-- 	        <input type="button" class="btn btn-success" value="Enviar Notificaciones" onclick="notificar();"/> -->
	    </div>

    <br>
    <div class="form-group">
		<table class="table table-hover table-bordered" border="1">
        	<thead style="background-color: #bce8f1;">
            	<tr>
                	<th style="text-align: center;"></th>
                	<th style="text-align: center;">Apellidos y Nombres</th>
                	<th style="text-align: center;">Mascota</th>
                	<th style="text-align: center;">Especie</th>
                	<th style="text-align: center;">Fecha Última Atención</th>
<!--                 	<th style="text-align: center;">Código Promoción</th> -->
                </tr>
            </thead>
            <tbody>
            	<c:forEach var="SCM" items="${listaSCM}">
	            	<tr>
	            		<td style="text-align: center;"><input type="checkbox" id="${SCM.idMascota}" /></td>
	            		<td style="text-align: center;">${SCM.datosCliente}</td>
	            		<td style="text-align: center;">${SCM.datosMascota}</td>
	            		<td style="text-align: center;">${SCM.descripcionEspecie}</td>
	            		<td style="text-align: center;">${SCM.fechaUltimaAtencion}</td>
	            	</tr>
            	</c:forEach>
            	<c:if test="${empty listaSCM}">
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