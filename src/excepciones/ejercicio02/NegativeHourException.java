package excepciones.ejercicio02;

/**
 * Excepcion que se lanzara cuando se introduzca una hora negativa
 */
public class NegativeHourException extends Exception{
	
	/**
	 * Metodo toString sobreescrito
	 */
	@Override
	public String toString() {
		return "Hora negativa";
	}
	

}
