package prog3.arbol.general;

import prog3.lista.ListaEnlazadaGenerica;
import prog3.lista.ListaGenerica;

public class NodoGeneral<T> {

    private T dato;
    private ListaGenerica<NodoGeneral<T>> listaHijos;
    
    public NodoGeneral(T dato){

        this.dato = dato;
        listaHijos = new ListaEnlazadaGenerica<NodoGeneral<T>>();
    }
    
    public T getDato(){

        return this.dato;
    }    
    
    public ListaGenerica<NodoGeneral<T>> getHijos(){

        return this.listaHijos;
    }     
    
    public void setDato(T dato){

        this.dato = dato;
    }
    
    public void setListaHijos(ListaGenerica<NodoGeneral<T>> lista){

        this.listaHijos = lista;
    }    
    
    void preOrden(ListaGenerica<T> l){
    	l.agregarFinal(this.getDato());
    	ListaGenerica<NodoGeneral<T>> lhijos= this.getHijos();
    	lhijos.comenzar();
    	while(!lhijos.fin())
    		(lhijos.proximo()).preOrden(l);
    }
    
    int contarEnPreOrden(){
    	int res= 1;
    	ListaGenerica<NodoGeneral<T>> lhijos= this.getHijos();
    	lhijos.comenzar();
    	while(!lhijos.fin())
    		res+= lhijos.proximo().contarEnPreOrden();
    	
    	return res;
    }
    
}
