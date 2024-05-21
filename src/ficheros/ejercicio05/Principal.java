package ficheros.ejercicio05;

import java.io.BufferedWriter;
import java.io.File;
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

		// Creamos un objeto de tipo File con una ruta en dónde estará (o creará) un
		// documento de texto
		File archivo = new File("src\\ficheros\\ejercicio05\\datos.txt");

		try {
			// Si el archivo no existe
			if (!archivo.exists()) {
				// Lo crea
				archivo.createNewFile();
			}
			// Abrimos el archivo indicado para su escritura, se respetará lo escrito
			// anteriormente
			in = new BufferedWriter(new FileWriter(archivo, true));

			// Le pedimos al usuario los datos
			System.out.println("Introduzca su nombre y su edad");
			// Y los asignamos
			lineaTexto = sc.nextLine();
			// Y los introduciremos en el archivo
			in.write(lineaTexto);

			// Vaciamos el buffer de entrada
			in.flush();
			// Cerramos el flujo de salida
			in.close();

			// Excepción de entrada/salida
		} catch (IOException e) {
			System.out.println("No se puede encontrar la ruta");
		}

		// Cerramos el Scanner
		sc.close();

	}

}
