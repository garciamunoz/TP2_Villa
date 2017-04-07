<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../common/header.jspf"%>

<script type="text/javascript">
	$(function(){
		var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
		
		$('#fechaSolicitud').datepicker({
			format: 'dd/mm/yyyy',
			container: container,
			todayHighlight: true,
			autoclose: true
		});
		
		$('#nroOrdenMedica').keyup(function (){
	        this.value = (this.value + '').replace(/[^0-9]/g, '');
	    });
		
		$('#codMedico').keyup(function (){
	        this.value = (this.value + '').replace(/[^0-9]/g, '');
	    });
		
		$('#nroOrdenMedica').focusout(function (){
			var req = {};
			req.idAM = $('#nroOrdenMedica').val();
			
			$.ajax({
				url: "${pageContext.request.contextPath}/actualizarSolicitudAnalisis/recuperarAtencionMedica",
				async : true,
				type: "get", 
				data: req, 
				success: function(result){
					if (result=="") {
						$('#cliente').val("");
						$('#nomMascota').val("");
						$('#numeroColegiatura').val("");
					} else {
						$('#cliente').val(result.historiaClinica.cliente.nomCliente + " " + result.historiaClinica.cliente.apePaternoCliente + " " + result.historiaClinica.cliente.apeMaternoCliente);
						$('#nomMascota').val(result.historiaClinica.mascota.nomMascota);
						$('#numeroColegiatura').val(result.atencionMedica.codMedico);
					}
				}
			});
	    });
		
		
		
		$('#btnAgregarEC').click(function(){
			$("#modalExamenesClinicos").modal();
		});
		
		$('#btnBuscarTE').click(function(){
			$.ajax({
				url: "${pageContext.request.contextPath}/actualizarSolicitudAnalisis/consultarTipoExamPrecioExamVig",
				async : true,
				type: "get",
				data: {nombreExamenClinico: $("#nombreTE").val()},
				success: function(result){
					$("#tbConsultarTipoExamen").empty();
					$.each(result, function (index, item) {
						var row = "<tr>" +
			    		"<td><input type=\"checkbox\" idExamenClinico=\"" + item.idExamenClinico + "\"></td>" +
			    		"<td>" + item.idExamenClinico + "</td>" +
			    		"<td>" + item.nombreExamenClinico + "</td>" +
			    		"<td>" + item.descripcionExamenClinico + "</td>" + 
			    		"<td>" + item.diasCultivo + "</td>" + 
			    		"</tr>";
			    
						$("#tbConsultarTipoExamen").append(row); 
					});
				}
			});
		});
		
		$('#btnAgregarTE').click(function(){
	
			$("input:checked", "#tbConsultarTipoExamen").each(function(i, item) {
				$.ajax({
					url: "${pageContext.request.contextPath}/actualizarSolicitudAnalisis/consultarTipoExamPrecioExamVig",
					async : false,
					type: "get",
					data: {idExamenClinico: $(item).attr("idExamenClinico")},
					success: function(result){
						var row = "<tr idExamenClinico='"+ result[0].idExamenClinico +"' precio='"+result[0].precio+"' descuento='"+result[0].descuento+"'>" +
					    		"<td><input type=\"checkbox\" idExamenClinico=\"" + result[0].idExamenClinico + "\"></td>" +
					    		"<td>" + result[0].idExamenClinico + "</td>" +
					    		"<td>" + result[0].nombreExamenClinico + "</td>" + 
					    		"<td><input type=\"checkbox\" name=\"aplicaMuestras\"></td>" + 
					    		"<td>"+ result[0].precio +"</td>" + 
					    		"<td>"+ result[0].descuento +"</td>" + 
					    	"</tr>";
					    
					    if(!$("input:checkbox[idExamenClinico='"+result[0].idExamenClinico+"']", "#tbDetalle").length) {
					    	$("#tbDetalle").append(row); 
					    }	
					}
				});
			});
			
			var subtotal = 0;
			var descuento = 0;
			$("tr", "#tbDetalle").each(function(i, item) {
				var precio = parseFloat($(item).attr("precio"));
				var desc = parseFloat($(item).attr("descuento"));
				
				subtotal = subtotal + precio;
				descuento = descuento + desc;
			});
			
			$("#subtotal").val(subtotal);
			$("#descuento").val(descuento);
			var igv = subtotal*0.18;
			igv = igv.toFixed(2);
			$("#igv").val(igv);
			var total = subtotal-descuento+ parseFloat(igv);
			total = total.toFixed(2);
			$("#total").val(total);
			
			$('#modalExamenesClinicos').modal('toggle');
		});
		
		$('#btnEliminarEC').click(function(){
			if (!$("input:checked", "#tbDetalle").length){
				alert("Debe seleccionar los exámenes a eliminar");
			} else {
				if(confirm("¿Está seguro de eliminar los exámenes seleccionados?")){
					$("input:checked", "#tbDetalle").parent().parent().remove();
					
					var subtotal = 0;
					var descuento = 0;
					$("tr", "#tbDetalle").each(function(i, item) {
						var precio = parseFloat($(item).attr("precio"));
						var desc = parseFloat($(item).attr("descuento"));
						
						subtotal = subtotal + precio;
						descuento = descuento + desc;
					});
					
					$("#subtotal").val(subtotal);
					$("#descuento").val(descuento);
					var igv = subtotal*0.18;
					igv = igv.toFixed(2);
					$("#igv").val(igv);
					var total = subtotal-descuento+ parseFloat(igv);
					total = total.toFixed(2);
					$("#total").val(total);
				}
			}
		});
		
		$('#btnGrabar2').click(function(){
			
			var fechaSolicitud = $('#fechaSolicitud').datepicker("getDate");
			
			if(fechaSolicitud==null) {
				alert("Debe ingresar fecha de solicitud");
				return;
			}
			
			if($("#nroOrdenMedica").val().length == 0) {
				alert("Debe ingresar Nro. De orden médica");
				return;
			}
			
			if($("#numeroColegiatura").val().length == 0) {
				alert("Debe ingresar la colegiatura de veterinario");
				return;
			}
			
			var resultado = "";
			
			$.ajax({
				url: "${pageContext.request.contextPath}/consultarColegiaturas/recuperarColegiado",
				async : false,
				type: "get",
				data: {numeroColegiatura: $("#numeroColegiatura").val()},
				success: function(result){
					resultado = result
					console.dir("0->"+resultado);
				}
			});
			
			console.dir("1->"+resultado);
			
			if (resultado == "") {
				alert("Colegiatura de veterinario no es válida");
				return;
			}
			
			resultado = "";
			
			$.ajax({
				url: "${pageContext.request.contextPath}/actualizarSolicitudAnalisis/recuperarAtencionMedica",
				async : false,
				type: "get", 
				data: {idAM:$('#nroOrdenMedica').val()}, 
				success: function(result){
					resultado = result
					console.dir("2->"+resultado);
				}
			});
			
			if (resultado == "") {
				alert("Nro. Orden médico no es válida");
				return;
			}
			
			console.dir("3->"+resultado);
			
			if ($("tr", "#tbDetalle").length <= 0){
				alert("Debe agregar por lo menos un examen");
				return;
			}
			
			if (confirm("¿Está seguro de crear una solicitud de examen médico?")) {
				
				var req = {};
				req.fechaSolicitudexamen = $.datepicker.formatDate('dd-mm-yy', fechaSolicitud);
				req.nroOrdenMedica = $('#nroOrdenMedica').val();
				req.subtotal = $('#subtotal').val();
				req.totalDscto = $('#descuento').val();
				req.totalIgv = $('#igv').val();
				req.totalPrecio = $('#total').val();
				req.numeroColegiatura = $("#numeroColegiatura").val();
				req.cantExamenes = $("tr", "#tbDetalle").length;
				req.idEstado = $('#idEst').val();
				
				req.detalle = [];
				
				$("tr", "#tbDetalle").each(function(i, item) {
					var ec = $(item).attr("idExamenClinico");
					var pre = parseFloat($(item).attr("precio"));
					var des = parseFloat($(item).attr("descuento"));
					var aplica = $("input[name='aplicaMuestras']", item).is(':checked')?"X":"";
					
					var reqd = {};
					reqd.idExamenClinico = ec;
					reqd.indMuestras = aplica;
					reqd.precio = pre;
					reqd.descuento = des;
					
					req.detalle.push(reqd);
				});
				
				console.dir(req);
				
				$.ajax({
					url: "${pageContext.request.contextPath}/actualizarSolicitudAnalisis/registrarSolicitudExamen",
					async : false,
					type: "post",
					contentType: "application/json; charset=utf-8",
			        dataType: 'json', 
					data: JSON.stringify(req),
					success: function(result){
						resultado = result
						console.dir("4->"+resultado);
					}
				});
				
				alert("Solicitud de examen médico se grabó correctamente");
				window.location.href = "${pageContext.request.contextPath}/actualizarSolicitudAnalisis";
			}
			
		});

		$('#btnActualizar2').click(function(){
			
			if (confirm("¿Está seguro de actualizar la solicitud de examen médico?")) {
				var req = {};
				req.idSolicitudexamen = $('#idSolicitudexamen').val();
				req.idEstado = $('#idEst').val();
				
				$.ajax({
					url: "${pageContext.request.contextPath}/actualizarSolicitudAnalisis/actualizarSolicitudExamen",
					async : false,
					type: "post",
					contentType: "application/json; charset=utf-8",
			        dataType: 'json', 
					data: JSON.stringify(req),
					success: function(result){
						resultado = result
						console.dir("5->"+resultado);
					}
				});
				
				alert("Solicitud de examen médico se grabó correctamente");
				window.location.href = "${pageContext.request.contextPath}/actualizarSolicitudAnalisis";
			}
			
		});
		
		$('#btnCancelar2').click(function(){
			window.location.href = "${pageContext.request.contextPath}/actualizarSolicitudAnalisis";
		});
		
		if ('${accion}' == "modificar") {
			
			$.ajax({
				url: "${pageContext.request.contextPath}/actualizarSolicitudAnalisis/recuperarAtencionMedica",
				async : true,
				type: "get", 
				data: {idAM:$('#nroOrdenMedica').val()}, 
				success: function(result){
					if (result=="") {
						$('#cliente').val("");
						$('#nomMascota').val("");
					} else {
						$('#cliente').val(result.historiaClinica.cliente.nomCliente + " " + result.historiaClinica.cliente.apePaternoCliente + " " + result.historiaClinica.cliente.apeMaternoCliente);
						$('#nomMascota').val(result.historiaClinica.mascota.nomMascota);
					}
				}
			});
			
			$("tr", "#tbDetalle").each(function(i, item) {
				var arr = $(item).children('td');
				$.ajax({
					url: "${pageContext.request.contextPath}/actualizarSolicitudAnalisis/consultarTipoExamPrecioExamVig",
					async : false,
					type: "get",
					data: {idExamenClinico: arr[1].innerText},
					success: function(result){
						arr[2].innerText = result[0].nombreExamenClinico;
					}
				});
			});
			
		}
		
	});
</script>

<%--content--%>

<div class="container" id="for">
	<div class="page-header">
       <h1>
       		<c:choose>
       			<c:when test="${accion == 'nuevo'}">
       			Nueva solicitud de análisis
       			</c:when>
       			<c:otherwise>
       			Modificar solicitud de análisis
       			</c:otherwise>
       		</c:choose>
       	</h1>
    </div>

<form class="form-horizontal">

	<div class="form-group">
		<div class="col-xs-6">
			<div class="form-group">
		        <label class="control-label col-xs-6" >Nro de solicitud</label>
		        <div class="col-xs-4">
		            <input id="idSolicitudexamen" type="text" class="form-control" placeholder="" value="${sec.idSolicitudexamen}" disabled="disabled">
		        </div>
		    </div>
			<div class="form-group">
		        <label class="control-label col-xs-6" >Fecha solicitud</label>
		        <div class="col-xs-5">
		            <input id="fechaSolicitud" type="text" class="form-control" placeholder="" value='<fmt:formatDate pattern="dd/MM/yyyy" value="${sec.fechaSolicitudexamen}" />' <c:if test="${accion == 'modificar'}">disabled="disabled"</c:if>>
		        </div>
		    </div>
		    <div class="form-group">
		        <label class="control-label col-xs-6" >Colegiatura del veterinario</label>
		        <div class="col-xs-4">
		            <input id="numeroColegiatura" type="text" class="form-control" value="${sec.numeroColegiatura}" placeholder="" <c:if test="${accion == 'modificar'}">disabled="disabled"</c:if>>
		        </div>
		    </div>
		    <div class="form-group">
			    <label class="control-label col-xs-6">Estado</label>
		        <div class="col-xs-6">
		            <select id="idEst" class="form-control" <c:if test="${accion == 'nuevo'}">disabled="disabled"</c:if>>
		            	<c:forEach items="${estados}" var="est">
		            		<c:choose>
		            			<c:when test="${accion == 'nuevo'}">
		            				<option value="${est.idEstado}" <c:if test="${est.idEstado == 'PEN'}">selected="selected"</c:if>>${est.nombreEstado}</option>
		            			</c:when>
		            			<c:otherwise>
		            				<option value="${est.idEstado}" <c:if test="${est.idEstado == sec.idEstado}">selected="selected"</c:if>>${est.nombreEstado}</option>
		            			</c:otherwise>
		            		</c:choose>
					   		
					    </c:forEach>
		            </select>
		        </div>
		    </div>
		    
		</div>
		<div class="col-xs-6">
			<div class="form-group">
		        <label class="control-label col-xs-6" >Nro. Orden médico</label>
		        <div class="col-xs-4">
		            <input id="nroOrdenMedica" type="text" class="form-control" placeholder="" value="${sec.nroOrdenMedica}" <c:if test="${accion == 'modificar'}">disabled="disabled"</c:if>>
		        </div>
		    </div>
		    <div class="form-group">
		        <label class="control-label col-xs-6" >Nombres del cliente</label>
		        <div class="col-xs-6">
		            <input id="cliente" type="text" class="form-control" placeholder="" disabled="disabled">
		        </div>
		    </div>
		    <div class="form-group">
		        <label class="control-label col-xs-6" >Mastoca</label>
		        <div class="col-xs-6">
		            <input id="nomMascota" type="text" class="form-control" placeholder="" disabled="disabled">
		        </div>
		    </div>
		</div>
	
	</div>
	<c:if test="${accion == 'nuevo'}">
    <div class="form-group">
        <div class="col-xs-offset-3 col-xs-9">
            <input id="btnAgregarEC" type="button" class="btn btn-primary" value="Agregar examen">
            <input id="btnEliminarEC" type="button" class="btn btn-primary" value="Eliminar examen">
        </div>
    </div>
    </c:if>
 	<div class="table-responsive">
  		<table class="table table-striped table-bordered table-hover">
	        <thead>
	            <tr>
	            	<th></th>
	                <th>Código</th>
	                <th>Examen médico</th>
	                <th>Aplica muestras</th>
	                <th>Precio</th>
	                <th>Descuento</th>
	            </tr>
	        </thead>
	        <tbody id="tbDetalle">
	        	<c:forEach items="${detalle}" var="dsec">
	        		<tr>
	        			<td></td>
	        			<td>${dsec.idExamenClinico}</td>
	        			<td></td>
	        			<td><input type="checkbox" <c:if test="${dsec.indMuestras == 'X'}">checked="checked"</c:if> disabled="disabled"></td>
	        			<td>${dsec.precio}</td>
	        			<td>${dsec.descuento}</td>
	        		</tr>
	        	</c:forEach>
	        </tbody>
	    </table>
	</div>
	
	<div class="form-group">
		<label class="control-label col-xs-offset-8 col-xs-2" >Subtotal</label>
		<div class="col-xs-2">
			<input id="subtotal" type="text" class="form-control" placeholder="" value="${sec.subtotal}" disabled="disabled">
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-xs-offset-8 col-xs-2" >Descuento</label>
		<div class="col-xs-2">
			<input id="descuento" type="text" class="form-control" placeholder="" value="${sec.totalDscto}" disabled="disabled">
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-xs-offset-8 col-xs-2" >IGV</label>
		<div class="col-xs-2">
			<input id="igv" type="text" class="form-control" placeholder="" value="${sec.totalIgv}" disabled="disabled">
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-xs-offset-8 col-xs-2" >Total</label>
		<div class="col-xs-2">
			<input id="total" type="text" class="form-control" placeholder="" value="${sec.totalPrecio}" disabled="disabled">
		</div>
	</div>
	
	<div class="form-group">
        <div class="col-xs-offset-3 col-xs-9">
        	<c:choose>
        		<c:when test="${accion=='nuevo'}">
        			<input id="btnGrabar2" type="button" class="btn btn-primary" value="Grabar">
        		</c:when>
        		<c:otherwise>
        		    <input id="btnActualizar2" type="button" class="btn btn-primary" value="Grabar">
        		</c:otherwise>
        	</c:choose>
            
            <input id="btnCancelar2" type="button" class="btn btn-primary" value="Cancelar">
        </div>
    </div>
</form>

	<!-- Modal -->
	<div id="modalExamenesClinicos" class="modal fade" role="dialog">
	  <div class="modal-dialog">
	
	    <!-- Modal content-->
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	        <h4 class="modal-title">Consultar Tipo de Examen Médico</h4>
	      </div>
	      <div class="modal-body">
	      		<div class="row">
			      	<div class="form-group">
				        <label class="control-label col-xs-3" >Nombre de examen médico</label>
				        <div class="col-xs-6">
				            <input name="nombreTE" id="nombreTE" type="text" class="form-control" placeholder="">
				        </div>
				        <div class="col-xs-3">
				            <input id="btnBuscarTE" type="button" class="btn btn-primary" value="<spring:message code="uc.first.btn.search"/>">
				        </div>
				    </div>
				    <div class="form-group">
				    	<div class="col-xs-12">
						    <div class="table-responsive">
						    	<table class="table table-striped table-bordered table-hover">
						        	<thead>
							            <tr>
							            	<th></th>
							                <th>Código</th>
							                <th>Nombre</th>
							                <th>Descripción</th>
							                <th>Días cultivo</th>
							            </tr>
						            </thead>
						            <tbody id="tbConsultarTipoExamen">
						        	</tbody>
						     	</table>
						    </div>
					    </div>
				    </div>
			    </div>
	      </div>
	      <div class="modal-footer">
	      	<button type="button" class="btn btn-primary" id="btnAgregarTE">Aceptar</button>
	        <button type="button" class="btn btn-default" data-dismiss="modal">Salir</button>
	      </div>
	    </div>
	
	  </div>
	</div>

</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>