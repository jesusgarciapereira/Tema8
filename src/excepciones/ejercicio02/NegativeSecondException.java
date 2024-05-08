package excepciones.ejercicio02;

/**
 * Excepcion que se lanzara cuando se introduzca un minuto negativo
 */
public class NegativeSecondException extends Exception{
	@Override
	public String toString() {
		return "Minuto negativo";
	}
	

}
