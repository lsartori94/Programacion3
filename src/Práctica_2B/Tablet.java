package Práctica_2B;

public class Tablet extends Mobile {
	
	private int pulgadas;

	public int getPulgadas() {
		return pulgadas;
	}

	public void setPulgadas(int pulgadas) {
		this.pulgadas = pulgadas;
	}
	
	public boolean equals(Object obj){
		boolean bol= false;
		
		if(obj instanceof Tablet){
			Tablet t= (Tablet) obj;
			if(t.pulgadas == this.pulgadas){
				if(t.getMarca().equals(this.getMarca())){
					if(t.getModelo().equals(this.getModelo())){
						if(t.getSistemaOperativo().equals(this.getSistemaOperativo())){
							if(t.getCosto() == this.getCosto()){
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
		
		String datos= "Marca:"+ this.getMarca()+" Modelo:"+this.getModelo()+" Pulgadas:"+this.getPulgadas()+" Sistema Operativo:"+this.getSistemaOperativo()+" Precio:"+this.getCosto();
		return datos;
	}
}
