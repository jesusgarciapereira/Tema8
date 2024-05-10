package ficheros.ejercicio01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Principal {

	public static void main(String[] args) {
		
		// Objeto de tipo BufferedReader, inicializado en null 
		// (para que no me lance la excepción aquí)
		BufferedReader br = null;
		
		String linea = "";
		int suma = 0;
		int media= 0;
		String datosObtenidos[];
		
		try {
			// Asignamos a lectura, la lectura de nuestro fichero
			br = new BufferedReader(new FileReader("src\\ficheros\\ejercicio01\\NumerosReales.txt"));
			
			linea = br.readLine();
			// Asignamos cada línea leída a nuestro String
			while(linea  != null) {
				// Dividimos la línea leída en un arreglo de strings separados por espacio en blanco
				datosObtenidos = linea.split(" ");
				
				// Imprimimos los datos obtenidos
				System.out.println(Arrays.toString(datosObtenidos));
				
				// Iteramos sobre cada número obtenido en la línea
				for (String numero : datosObtenidos) {
					// Sumamos el número convertido a entero a la suma total (parseInt o valueOf)
					suma += Integer.parseInt(numero);
				}
				
				// Calculamos la media dividiendo la suma por la cantidad de números obtenidos        
				media = suma / datosObtenidos.length;	
				
				linea = br.readLine();
			}
			// Si el archivo no se encuentra, imprime la traza del error
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			// Si hay un error de entrada/salida, imprime la traza del error
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Imprimimos la suma total de los números leídos
		System.out.println(suma);
		// Imprimimos la media de los números leídos
		System.out.println(media);

	}

}
