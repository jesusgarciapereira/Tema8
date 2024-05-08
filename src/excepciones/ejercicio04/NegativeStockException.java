package excepciones.ejercicio04;

/**
 * Excepcion que se lanzara cuando se introduzca un stock negativo
 */
public class NegativeStockException extends Exception{
	/**
	 * Metodo toString() sobreescrito
	 */
	@Override
	public String toString() {
		return "Stock negativo";
	}

}
