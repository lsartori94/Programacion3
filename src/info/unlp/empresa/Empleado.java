package info.unlp.empresa;

import modelo.Persona;

public class Empleado extends Persona{
	private long nroLegajo;
	private double sueldo;

	public long getNroLegajo(){
		return this.nroLegajo;
	}

	public void setNroLegajo(long nroLegajo){
		this.nroLegajo = nroLegajo;
	}

	public double getSueldo(){
		return this.sueldo;
	}

	public void setSueldo(double sueldo){
		this.sueldo = sueldo;
	}
}