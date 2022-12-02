package org.iesvdm.model;

import java.util.Objects;

public class Departamento {

	private int id;
	private String nombre;
	private double presupuesto;
	private double gastos;

	
	
	public Departamento() {
		super();
		// TODO Apéndice de constructor generado automáticamente
	}

	public Departamento( String nombre, double presupuesto) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
	}
	
	public Departamento( String nombre, double presupuesto, double gastos) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.gastos = gastos;
	}
	
	public Departamento(int id, String nombre, double presupuesto, double gastos) {
		this(  nombre,  presupuesto,  gastos);
		this.id = id;
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

	public double getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}
	
	public double getGastos() {
		return gastos;
	}

	public void setGastos(double gastos) {
		this.gastos = gastos;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return id == other.id ;
	}

	
	@Override
	public String toString() {
		return "Departamento [Id=" + id + ", nombre=" + nombre + ", presupuesto=" + presupuesto + ", gastos=" + gastos + " ]";
	}
}
