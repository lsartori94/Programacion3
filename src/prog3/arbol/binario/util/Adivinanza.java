package prog3.arbol.binario.util;

import prog3.arbol.binario.ArbolBinario;
import prog3.lista.simple.ListaEnlazadaGenerica;

public class Adivinanza {

	public ListaEnlazadaGenerica <String> secuenciaMasLarga (ArbolBinario<String> abinario){
		ListaEnlazadaGenerica<String> listmp = new ListaEnlazadaGenerica<String>();
		ListaEnlazadaGenerica<String> listf = new ListaEnlazadaGenerica<String>();
		
		this.secMasLarga(abinario, listf, listmp);
		
		return listf;
		
	}
	
	private void secMasLarga(ArbolBinario<String> ab, ListaEnlazadaGenerica<String> lf, ListaEnlazadaGenerica<String> lt){
		lt.agregarFinal(ab.getDatoRaiz());
		
		if(ab.esHoja()){
			if(lt.tamanio()>lf.tamanio())
				copiar(lt, lf);
		}
		else if(!ab.getHijoIzquierdo().esVacio()){
			lt.agregarFinal("SI");
			secMasLarga(ab.getHijoIzquierdo(), lf, lt);
			lt.eliminarEn(lt.tamanio());
		}
		if(!ab.getHijoDerecho().esVacio()){
			lt.agregarFinal("NO");
			secMasLarga(ab.getHijoDerecho(), lf, lt);
			lt.eliminarEn(lt.tamanio());
		}
		
		lt.eliminarEn(lt.tamanio());
	}
	
	private void copiar(ListaEnlazadaGenerica<String> lt, ListaEnlazadaGenerica<String> lf){
		for(int i=1; i<=lf.tamanio(); i++)
			lf.eliminarEn(i);
		for(int i=1; i<=lt.tamanio(); i++)
			lt.eliminarEn(i);
		}
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
