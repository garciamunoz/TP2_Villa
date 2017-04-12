<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jspf"%>

<script type="text/javascript">
	$(function(){
		var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
		
		$('#desde').datepicker({
			format: 'dd/mm/yyyy',
			container: container,
			todayHighlight: true,
			autoclose: true
		});
		
		$('#hasta').datepicker({
			format: 'dd/mm/yyyy',
			container: container,
			todayHighlight: true,
			autoclose: true
		});
		
		$('#btnBuscar').click(function(){
			
			var desde = $('#desde').datepicker("getDate");
			var hasta = $('#hasta').datepicker("getDate");
			
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
			
			var req = {};
			req.nombreExamenClinico = $('#nombre').val();
			if ($('#moneda').val()!="0") {
				req.idMoneda = $('#moneda').val()
			}
			if(desde!=null && hasta!=null) {
				req.fechaInicial = $.datepicker.formatDate('dd-mm-yy', desde);
				req.fechaFinal = $.datepicker.formatDate('dd-mm-yy', hasta);
			}
			
			$.ajax({
				url: "/TP2_Villa/actualizarPrecioExamen/consultarPreciosExamenes",
				async : true,
				type: "get", 
				data: req, 
				success: function(result){
					$("#tbDetalle").empty();
					$.each(result, function (index, item) {
						$.each(item.precios, function (index2, item2) {
							
							var fi = item2.fechaInicial;
							var arrFi = fi.split("/");
							var dFi = new Date(arrFi[2], arrFi[1] - 1, arrFi[0]);
							
							var ff = item2.fechaFinal;
							var arrFf = ff.split("/");
							var dFf = new Date(arrFf[2], arrFf[1] - 1, arrFf[0]);
							
							var row = "<tr>" +
							"<td><input type=\"radio\" name=\"examen\" "+
								  "idExamenClinico=\"" + item.idExamenClinico + "\"" + 
								  "fechaInicial=\"" +  $.datepicker.formatDate('dd-mm-yy', dFi) + "\"" + 
								  "fechaFinal=\"" + $.datepicker.formatDate('dd-mm-yy', dFf) + "\"></td>" + 
				    		"<td>" + item.idExamenClinico + "</td>" +
				    		"<td>" + item.nombreExamenClinico + "</td>" + 
				    		"<td>" + item2.fechaInicial + "</td>" + 
				    		"<td>" + item2.fechaFinal + "</td>" + 
				    		"<td>" + item2.precio + "</td>" +
				    		"<td>" + item2.idMoneda + "</td>" +
				    		"</tr>";
				    		$("#tbDetalle").append(row);
						});
					});
				}
			});
			
		});
		
		$('#btnNuevo').click(function(){
			if (!$("input:checked", "#tbDetalle").length){
				alert("debe seleccionar un examen médico");
			} else {
				window.location.href = "/TP2_Villa/actualizarPrecioExamen/nuevoPrecioMedico?idExamenClinico="+$("input:checked", "#tbDetalle").attr("idExamenClinico") + 
																						  "&fechaInicial="+$("input:checked", "#tbDetalle").attr("fechaInicial") + 
																						  "&fechaFinal="+$("input:checked", "#tbDetalle").attr("fechaFinal");
			}
		});
		
		$('#btnEditar').click(function(){
			if (!$("input:checked", "#tbDetalle").length){
				alert("debe seleccionar un examen médico");
			} else {
				window.location.href = "/TP2_Villa/actualizarPrecioExamen/editarPrecioMedico?idExamenClinico="+$("input:checked", "#tbDetalle").attr("idExamenClinico") + 
																						  "&fechaInicial="+$("input:checked", "#tbDetalle").attr("fechaInicial") + 
																						  "&fechaFinal="+$("input:checked", "#tbDetalle").attr("fechaFinal");
			}
		});
		
	});
</script>

<%--content--%>

<div class="container" id="for">
	<div class="page-header">
       <h1>Actualizar precios de examen médico</h1>
    </div>

<form class="form-horizontal">

    <div class="form-group">
        <label class="control-label col-xs-3" >Nombre</label>
        <div class="col-xs-3">
            <input id="nombre" type="text" class="form-control" placeholder="<spring:message code="uc.first.lbl.name"/>">
        </div>
        <label class="control-label col-xs-3">Moneda</label>
        <div class="col-xs-3">
            <select id="moneda" class="form-control">
            	<option value="0"><spring:message code="uc.first.tb.dwon.choose"/></option>
            	<c:forEach items="${monedas}" var="mon">
               		 <option value="${mon.idMoneda}">${mon.nombreMoneda}</option>
               	 </c:forEach>	 
            </select>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-xs-3">Fecha Desde</label>
        <div class="col-xs-3">
            <input id="desde" type="text" class="form-control" />
        </div>
        <label class="control-label col-xs-3" >Hasta</label>
        <div class="col-xs-3">
            <input id="hasta" type="text" class="form-control" />
        </div>
    </div>
    <div class="form-group">
        <div class="col-xs-offset-3 col-xs-9">
            <input id="btnBuscar" type="button" class="btn btn-primary" value="<spring:message code="uc.first.btn.search"/>">
            <input id="btnNuevo" type="button" class="btn btn-primary" value="<spring:message code="uc.first.btn.new"/>">
            <input id="btnEditar" type="button" class="btn btn-primary" value="<spring:message code="uc.first.btn.upd"/>">
            <input type="button" id="btnExit" class="btn btn-primary" value="<spring:message code="uc.first.btn.exit"/>">
        </div>
    </div>
    <br>
 	<div class="table-responsive">
  		<table class="table table-striped table-bordered table-hover">
        <thead>
            <tr>
            	<th></th>
                <th>Código</th>
                <th>Nombre</th>
                <th>Fecha desde</th>
                <th>Fecha hasta</th>
                <th>Precio</th>
                <th>Moneda</th>
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