package prog3.lista.simple;

public abstract class ListaGenerica <T> {

	public abstract void comenzar();
	public abstract T proximo();
	public abstract boolean fin();
	public abstract T elemento(int elem);
	public abstract boolean agregarEn(T key, int pos);
	public abstract boolean agregarInicio(T key);
	public abstract boolean agregarFinal(T key);
	public abstract boolean eliminar(T key);
	public abstract boolean eliminarEn(int pos);
	public abstract boolean incluye(T key);
	public abstract boolean esVacia();
	public abstract int tamanio();
	
}
