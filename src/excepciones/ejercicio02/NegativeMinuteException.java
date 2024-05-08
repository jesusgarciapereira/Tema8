package excepciones.ejercicio02;

/**
 * Excepcion que se lanzara cuando se introduzca un segundo negativo
 */
public class NegativeMinuteException extends Exception{
	@Override
	public String toString() {
		return "Segundo negativo";
	}
	

}
