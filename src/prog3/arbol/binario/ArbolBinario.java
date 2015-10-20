package prog3.arbol.binario;

import prog3.lista.simple.ListaEnlazadaGenerica;
import prog3.lista.simple.ListaGenerica;

public class ArbolBinario<T> {

	private NodoBinario<T> raiz;
	
	public ArbolBinario(){		
		this.raiz = null;
	}
	
	public ArbolBinario(T dato){		
		this.raiz = new NodoBinario<T>(dato);
	}	
	
	private ArbolBinario(NodoBinario<T> nodo){		
		this.raiz = nodo;
	}
	
	private NodoBinario<T> getRaiz(){		
		return raiz;
	}
	
	public T getDatoRaiz(){
		if (this.getRaiz() != null){
			return this.getRaiz().getDato();
		}else{
			return null;
		}
	}
	
	public ArbolBinario<T> getHijoIzquierdo(){		
		return new ArbolBinario<T>(this.raiz.getHijoIzquierdo());
	}
	
	public ArbolBinario<T> getHijoDerecho(){		
		return new ArbolBinario<T>(this.raiz.getHijoDerecho());
	}	
	
	public void agregarHijoIzquierdo(ArbolBinario<T> hijo){		
		this.raiz.setHijoIzquierdo(hijo.getRaiz());
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo){		
		this.raiz.setHijoDerecho(hijo.getRaiz());
	}	
	
	public void eliminarHijoIzquierdo(){		
		this.raiz.setHijoIzquierdo(new NodoBinario<T>(null));
	}
	
	public void eliminarHijoDerecho(){		
		this.raiz.setHijoDerecho(new NodoBinario<T>(null));
	}	
	
	public boolean esVacio(){
		return this.raiz==null;
	}
	
	public boolean esHoja(){
		return this.getDatoRaiz()!=null && this.getHijoIzquierdo().esVacio() && this.getHijoDerecho().esVacio();
	}
	public ListaGenerica<T> frontera() {
		ListaGenerica<T> lis= new ListaEnlazadaGenerica<T>();
		this.recurs(lis);
		
		return lis;
	}
	
	private void recurs(ListaGenerica<T> l){
		if(!this.getHijoIzquierdo().esVacio())
			this.getHijoIzquierdo().recurs(l);
		if(!this.getHijoDerecho().esVacio())
			this.getHijoDerecho().recurs(l);
		if(this.esHoja())
			l.agregarFinal(this.getDatoRaiz());
	}
	

	private int contar(){
		if(this.esVacio())
			return 0;
		else{
			return (1 + this.getHijoIzquierdo().contar() + this.getHijoDerecho().contar());
		}
	}
	
	private int altura(){
		if(this.esVacio())
			return -1;
		else{
			return 1 + Math.max(this.getHijoIzquierdo().altura(), this.getHijoDerecho().altura());
		}
	}
	
	public boolean lleno(){
		System.out.println("Altura: " + this.altura());
		System.out.println("Nodos: "+ this.contar());
		return this.contar() == (Math.pow(2, this.altura()+1)-1);
	}
	
	public boolean completo() {
		//Falta implementar. 
		return true;

	}
	
}