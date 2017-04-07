<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jspf"%>

<script type="text/javascript">
	$(function(){
		var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
		
		$('#fechaInicial').datepicker({
			format: 'dd/mm/yyyy',
			container: container,
			todayHighlight: true,
			autoclose: true
		});
		
		$('#fechaFinal').datepicker({
			format: 'dd/mm/yyyy',
			container: container,
			todayHighlight: true,
			autoclose: true
		});
		
		$('#btnBuscar').click(function(){
			
			var fechaInicial = $('#fechaInicial').datepicker("getDate");
			var fechaFinal = $('#fechaFinal').datepicker("getDate");
			
			if(fechaInicial!=null && fechaFinal==null) {
				alert("Debe ingresar fecha hasta");
				return;
			}
			
			if(fechaInicial==null && fechaFinal!=null) {
				alert("Debe ingresar fecha desde");
				return;
			}
			
			if(fechaInicial!=null && fechaFinal!=null && fechaInicial>fechaFinal) {
				alert("Fecha desde no puede ser menor a fecha hasta");
				return;
			}
			
			var req = {};
			if($("#idSolicitudexamen").val().length != 0) {
				req.idSolicitudexamen = $('#idSolicitudexamen').val();
			}
			if($("#idCliente").val().length == 0) {
				req.idCliente = 0;
			} else {
				req.idCliente = $('#idCliente').val();
			}
			if(fechaInicial!=null && fechaFinal!=null) {
				req.fechaInicial = $.datepicker.formatDate('dd-mm-yy', fechaInicial);
				req.fechaFinal = $.datepicker.formatDate('dd-mm-yy', fechaFinal);
			}
			
			console.dir(req);
			
			$.ajax({
				url: "/TP2_Villa/actualizarSolicitudAnalisis/consultarSolicitudesExamenes",
				async : true,
				type: "get", 
				data: req, 
				success: function(result){
					$("#tbDetalle").empty();
					$.each(result, function (index, item) {
						var row = "<tr>" +
			    		"<td><a href='${pageContext.request.contextPath}/actualizarSolicitudAnalisis/modificarSolicitudAnalisis?idSolicitudexamen="+item.idSolicitudexamen+"'>" + item.idSolicitudexamen + "</a></td>" +
			    		"<td>" + item.historiaClinica.cliente.nomCliente + " " + item.historiaClinica.cliente.apePaternoCliente + " " + item.historiaClinica.cliente.apeMaternoCliente + "</td>" +
			    		"<td>" + item.fechaSolicitudexamen + "</td>" + 
			    		"<td>" + item.estado.nombreEstado + "</td>" + 
			    		"</tr>";
			    
						$("#tbDetalle").append(row); 
					});
				}
			});
		});
		
		$('#btnNuevo').click(function(){
			/*if (!$("input:checked", "#tbDetalle").length){
				alert("debe seleccionar un examen médico");
			} else {
				window.location.href = "/TP2_Villa/actualizarPrecioExamen/nuevoPrecioMedico?idExamenClinico="+$("input:checked", "#tbDetalle").attr("idExamenClinico") + 
																						  "&fechaInicial="+$("input:checked", "#tbDetalle").attr("fechaInicial") + 
																						  "&fechaFinal="+$("input:checked", "#tbDetalle").attr("fechaFinal");
			}*/
			
			window.location.href = "${pageContext.request.contextPath}/actualizarSolicitudAnalisis/nuevoSolicitudAnalisis";
		});
		
		$('#btnExit').click(function(){
			window.location.href = "${pageContext.request.contextPath}";
		});
		
		
	});
</script>

<%--content--%>

<div class="container" id="for">
	<div class="page-header">
       <h1>Actualizar solicitud de análisis</h1>
    </div>

<form class="form-horizontal">

    <div class="form-group">
        <label class="control-label col-xs-3" >Nro de solicitud</label>
        <div class="col-xs-3">
            <input id="idSolicitudexamen" type="text" class="form-control" placeholder="">
        </div>
        <label class="control-label col-xs-3">Cliente</label>
        <div class="col-xs-3">
            <input id="idCliente" type="text" class="form-control" placeholder="">
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-xs-3">Fecha Desde</label>
        <div class="col-xs-3">
            <input id="fechaInicial" type="text" class="form-control" />
        </div>
        <label class="control-label col-xs-3" >Hasta</label>
        <div class="col-xs-3">
            <input id="fechaFinal" type="text" class="form-control" />
        </div>
    </div>
    <div class="form-group">
        <div class="col-xs-offset-3 col-xs-9">
            <input id="btnBuscar" type="button" class="btn btn-primary" value="<spring:message code="uc.first.btn.search"/>">
            <input id="btnNuevo" type="button" class="btn btn-primary" value="<spring:message code="uc.first.btn.new"/>">
            <%--input id="btnEditar" type="button" class="btn btn-primary" value="<spring:message code="uc.first.btn.upd"/>"--%>
            <input type="button" id="btnExit" class="btn btn-primary" value="<spring:message code="uc.first.btn.exit"/>">
        </div>
    </div>
    <br>
 	<div class="table-responsive">
  		<table class="table table-striped table-bordered table-hover">
        <thead>
            <tr>
                <th>Nro Solicitud</th>
                <th>Cliente</th>
                <th>Fecha Solicitud</th>
                <th>Estado</th>
            </tr>
        </thead>
        <tbody id="tbDetalle">
        </tbody>
    </table>
	</div>
</form>
</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>