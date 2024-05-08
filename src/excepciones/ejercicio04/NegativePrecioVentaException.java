package excepciones.ejercicio04;

/**
 * Excepcion que se lanzara cuando se introduzca un precio de venta negativo
 */
public class NegativePrecioVentaException extends Exception{
	/**
	 * Metodo toString() sobreescrito
	 */
	@Override
	public String toString() {
		return "Precio de venta negativo";
	}

}
