package prog3.lista.simple.test;
import prog3.lista.simple.ListaDeEnterosEnlazada;;

public class ListaDeEnterosEnlazadaTestBasico {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListaDeEnterosEnlazada L = new ListaDeEnterosEnlazada();
		int [] i = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
		for(int r=0; r<i.length; r++)
			L.agregarInicio(i[r]);
		System.out.println(L);
	}
}
