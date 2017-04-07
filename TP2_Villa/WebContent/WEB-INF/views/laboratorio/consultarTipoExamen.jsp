<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jspf"%>
  <script src="/TP2_Villa/static/js/consultarTipoExamen.js"></script>
<%--content--%>

<div class="container" id="for">
	<div class="page-header">
       <h1>Consultar Tipo de Examen Médico</h1>
    </div>

<form class="form-horizontal">

    <div class="form-group">
        <label class="control-label col-xs-3" >Nombre de examen médico</label>
        <div class="col-xs-3">
            <input name="nombre" id="nombre" type="text" class="form-control" placeholder="">
        </div>
    </div>

        
    
    <div class="form-group">
        <div class="col-xs-offset-3 col-xs-9">
            <input id="btnBuscar" type="button" class="btn btn-primary" value="<spring:message code="uc.first.btn.search"/>">
            <input id="btnSalir" type="button" class="btn btn-primary" value="Salir" > 
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
	                <th>Descripción</th>
	                <th>Días cultivo</th>
	            </tr>
            </thead>
            <tbody id="tbConsultarTipoExamen">
        	</tbody>
     	</table>
     </div>
      
</form>
</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>