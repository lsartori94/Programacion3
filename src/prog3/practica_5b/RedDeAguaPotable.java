package prog3.practica_5b;

import prog3.arbol.general.ArbolGeneral;
import prog3.lista.*;
import prog3.util.ColaGenerica;

public class RedDeAguaPotable {
	
	public Double caudalMin(ArbolGeneral<Double> ag, Double litros){

		ColaGenerica<ArbolGeneral<Double>> q= new ColaGenerica<ArbolGeneral<Double>>();
		Double min= 99999.99;

		q.encolar(ag);	//encolo raiz

		while(!q.esVacia()){
			ArbolGeneral<Double> a= q.desencolar();
			if(a.esHoja()){
				if(litros.compareTo(min)<0)
					min= litros;
			}
			else{
				ListaGenerica<ArbolGeneral<Double>> lh= a.getHijos();
				litros= litros/(lh.tamanio()-1);
				lh.comenzar();
				while(!lh.fin()){
					q.encolar(lh.proximo());
				}
			}
		}
		return min;
	}
}
