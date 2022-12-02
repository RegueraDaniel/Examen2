package org.iesvdm.dao;

import java.util.Optional;

import org.iesvdm.model.Empleado;

public interface EmpleadoDAO {
		
	public Optional<Empleado>  find(int id);
	
	public void update(Empleado empleado);
	
	
}
