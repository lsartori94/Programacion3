package figuras.prog3.info;

public class Circulo extends Figura {
	
	private double radio;
	
	public Circulo(){
	}
	public Circulo(double r){
		setRadio(r);
	}
	public Circulo(double d, String a, boolean b){
		setRadio(d);
		setColor(a);
		setRelleno(b);
	}
	public double getRadio() {
		return radio;
	}
	public void setRadio(double radio) {
		this.radio = radio;
	}
	@Override
	public double getArea(){
		return Math.PI*Math.sqrt(this.radio);
	}
	@Override
	public double getPerimetro(){
		return Math.PI*2*this.radio;
	}
	@Override
	public String toString() {
		return "Circulo [radio=" + radio + ", getArea()=" + getArea()
				+ ", getPerimetro()=" + getPerimetro() + "]";
	}

}
