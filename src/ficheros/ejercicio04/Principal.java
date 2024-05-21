package ficheros.ejercicio04;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Principal {

	/**
	 * Scanner activado
	 */
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// Objeto de tipo BufferedWriter
		BufferedWriter in;

		// Cada línea de texto que se introducirá
		String lineaTexto = "";

		try {
			// Abrimos el archivo indicado para su escritura
			in = new BufferedWriter(new FileWriter("src\\ficheros\\ejercicio04\\vacio.txt"));

			// Mientras la cadena de texto no sea "fin"
			while (!lineaTexto.equalsIgnoreCase("fin")) {
				// Le pedimos al usuario un texto
				System.out.println("Introduzca texto");
				// Y lo asignamos
				lineaTexto = sc.nextLine();
				// Para luego introducirlo en nuestro archivo
				in.write(lineaTexto);
				// Salto de línea en nuestro archivo
				in.newLine();

			}
			// Vaciamos el buffer de entrada
			in.flush();
			// Cerramos el flujo de salida
			in.close();
			
			// Mensaje de programa finalizado
			System.out.println("Programa finalizado");
			
			
			// Excepción de entrada/salida
		} catch (IOException e) {
			System.out.println("Se ha producido un error en la escritura");
		}
		
		// Cerramos el Scanner
		sc.close();
	}

}
