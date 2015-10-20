package Práctica_2;

public class PruebaRetorno {
	
	public static int sumaArreglo(int [] a){
		
		int suma= 0;
		for(int i= 0; i<a.length; i++){
			suma= suma + a[i];
		}
		return suma;
		}
	
	public static void sumaArreglo2(int[] a, int[] res){
		
		int suma= 0;
		for(int i= 0; i<a.length; i++){
			suma= suma + a[i];
		}
		res[0]= suma;
	}
	
	public static void main(String[] args) {
	
		int [] datos= {1, 2, 3, 4, 5};
		int [] resultado= new int[1];
		
		System.out.println(sumaArreglo(datos));
		sumaArreglo2(datos, resultado);
		System.out.println(resultado[0]);
	}
	
}
