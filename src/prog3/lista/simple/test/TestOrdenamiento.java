package prog3.lista.simple.test;
import prog3.lista.simple.ListaDeEnterosEnlazada;

public class TestOrdenamiento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListaDeEnterosEnlazada L = new ListaDeEnterosEnlazada();
		ListaDeEnterosEnlazada L2 = new ListaDeEnterosEnlazada();
		
		L.agregarInicio(3);
		L.agregarInicio(6);
		L.agregarInicio(1);
		L.agregarInicio(7);
		L.agregarInicio(8);
		L.agregarInicio(15);
		L.agregarInicio(2);
		L.agregarInicio(10);
		L.agregarInicio(1);
		L.agregarInicio(2);
		System.out.println("Desordenada: "+ L);

		L2=L.ordenar();
		
		System.out.println("Ordenada:     "+L2);
	}

}
