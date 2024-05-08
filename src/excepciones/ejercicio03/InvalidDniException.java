package excepciones.ejercicio03;

/**
 * Excepcion que se lanzara cuando se introduzca una dni invalido
 */
public class InvalidDniException extends Exception {
	/**
	 * Metodo toString() sobreescrito
	 */
	@Override
	public String toString() {
		return "Dni inválido";
	}

}
