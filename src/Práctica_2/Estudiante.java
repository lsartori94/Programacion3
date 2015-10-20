package Práctica_2;

public class Estudiante {

	private String nombre;
	private String apellido;
	private String legajo;
	private String email;
	private int celular;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getLegajo() {
		return legajo;
	}
	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCelular() {
		return celular;
	}
	public void setCelular(int celular) {
		this.celular = celular;
	}
	
	public String tusDatos(){
		String datos= getApellido() + " " + getNombre() + " " + getLegajo() + " " + getEmail() + " " + getCelular();
		return datos;
	}
}

