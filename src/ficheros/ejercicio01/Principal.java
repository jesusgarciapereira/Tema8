package ficheros.ejercicio01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Principal {

	public static void main(String[] args) {

		// Variable de tipo BufferedReader para leer el archivo
		BufferedReader br;

		// Cada línea leída
		String lineaLeida = "";
		// Tabla con los números leídos del archivo
		String numeros[] = null;
		// Suma de todos los números
		int suma = 0;
		// Media de todos los números
		int media;

		try {
			// Abrimos el archivo indicado para su lectura
			br = new BufferedReader(new FileReader("src\\ficheros\\ejercicio01\\NumerosReales.txt"));

			// Asignamos a línea leída la primera línea del archivo
			lineaLeida = br.readLine();

			// Mientras la línea leída no sea null
			while (lineaLeida != null) {

				// Asignamos a la tabla los números de la línea separados por un espacio
				numeros = lineaLeida.split(" ");

				// Bucle for-each que recorre cada elemento de la tabla números
				for (String numero : numeros) {
					// Le asignamos a la variable suma la suma de todos los números de la tabla, su
					// respectivo valor en int
					suma += Integer.valueOf(numero);
				}

				// Asignamos a línea leída la siguiente línea del archivo
				lineaLeida = br.readLine();
			}

			// Excepción en caso de no encontrar el archivo
		} catch (FileNotFoundException e) {
			System.out.println(e);
			// Excepción de entrada/salida
		} catch (IOException e) {
			System.out.println(e);
		}

		// Asignamos a la media la suma total partido la longitud de la tabla números
		media = suma / numeros.length;

		// Mostramos todos los resultados
		System.out.println("Números leídos del fichero");
		System.out.println(Arrays.toString(numeros));
		System.out.println();

		System.out.println("Suma total");
		System.out.println(suma);
		System.out.println();

		System.out.println("Media");
		System.out.println(media);
		System.out.println();

	}

}
