package prog3.arbol.binariobusqueda;

import prog3.lista.simple.ListaEnlazadaGenerica;

public class ABBUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArbolBinarioDeBusqueda<Integer> abb= new ArbolBinarioDeBusqueda<Integer>();
		ListaEnlazadaGenerica<ListaEnlazadaGenerica<Integer>> lis= new ListaEnlazadaGenerica<ListaEnlazadaGenerica<Integer>>();
		
		abb.agregar(7);
		abb.agregar(3);
		abb.agregar(8);
		abb.agregar(-1);
		abb.agregar(5);
		abb.agregar(12);
		lis= sumaCaminos(abb, 15);
		lis.comenzar();
		while(!lis.fin())
			System.out.println(lis.proximo().toString());
	};

	
	public static ListaEnlazadaGenerica<ListaEnlazadaGenerica<Integer>> sumaCaminos(ArbolBinarioDeBusqueda<Integer> abb, int x){
		ListaEnlazadaGenerica<ListaEnlazadaGenerica<Integer>> lis= new ListaEnlazadaGenerica<ListaEnlazadaGenerica<Integer>>();
		ListaEnlazadaGenerica<Integer> aux= new ListaEnlazadaGenerica<Integer>();
		loop(abb, x, lis, aux);
		
		return lis;
	}
	
	private static void loop (ArbolBinarioDeBusqueda<Integer> abb, int x, ListaEnlazadaGenerica<ListaEnlazadaGenerica<Integer>> lis, ListaEnlazadaGenerica<Integer> aux){
		
		if(!abb.esVacio()){
			aux.agregarFinal(abb.getDatoRaiz());
			aux.comenzar();
			int i= 0;
			while(!aux.fin()){
				i+=aux.proximo();
			}
			if(i==x){
				ListaEnlazadaGenerica<Integer> tmp= new ListaEnlazadaGenerica<Integer>();
				aux.comenzar();
				while(!aux.fin()){
					tmp.agregarFinal(aux.proximo());
				}
				lis.agregarFinal(tmp);
				return;
			}
			if(!abb.getHijoIzquierdo().esVacio()){
				loop(abb.getHijoIzquierdo(), x, lis, aux);
				aux.eliminarEn(aux.tamanio());
			}
			if(!abb.getHijoDerecho().esVacio()){
				loop(abb.getHijoDerecho(), x, lis, aux);
				aux.eliminarEn(aux.tamanio());
			}
		}
			
	};
	
}
