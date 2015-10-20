package prog3.util;
import prog3.lista.simple.ListaEnlazadaGenerica;

public class PilaGenerica<T> {
	ListaEnlazadaGenerica<T> datos= new ListaEnlazadaGenerica<T>();
	
	public void apilar(T elem){
		datos.agregarFinal(elem);
	}
	
	public T desapilar(){
		T elem = datos.elemento(datos.tamanio());
		datos.eliminarEn(datos.tamanio());
		return elem;
	}
	
	public T tope(){
		return datos.elemento(datos.tamanio());
	}
	
	public boolean esVacia(){
		return datos.tamanio()==0;
	}
}
