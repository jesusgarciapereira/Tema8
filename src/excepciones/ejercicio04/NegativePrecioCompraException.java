package excepciones.ejercicio04;

/**
 * Excepcion que se lanzara cuando se introduzca un precio de compra negativo
 */
public class NegativePrecioCompraException extends Exception{
	/**
	 * Metodo toString() sobreescrito
	 */
	@Override
	public String toString() {
		return "Precio de compra negativo";
	}

}
