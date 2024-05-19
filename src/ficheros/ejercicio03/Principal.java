package ficheros.ejercicio03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Principal {

	public static void main(String[] args) {

		// Variable de tipo BufferedReader para leer el archivo
		BufferedReader br;

		// Cada línea leída
		String lineaLeida = "";
		// Tabla con los datos de cada fila
		String alumno[];

		// Suma de todas las edades
		int sumaEdades = 0;
		// Media de todas las edades
		int mediaEdades;

		// Suma de todas las alturas
		double sumaAlturas = 0;
		// Media de todas las alturas
		double mediaAlturas;

		// Listas con los nombres, edades y alturas respectivamente
		List<String> nombres = new ArrayList<>();
		List<Integer> edades = new ArrayList<>();
		List<Double> alturas = new ArrayList<>();

		try {
			// Abrimos el archivo indicado para su lectura
			br = new BufferedReader(new FileReader("src\\ficheros\\ejercicio03\\Alumnos.txt"));

			// Asignamos a línea leída la primera línea del archivo
			lineaLeida = br.readLine();

			// Mientras la línea leída no sea null
			while (lineaLeida != null) {
				// Asignamos a la tabla alumno los datos de la línea separados por un espacio
				alumno = lineaLeida.split(" ");

				// Cada elemento de la tabla alumno se introducirá en su respectiva lista
				nombres.add(alumno[0]);
				edades.add(Integer.valueOf(alumno[1]));
				alturas.add(Double.valueOf(alumno[2]));

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

		// Bucle for-each que recorre cada elemento de la lista edades
		for (Integer edad : edades) {
			// Asignamos a sumaEdades la suma de todas las edades
			sumaEdades += edad;
		}

		// Bucle for-each que recorre cada elemento de la lista alturas
		for (Double altura : alturas) {
			// Asignamos a sumaAlturas la suma de todas las alturas
			sumaAlturas += altura;
		}

		// Asignamos a mediaEdades la suma de las edades partido el tamaño de la lista
		// edades
		mediaEdades = sumaEdades / edades.size();
		// Asignamos a mediaAlturas la suma de las alturas partido el tamaño de la lista
		// alturas
		mediaAlturas = sumaAlturas / alturas.size();

		// Mostramos todos los resultados
		System.out.println("Nombres de los Alumnos");
		System.out.println(nombres);
		System.out.println();

		System.out.println("Media de las edades");
		System.out.println(mediaEdades);
		System.out.println();

		System.out.println("Media de las alturas");
		System.out.println(mediaAlturas);
		System.out.println();
	}

}
