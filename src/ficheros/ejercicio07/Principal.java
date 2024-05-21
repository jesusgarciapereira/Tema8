package ficheros.ejercicio07;

import java.util.Scanner;

public class Principal {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int opcion = 0;
		
		String nombre = "";
		long telefono;

		do {
			menu();
			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
			case 1:
				System.out.println("Introduzca un nombre");
				nombre = sc.nextLine();
				System.out.println("Introduzca un teléfono");
				telefono = sc.nextInt();
				sc.nextLine();
				if(AgendaMap.introducirContacto(nombre, telefono)){
					System.out.println("Datos introducidos correctamente");
				} else {
					System.out.println("Error al introducir los datos");
				}
				System.out.println();
				
				
				break;
			case 2:
				System.out.println("Introduzca un nombre");
				nombre = sc.nextLine();
				if(AgendaMap.buscarContacto(nombre) != 0){
					System.out.println("Número de " + nombre + ": " + AgendaMap.buscarContacto(nombre));
				} else {
					System.out.println("El nombre introducido no se encuentra en nuestra base de datos");
				}
				System.out.println();
				
				break;
			case 3:
				AgendaMap.mostrarTodos();

				break;
			case 4:

				break;

			default:
				break;
			}

		} while (opcion != 4);

		System.out.println("Saliendo del programa");
	}

	private static void menu() {
		System.out.println("1. Nuevo Contacto");
		System.out.println("2. Buscar por nombre");
		System.out.println("3. Mostrar todos");
		System.out.println("4. Salir");
		System.out.println("\tElija una opción");
	}

}
