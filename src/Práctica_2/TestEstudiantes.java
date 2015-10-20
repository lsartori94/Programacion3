package Práctica_2;

public class TestEstudiantes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n= 3;
		Estudiante [] E= new Estudiante[n];
		for(int i=0; i<n; i++){
			E[i]= new Estudiante();
		}
		
		E[0].setNombre("Luca");
		E[0].setApellido("Sartori");
		E[0].setLegajo("732/8");
		E[0].setEmail("lucasartori94@gmail.com");
		E[0].setCelular(22156783);
		E[1].setNombre("Agustin");
		E[1].setApellido("Liebana");
		E[1].setLegajo("733/8");
		E[1].setEmail("asdf@gmail.com");
		E[1].setCelular(22146783);
		E[2].setNombre("Juan");
		E[2].setApellido("Doe");
		E[2].setLegajo("322/8");
		E[2].setEmail("lucasder@gmail.com");
		E[2].setCelular(2213783);
		
		recorrer(E, n);
	}

	public static void recorrer(Estudiante [] E, int n){
		for(int j=0; j<n; j++){
			System.out.println(E[j].tusDatos());
		}
	}
}
