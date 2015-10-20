package modelo;

public class Persona implements Comparable<Persona> {
	private String nombre;
	private String apellido;
	private int edad;
	
	public String getNombre(){
		return nombre;
	}
	public void setNombre(String nombre){
		this.nombre= nombre;
	}
	public String getApellido(){
		return apellido;
	}
	public void setApellido(String apellido){
		this.apellido= apellido;
	}
	public int getEdad(){
		return edad;
	}
	public void setEdad(int edad){
		this.edad= edad;
	}
	public int compareTo(Persona o){
		if(this.apellido.compareTo(o.getApellido()) < 0){
			return -1;
		}else if(this.apellido.compareTo(o.getNombre()) > 0){
			return 1;
		}else{
			if(this.nombre.compareTo(o.getNombre()) < 0){
				return -1;
			}else if(this.nombre.compareTo(o.getNombre()) > 0){
				return 1;
			}else
				return 0;
		}
	}
}
