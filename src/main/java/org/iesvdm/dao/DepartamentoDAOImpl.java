package org.iesvdm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.iesvdm.model.Departamento;

import org.iesvdm.dto.DepartamentoDTO;
import org.iesvdm.model.Empleado;

public class DepartamentoDAOImpl extends AbstractDAOImpl implements DepartamentoDAO{

	/**
	 * Inserta en base de datos el nuevo departamento, actualizando el id en el bean departamento.
	 */
	@Override	
	public synchronized void create(Departamento departamento) {
		
		Connection conn = null;
		PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet rsGenKeys = null;

        try {
        	conn = connectDB();

        	
        	ps = conn.prepareStatement("INSERT INTO departamento (nombre, presupuesto, gastos) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        	
            int idx = 1;
            ps.setString(idx++, departamento.getNombre());
            ps.setDouble(idx++, departamento.getPresupuesto());
            ps.setDouble(idx++, departamento.getGastos());
            
            int rows = ps.executeUpdate();
            if (rows == 0) 
            	System.out.println("INSERT de departamento con 0 filas insertadas.");
            
            rsGenKeys = ps.getGeneratedKeys();
            if (rsGenKeys.next()) 
            	departamento.setId(rsGenKeys.getInt(1));
                      
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
            closeDb(conn, ps, rs);
        }
        
	}

	/**
	 * Devuelve lista con todos loa fabricantes.
	 */
	@Override
	public List<Departamento> getAll() {
		
		Connection conn = null;
		Statement s = null;
        ResultSet rs = null;
        
        List<Departamento> listDep = new ArrayList<>(); 
        
        try {
        	conn = connectDB();

        	// Se utiliza un objeto Statement dado que no hay parámetros en la consulta.
        	s = conn.createStatement();
            		
        	rs = s.executeQuery("SELECT * FROM departamento");          
            while (rs.next()) {
            	Departamento dep = new Departamento();
            	int idx = 1;
            	dep.setId(rs.getInt(idx++));
            	dep.setNombre(rs.getString(idx++));
            	dep.setPresupuesto(rs.getDouble(idx++));
            	dep.setGastos(rs.getDouble(idx));
            	listDep.add(dep);
            }
          
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
            closeDb(conn, s, rs);
        }
        return listDep;
        
	}
	
	@Override
	public Optional<Integer> getCountEmpleados(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
        ResultSet rs = null;

        try {
        	conn = connectDB();
        	
        	ps = conn.prepareStatement("SELECT COUNT(id_departamento) FROM empleado WHERE id_departamento = ?");
        	
        	int idx = 1;
        	ps.setInt(idx, id);
        	
        	rs = ps.executeQuery();
        	int contador = 0;
        	if (rs.next()) {
        		contador = rs.getInt(idx++);	
        		return Optional.of(contador);
        	}
        	
        } catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
            closeDb(conn, ps, rs);
        }
        
        return Optional.empty();
	}

}
