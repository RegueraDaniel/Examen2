<%@page import="org.iesvdm.model.Empleado"%>
<%@page import="java.util.Optional"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalle Usuario</title>
<%@ include file="/WEB-INF/jsp/head.jspf" %>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/nav.jspf" %>
	<main>
<div id="contenedora" style="float:none; margin: 0 auto;width: 900px;" >
	<form action="/web_empleados/empleados/editar/" method="post" >
		<input type="hidden" name="__method__" value="put" />
		<div class="clearfix">
			<div style="float: left; width: 50%">
				<h1>Editar Empleado</h1>
			</div>
			<div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">
				
				<div style="position: absolute; left: 39%; top : 39%;">
							<input type="submit" value="Guardar" />						
				</div>
				
			</div>
		</div>
		
		<div class="clearfix">
			<hr/>
		</div>
		
		<% 	Optional<Empleado> optUser = (Optional<Empleado>)request.getAttribute("empleado");
			if (optUser.isPresent()) {
		%>
		
		<div style="margin-top: 6px;" class="clearfix">
			<div style="float: left;width: 50%">
				<label>Id</label>
			</div>
			<div style="float: none;width: auto;overflow: hidden;">
				<input name="id" value="<%= optUser.get().getId() %>" readonly="readonly"/>
			</div> 
		</div>
		<div style="margin-top: 6px;" class="clearfix">
			<div style="float: left;width: 50%">
				<label>Nif</label>
			</div>
			<div style="float: none;width: auto;overflow: hidden;">
				<input name="nif" value="<%= optUser.get().getNif()%>"/>
			</div> 
		</div>
		<div style="margin-top: 6px;" class="clearfix">
			<div style="float: left;width: 50%">
				<label>Nombre de empleado</label>
			</div>
			<div style="float: none;width: auto;overflow: hidden;">
				<input name="nombre" value="<%= optUser.get().getNombre()%>"/>
			</div> 
		</div>
		<div style="margin-top: 6px;" class="clearfix">
			<div style="float: left;width: 50%">
				<label>Primer Apellido</label>
			</div>
			<div style="float: none;width: auto;overflow: hidden;">
				<input name="apellido1" value="<%= optUser.get().getApellido1()%>"/>
			</div> 
		</div>
		<div style="margin-top: 6px;" class="clearfix">
			<div style="float: left;width: 50%">
				<label>Segundo Apellido </label>
			</div>
			<div style="float: none;width: auto;overflow: hidden;">
				<input name="apellido2" value="<%= optUser.get().getApellido2()%>"/>
			</div> 
		</div>
		<div style="margin-top: 6px;" class="clearfix">
			<div style="float: left;width: 50%">
				<label>Id del departamento </label>
			</div>
			<div style="float: none;width: auto;overflow: hidden;">
				<input name="id_departamento" value="<%= optUser.get().getId_departamento()%>"/>
			</div> 
		</div>
		
		
		
		
		
		<% 	} else { %>
			
				request.sendRedirect("usuarioss/");
		
		<% 	} %>
	</form>
</div>
	</main>
</body>
</html>