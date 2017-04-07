<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../common/header.jspf"%>

<script type="text/javascript">
	$(function(){
		
		$('#btnBuscar').click(function(){
			
			var req = {};
			req.numeroColegiatura = $('#numeroColegiatura').val();
			req.nombre = $('#nombre').val();
			req.apellidoPaterno = $('#apellidoPaterno').val();
			req.apellidoMaterno = $('#apellidoMaterno').val();
			
			$.ajax({
				url: "/TP2_Villa/consultarColegiaturas/consultarColegiados",
				async : false,
				type: "get", 
				data: req, 
				success: function(result){
					$("#tbConsulta").empty();
					$.each(result, function (index, item) {
						var row = "<tr>" +
			    		"<td>" + item.numeroColegiatura + "</td>" +
			    		"<td>" + item.nombre + "</td>" +
			    		"<td>" + item.apellidoPaterno + "</td>" + 
			    		"<td>" + item.apellidoMaterno + "</td>" + 
			    		"<td>" + item.fechaColegiatura + "</td>" + 
			    		"<td>" + item.estado.nombreEstado + "</td>" + 
			    		"</tr>";
			    
						$("#tbConsulta").append(row); 
					});
				}
			});
			
		});
		
		$('#btnSalir').click(function(){
			window.location.href = "/TP2_Villa";
		});
		
	});
</script>

<%--content--%>

<div class="container" id="for">
	<div class="page-header">
       <h1>Consultar colegiaturas de veterinarios</h1>
    </div>

<form class="form-horizontal">

	<div class="form-group">
		<label class="control-label col-xs-3" >Colegiatura</label>
       <div class="col-xs-9">
           <input id="numeroColegiatura" type="text" class="form-control" placeholder="" >
       </div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-xs-3" >Nombres</label>
       <div class="col-xs-9">
           <input id="nombre" type="text" class="form-control" placeholder="" >
       </div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-xs-3" >Apellido Paterno</label>
       <div class="col-xs-9">
           <input id="apellidoPaterno" type="text" class="form-control" placeholder="" >
       </div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-xs-3" >Apellido Materno</label>
       <div class="col-xs-9">
           <input id="apellidoMaterno" type="text" class="form-control" placeholder="" >
       </div>
	</div>
	
	<div class="form-group">
        <div class="col-xs-offset-3 col-xs-9">
            <input id="btnBuscar" type="button" class="btn btn-primary" value="Buscar">
            <input id="btnSalir" type="button" class="btn btn-primary" value="salir">
        </div>
    </div>
    
    <br>
    
    <div class="table-responsive">
    	<table class="table table-striped table-bordered table-hover">
        	<thead>
	            <tr>
	                <th>Colegiatura</th>
	                <th>Nombres</th>
	                <th>Apellido Paterno</th>
	                <th>Apellido Materno</th>
	                <th>Fecha vigencia</th>
	                <th>Estado</th>
	            </tr>
            </thead>
            <tbody id="tbConsulta">
        	</tbody>
     	</table>
     </div>
    
</form>
</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>