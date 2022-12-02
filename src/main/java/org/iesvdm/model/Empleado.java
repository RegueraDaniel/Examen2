package org.iesvdm.model;

import java.util.Objects;

public class Empleado {

	private int id;
	private String nif;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private int id_departamento;
	
	
	public Empleado() {
		super();
		// TODO Apéndice de constructor generado automáticamente
	}

	
	public Empleado (String nif, String nombre, String apellido1, String apellido2, int id_departamento) {
		this.nif= nif;
		this.nombre= nombre;
		this.apellido1= apellido1;
		this.apellido2= apellido2;
		this.id_departamento= id_departamento;
	}
	
	public Empleado (int id, String nif, String nombre, String apellido1, String apellido2, int id_departamento) {
		this(nif, nombre, apellido1, apellido2, id_departamento);
		this.id= id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return id == other.id ;
	}

	
	@Override
	public String toString() {
		return "Empleado [Id=" + id + ", nif=" + nif +", nombre=" + nombre + ", apellido1=" + getApellido1() +", apellido2=" + getApellido2() + ", id_departamento=" + getId_departamento() + " ]";
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public int getId_departamento() {
		return id_departamento;
	}

	public void setId_departamento(int id_departamento) {
		this.id_departamento = id_departamento;
	}
}
