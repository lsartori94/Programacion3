package prog3.complementos;
import prog3.util.PilaGenerica;

public class TestBalanceo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "([]{()})";
		String test2 = "(({[})])";
		
		if(balanced(test))
			System.out.println("El string " + test + " esta balanceado");
		else
			System.out.println("El string " + test + " NO esta balanceado");
		
		System.out.println(" ");
		if(balanced(test2))
			System.out.println("El string " + test2 + " esta balanceado");
		else
			System.out.println("El string " + test2 + " NO esta balanceado");

	}
	
	public static boolean balanced(String s){
		PilaGenerica<Character> c = new PilaGenerica<Character>();
				
		for(int i=0; i<s.length(); i++){
			if(i==0){	//primer char
				if(s.charAt(i)=='}'||s.charAt(i)==')'||s.charAt(i)==']')	//si es de cierre sale
					return false;
				else
					c.apilar(s.charAt(i));		//si es de apertura lo apila
			}
			if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{')	//si es de apertura lo apila
					c.apilar(s.charAt(i));
			else if(c.esVacia())	//lista vacia y se trata de apilar un caracter de cierre
				return false;
			else if(s.charAt(i)==')'){
				if(c.tope()=='(')
					c.desapilar();
				else
					return false;
			}
			else if(s.charAt(i)==']'){
				if(c.tope()=='[')
					c.desapilar();
				else
					return false;
			}
			else if(s.charAt(i)=='}'){
				if(c.tope()=='{')
					c.desapilar();
				else
					return false;
			}	
		}
		return true;
	}
}
