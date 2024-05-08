package excepciones.ejercicio03;

/**
 * Excepcion que se lanzara cuando se introduzca un saldo negativo
 */
public class NegativeSaldoException extends Exception {
	/**
	 * Metodo toString() sobreescrito
	 */
	@Override
	public String toString() {
		return "Saldo negativo";
	}

}
