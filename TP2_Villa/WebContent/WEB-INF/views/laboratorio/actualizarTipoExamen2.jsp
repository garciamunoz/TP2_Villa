<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jspf"%>
  <script src="/TP2_Villa/static/js/actualizarTipoExamen.js"></script>
<%--content--%>

<div class="container" id="for">
	<div class="page-header">
       <h1><spring:message code="uc.first.title"/></h1>
    </div>

<form class="form-horizontal">

    <div class="form-group">
        <label class="control-label col-xs-3" ><spring:message code="uc.first.lbl.name"/></label>
        <div class="col-xs-3">
            <input name="nombre" id="nombre" type="text" class="form-control" placeholder="<spring:message code="uc.first.lbl.name"/>">
        </div>
        <label class="control-label col-xs-3"><spring:message code="uc.first.lbl.est"/></label>
        <div class="col-xs-3">
            <select id="idEst" class="form-control">
            	<option value="0"><spring:message code="uc.first.tb.dwon.choose"/></option>
            	<c:forEach items="${listaEstados}" var="est">
			   		<option value="${est.idEstado}">${est.nombreEstado}</option>
			    </c:forEach>
            </select>
        </div>
    </div>

    <div class="form-group">
		<label class="control-label col-xs-3"><spring:message code="uc.first.lbl.desc"/></label>
        <div class="col-xs-3">
            <input id="descripcion" type="text" class="form-control" placeholder="<spring:message code="uc.first.lbl.desc"/>">
        </div>
        <label class="control-label col-xs-3"><spring:message code="uc.first.lbl.esp"/></label>
        <div class="col-xs-3">
            <select id="idEsp" class="form-control">
            	<option value="0"><spring:message code="uc.first.tb.dwon.choose"/></option>
            	<c:forEach items="${listaEspecialidades}" var="esp">
               		 <option value="${esp.idEspecialidad}">${esp.nombreEspecialidad}</option>
               	 </c:forEach>	 
            </select>
        </div>
    </div>          
    
    <div class="form-group">
        <div class="col-xs-offset-3 col-xs-9">
            <input id="btnBuscar" type="button" class="btn btn-primary" value="<spring:message code="uc.first.btn.search"/>">
            <input id="btnNuevo" type="button" class="btn btn-primary" value="<spring:message code="uc.first.btn.new"/>">
            <input type="button" id="btnExit" class="btn btn-primary" value="<spring:message code="uc.first.btn.exit"/>">
        </div>
    </div>
    
    <br>
    
    <div class="table-responsive">
    	<table class="table table-striped table-bordered table-hover">
        	<thead>
	            <tr>
	                <th><spring:message code="uc.first.tb.header.code"/></th>
	                <th><spring:message code="uc.first.tb.header.nombre"/></th>
	                <th><spring:message code="uc.first.tb.header.descripcion"/></th>
	                <th><spring:message code="uc.first.tb.header.especialidad"/></th>
	                <th>Estado</th>
	            </tr>
            </thead>
            <tbody id="tbDetalleOrdenCompra">
        	</tbody>
     	</table>
     </div>
      
</form>
</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>