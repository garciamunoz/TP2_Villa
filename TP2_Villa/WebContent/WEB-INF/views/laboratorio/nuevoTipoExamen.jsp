<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../common/header.jspf"%>
  <script src="/TP2_Villa/static/js/tipoExamen.js"></script>
<%--content--%>

<div class="container" id="for">
	<div class="page-header">
       <h1><spring:message code="uc.first.title.tipo.examen.title"/></h1>
    </div>

<form class="form-horizontal">

	<div class="form-group">
		<label class="control-label col-xs-3" >Codigo</label>
        <div class="col-xs-3">
            <input name="codigo" id="codigo" type="text" class="form-control" placeholder="Codigo" value="${tipoExamen.idExamenClinico}" disabled="disabled">
        </div>
	</div>

    <div class="form-group">
        <label class="control-label col-xs-3" ><spring:message code="uc.first.title.tipo.examen.lbl.name"/></label>
        <div class="col-xs-3">
            <input name="nombre" id="nombre" type="text" class="form-control" placeholder="<spring:message code="uc.first.title.tipo.examen.lbl.name"/>" value="${tipoExamen.nombreExamenClinico}">
        </div>
        <label class="control-label col-xs-3"><spring:message code="uc.first.title.tipo.examen.lbl.especialidad"/></label>
        <div class="col-xs-3">
            <select id="idEsp" class="form-control">
            	<option value="0"><spring:message code="uc.first.tb.dwon.choose"/></option>
            	<c:forEach items="${listaEspecialidades}" var="esp">
               		 <option value="${esp.idEspecialidad}" <c:if test="${esp.idEspecialidad == tipoExamen.especialidad.idEspecialidad}">selected="selected"</c:if>>${esp.nombreEspecialidad}</option>
               	 </c:forEach>	
            </select>
        </div>
    </div>
    
    <div class="form-group">
    	<div class="col-xs-6">
    		<div class="form-group">
    			<label class="control-label col-xs-6"><spring:message code="uc.first.title.tipo.examen.lbl.descripcion"/></label>
        		<div class="col-xs-6">
            		<textarea id="descripcion" rows="6" class="form-control" placeholder="<spring:message code="uc.first.title.tipo.examen.lbl.descripcion"/>">${tipoExamen.descripcionExamenClinico}</textarea>
        		</div>
    		</div>
    	</div>
    	
    	<div class="col-xs-6">
    		<div class="form-group">
    			<label class="control-label col-xs-6"><spring:message code="uc.first.title.tipo.examen.lbl.normativa"/></label>
        		<div class="col-xs-6">
		            <select id="idNorm" class="form-control">
		            	<option value="0"><spring:message code="uc.first.tb.dwon.choose"/></option>
		            	    <c:forEach items="${listaNormativas}" var="nor">
		               		 <option value="${nor.idNormativa}" <c:if test="${nor.idNormativa == tipoExamen.normativa.idNormativa}">selected="selected"</c:if>>${nor.nombreNormativa}</option>
		               	 </c:forEach>	
		            </select>
		        </div>
    		</div>
    		<div class="form-group">
		        <label class="control-label col-xs-6"><spring:message code="uc.first.title.tipo.examen.lbl.estandar"/></label>
		        <div class="col-xs-6">
		            <select id="idEstandar" class="form-control">
		            	<option value="0"><spring:message code="uc.first.tb.dwon.choose"/></option>
		            	    <c:forEach items="${listaEstandares}" var="estan">
		               		 <option value="${estan.idEstandar}" <c:if test="${estan.idEstandar == tipoExamen.estandar.idEstandar}">selected="selected"</c:if>>${estan.nombreEstandar}</option>
		               	 </c:forEach>	
		            </select>
		        </div>
		    </div>
		    <div class="form-group">
		        <label class="control-label col-xs-6" ><spring:message code="uc.first.title.tipo.examen.lbl.dias.cultivo"/></label>
		        <div class="col-xs-6">
		            <input name="idDiasCultivo" id="idDiasCultivo" type="text" class="form-control" placeholder="<spring:message code="uc.first.title.tipo.examen.lbl.dias.cultivo"/>" value="${tipoExamen.diasCultivo}">
		        </div>
		    </div>
    	</div>
    
    </div>
    
    <div class="form-group">
        <label class="control-label col-xs-3"><spring:message code="uc.first.lbl.est"/></label>
        <div class="col-xs-3">
            <select id="idEst" class="form-control" <c:if test="${accion == 'registrar'}">disabled="disabled"</c:if> >
            	<c:forEach items="${listaEstados}" var="est">
            		<c:choose>
            			<c:when test="${accion == 'registrar'}">
            				<option value="${est.idEstado}" <c:if test="${est.idEstado == 'ACT'}">selected="selected"</c:if>>${est.nombreEstado}</option>
            			</c:when>
            			<c:otherwise>
            				<option value="${est.idEstado}" <c:if test="${est.idEstado == tipoExamen.estado.idEstado}">selected="selected"</c:if>>${est.nombreEstado}</option>
            			</c:otherwise>
            		</c:choose>
			    </c:forEach>
            </select>
        </div>
        <label class="control-label col-xs-3" ><spring:message code="uc.first.title.tipo.examen.lbl.precio"/></label>
        <div class="col-xs-3">
            <select id="idPrecio" class="form-control" disabled="disabled">
            	<c:forEach items="${listaPrecios}" var="pre">
			   		<option value="<fmt:formatDate pattern="dd-MM-yyyy" value="${pre.fechaInicial}" />,<fmt:formatDate pattern="dd-MM-yyyy" value="${pre.fechaFinal}" />" <c:if test="${pre.indVigente == 'V'}">selected="selected"</c:if>>${pre.precio}</option>
			    </c:forEach>
            </select>
        </div>
    </div>   
                  
    <%--a href="#"><spring:message code="uc.first.title.tipo.examen.link.analisis"/></a--%>
   
   <h3>Lista de atributos</h3>
   
   <div class="form-group">
   		<div class="col-xs-9" >
   			<div class="table-responsive">
			   <table class="table table-striped table-bordered table-hover">
			        <thead>
			            <tr>
			            	<th></th>
			                <th><spring:message code="uc.first.title.tipo.examen.table.head.one"/></th>
			                <th><spring:message code="uc.first.title.tipo.examen.table.head.two"/></th>
			            </tr>
			        </thead>
			        <tbody id="tbATRIBUTOSXEXAMENCLINICO">
			        	<c:forEach items="${tipoExamen.atributos}" var="atri">
			        		<tr>
			        			<td><input type="checkbox" idAtributo="${atri.idAtributo}"/></td>
			        			<td>${atri.nombreAtributo}</td>
			        			<td><input type="text" name="obs" value="${atri.observacionesAtributo}"/></td>
			        		</tr>
			        	</c:forEach>
			        </tbody>
			    </table>
		    </div>
   		</div>
   		<div class="col-xs-3">
   		   <div class="form-group">
   		   	<input id="btnAgregarAtributo" type="button" class="btn btn-success col-xs-6" value="Agregar atributo">
   		   </div>
   		   <div class="form-group">
   		   	<input id="btnEliminarAtributo" type="button" class="btn btn-danger col-xs-6" value="Eliminar atributo">
   		   </div>
   		</div>
    </div>

    <br>
    <div class="form-group">
        <div class="col-xs-offset-3 col-xs-9">
            <c:if test="${accion == 'registrar'}">
            	<input id="btnSave" type="button" class="btn btn-primary" value="<spring:message code="uc.first.title.tipo.examen.btn.save"/>">
            </c:if>
            <c:if test="${accion == 'actualizar'}">
            	<input id="btnUpdate" type="button" class="btn btn-primary" value="Grabar">
            </c:if>
            <input id="btnCancel" type="button" class="btn btn-primary" value="<spring:message code="uc.first.title.tipo.examen.btn.cancel"/>">
        </div>
    </div>
</form>

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="padding:35px 50px;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4><span class="modal-title"></span> <spring:message code="modal.search.price.title"/></h4>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
          <form role="form">
            <div class="form-group">
            		<label for="optradio" class="control-label"> <spring:message code="modal.search.price.lbl.type.currency"/></label>
				    <label class="radio-inline">
				      <input type="radio" name="optradio" value="PEN"><spring:message code="type.currency.pen"/>
				    </label>
				    <label class="radio-inline">
				      <input type="radio" name="optradio" value="USD"><spring:message code="type.currency.usd"/>
				    </label>
            </div>
            <div class="form-group">
            	 <label for="date" class="control-label"><spring:message code="modal.search.price.lbl.start.date"/> </label>
            	 <div class="input-group">
		        <div class="input-group-addon">
		         <i class="fa fa-calendar">
		         </i>
		        </div>
		         <input class="form-control" id="date" name="date" placeholder="DD/MM/YYYY" type="text"/>
		       </div>
            </div>
            <div class="form-group">
            	 <label for="date2" class="control-label"><spring:message code="modal.search.price.lbl.end.date"/> </label>
            	 <div class="input-group">
		        <div class="input-group-addon">
		         <i class="fa fa-calendar">
		         </i>
		        </div>
		         <input class="form-control" id="date2" name="date" placeholder="DD/MM/YYYY" type="text"/>
		       </div>
            </div>            
     					     
                    <div class="bootstrap-table">
					<div class="fixed-table-toolbar"></div>
					<div class="fixed-table-container" style="height: 299px; padding-bottom: 37px;">
						<div class="fixed-table-header" style="height: 37px; border-bottom: 1px solid rgb(221, 221, 221); margin-right: 0px;">
							<table class="table table-hover" style="width: 669px;">
								<thead>
									<tr>
										<th class="bs-checkbox " style="width: 20px; ">
											<div class="th-inner ">
												<input name="btSelectAll" type="checkbox">
											</div>
											<div class="fht-cell" style="width: 29px;">
											</div>
										</th>
										<th style="">
											<div class="th-inner "><spring:message code="modal.search.price.grid.type.currency"/></div><div class="fht-cell" style="width: 173px;"></div>
										</th>
										<th style="">
											<div class="th-inner "><spring:message code="modal.search.price.grid.start.date"/></div><div class="fht-cell" style="width: 237px;"></div>
										</th>
										<th style="">
											<div class="th-inner "><spring:message code="modal.search.price.grid.end.date"/></div><div class="fht-cell" style="width: 227px;"></div>
										</th>
										<th style="">
											<div class="th-inner "><spring:message code="modal.search.price.grid.price"/></div><div class="fht-cell" style="width: 227px;"></div>
										</th>
									</tr>
								</thead>
							</table>
						</div>
						<div class="fixed-table-body">
						<div class="fixed-table-loading" style="top: 0px;">Cargando, por favor espere�</div>
						<table id="table-methods-table" data-height="299" class="table table-hover" style="margin-top: -41px;">
							<thead>
									<tr>
										<th class="bs-checkbox " style="width: 20px; ">
											<div class="th-inner ">
												<input name="btSelectAll" type="checkbox">
											</div>
											<div class="fht-cell" style="width: 29px;">
											</div>
										</th>
										<th style="">
											<div class="th-inner "><spring:message code="modal.search.price.grid.type.currency"/></div><div class="fht-cell" style="width: 173px;"></div>
										</th>
										<th style="">
											<div class="th-inner "><spring:message code="modal.search.price.grid.start.date"/></div><div class="fht-cell" style="width: 237px;"></div>
										</th>
										<th style="">
											<div class="th-inner "><spring:message code="modal.search.price.grid.end.date"/></div><div class="fht-cell" style="width: 227px;"></div>
										</th>
										<th style="">
											<div class="th-inner "><spring:message code="modal.search.price.grid.price"/></div><div class="fht-cell" style="width: 227px;"></div>
										</th>
									</tr>
							</thead>
							  <tbody id="tbPrice">
							  </tbody>
						</table>
						</div>
					<div class="fixed-table-pagination"></div>
					</div>
					</div>
					<div class="clearfix"></div>                       
			</form>
        </div>
        <div class="modal-footer">
          <button type="button" id="modBtnSearch" class="btn btn-primary" ><span class="glyphicon glyphicon-remove"></span> <spring:message code="modal.search.price.btn.search"/></button>
           <button type="button" class="btn btn-primary" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> <spring:message code="modal.search.price.btn.cancel"/></button>
             <button type="button" id="btnSelecto" class="btn btn-primary"><span class="glyphicon glyphicon-remove"></span> <spring:message code="modal.search.price.btn.select"/></button>
        </div>
      </div>
      
    </div>
  </div>
  
  
  
	<!-- Modal -->
	<div id="modalAtributos" class="modal fade" role="dialog">
	  <div class="modal-dialog">
	
	    <!-- Modal content-->
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	        <h4 class="modal-title">Lista de atributos</h4>
	      </div>
	      <div class="modal-body">
	        <div class="table-responsive">
			   <table class="table table-striped table-bordered table-hover">
			        <thead>
			            <tr>
			            	<th></th>
			                <th>Código</th>
			                <th>Nombre</th>
			                <th>Descripción</th>
			                <th>Caraterística</th>
			            </tr>
			        </thead>
			        <tbody id="tbAtributosGenerales">
			        	
			        </tbody>
			    </table>
		    </div>
	      </div>
	      <div class="modal-footer">
	      	<button type="button" class="btn btn-primary" id="btnAgregarAtributo2">Aceptar</button>
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	
	  </div>
	</div>
	
	
	

</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>