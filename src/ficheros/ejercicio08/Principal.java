package ficheros.ejercicio08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		List<String> registros = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		String fecha;
		String linea;
		int temperaturaMaxima;
		int temperaturaMinima;
		int ops;
		int temperaturaMaximaMaxima = Integer.MIN_VALUE;
		int temperaturaMinimaMinima = Integer.MAX_VALUE;
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(new FileReader("src\\ficheros\\ej8\\registro.txt"));

			while ((linea = br.readLine()) != null) {
				registros.add(linea);
			}
		} catch (IOException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
		}

		do {
			System.out.println("Menú:");
			System.out.println("1. Registrar nueva temperatura.");
			System.out.println("2. Mostrar historial de registros.");
			System.out.println("3. Salir.");
			System.out.print("Selecciona una opción: ");
			ops = sc.nextInt();
			sc.nextLine(); // Consumir el salto de línea

			switch (ops) {
			case 1:
				System.out.print("Ingresa la fecha (AAAA-MM-DD): ");
				fecha = sc.nextLine();
				System.out.print("Ingresa la temperatura máxima: ");
				temperaturaMaxima = sc.nextInt();
				System.out.print("Ingresa la temperatura mínima: ");
				temperaturaMinima = sc.nextInt();
				sc.nextLine(); // Consumir el salto de línea

				String nuevoRegistro = fecha + "," + temperaturaMaxima + "," + temperaturaMinima;
				registros.add(nuevoRegistro);

				try {
					bw = new BufferedWriter(new FileWriter("src\\ficheros\\ej8\\registro.txt"));
					bw.write(nuevoRegistro);
					bw.newLine();
				} catch (IOException e) {
					System.out.println("Error al guardar el registro: " + e.getMessage());
				} finally {
					try {
						bw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				System.out.println("Temperatura registrada exitosamente.");
				break;

			case 2:
				System.out.println("Historial de registros:");
				System.out.println("Fecha,Temperatura máxima,Temperatura mínima");

				for (String registro : registros) {
					System.out.println(registro);
					String[] datos = registro.split(",");
					temperaturaMaximaMaxima = Math.max(temperaturaMaximaMaxima, Integer.parseInt(datos[1]));
					temperaturaMinimaMinima = Math.min(temperaturaMinimaMinima, Integer.parseInt(datos[2]));
				}
				break;

			case 3:
				System.out.println("Saliendo de la aplicación...");
				break;

			default:
				System.out.println("Opción inválida. Intenta de nuevo.");
			}
		} while (ops != 3);
		
		sc.close();
	}
}
