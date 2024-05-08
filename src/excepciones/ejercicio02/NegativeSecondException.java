package excepciones.ejercicio02;

/**
 * Excepcion que se lanzara cuando se introduzca un segundo negativo
 */
public class NegativeSecondException extends Exception{
	/**
	 * Metodo toString sobreescrito
	 */
	@Override
	public String toString() {
		return "Segundo negativo";
	}
	

}
