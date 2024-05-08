package excepciones.ejercicio01;

import java.util.Locale;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		// Creamos un objeto de tipo Scanner
		Scanner sc = new Scanner(System.in);
		// Para poder escribir decimales con un punto
		sc.useLocale(Locale.US);

		// Le pedimos al usuario que escriba un número decimal
		System.out.println("Escribe un número decimal");
		// Mostramos el valor que devuelve la función readDouble() al pasarle lo que hemos escrito por teclado
		System.out.println(Utils.readDouble(sc));
		
		// Le pedimos al usuario que escriba un número entero
		System.out.println("Escribe un número entero");
		// Mostramos el valor que devuelve la función readInt() al pasarle lo que hemos escrito por teclado
		System.out.println(Utils.readInt(sc));
	}

}
