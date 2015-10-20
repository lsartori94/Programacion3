package figuras.prog3.info;

public class Rectangulo extends Figura{

	private double ancho;
	private double largo;
	
	public Rectangulo(){
	}
	public Rectangulo(double a, double l){
		setAncho(a);
		setLargo(l);
	}
	public Rectangulo(double a, double l, String c, boolean b){
		setAncho(a);
		setLargo(l);
		setColor(c);
		setRelleno(b);
	}
	public double getAncho() {
		return ancho;
	}
	public void setAncho(double ancho) {
		this.ancho = ancho;
	}
	public double getLargo() {
		return largo;
	}
	public void setLargo(double largo) {
		this.largo = largo;
	}
	@Override
	public double getArea(){
		return this.ancho*this.largo;
	}
	@Override
	public double getPerimetro(){
		return (2*this.ancho)+(2*this.largo);
	}
	@Override
	public String toString() {
		return "Rectangulo [ancho=" + ancho + ", largo=" + largo
				+ ", getArea()=" + getArea() + ", getPerimetro()="
				+ getPerimetro() + "]";
	}
	
	
}
