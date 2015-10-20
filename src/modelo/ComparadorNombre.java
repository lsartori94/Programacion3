package modelo;

import java.util.Comparator;

public class ComparadorNombre implements Comparator<Persona> {
	
	public int compare(Persona p1, Persona p2){
		if (!(p1.getApellido().equals(p2.getApellido())))
			return p1.getApellido().compareTo(p2.getApellido()); else
			return p1.getNombre().compareTo(p2.getNombre());
		}
}
