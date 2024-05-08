package excepciones.ejercicio03;

/**
 * Excepcion que se lanzara cuando se introduzca un nombre invalido
 */
public class InvalidNameException extends Exception {
	/**
	 * Metodo toString() sobreescrito
	 */
	@Override
	public String toString() {
		return "Nombre inválido";
	}

}
