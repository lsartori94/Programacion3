package prog3.util;

import prog3.lista.simple.ListaDeEnteros;
import prog3.lista.simple.ListaDeEnterosEnlazada;

public class PilaDeEnteros {

	private ListaDeEnteros datos;
	
	public PilaDeEnteros() {
		datos= new ListaDeEnterosEnlazada();
	}
	public void apilar(int dato){
		datos.agregarEn(dato, 1);
	}
	public int desapilar(){
		int x= datos.elemento(1);
		
		return x;
	}
	public int tope(){
		return datos.elemento(1);
	}
	public boolean esVacia(){
		return datos.tamanio()==0;
	}	

}
