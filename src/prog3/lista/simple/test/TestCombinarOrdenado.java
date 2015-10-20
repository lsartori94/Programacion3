package prog3.lista.simple.test;
import prog3.lista.simple.ListaDeEnterosEnlazada;

public class TestCombinarOrdenado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListaDeEnterosEnlazada L = new ListaDeEnterosEnlazada();
		ListaDeEnterosEnlazada L2 = new ListaDeEnterosEnlazada();
		
		L.agregarInicio(2);
		L.agregarInicio(2);
		L.agregarInicio(25);
		L.agregarInicio(1);
		L.agregarInicio(8);
		L.agregarInicio(6);
		L.agregarInicio(5);
		L.agregarInicio(0);
		L.agregarInicio(51);
		L2.agregarInicio(7);
		L2.agregarInicio(32);
		L2.agregarInicio(4);
		L2.agregarInicio(3);
		L2.agregarInicio(14);
		L2.agregarInicio(95);
		L2.agregarInicio(100);
		L2.agregarInicio(4);
		L2.agregarInicio(0);
		L2.agregarInicio(1);
		System.out.println("LISTA 1 DESORDEANDA: "+ L);
		System.out.println("LISTA 1 ORDENADA: "+L.ordenar());
		System.out.println("LISTA 2 DESORDENADA: "+L2);
		System.out.println("LISTA 2 ORDENADA : "+L2.ordenar());
		System.out.println("LISTA COMBINADA: "+L.ordenarCombinado(L2));

	}

}
