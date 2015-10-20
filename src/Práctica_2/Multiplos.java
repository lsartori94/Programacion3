package Práctica_2;

public class Multiplos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		int m[]= getMultiplos(n);
		for(int i=0; i<n; i++){
			System.out.println(m[i]);
		}
	}
	
	public static int[] getMultiplos(int n){
		int mul[]= new int[n];
		
		if(n>1){
			for(int i=0; i<n; i++){
				mul[i]=n*(i+1);
			}
		}
		else if(n==1){
			mul[0]=2;
		}
		
		return mul;
	}
}
