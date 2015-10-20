package prog3.lista.simple.test;
import prog3.util.PilaGenerica;

public class PilaGenericaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PilaGenerica<Character> p = new PilaGenerica<Character>();
		
		p.apilar('a');
		p.apilar('b');
		p.apilar('c');
		p.apilar('c');
		p.apilar('d');
		p.apilar('e');
		
		for(int i=0; i<=4; i++)
			p.desapilar();
		System.out.println(p.tope());
	}

}
