package figuras.prog3.info;

public class Cuadrado extends Rectangulo {
	
	public Cuadrado(){
	}
	public Cuadrado(double a){
		setAncho(a);
		setLargo(a);
	}
	public Cuadrado(double a, String c, boolean b){
		setAncho(a);
		setLargo(a);
		setColor(c);
		setRelleno(b);
	}	
	public void setLado(double l){
		super.setAncho(l);
		super.setLargo(l);
	}
	@Override
	public void setAncho(double l) {
		this.setLado(l);
	}
	@Override
	public void setLargo(double l) {
		this.setLado(l);
	}
	@Override
	public String toString() {
		return "Cuadrado [getAncho()=" + getAncho() + ", getLargo()="
				+ getLargo() + ", getArea()=" + getArea() + ", getPerimetro()="
				+ getPerimetro() + ", toString()=" + super.toString()
				+ ", getColor()=" + getColor() + ", isRelleno()=" + isRelleno()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}
	
}
