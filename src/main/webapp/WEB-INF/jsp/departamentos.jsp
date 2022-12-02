<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.iesvdm.model.Departamento"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Departamentos</title>
	<%@ include file="/WEB-INF/jsp/head.jspf" %>
</head>

<body>
	<%@ include file="/WEB-INF/jsp/nav.jspf" %>
	<main>
	<div id="contenedora" style="float:none; margin: 0 auto;width: 900px;" >
		<div class="clearfix">
			<div style="float: left; width: 50%">
				<h1>Departamentos</h1>
			</div>
			<div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">
				
				<div style="position: absolute; left: 39%; top : 39%;">
					
						<form action="/web_empleados/departamentos/crear">
							<input type="submit" value="Crear">
						</form>
					</div>
					
				
			</div>
		</div>
		
	
		<div class="clearfix">
			<hr/>
		</div>
		
		
		<div class="clearfix">
			<hr/>
		</div>
		<div class="clearfix">
			<div style="float: left;width: 15%">Id</div>
			<div style="float: left;width: 30%">Nombre</div>
			<div style="float: left;width: 15%">Presupuesto</div>
			<div style="float: left;width: 15%">Gastos</div>
			<div style="float: none;width: auto;overflow: hidden;">Acción</div>
		</div>
		<div class="clearfix">
			<hr/>
		</div>
	<% 
        if (request.getAttribute("listaDepartamentos") != null) {
            List<Departamento> listaDepartamento = (List<Departamento>)request.getAttribute("listaDepartamentos");
            
            for (Departamento departamento : listaDepartamento) {
    %>

		<div style="margin-top: 6px;" class="clearfix">
			<div style="float: left;width: 15%"><%= departamento.getId()%></div>
			<div style="float: left;width: 30%"><%= departamento.getNombre()%></div>
			<div style="float: left;width: 15%"><%= departamento.getPresupuesto()%></div>
			<div style="float: left;width: 15%"><%= departamento.getGastos()%></div>
			<div style="float: none;width: auto;overflow: hidden;">
				<form action="/web_empleados/departamentos/<%= departamento.getId()%>" style="display: inline;">
    				<input type="submit" value="Ver Detalle" />
				</form>
					<form action="/web_empleados/departamentos/editar/<%= departamento.getId()%>" style="display: inline;">
	    				<input type="submit" value="Editar" />
					</form>
					<form action="/web_empleados/departamentos/borrar/" method="post" style="display: inline;">
						<input type="hidden" name="__method__" value="delete"/>
						<input type="hidden" name="codigo" value="<%= departamento.getId()%>"/>
	    				<input type="submit" value="Eliminar" />
					</form>
				
			</div>
		</div>

	<% 
            }
        } else { 
    %>
		No hay registros del departamento
	<% } %>
	</div>
	</main>
</body>

</html>