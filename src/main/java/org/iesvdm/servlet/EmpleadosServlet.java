package org.iesvdm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iesvdm.dao.EmpleadoDAO;
import org.iesvdm.dao.EmpleadoDAOImpl;
import org.iesvdm.model.Empleado;

public class EmpleadosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	/**
	 * HTTP Method: GET
	 * Paths: 
	 * 		/usuarios/
	 * 		/usuarios?filtrar-por-nombre=hua 
	 * 		/usuarios/{id}
	 * 		/usuarios/edit/{id}
	 * 		/usuarios/create
	 */		
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher;
				
		String pathInfo = request.getPathInfo(); //
		
		String riques = request.getQueryString();
		
		
			pathInfo = pathInfo.replaceAll("/$", "");
			String[] pathParts = pathInfo.split("/");
			
			 if (pathParts.length == 3 && "editar".equals(pathParts[1]) ) {
				EmpleadoDAO userDAO = new EmpleadoDAOImpl();
				
				// GET
				// /usuarios/edit/{id}
				try {
					request.setAttribute("usuario",userDAO.find(Integer.parseInt(pathParts[1])));
					dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/editar-empleado.jsp");
					        								
				} catch (NumberFormatException nfe) {
					nfe.printStackTrace();
					dispatcher = request.getRequestDispatcher("index.jsp");
				}
				
				
			} else {
				
				System.out.println("Opción POST no soportada.");
				dispatcher = request.getRequestDispatcher("index.jsp");
			
			}
			
		
		
		dispatcher.forward(request, response);
			 
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher;
		String __method__ = request.getParameter("__method__");
		
		if (__method__ == null) {
			
			String pathInfo = request.getPathInfo();
			pathInfo = pathInfo.replaceAll("/$", "");
			String[] pathParts = pathInfo.split("/");
			
			 
			 if ( "put".equalsIgnoreCase(__method__)) {			
			// Actualizar uno existente
			//Dado que los forms de html sólo soportan method GET y POST utilizo parámetro oculto para indicar la operación de actulización PUT.
			doPut(request, response);
			
	
			 } else {
			
				 System.out.println("Opción POST no soportada.");
			
			 }
		}else {
					
				 System.out.println("Opción POST no soportada.");
			
		 }
		response.sendRedirect("/web_empleados/");
		
		
	}
	
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		EmpleadoDAO userDAO = new EmpleadoDAOImpl();
		
		String idUsuario = request.getParameter("id");
		String nif = request.getParameter("nif");
		String nombre = request.getParameter("nombre");
		String apellido1 = request.getParameter("apellido1");
		String apellido2 = request.getParameter("apellido2");
		String id_departamento = request.getParameter("id_departamento");

		Empleado epl = new Empleado();
		
		try {
			
			int id = Integer.parseInt(idUsuario);
			epl.setId(id);
			
			epl.setNif(nif);
			epl.setNombre(nombre);
			epl.setApellido1(apellido1);
			epl.setApellido2(apellido2);
			
			epl.setId_departamento(Integer.parseInt(id_departamento));
			
			userDAO.update(epl);
			
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		
	}
	
	
}
