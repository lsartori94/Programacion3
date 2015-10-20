package info.unlp.empresa;

import java.util.Comparator;

public class ComparadorSueldo implements Comparator<Empleado> {
	
	public int compare(Empleado e1, Empleado e2){
		if(e1.getSueldo() < e2.getSueldo()){
			return -1;
		}else if(e1.getSueldo() > e2.getSueldo()){
			return 1;
		}
		else
			return 0;
	}
}
