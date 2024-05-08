package excepciones.ejercicio02;

/**
 * Excepcion que se lanzara cuando se introduzca un minuto negativo
 */
public class NegativeMinuteException extends Exception{
	/**
	 * Metodo toString sobreescrito
	 */
	@Override
	public String toString() {
		return "Minuto negativo";
	}
	

}
