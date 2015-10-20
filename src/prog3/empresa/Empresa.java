package prog3.empresa;

import prog3.arbol.general.ArbolGeneral;
import prog3.lista.*;
import prog3.util.ColaGenerica;

public class Empresa {
	
	private ArbolGeneral<Empleado> empleados;

	public ListaEnlazadaGenerica<Integer> empleadosPorCategoria(){
		ListaEnlazadaGenerica<Integer> lcat= new ListaEnlazadaGenerica<Integer>();
		ColaGenerica<ArbolGeneral<Empleado>> cola= new ColaGenerica<ArbolGeneral<Empleado>>();
		lcat.agregarInicio(1); 
		int suma=0;
		
	    cola.encolar(this.empleados);
	    cola.encolar(null);
	    while(!cola.esVacia()){
	    	ArbolGeneral<Empleado> ab=cola.desencolar();
	    	if(ab==null){
	    		cola.encolar(null);
	    		lcat.agregarFinal(suma);
	   		 	suma=0;
	    	}
	   	 	else{
	   	 		ListaGenerica<ArbolGeneral<Empleado>> hijos= this.empleados.getHijos();
	   	 		hijos.comenzar();
	   	 		while(!hijos.fin()){
	   	 			cola.encolar(hijos.proximo());
	   	 			suma++;
	   	 		}
	   	 	}
	    }
	    
	    return lcat;
	}

	public int categoriaConMasEmpleados(){
		ListaEnlazadaGenerica<Integer> lis= this.empleadosPorCategoria();
		int catmax=0;
		int empmax=0;
		for(int i=1; i<=3; i++){
			if(lis.elemento(i)>empmax){
				catmax=i+1;
				empmax=lis.elemento(i);
			}
		}
		
		return catmax;
	}
	
	public int cantidadTotalDeEmpleados(){
		ListaEnlazadaGenerica<Integer> lis= this.empleadosPorCategoria();
		int empmax=0;
		for(int i=1; i<=3; i++){
			empmax= empmax+lis.elemento(i);
		}
		
		return empmax;
	}
	
	public void reemplazarPresidente(){
		ListaGenerica<ArbolGeneral<Empleado>> lemp= this.empleados.getHijos();
	//	ListaGenerica<ArbolGeneral<Empleado>> emp= new ListaEnlazadaGenerica<ArbolGeneral<Empleado>>();
		lemp.comenzar();
		ArbolGeneral<Empleado> amax= maxAnt(lemp);
		
		if(amax.getHijos()!=null){
			
		}
		
			
		}
	
	private ArbolGeneral<Empleado> maxAnt(ListaGenerica<ArbolGeneral<Empleado>> lemp){
		int indice= 0;
		int amax= 0;
		ArbolGeneral<Empleado> maxemp;
		while(!lemp.esVacia()){
			if(amax > lemp.elemento(indice).getDatoRaiz().getAntiguedad()){
				amax= lemp.elemento(indice).getDatoRaiz().getAntiguedad();
				maxemp= lemp.elemento(indice);
			};
			indice++;
		}
		return maxemp;
	}
}
