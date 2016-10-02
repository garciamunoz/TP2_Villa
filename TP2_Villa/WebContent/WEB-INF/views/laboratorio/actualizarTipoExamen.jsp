<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jspf"%>
<%--content--%>

<div class="container">
	<div class="page-header">
       <h1>Actualizar tipo de examen medico
    </div>

<form class="form-horizontal">

    <div class="form-group">
        <label class="control-label col-xs-3">Nombre:</label>
        <div class="col-xs-9">
            <input type="text" class="form-control" placeholder="Nombre">
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-xs-3">Descripcion:</label>
        <div class="col-xs-9">
            <input type="text" class="form-control" placeholder="Descripcion">
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-xs-3">Estado:</label>
        <div class="col-xs-9">
            <select class="form-control">
            	<c:forEach items="${listaEstados}" var="est">
			   		<option value="${est.idEstado}">${est.nombreEstado}</option>
			    </c:forEach>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-xs-3">Especialidad:</label>
        <div class="col-xs-9">
            <select class="form-control">
            	<c:forEach items="${listaEspecialidades}" var="esp">
               		 <option value="${esp.idEspecialidad}">${esp.nombreEspecialidad}</option>
               	 </c:forEach>	 
            </select>
        </div>
    </div>          

    <br>
    <div class="form-group">
        <div class="col-xs-offset-3 col-xs-9">
            <input type="submit" class="btn btn-primary" value="Buscar">
            <input type="submit" class="btn btn-primary" value="Nuevo">
            <input type="reset" class="btn btn-primary" value="Modificar">
            <input type="submit" class="btn btn-primary" value="Salir">
        </div>
    </div>
</form>
</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>