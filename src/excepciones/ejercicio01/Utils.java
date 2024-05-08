package excepciones.ejercicio01;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase en la que definire las funciones con excepciones capturadas
 */
public class Utils {

	/**
	 * Funcion que devuelve el numero decimal escrito por teclado
	 * 
	 * @param sc Objeto de tipo Scanner que leera
	 * @return Valor del numero decimal escrito
	 */
	public static double readDouble(Scanner sc) {
		// Numero decimal que devolverá la funcion, inicializado en 0.0
		double doubleDevuelto = 0.0;

		try {
			// Le asignamos el double escrito por teclado
			doubleDevuelto = sc.nextDouble();

			// Si se produce un InputMismatchException
		} catch (InputMismatchException e) {
			// Mostrará este mensaje
			System.out.println("El valor introducido no es de tipo double");
		} finally {
			// Siempre limpiamos el buffer
			sc.nextLine();
		}
		
		// Devolverá el valor escrito por teclado, o 0.0 si no es del tipo correcto
		return doubleDevuelto;
	}

	public static int readInt(Scanner sc) {
		// Numero decimal que devolverá la funcion, inicializado en 0
		int intDevuelto = 0;

		try {
			// Le asignamos el int escrito por teclado
			intDevuelto = sc.nextInt();

			// Si se produce un InputMismatchException
		} catch (InputMismatchException e) {
			// Mostrará este mensaje
			System.out.println("El valor introducido no es de tipo int");
		} finally {
			// Siempre limpiamos el buffer
			sc.nextLine();
		}

		// Devolverá el valor escrito por teclado, o 0 si no es del tipo correcto
		return intDevuelto;
	}
}
