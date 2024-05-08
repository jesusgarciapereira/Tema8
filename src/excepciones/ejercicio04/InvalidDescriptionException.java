package excepciones.ejercicio04;

/**
 * Excepcion que se lanzara cuando se introduzca una descripcion invalida
 */
public class InvalidDescriptionException extends Exception{
	/**
	 * Metodo toString() sobreescrito
	 */
	@Override
	public String toString() {
		return "Descripción inválida";
	}

}
