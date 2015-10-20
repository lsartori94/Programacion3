package prog3.grafos;

import prog3.lista.*;

public class Mapa {

	private Grafo<String> mapa;
	
	public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2){
		ListaGenerica<String> lista_temporal= new ListaEnlazadaGenerica<String>();
		ListaGenerica<String> lista_final= new ListaEnlazadaGenerica<String>();
		ListaGenerica<Vertice<String>> lista_vertices= mapa.listaDeVertices();
		Boolean[] visitados= new Boolean[lista_vertices.tamanio()];
		Vertice<String> in= null;
		Vertice<String> out= null;
		
		lista_vertices.comenzar();
		while(!lista_vertices.fin()&&(in==null||out==null)){
			Vertice<String> actual= lista_vertices.proximo();
			if(actual.equals(ciudad1))
				in= actual;
			if(actual.equals(ciudad2))
				out= actual;
		}
		dfs_camino(lista_temporal, lista_final, in, out, visitados);
		
		return lista_final;
	}
	
	private void dfs_camino(ListaGenerica<String> lt, ListaGenerica<String> lf, Vertice<String> in, Vertice<String> out, Boolean[] marca){
		marca[in.posicion()]= true;
		lt.agregarFinal(in.dato());
		
		if(in.equals(out)){
			this.copiar(lt, lf);
		}
		else{
			ListaGenerica<Arista<String>> adyacentes= mapa.listaDeAdyacentes(in);
			adyacentes.comenzar();
			while(!adyacentes.fin()){
				Arista<String> a= adyacentes.proximo();
				Vertice<String> v= a.verticeDestino();
				if(!marca[v.posicion()])
					dfs_camino(lt, lf, v, out, marca);
			}
		}
		
		marca[in.posicion()]= false;
		lt.eliminar(lt.tamanio());
	}
	
	public ListaGenerica<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, ListaGenerica<String> ciudades){
		ListaGenerica<String> lista_temporal= new ListaEnlazadaGenerica<String>();
		ListaGenerica<String> lista_final= new ListaEnlazadaGenerica<String>();
		ListaGenerica<Vertice<String>> lista_vertices= mapa.listaDeVertices();
		Vertice<String> in= null;
		Vertice<String> out= null;
		Boolean[] visitados= new Boolean[lista_vertices.tamanio()];
		
		lista_vertices.comenzar();
		while(!lista_vertices.fin() && (in==null || out==null)){
			Vertice<String>v= lista_vertices.proximo();
			if(v.dato().equals(ciudad1))
				in= v;
			if(v.dato().equals(ciudad2))
				out= v;
		}
		dfs_exceptuado(lista_temporal, lista_final, in, out, visitados, ciudades);
		
		return lista_final;
	}
	
	private void dfs_exceptuado(ListaGenerica<String> lt, ListaGenerica<String> lf, Vertice<String> in, Vertice<String> out, Boolean[] marca, ListaGenerica<String> ignorar){
		marca[in.posicion()]= true;
		lt.agregarFinal(in.dato());
		if(lt.tamanio()<=lf.tamanio() || lf.esVacia()){
			this.copiar(lt, lf);
		}
		else{
			ListaGenerica<Arista<String>> adyacentes= mapa.listaDeAdyacentes(in);
			adyacentes.comenzar();
			while(!adyacentes.fin()){
				Arista<String> a= adyacentes.proximo();
				Vertice<String> v= a.verticeDestino();
				if(!marca[v.posicion()] && !ignorar.incluye(v.dato()))
						dfs_exceptuado(lt, lf, v, out, marca, ignorar);
			}
		}
		marca[in.posicion()]= false;
		lt.eliminar(lt.tamanio());
	}

	public ListaGenerica<String> caminoMasCorto(String ciudad1, String ciudad2){
		ListaGenerica<String> lista_temporal= new ListaEnlazadaGenerica<String>();
		ListaGenerica<String> lista_final= new ListaEnlazadaGenerica<String>();
		ListaGenerica<Vertice<String>> lista_vertices= mapa.listaDeVertices();
		Vertice<String> in= null;
		Vertice<String> out= null;
		Boolean[] visitados= new Boolean[lista_vertices.tamanio()];
		
		lista_vertices.comenzar();
		while(!lista_vertices.fin() && (in==null || out==null)){
			Vertice<String> actual= lista_vertices.proximo();
			if(actual.equals(ciudad1))
				in= actual;
			if(actual.equals(ciudad2))
				out= actual;
		}
		int [] peso_total= {0};
		int peso_actual= 0;
		dfs_corto(lista_temporal, lista_final, in, out, visitados, peso_actual, peso_total);
		
		return lista_final;
	}
	
	private void dfs_corto(ListaGenerica<String> lt, ListaGenerica<String> lf, Vertice<String> in, Vertice<String> out, Boolean[] marca, int pa, int[] pt){
		marca[in.posicion()]= true;
		lt.agregarFinal(in.dato());
		
		if(in.equals(out)){
			if(pa<= pt[0]){
				pt[0]= pa;
				this.copiar(lt, lf);
			}
		}
		else{
			ListaGenerica<Arista<String>> adyacentes= mapa.listaDeAdyacentes(in);
			adyacentes.comenzar();
			while(!adyacentes.fin()){
				Arista<String> a= adyacentes.proximo();
				Vertice<String> v= a.verticeDestino();
				if(!marca[v.posicion()])
					dfs_corto(lt, lf, v, out, marca, pa, pt);
			}
		}
		
		marca[in.posicion()]= false;
		lt.eliminar(lt.tamanio());
	}
	
	public ListaGenerica<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto){
		ListaGenerica<String> l_temporal= new ListaEnlazadaGenerica<String>();
		ListaGenerica<String> l_final= new ListaEnlazadaGenerica<String>();
		ListaGenerica<Vertice<String>> l_vertices= mapa.listaDeVertices();
		Vertice<String> in= null;
		Vertice<String> out= null;
		Boolean [] visitados= new Boolean[l_vertices.tamanio()];
		
		l_vertices.comenzar();
		while(!l_vertices.fin()){
			Vertice<String> actual= l_vertices.proximo();
			if(actual.equals(ciudad1))
				in= actual;
			if(actual.equals(ciudad2))
				out= actual;
		}
		dfs_sinCombustible(l_temporal, l_final, in, out, visitados, tanqueAuto);
		
		return l_final;
	}

	private void dfs_sinCombustible(ListaGenerica<String> lt, ListaGenerica<String> lf, Vertice<String> in, Vertice<String> out, Boolean[] marca, int tanqueAuto){
		marca[in.posicion()]= true;
		lt.agregarFinal(in.dato());
		if(in.equals(out)){
			if(lt.tamanio()<=lf.tamanio() || lf.esVacia())
				this.copiar(lt, lf);
		}
		else{
			ListaGenerica<Arista<String>> adyacentes= mapa.listaDeAdyacentes(in);
			adyacentes.comenzar();
			while(!adyacentes.fin()){
				Arista<String> a= adyacentes.proximo();
				Vertice<String> v= a.verticeDestino();
				if(!marca[v.posicion()]){
					if(tanqueAuto - a.peso()>0)
						dfs_sinCombustible(lt, lf, v, out, marca, tanqueAuto);
				}
			}
		}
		
		marca[in.posicion()]= false;
		lt.eliminar(lt.tamanio());
	}
	
	public ListaGenerica<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto){
		ListaGenerica<String> lista_temporal= new ListaEnlazadaGenerica<String>();
		ListaGenerica<String> lista_final= new ListaEnlazadaGenerica<String>();
		ListaGenerica<Vertice<String>> lista_vertices= mapa.listaDeVertices();
		Vertice<String> in= null;
		Vertice<String> out= null;
		Boolean[] visitados= new Boolean[lista_vertices.tamanio()];
		
		lista_vertices.comenzar();
		while(!lista_vertices.fin() && (in==null || out== null)){
			Vertice<String> actual= lista_vertices.proximo();
			if(actual.dato().equals(ciudad1))
				in= actual;
			if(actual.dato().equals(ciudad2))
				out= actual;
		}
		int [] carga_total= {Integer.MAX_VALUE};
		int carga_actual= 0;
		dfs_menor_camino_menor_carga(lista_temporal, lista_final, in, out, visitados, carga_actual, carga_total, tanqueAuto);
		
		return lista_final;
	}

	private void dfs_menor_camino_menor_carga(ListaGenerica<String> lt, ListaGenerica<String> lf, Vertice<String> in, Vertice<String> out, Boolean[] marca, int ca, int[] ct, int tanque){
		marca[in.posicion()]= true;
		lt.agregarFinal(in.dato());
		
		if(in.equals(out)){
			if(ca <= ct[0]){
				ct[0]= ca;
				this.copiar(lt, lf);
			}
		}
		else{
			ListaGenerica<Arista<String>> adyacentes= mapa.listaDeAdyacentes(in);
			adyacentes.comenzar();
			while(!adyacentes.fin()){
				Arista<String> a= adyacentes.proximo();
				Vertice<String> v= a.verticeDestino();
				if(!marca[v.posicion()]){
					if(tanque - a.peso() < 0)
						dfs_menor_camino_menor_carga(lt, lf, v, out, marca, ca + 1, ct, tanque - a.peso());
					else{
						dfs_menor_camino_menor_carga(lt, lf, v, out, marca, ca, ct, tanque - a.peso());
					}
				}
			}
		}
		
		marca[in.posicion()]= false;
		lt.eliminar(lt.tamanio());
}

	public void copiar(ListaGenerica<String> fuente, ListaGenerica<String> destino){
		for(int i= 1; i< destino.tamanio(); i++)
			destino.eliminar(1);
		for(int m=1; m< fuente.tamanio(); m++)
			destino.agregarFinal(fuente.elemento(m));
	}

	public Mapa(){
		mapa=new GrafoImplListAdy<String>();
		Vertice<String> a=new VerticeImplListAdy<String>("Bariloche");
		Vertice<String> b=new VerticeImplListAdy<String>("Villa");
		Vertice<String> c=new VerticeImplListAdy<String>("Chile");
		Vertice<String> d=new VerticeImplListAdy<String>("SanMa");
		Vertice<String> e=new VerticeImplListAdy<String>("Pepe");
		Vertice<String> f=new VerticeImplListAdy<String>("Bolson");
		Vertice<String> g=new VerticeImplListAdy<String>("Nqn");
		this.mapa.agregarVertice(a);
		this.mapa.agregarVertice(b);
		this.mapa.agregarVertice(c);
		this.mapa.agregarVertice(d);
		this.mapa.agregarVertice(e);
		this.mapa.agregarVertice(f);
		this.mapa.agregarVertice(g);
		this.mapa.conectar(a,e);
		this.mapa.conectar(a,f);
		this.mapa.conectar(a,d);
		this.mapa.conectar(a,b);
		this.mapa.conectar(c,b);
		this.mapa.conectar(c,f);
		this.mapa.conectar(f,e);
		this.mapa.conectar(e,g);
		this.mapa.conectar(d,g);
		this.mapa.conectar(e,a);
		this.mapa.conectar(f,a);
		this.mapa.conectar(d,a);
		this.mapa.conectar(b,a);
		this.mapa.conectar(b,c);
		this.mapa.conectar(f,c);
		this.mapa.conectar(e,f);
		this.mapa.conectar(g,e);
		this.mapa.conectar(g,d);
		this.mapa.conectar(f,g);
		this.mapa.conectar(g,f);
	}
}