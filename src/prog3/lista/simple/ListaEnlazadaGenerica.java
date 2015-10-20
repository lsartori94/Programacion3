package prog3.lista.simple;

public class ListaEnlazadaGenerica<T> extends ListaGenerica<T>{
	
	private int tamanio;
	private NodoGenerico<T> inicio;
	private NodoGenerico<T> actual;
	private NodoGenerico<T> fin;
	
	@Override
	public void comenzar(){
		actual=inicio;
	}
	
	@Override
	public T proximo(){
		T elto= actual.getDato();
		actual= actual.getSiguiente();
		return elto;
	}
	
	@Override
	public boolean fin(){
		return (actual == null);
	}
	
	@Override
	public T elemento(int pos){
		if (pos < 1 || pos > this.tamanio())
			return null;
		NodoGenerico<T> T = this.inicio;
		while (pos-- > 1)
			T = T.getSiguiente();
		return T.getDato();
	}
	
	@Override
	public boolean agregarEn(T key, int pos){
		if (pos < 1 || pos > this.tamanio() + 1)
			return false;
		this.tamanio++;
		NodoGenerico<T> aux = new NodoGenerico<T>();
		aux.setDato(key);
		if (pos == 1) {
			aux.setSiguiente(inicio);
			inicio = aux;
		} else {
			NodoGenerico<T> n = this.inicio;
			NodoGenerico<T> ant = null;
			int posActual = 1;
			while (!(n == null) && (posActual < pos)) {
				ant = n;
				n = n.getSiguiente();
				posActual++;
			}
			aux.setSiguiente(n);
			ant.setSiguiente(aux);
			// Nuevo
			if (aux.getSiguiente() == null)
				fin = aux;
		}
		return true;
	}
	
	@Override
	public boolean agregarInicio(T key){
		this.agregarEn(key, 1);
		return true;
	}
	
	@Override
	public boolean agregarFinal(T key){
		NodoGenerico<T> aux = new NodoGenerico<T>();
		aux.setDato(key);
		if (inicio == null) {
			inicio = aux;
			fin = aux;
		} else {
			fin.setSiguiente(aux);
			fin = aux;
		}
		tamanio++;
		return true;
	}
	
	@Override
	public boolean eliminar(T key){
		NodoGenerico<T> n = this.inicio;
		NodoGenerico<T> ant = null;
		while ((n != null) && (!n.getDato().equals(key))) {
			ant = n;
			n = n.getSiguiente();
		}
		if (n == null)
			return false;
		else {
			if (ant == null)
				inicio = null;
			else
				ant.setSiguiente(n.getSiguiente());
			this.tamanio--;
		
		return true;
		}
	}
	
	@Override
	public boolean eliminarEn(int pos){
		if (pos < 1 || pos > this.tamanio())
			return false;
		this.tamanio--;
		if (pos == 1) {
			inicio = inicio.getSiguiente();
			return true;
		}
		NodoGenerico<T> n = this.inicio;
		NodoGenerico<T> ant = null;
		while (!(n == null) && (pos > 1)) {
			pos--;
			ant = n;
			n = n.getSiguiente();
		}
		ant.setSiguiente(n.getSiguiente());
		// Nuevo
		if (ant.getSiguiente() == null)
			fin = ant;
		return true;
	}
	
	@Override
	public boolean incluye(T key){
		NodoGenerico<T> n = this.inicio;
		while (!(n == null) && !(n.getDato().equals(key)))
			n = n.getSiguiente();
		return !(n == null);
	}
	
	@Override
	public String toString() {
		String str = "";
		NodoGenerico<T> n = this.inicio;
		while (n != null) {
			str = str + n.getDato() + " -> ";
			n = n.getSiguiente();
		}
		if (str.length() > 1)
			str = str.substring(0, str.length() - 4);
		return str;
	}
	
	@Override
	public int tamanio() {
		return this.tamanio;
	}
	
	@Override
	public boolean esVacia() {
		return(this.tamanio==0);
	}

	public ListaEnlazadaGenerica<T> invertir(){
		NodoGenerico<T> n = new NodoGenerico<T>();
		n= this.inicio;
		ListaEnlazadaGenerica<T> L = new ListaEnlazadaGenerica<T>();
		
		while(n!= null){
			L.agregarFinal(n.getDato());
			n= n.getSiguiente();
		}
		return L;
	}
	
	
}
