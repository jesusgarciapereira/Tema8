package ficheros.ejercicio02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		// Objeto de tipo Scanner
		Scanner sc;

		// Lista de enteros con todos los números leídos del fichero
		List<Integer> numeros = new ArrayList<>();
		// Suma de todos los números
		int suma = 0;
		// Media de todos los números
		int media;

		try {
			// Abrimos el archivo indicado para su lectura
			sc = new Scanner(new FileReader("src\\ficheros\\ejercicio02\\Enteros.txt"));

			// Mientras haya enteros en el archivo
			while (sc.hasNextInt()) {
				// Añade cada entero leído a la lista
				numeros.add(sc.nextInt());
			}
			// Excepción en caso de no encontrar el archivo
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}

		// Bucle for-each que recorre cada elemento de la Lista numeros
		for (Integer numero : numeros) {
			// Asignamos a suma la suma de todos los números
			suma += numero;
		}

		// Asignamos a la media la suma total partido el tamaño de la lista
		media = suma / numeros.size();

		// Mostramos todos los datos
		System.out.println("Números leídos del fichero");
		for (Integer numero : numeros) {
			System.out.print(numero + " ");
		}
		System.out.println();
		System.out.println();

		System.out.println("Suma total");
		System.out.println(suma);
		System.out.println();

		System.out.println("Media");
		System.out.println(media);
		System.out.println();

	}

}
