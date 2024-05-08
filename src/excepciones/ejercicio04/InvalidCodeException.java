package excepciones.ejercicio04;

/**
 * Excepcion que se lanzara cuando se introduzca un codigo invalido
 */
public class InvalidCodeException extends Exception{
	/**
	 * Metodo toString() sobreescrito
	 */
	@Override
	public String toString() {
		return "Código inválido";
	}

}
