<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jspf"%>

<%--content--%>

<div class="container">
	<div class="page-header">
       <h1><spring:message code="uc.first.title"/></h1>
    </div>

<form class="form-horizontal">

    <div class="form-group">
        <label class="control-label col-xs-3" ><spring:message code="uc.first.lbl.name"/></label>
        <div class="col-xs-9">
            <input type="text" class="form-control" placeholder="<spring:message code="uc.first.lbl.name"/>">
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-xs-3"><spring:message code="uc.first.lbl.desc"/></label>
        <div class="col-xs-9">
            <input type="text" class="form-control" placeholder="<spring:message code="uc.first.lbl.desc"/>">
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-xs-3"><spring:message code="uc.first.lbl.est"/></label>
        <div class="col-xs-9">
            <select class="form-control">
            	<c:forEach items="${listaEstados}" var="est">
			   		<option value="${est.idEstado}">${est.nombreEstado}</option>
			    </c:forEach>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-xs-3"><spring:message code="uc.first.lbl.esp"/></label>
        <div class="col-xs-9">
            <select class="form-control">
            	<c:forEach items="${listaEspecialidades}" var="esp">
               		 <option value="${esp.idEspecialidad}">${esp.nombreEspecialidad}</option>
               	 </c:forEach>	 
            </select>
        </div>
    </div>          
    
   <div class="table-responsive">
        		<table class="table table-striped table-bordered table-hover">
              <thead>
                  <tr>
                      <th><spring:message code="uc.first.tb.header.code"/></th>
                      <th><spring:message code="uc.first.tb.header.nombre"/></th>
                      <th><spring:message code="uc.first.tb.header.descripcion"/></th>
                      <th><spring:message code="uc.first.tb.header.especialidad"/></th>
                  </tr>
              </thead>
              <tbody id="tbDetalleOrdenCompra">
              <tr class="odd gradeX"><td>coca-cola</td><td>und</td><td>50</td><td>11</td></tr>
              </tbody>
          </table>
      </div>

    <br>
    <div class="form-group">
        <div class="col-xs-offset-3 col-xs-9">
            <input type="submit" class="btn btn-primary" value="<spring:message code="uc.first.btn.search"/>">
            <input type="submit" class="btn btn-primary" value="<spring:message code="uc.first.btn.new"/>">
            <input type="reset" class="btn btn-primary" value="<spring:message code="uc.first.btn.upd"/>">
            <input type="submit" class="btn btn-primary" value="<spring:message code="uc.first.btn.exit"/>">
        </div>
    </div>
</form>
</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>