<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jspf"%>
  <script src="/TP2_Villa/static/js/tipoExamen.js"></script>
<%--content--%>

<div class="container" id="for">
	<div class="page-header">
       <h1><spring:message code="uc.first.title.tipo.examen.title"/></h1>
    </div>

<form class="form-horizontal">

    <div class="form-group">
        <label class="control-label col-xs-3" ><spring:message code="uc.first.title.tipo.examen.lbl.name"/></label>
        <div class="col-xs-9">
            <input name="nombre" id="nombre" type="text" class="form-control" placeholder="<spring:message code="uc.first.title.tipo.examen.lbl.name"/>">
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-xs-3"><spring:message code="uc.first.title.tipo.examen.lbl.descripcion"/></label>
        <div class="col-xs-9">
            <textarea id="descripcion" rows="3" class="form-control" placeholder="<spring:message code="uc.first.title.tipo.examen.lbl.descripcion"/>"></textarea>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-xs-3"><spring:message code="uc.first.title.tipo.examen.lbl.especialidad"/></label>
        <div class="col-xs-9">
            <select id="idEsp" class="form-control">
            	<option value="0"><spring:message code="uc.first.tb.dwon.choose"/></option>
            	<c:forEach items="${listaEspecialidades}" var="esp">
               		 <option value="${esp.idEspecialidad}">${esp.nombreEspecialidad}</option>
               	 </c:forEach>	
            </select>
        </div>
    </div>
     <div class="form-group">
        <label class="control-label col-xs-3"><spring:message code="uc.first.title.tipo.examen.lbl.normativa"/></label>
        <div class="col-xs-9">
            <select id="idNorm" class="form-control">
            	<option value="0"><spring:message code="uc.first.tb.dwon.choose"/></option>
            	    <c:forEach items="${listaNormativas}" var="nor">
               		 <option value="${nor.idNormativa}">${nor.descripcionNormativa}</option>
               	 </c:forEach>	
            </select>
        </div>
    </div>
     <div class="form-group">
        <label class="control-label col-xs-3"><spring:message code="uc.first.title.tipo.examen.lbl.estandar"/></label>
        <div class="col-xs-9">
            <select id="idNorm" class="form-control">
            	<option value="0"><spring:message code="uc.first.tb.dwon.choose"/></option>
            	    <c:forEach items="${listaEstandares}" var="estan">
               		 <option value="${estan.idEstandar}">${estan.nombreEstandar}</option>
               	 </c:forEach>	
            </select>
        </div>
    </div>    
    <div class="form-group">
        <label class="control-label col-xs-3" ><spring:message code="uc.first.title.tipo.examen.lbl.precio"/></label>
        <div class="col-xs-9">
            <input name="idPrecio" id="idPrecio" type="text" disabled="disabled" class="form-control" placeholder="<spring:message code="uc.first.title.tipo.examen.lbl.precio"/>"> <a href="#"><spring:message code="uc.first.title.tipo.examen.link.precio"/></a>.
        </div>
    </div>                 
    <a href="#"><spring:message code="uc.first.title.tipo.examen.link.analisis"/></a>
   <div class="table-responsive">
        		<table class="table table-striped table-bordered table-hover">
              <thead>
                  <tr>
                      <th><spring:message code="uc.first.title.tipo.examen.table.head.one"/></th>
                      <th><spring:message code="uc.first.title.tipo.examen.table.head.two"/></th>
                  </tr>
              </thead>
              <tbody id="tbDetalleOrdenCompra">
              </tbody>
          </table>
      </div>

    <br>
    <div class="form-group">
        <div class="col-xs-offset-3 col-xs-9">
            <input id="btnSave" type="button" class="btn btn-primary" value="<spring:message code="uc.first.title.tipo.examen.btn.save"/>">
            <input id="btnCancel" type="button" class="btn btn-primary" value="<spring:message code="uc.first.title.tipo.examen.btn.cancel"/>">
        </div>
    </div>
</form>
</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>