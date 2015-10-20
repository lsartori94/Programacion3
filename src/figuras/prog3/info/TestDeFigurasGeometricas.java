package figuras.prog3.info;

public class TestDeFigurasGeometricas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Figura [] f= new Figura [3];
		
		f[0]= new Circulo(4.0, "Rojo", true);
		f[1]= new Rectangulo(3.0, 2.0, "Azul", true);
		f[2]= new Cuadrado(6.7, "verde", false);
		
		for(Figura i : f){
			System.out.println(i.toString());
		}

	}

}
