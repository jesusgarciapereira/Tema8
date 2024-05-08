package excepciones.ejercicio03;

import java.util.Locale;
import java.util.Scanner;

public class Banco {

	// Creamos el Scanner
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// Para poder escribir decimales con un punto
		sc.useLocale(Locale.US);

		// Opción elegida por el usuario
		int opcion;
		// Boolean que indica si la operación se ha realizado
		boolean operacion;

		// Objeto de tipo CuentaCorriente
		CuentaCorriente cuenta;

		// Datos de la cuenta que pediremos que rellene el usuario
		String dni = "";
		String nombre = "";
		double saldo;
		double cantDinero;

		// Mensaje de bienvenida
		System.out.println("Bienvenid@ al sistema de gestión de nuestro banco");

		do {
			// Mostramos el menú
			muestraMenu();

			// Asignamos la opción elegida por el usuario
			opcion = sc.nextInt();
			// Y limpiamos el buffer
			sc.nextLine();

			// Switch para cada posible opción elegida
			switch (opcion) {
			// Si la opción es 1
			case 1:
				try {
					// Le pedimos al usuario el dni del titular de la cuenta
					System.out.println("Introduzca el dni del titular de la cuenta");
					// Y lo asignamos
					dni = sc.nextLine();

					// Le pedimos al usuario el nombre del titular de la cuenta
					System.out.println("Introduzca el nombre del titular de la cuenta");
					// Y lo asignamos
					nombre = sc.nextLine();

					// Le pedimos al usuario el saldo de la cuenta
					System.out.println("Introduzca el saldo de la cuenta");
					// Lo asignamos
					saldo = sc.nextDouble();
					// Y limpiamos el buffer
					sc.nextLine();

					// Creamos una nueva cuenta con los datos introducidos por el usuario
					cuenta = new CuentaCorriente(dni, nombre, saldo);

					// Asignamos a la operacion el valor devuelto por la función abrirCuenta()
					operacion = ArrayCuentaCorriente.abrirCuenta(cuenta);

					// Mostrará un mensaje según si operacion es true o false
					System.out.println(operacion ? "Cuenta abierta correctamente" : "No se ha podido abrir la cuenta");
				} catch (InvalidDniException e) {
					e.toString();
				} catch (InvalidNameException e) {
					e.toString();
				} catch (NegativeSaldoException e) {
					e.toString();
				}
				break;

			// Si la opción es 2
			case 2:
				// Llama a la función muestraCuentas() para mostrar todas las cuentas existentes
				ArrayCuentaCorriente.muestraCuentas();
				break;

			// Si la opción es 3
			case 3:
				try {
					// Le pedimos al usuario el dni del titular de la cuenta
					System.out.println("Introduzca el dni del titular de la cuenta");
					// Y lo asignamos
					dni = sc.nextLine();

					// Creamos una nueva cuenta con el dni introducido por el usuario
					cuenta = new CuentaCorriente(dni);

					// Asignamos a la operacion el valor devuelto por la función borrarCuenta()
					operacion = ArrayCuentaCorriente.borrarCuenta(cuenta);

					// Mostrará un mensaje según si operacion es true o false
					System.out.println(operacion ? "Cuenta eliminada" : "No se ha podido eliminar la cuenta");
				} catch (InvalidDniException e) {
					e.toString();
				}
				break;

			// Si la opción es 4
			case 4:
				try {
					// Le pedimos al usuario el dni del titular de la cuenta
					System.out.println("Introduzca el dni del titular de la cuenta");
					// Y lo asignamos
					dni = sc.nextLine();

					// Le pedimos al usuario el nuevo nombre
					System.out.println("Introduzca el nuevo nombre");
					// Y lo asignamos
					nombre = sc.nextLine();

					// Creamos una nueva cuenta con el dni introducido por el usuario
					cuenta = new CuentaCorriente(dni);

					// Asignamos a la operacion el valor devuelto por la función cambiarNombre()
					operacion = ArrayCuentaCorriente.cambiarNombre(cuenta, nombre);

					// Mostrará un mensaje según si operacion es true o false
					System.out.println(
							operacion ? "Nombre modificado correctamente" : "No se ha podido modificar el nombre");
				} catch (InvalidDniException e) {
					e.toString();
				} catch (InvalidNameException e) {
					e.toString();
				}
				break;

			// Si la opción es 5
			case 5:
				try {
					// Le pedimos al usuario el dni del titular de la cuenta
					System.out.println("Introduzca el dni del titular de la cuenta");
					// Y lo asignamos
					dni = sc.nextLine();

					// Le pedimos al usuario la cantidad a ingresar
					System.out.println("Introduzca la cantidad a ingresar");
					// Lo asignamos
					cantDinero = sc.nextDouble();
					// Y limpiamos el buffer
					sc.nextLine();

					// Creamos una nueva cuenta con el dni introducido por el usuario
					cuenta = new CuentaCorriente(dni);

					// Asignamos a la operacion el valor devuelto por la función ingresarDinero()
					operacion = ArrayCuentaCorriente.ingresarDinero(cuenta, cantDinero);

					// Mostrará un mensaje según si operacion es true o false
					System.out.println(operacion ? "Transferencia hecha" : "No se ha podido realizar la transferencia");
				} catch (InvalidDniException e) {
					e.toString();
				} catch (NegativeSaldoException e) {
					e.toString();
				}
				break;
			case 6:
				try {
					// Le pedimos al usuario el dni del titular de la cuenta
					System.out.println("Introduzca el dni del titular de la cuenta");
					// Y lo asignamos
					dni = sc.nextLine();

					// Le pedimos al usuario la cantidad a retirar
					System.out.println("Introduzca la cantidad a retirar");
					// Lo asignamos
					cantDinero = sc.nextDouble();
					// Y limpiamos el buffer
					sc.nextLine();

					// Creamos una nueva cuenta con el dni introducido por el usuario
					cuenta = new CuentaCorriente(dni);

					// Asignamos a la operacion el valor devuelto por la función sacarDinero()
					operacion = ArrayCuentaCorriente.sacarDinero(cuenta, cantDinero);

					// Mostrará un mensaje según si operacion es true o false
					System.out.println(operacion ? "Transferencia hecha" : "No se ha podido realizar la transferencia");
				} catch (InvalidDniException e) {
					e.toString();
				} catch (NegativeSaldoException e) {
					e.toString();
				}
				break;
			case 0:
				break;
			default:
				System.out.println("Opción incorrecta");
				break;
			}

			// Mientras la opción sea diferente de 0 se ejecutarán todas las instrucciones
			// del do
		} while (opcion != 0);

		// Mensaje de salida del sistema
		System.out.println("Saliendo del sistema...");

		// Cerramos el Scanner
		sc.close();
	}

	/**
	 * Funcion que muestra el siguiente menu
	 */
	public static void muestraMenu() {
		System.out.println("1. Abrir cuenta.");
		System.out.println("2. Listar cuentas.");
		System.out.println("3. Dar de baja.");
		System.out.println("4. Cambiar nombre.");
		System.out.println("5. Ingresar dinero.");
		System.out.println("6. Sacar dinero.");
		System.out.println("0. Salir.\n");
		System.out.println("¿Qué opción quiere ejecutar?");

	}

}
