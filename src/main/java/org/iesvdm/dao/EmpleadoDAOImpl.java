package org.iesvdm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.iesvdm.model.Empleado;

public class EmpleadoDAOImpl extends AbstractDAOImpl implements EmpleadoDAO{

	/**
	 * Devuelve Optional de empleado con el ID dado.
	 */
	@Override
	public Optional<Empleado> find(int id) {
		
		Connection conn = null;
		PreparedStatement ps = null;
        ResultSet rs = null;

        try {
        	conn = connectDB();
        	
        	ps = conn.prepareStatement("SELECT * FROM empleado WHERE id = ?");
        	
        	int idx =  1;
        	ps.setInt(idx, id);
        	
        	rs = ps.executeQuery();
        	
        	if (rs.next()) {
        		Empleado empl = new Empleado();
        		empl.setId(rs.getInt("id"));

        		empl.setNif("nif");
        		empl.setNombre(rs.getString("nombre"));
        		empl.setApellido1(rs.getString("apellido1"));
    			empl.setApellido2(rs.getString("apellido2"));
    			
    			empl.setId_departamento(rs.getInt("id_departamento"));
        		
        		return Optional.of(empl);
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
	
	/**
	 * Actualiza empleado con campos del bean empleado según ID del mismo.
	 */
	@Override
	public void update(Empleado empleado) {
		
		Connection conn = null;
		PreparedStatement ps = null;
        ResultSet rs = null;

        try {
        	conn = connectDB();
        	
        	/*ps = conn.prepareStatement("UPDATE empleado SET nombre = ?, precio = ?  WHERE codigo = ?");*/
        	ps = conn.prepareStatement("UPDATE empleado SET nif = ?, nombre = ? apellido1 = ? apellido2 = ? id_departamento = ? WHERE id = ?");
        	int idx = 1;
        	ps.setString(idx++, empleado.getNif());
        	ps.setString(idx++, empleado.getNombre());
        	ps.setString(idx++, empleado.getApellido1());
        	ps.setString(idx++, empleado.getApellido2());
        	ps.setInt(idx++, empleado.getId_departamento());
        	
        	ps.setInt(idx, empleado.getId());
        	
        	int rows = ps.executeUpdate();
        	
        	if (rows == 0) 
        		System.out.println("Update de empleado con 0 registros actualizados.");
        	
        } catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
            closeDb(conn, ps, rs);
        }
    
	}

}