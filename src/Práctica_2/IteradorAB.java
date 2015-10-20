package Práctica_2;

public class IteradorAB {
		
	public static void iteracionConFor(int a, int b){
		if(b<a){
			int i= b;
			b=a;
			a=i;
		}
		for(int i=a; i<b+1; i++){
			System.out.println(i);
		}
	}
	
	public static void iteracionConWhile(int a, int b){
		if(b<a){
			int i= b;
			b=a;
			a=i;
		}
		int i=a;
		while(i<b++){
			System.out.println(i);
		i++;
		}
	}
	
	public static void recursiva(int a, int b){
		if(b<a){
			int i= b;
			b=a;
			a=i;
		}
		rec2(a,b);
	}
	
	private static void rec2(int a, int b){
		if(a<b+1){
			System.out.println(a);
			rec2(a++, b);
		}
	}
	
}
