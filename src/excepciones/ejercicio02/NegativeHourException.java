package excepciones.ejercicio02;

/**
 * Excepcion que se lanzara cuando se introduzca una hora negativa
 */
public class NegativeHourException extends Exception{
	@Override
	public String toString() {
		return "Hora negativa";
	}
	

}
