package prog3.grafos.utiles;

import prog3.grafos.*;
import prog3.lista.*;
import prog3.util.ColaGenerica;

public class Recorridos {

	
	
	public ListaGenerica<Vertice<T>> DFS(Grafo<T> grafo){
		boolean [] marca= new boolean[grafo.listaDeVertices().tamanio()];
		ListaGenerica<Vertice<T>> lprof= new ListaEnlazadaGenerica<Vertice<T>>();
		
		for(int i=0; i<grafo.listaDeVertices().tamanio(); i++)
			marca[i]= false;
		
		for(int m=0; m<grafo.listaDeVertices().tamanio(); m++){
			if(!marca[m])
				DFS(lprof, grafo, marca, m);
		}
		
		return lprof;
	}
	
	private void DFS(ListaGenerica<Vertice<T>> lis, Grafo<T> g, boolean[] marca, int i){
		marca[i]= true;
		
		Vertice<T> v= g.listaDeVertices().elementoEn(i);
		lis.agregarFinal(v);
		
		ListaGenerica<Arista<T>> adyacentes= g.listaDeAdyacentes(v);
		adyacentes.comenzar();
		while(!adyacentes.fin()){
			int a= adyacentes.proximo().getVerticeDestino().getPosicion();
			if(!marca[a])
				this.DFS(lis, g, marca, a);
		}
	}
	
	public ListaGenerica<Vertice<T>> BFS(Grafo<T> grafo){
		boolean[] marca= new boolean[grafo.listaDeVertices.tamanio()];
		ListaGenerica<Vertice<T>> lamp= new ListaEnlazadaGenerica<Vertice<T>>();
		
		for(int i=0; i<grafo.listaDeVertices().tamanio(); i++)
			marca[i]= false;
		
		for(int m= 1; m<grafo.listaDeVertices().tamanio(); m++){
			if(!marca[m])
				BFS(grafo, marca, m, lamp);
		}
		
		return lamp;
	}
	
	private void BFS(Grafo<T> grafo, boolean[] marca, int i, ListaGenerica<Vertice<T>> lis){
		ColaGenerica<Vertice<T>> cola= new ColaGenerica<Vertice<T>>();
		
		marca[i]= true;
		cola.encolar(grafo.listaDeVertices().elementoEn(i));
		while(!cola.esVacia()){
			Vertice<T> v= cola.desencolar();
			lis.agregarFinal(v);
			ListaGenerica<Arista<T>> adyacentes= grafo.listaDeAdyacentes();
			adyacentes.comenzar();
			while(!adyacentes.fin()){
				Arista<A> arista= adyacentes.proximo();
				int a= arista.getVerticeDestino().getPosicion();
				if(!marca[a]){
					marca[a]= true;
					Vertice<T> w= arista.getVerticeDestino();
					cola.encolar(w);
				}
			}
		}
	}
	
}
