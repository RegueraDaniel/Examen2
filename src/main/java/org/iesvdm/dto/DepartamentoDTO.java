package org.iesvdm.dto;

import java.util.Optional;

import org.iesvdm.model.Departamento;

public class DepartamentoDTO extends Departamento{
	
	private Optional<Integer> numeroEmpleados;
	private int enteroEmpleados;

	public Optional<Integer> numeroEmpleados() {
		return numeroEmpleados;
	}

	public void setNumeroEmpleados(Optional<Integer> numeroEmpleados) {
		this.numeroEmpleados = numeroEmpleados;
	}
	
	public int getEnteroEmpleados() {
		return enteroEmpleados;
	}

	public void setEnteroEmpleados(int enteroEmpleados) {
		this.enteroEmpleados = enteroEmpleados;
	}
	
	public DepartamentoDTO(Departamento dep) {
		this.setId(dep.getId());
		this.setNombre(dep.getNombre());
	}
}
