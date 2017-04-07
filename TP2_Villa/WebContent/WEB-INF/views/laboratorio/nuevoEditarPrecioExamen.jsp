<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		
		 $('#precio').numeric('.');
		
		$('#descuento').keyup(function (){
	        this.value = (this.value + '').replace(/[^0-9]/g, '');
	    });
		
		$('#btnRegistrar').click(function(){
			
			var desde = $('#fechaInicial').datepicker("getDate");
			var hasta = $('#fechaFinal').datepicker("getDate");
			
			if(desde!=null && hasta==null) {
				alert("Debe ingresar fecha hasta");
				return;
			}
			
			if(desde==null && hasta!=null) {
				alert("Debe ingresar fecha desde");
				return;
			}
			
			if(desde!=null && hasta!=null && desde>hasta) {
				alert("Fecha desde no puede ser menor a fecha hasta");
				return;
			}
			
			if($("#idMoneda").val() == "0") {
				alert("Debe seleccionar la moneda");
				return;
			}
			
			if($("#precio").val().length == 0) {
				alert("Debe ingresar el precio");
				return;
			}
			
			if(parseInt($("#precio").val()) <= 0) {
				alert("Debe ingresar un precio valido");
				return;
			}
			
			if($("#descuento").val().length != 0) {
				if(parseInt($("#descuento").val()) <= 0 || parseInt($("#descuento").val()) > 100) {
					alert("Debe ingresar un descuento valido");
					return;
				}
			}
			
			var req = {};
			req.idExamenClinico = $('#idExamenClinico').val();
			req.fechaInicial = $.datepicker.formatDate('dd-mm-yy', desde);
			req.fechaFinal = $.datepicker.formatDate('dd-mm-yy', hasta);
			
			$.ajax({
				url: "/TP2_Villa/actualizarPrecioExamen/existenPreciosExamenRango",
				async : false,
				type: "get", 
				data: req, 
				success: function(result){
					if (result) {
						alert("Existen registros dentro de las fechas seleccionadas");
					} else {
						
						req = {};
						req.idExamenClinico = $('#idExamenClinico').val();
						req.fechaInicial = $.datepicker.formatDate('dd-mm-yy', desde);
						req.fechaFinal = $.datepicker.formatDate('dd-mm-yy', hasta);
						req.idMoneda = $('#idMoneda').val();
						req.precio = $('#precio').val();
						req.descuento = $('#descuento').val();
						
						console.log(req);
						
						$.ajax({
							url: "/TP2_Villa/actualizarPrecioExamen/registrarPrecioExamen",
							async : true,
							type: "get", 
							data: req, 
							success: function(result){
								//console.log(data);
							}
						});
						
						alert("Precio de examen médico se grabó correctamente");
						window.location.href = "/TP2_Villa/actualizarPrecioExamen";
						
					}
				}
			});
			
			
			
		});
		
		$('#btnActualizar').click(function(){
			
			var desde = $('#fechaInicial').datepicker("getDate");
			var hasta = $('#fechaFinal').datepicker("getDate");
			
			if($("#idMoneda").val() == "0") {
				alert("Debe seleccionar la moneda");
				return;
			}
			
			if($("#precio").val().length == 0) {
				alert("Debe ingresar el precio");
				return;
			}
			
			if(parseInt($("#precio").val()) <= 0) {
				alert("Debe ingresar un precio valido");
				return;
			}
			
			if($("#descuento").val().length != 0) {
				if(parseInt($("#descuento").val()) <= 0 || parseInt($("#descuento").val()) > 100) {
					alert("Debe ingresar un descuento valido");
					return;
				}
			}
			
			var req = {};
			req.idExamenClinico = $('#idExamenClinico').val();
			req.fechaInicial = $.datepicker.formatDate('dd-mm-yy', desde);
			req.fechaFinal = $.datepicker.formatDate('dd-mm-yy', hasta);
			req.idMoneda = $('#idMoneda').val();
			req.precio = $('#precio').val();
			req.descuento = $('#descuento').val();
			
			console.log(req);
			
			$.ajax({
				url: "/TP2_Villa/actualizarPrecioExamen/actualizarPrecioExamen",
				async : true,
				type: "get", 
				data: req, 
				success: function(result){
					//console.log(data);
				}
			});
			
			alert("Precio de examen médico se modificó correctamente");
			window.location.href = "/TP2_Villa/actualizarPrecioExamen";
			
		});
		
		
		
		$('#btnCancelar').click(function(){
			window.location.href = "/TP2_Villa/actualizarPrecioExamen";
		});
		
	});
</script>

<%--content--%>

<div class="container" id="for">
	<div class="page-header">
       <h1>Precio por examen médico</h1>
    </div>

<form class="form-horizontal">

	<div class="form-group">
	
		<div class="col-xs-6">
			<div class="form-group">
				<label class="control-label col-xs-3" >Código</label>
		        <div class="col-xs-9">
		            <input id="idExamenClinico" type="text" class="form-control" placeholder="" value="${tipoExamen.idExamenClinico}" disabled="disabled">
		        </div>
	        </div>
			<div class="form-group">
				<label class="control-label col-xs-3" >Nombre</label>
		        <div class="col-xs-9">
		            <input id="nombreExamenClinico" type="text" class="form-control" placeholder="" value="${tipoExamen.nombreExamenClinico}" disabled="disabled">
		        </div>
	        </div>
	        <div class="form-group">
	        	<label class="control-label col-xs-3">Descripción</label>
        		<div class="col-xs-9">
            		<textarea id="descripcionExamenClinico" rows="6" class="form-control" placeholder="" disabled="disabled">${tipoExamen.descripcionExamenClinico}</textarea>
        		</div>
	        </div>
		</div>
		<div class="col-xs-6">
		    <div class="form-group">
		        <label class="control-label col-xs-3">Fecha Desde</label>
		        <div class="col-xs-3">
		            <input id="fechaInicial" type="text" class="form-control" value='<fmt:formatDate pattern="dd/MM/yyyy" value="${precioExamen.fechaInicial}" />' <c:if test="${accion=='editar'}">disabled="disabled"</c:if>/>
		        </div>
		        <label class="control-label col-xs-3" >Hasta</label>
		        <div class="col-xs-3">
		        	<c:choose>
		        		<c:when test="${accion=='nuevo'}">
		        			<input id="fechaFinal" type="text" class="form-control" value="31/12/9999" disabled="disabled"/>
		        		</c:when>
		        		<c:otherwise>
		        			<input id="fechaFinal" type="text" class="form-control" value='<fmt:formatDate pattern="dd/MM/yyyy" value="${precioExamen.fechaFinal}" />' disabled="disabled"/>
		        		</c:otherwise>
		        	</c:choose>
		        </div>
		    </div>
		    <div class="form-group">
		        <label class="control-label col-xs-3">Moneda</label>
		        <div class="col-xs-6">
		            <select id="idMoneda" class="form-control">
		            	<option value="0"><spring:message code="uc.first.tb.dwon.choose"/></option>
		            	<c:forEach items="${monedas}" var="mon">
		            		 <c:choose>
		            		 	<c:when test="${accion=='nuevo'}">
		            		 		<option value="${mon.idMoneda}" <c:if test="${mon.idMoneda == 'PEN'}">selected="selected"</c:if>>${mon.nombreMoneda}</option>
		            		 	</c:when>
		            		 	<c:otherwise>
		            		 		<option value="${mon.idMoneda}" <c:if test="${mon.idMoneda == precioExamen.idMoneda}">selected="selected"</c:if>>${mon.nombreMoneda}</option>
		            		 	</c:otherwise>
		            		 </c:choose>
		               	 </c:forEach>	 
		            </select>
		        </div>
		    </div>
		    <div class="form-group">
		    	<label class="control-label col-xs-3">Precio</label>
		    	<div class="col-xs-6">
		            <input id="precio" type="text" class="form-control" value="${precioExamen.precio}"/>
		        </div>
		    </div>
		    <div class="form-group">
		    	<label class="control-label col-xs-3">% Descuento</label>
		    	<div class="col-xs-6">
		            <input id="descuento" type="text" class="form-control" value="${precioExamen.descuento}"/>
		        </div>
		    </div>
		</div>
	
	</div>
	
    <div class="form-group">
        <div class="col-xs-offset-3 col-xs-9">
        	<c:choose>
        		<c:when test="${accion=='nuevo'}">
        			<input id="btnRegistrar" type="button" class="btn btn-primary" value="Grabar">
        		</c:when>
        		<c:otherwise>
        		    <input id="btnActualizar" type="button" class="btn btn-primary" value="Grabar">
        		</c:otherwise>
        		
        	</c:choose>
        	<input id="btnCancelar" type="button"  class="btn btn-primary" value="Cancelar">
        </div>
    </div>
    
</form>
</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>