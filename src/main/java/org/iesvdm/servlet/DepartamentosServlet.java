package org.iesvdm.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.iesvdm.dao.DepartamentoDAO;
import org.iesvdm.dao.DepartamentoDAOImpl;
import org.iesvdm.model.Departamento;

public class DepartamentosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	/**
	 * HTTP Method: GET
	 * Paths: 
	 * 		/departamentos/
	 * 		/departamentos?filtrar-por-nombre=hua 
	 * 		/departamentos/{id}
	 * 		/departamentos/edit/{id}
	 * 		/departamentos/create
	 */		
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher;
				
		String pathInfo = request.getPathInfo(); //
		
		String riques = request.getQueryString();
		String buscarNombre = request.getParameter("filtrar-por-nombre");
		//String 
		if (pathInfo == null || "/".equals(pathInfo)){
			
			DepartamentoDAO depDao = new DepartamentoDAOImpl();
			
			/*if(buscarNombre != null) {
				
				request.setAttribute("listaDepartamentos", depDao.buscarPorNombre(buscarNombre));		
				dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/departamentos.jsp");
		
			}else  {*/
				//GET 
				//	/departamentos/
				//	/departamentos
				
				request.setAttribute("listaDepartamentos", depDao.getAll());		
				dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/departamentos.jsp");
			/*}   	*/	       
		} else {
			// GET
			// 		/fabricantes/{id}
			// 		/fabricantes/{id}/
			// 		/fabricantes/edit/{id}
			// 		/fabricantes/edit/{id}/
			// 		/fabricantes/create
			// 		/fabricantes/create/
			
			pathInfo = pathInfo.replaceAll("/$", "");
			String[] pathParts = pathInfo.split("/");
			
			if (pathParts.length == 2 && "crear".equals(pathParts[1])) {
				
				// GET
				// /fabricantes/create					
				DepartamentoDAO depDAO = new DepartamentoDAOImpl();
				dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/crear-departamento.jsp");
        												
			
				
				
			} else {
				
				System.out.println("Opción POST no soportada.");
				dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/departamentos.jsp");
			
			}
			
		}
		
		dispatcher.forward(request, response);
			 
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher;
		String __method__ = request.getParameter("__method__");
		
		if (__method__ == null) {
			// Crear uno nuevo
			DepartamentoDAO depDao = new DepartamentoDAOImpl();
			
			String nombre = request.getParameter("nombre");
			String presupuesto = request.getParameter("presupuesto");
			String gastos = request.getParameter("gastos");

			
			Departamento nuevoDep = new Departamento();
			
			nuevoDep.setNombre(nombre);
			nuevoDep.setPresupuesto(Double.parseDouble(presupuesto));
			nuevoDep.setGastos(Double.parseDouble(gastos));
			
			depDao.create(nuevoDep);			
			
		} else if (__method__ != null && "put".equalsIgnoreCase(__method__)) {			
			// Actualizar uno existente
			//Dado que los forms de html sólo soportan method GET y POST utilizo parámetro oculto para indicar la operación de actulización PUT.
			doPut(request, response);
			
		
		} else if (__method__ != null && "delete".equalsIgnoreCase(__method__)) {			
			// Actualizar uno existente
			//Dado que los forms de html sólo soportan method GET y POST utilizo parámetro oculto para indicar la operación de actulización DELETE.
			doDelete(request, response);
			
			
			
		} else {
			
			System.out.println("Opción POST no soportada.");
			
		}
		
		response.sendRedirect("/web_empleados/departamentos");
		
		
	}
	
	
	
	
	
}
