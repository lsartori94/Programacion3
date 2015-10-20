package prog3.arbol.binariobusqueda;

import prog3.arbol.binario.NodoBinario;
import prog3.util.ColaGenerica;

public class ArbolBinarioDeBusqueda<T extends Comparable<T>> {

	private NodoBinario<T> raiz;

	public ArbolBinarioDeBusqueda() {
		this.raiz = null;
	}

	public ArbolBinarioDeBusqueda(T dato) {
		this.raiz = new NodoBinario<T>(dato);
	}

	private ArbolBinarioDeBusqueda(NodoBinario<T> nodo) {
		this.raiz = nodo;
	}

	private NodoBinario<T> getRaiz() {
		return raiz;
	}

	public T getDatoRaiz() {
		if (this.getRaiz() != null) {
			return this.getRaiz().getDato();
		} else {
			return null;
		}
	}

	public ArbolBinarioDeBusqueda<T> getHijoIzquierdo() {
		return new ArbolBinarioDeBusqueda<T>(this.raiz.getHijoIzquierdo());
	}

	public ArbolBinarioDeBusqueda<T> getHijoDerecho() {
		return new ArbolBinarioDeBusqueda<T>(this.raiz.getHijoDerecho());
	}
	
	private NodoBinario<T> buscar(Comparable<T> x,
			NodoBinario<T> t) {
		if (t != null) {
			if (x.compareTo(t.getDato()) < 0) {
				t = this.buscar(x, t.getHijoIzquierdo());
			} else if (x.compareTo(t.getDato()) > 0) {
				t = this.buscar(x, t.getHijoDerecho());
			} else
				; // Se encontro el nodo, asi que es t
			return t;
		} else {
			return null;
		}
	}
	
	public boolean incluye(Comparable<T> dato) {
		return buscar(dato, this.raiz) != null;
	}

	public T buscar(T dato){
    	NodoBinario<T> result = this.buscar(dato, this.getRaiz());
    	if (result != null){
    		return result.getDato();
    	}
    	return null;
    }

	public void agregar(T dato) {
		if(this.esVacio())
			raiz= new NodoBinario<T>(dato);
		else
			agregarRec(dato, this);
	}
	
	private void agregarRec(T dato, ArbolBinarioDeBusqueda<T> ab){
		if(ab.getDatoRaiz().compareTo(dato)>0){		//raiz es mayor que dato
			if(ab.getHijoIzquierdo().esVacio())
				ab.getRaiz().setHijoIzquierdo(new NodoBinario<T>(dato));
			else
				agregarRec(dato, ab.getHijoIzquierdo());
		}
		else{
			if(ab.getHijoDerecho().esVacio())
				ab.getRaiz().setHijoDerecho(new NodoBinario<T>(dato));
			else
				agregarRec(dato, ab.getHijoDerecho());
		}
	}

	public void eliminar(T dato) {
		this.raiz= this.eliminarRecu(dato, this.raiz);
	}
	
	private NodoBinario<T> eliminarRecu(T dato, NodoBinario<T> nod){
		if(dato == null)
			return nod;	//no encontro
		if( nod.getDato().compareTo(dato) > 0){
			if(nod.getHijoIzquierdo()!= null)
				nod.setHijoIzquierdo(this.eliminarRecu(dato, nod.getHijoIzquierdo()));
		} else if(nod.getDato().compareTo(dato)<0){
			if(nod.getHijoDerecho()!=null)
				nod.setHijoDerecho(this.eliminarRecu(dato, nod.getHijoDerecho()));
		} else if(nod.getDato().compareTo(dato)==0){
			if(nod.getHijoDerecho()!= null && nod.getHijoIzquierdo()!= null){
				NodoBinario<T> nreemp= this.buscarMayorDeMenores(nod);
				nod.setDato(nreemp.getDato());
				nod.setHijoIzquierdo(this.eliminarRecu(nreemp.getDato(), nod.getHijoIzquierdo()));
			} else {
				if(nod.getHijoIzquierdo()!= null)
					nod= nod.getHijoIzquierdo();
				else
					nod= nod.getHijoDerecho();
			}
		}
		
		return nod;
	}
	
	private NodoBinario<T> buscarMayorDeMenores(NodoBinario<T> nodo){
		NodoBinario<T> abb= nodo.getHijoIzquierdo();
		while(abb.getHijoDerecho()!= null)
			abb= abb.getHijoDerecho();		//muevo siempre por la rama rerecha
		
		return abb;
	}

	public boolean esVacio() {
		return (this.getRaiz() == null);
	}
	
	public String porNivel(){
		String resul="";
		ColaGenerica<ArbolBinarioDeBusqueda<T>> cola= new ColaGenerica<ArbolBinarioDeBusqueda<T>>();
		cola.encolar(this);
		cola.encolar(null);
		while(!cola.esVacia()){
			ArbolBinarioDeBusqueda<T> abb= cola.desencolar();
			if(abb==null){	//termino nivel
				if(!cola.esVacia())
					cola.encolar(null);
				resul+="\n";
			}
			else{
				resul+= abb.getDatoRaiz()+ " ";
				if(!abb.getHijoIzquierdo().esVacio())
					cola.encolar(abb.getHijoIzquierdo());
				if(!abb.getHijoDerecho().esVacio())
					cola.encolar(abb.getHijoDerecho());
			}
		}
		return resul;
	}

}