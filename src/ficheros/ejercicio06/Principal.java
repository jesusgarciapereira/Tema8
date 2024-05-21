package ficheros.ejercicio06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Principal {

	public static void main(String[] args) {

		// Objeto de tipo BufferedReader
		BufferedReader br;
		// Objeto de tipo BufferedWriter
		BufferedWriter in;

		// Cada línea de texto que se leerá
		String lineaLeida = "";

		// Lista que almacena los números
		List<Integer> listaNumeros = new ArrayList<>();

		try {
			// Abrimos el archivo indicado para su lectura
			br = new BufferedReader(new FileReader("src\\ficheros\\ejercicio06\\numerosDesordenados.txt"));
			// Abrimos el archivo indicado para su escritura
			in = new BufferedWriter(new FileWriter("src\\ficheros\\ejercicio06\\numerosOrdenados.txt"));

			// Asignamos a línea leída la primera línea del archivo
			lineaLeida = br.readLine();

			// Mientras la línea leída no sea null
			while (lineaLeida != null) {
				// Introducimos el número leido en nuesta lista
				listaNumeros.add(Integer.parseInt(lineaLeida));

				// Asignamos a línea leída la siguiente línea del archivo
				lineaLeida = br.readLine();
			}

			// Ordenamos la lista
			listaNumeros.sort(null);

			// Bucle for-each para recorrer cada elemento de la lista
			for (Integer numero : listaNumeros) {
				// Cuidado porque el metodo write() lee los números como si fueran caracteres
				// unicode
				// Insertamos el número en el archivo
				in.write(numero.toString());
				// Salto de línea
				in.newLine();
			}

			// Vaciamos el buffer de entrada
			in.flush();
			// Cerramos el flujo de salida
			in.close();

			// Excepción en caso de no encontrar el archivo
		} catch (FileNotFoundException e) {
			System.out.println(e);
			// Excepción de entrada/salida
		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
