package Práctica_2B;

public class SmartPhone extends Mobile {

	private int numero;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public boolean equals(Object obj){
		boolean bol= false;
		
		if(obj instanceof SmartPhone){
			SmartPhone s= (SmartPhone) obj;
			if(s.numero == this.numero){
				if(s.getMarca().equals(this.getMarca())){
					if(s.getModelo().equals(this.getModelo())){
						if(s.getSistemaOperativo().equals(this.getSistemaOperativo())){
							if(s.getCosto() == this.getCosto()){
								bol= true;
							}
						}
					}
				}
			}
			else{
			bol= false;
			}
			
		return bol;
		}
		else{
			bol= false;
			
			return bol;
		}
	}
	public String toString(){
		
		String datos= "Marca:"+ this.getMarca()+" Modelo:"+this.getModelo()+" Numero:"+this.getNumero()+" Sistema Operativo:"+this.getSistemaOperativo()+" Precio:"+this.getCosto();
		return datos;
	}
}
