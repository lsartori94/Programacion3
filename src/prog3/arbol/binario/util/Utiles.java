package prog3.arbol.binario.util;
import prog3.arbol.binario.*;

public class Utiles {
	
	public static int sumaMaximaVertical(ArbolBinario<Integer> arb){
		if(arb.esHoja())
			return arb.getDatoRaiz();
		else{
			return arb.getDatoRaiz() + Math.max(sumaMaximaVertical(arb.getHijoIzquierdo()), sumaMaximaVertical(arb.getHijoDerecho()));
		}
	}
}