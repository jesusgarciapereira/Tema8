package excepciones.ejercicio04;

import java.util.Locale;
import java.util.Scanner;

public class Gestisimal {

	public static void main(String[] args) {

		// Activamos el Scanner
		Scanner sc = new Scanner(System.in);

		// Para poder escribir decimales con un punto
		sc.useLocale(Locale.US);

		// Opción elegida por el usuario
		int opcion = 0;

		// Objeto de tipo articulo
		Articulo articulo;
		// Posición en la que se encuentra el artículo en nuestro almacén
		int posicion;
		// Cantidad que modificaremos del stock del artículo
		int cantidad;

		// ATRIBUTOS
		// Código del artículo que le pediremos al usuario
		String codigo = "";
		// Descripción del artículo que le pediremos al usuario
		String descripcion = "";
		// Precio de compra del artículo que le pediremos al usuario
		double precioDeCompra;
		// Precio de venta del artículo que le pediremos al usuario
		double precioDeVenta;
		// Stock del artículo que le pediremos al usuario
		int stock;

		do {
			// Mostramos el menú
			mostrarMenu();

			// Asignamos la opción elegida por el usuario
			opcion = sc.nextInt();
			// Y limpiamos el buffer
			sc.nextLine();

			// Swich para cada caso de la opción
			switch (opcion) {
			case 1:
				// Mostramos todos los artículos
				ArrayArticulo.muestraArticulos();
				break;
			case 2:
				try {
					// Le pedimos al usuario el código del nuevo artículo
					System.out.println("Introduzca el código del nuevo artículo");
					// Y lo asignamos
					codigo = sc.nextLine();

					// Le pedimos al usuario la descripción del nuevo artículo
					System.out.println("Introduzca la descripción del nuevo artículo");
					// Y lo asignamos
					descripcion = sc.nextLine();

					// Le pedimos al usuario el precio de compra del nuevo artículo
					System.out.println("Introduzca el precio de compra del nuevo artículo");
					// Y lo asignamos
					precioDeCompra = sc.nextDouble();
					// Y limpiamos el buffer
					sc.nextLine();

					// Le pedimos al usuario el precio de venta del nuevo artículo
					System.out.println("Introduzca el precio de venta del nuevo artículo");
					// Y lo asignamos
					precioDeVenta = sc.nextDouble();
					// Y limpiamos el buffer
					sc.nextLine();

					// Le pedimos al usuario el stock del nuevo artículo
					System.out.println("Introduzca el stock del nuevo artículo");
					// Lo asignamos
					stock = sc.nextInt();
					// Y limpiamos el buffer
					sc.nextLine();

					// Si se ha podido añadidir el artículo
					if (ArrayArticulo.anniadirArticulo(codigo, descripcion, precioDeCompra, precioDeVenta, stock))
						// Mostramos este mensaje
						System.out.println("Artículo añadido correctamente");
					// En caso contrario
					else
						// Mostramos este otro mensaje
						System.out.println("No se ha podido añadir el artículo");

					// salto de línea
					System.out.println();
				} catch (InvalidCodeException e) {
					e.toString();
				} catch (InvalidDescriptionException e) {
					e.toString();
				} catch (NegativePrecioCompraException e) {
					e.toString();
				} catch (NegativePrecioVentaException e) {
					e.toString();
				} catch (NegativeStockException e) {
					e.toString();
				}
				break;
			case 3:
				try {
					// Le pedimos al usuario el código del artículo que querrá eliminar
					System.out.println("Introduzca el código del artículo que quiera eliminar");
					// Y lo asignamos
					codigo = sc.nextLine();

					// Asignamos a nuestro objeto un nuevo artículo con el código introducido por el
					// usuario
					articulo = new Articulo(codigo);

					// Si se ha podido borrar el artículo
					if (ArrayArticulo.borrarArticulo(articulo))
						// Mostramos este mensaje
						System.out.println("Artículo borrado correctamente");
					// En caso contrario
					else
						// Mostramos este otro mensaje
						System.out.println("No existe artículo con ese código en el almacén");

					// salto de línea
					System.out.println();
				} catch (InvalidCodeException e) {
					e.toString();
				}
				break;
			case 4:
				try {
				// Le pedimos al usuario el código del artículo que quiera modificar
				System.out.println("Introduzca el código del artículo que quiera modificar");
				// Y lo asignamos
				codigo = sc.nextLine();

				// Asignamos a nuestro objeto un nuevo artículo con el código introducido por el
				// usuario
				articulo = new Articulo(codigo);
				// Asignamos la posición en la que se encuentra llamando a la función
				// encontrarArticulo()
				posicion = ArrayArticulo.encontrarArticulo(articulo);

				// Si la posición es mayor o igual que 0
				if (posicion >= 0) {
					System.out.println("1. Descripción");
					System.out.println("2. Precio de compra");
					System.out.println("3. Precio de venta");
					System.out.println("¿Qué dato quiere modificar?");
					opcion = sc.nextInt();
					sc.nextLine();

					switch (opcion) {
					case 1:
						try {
							// Le pedimos al usuario la nueva descripción del artículo
							System.out.println("Introduzca la nueva descripción del artículo");
							// Y lo asignamos
							descripcion = sc.nextLine();

							// Asignamos a articulo el artículo perteneciente a que se encuentre en dicha
							// posición en el almacén
							articulo = ArrayArticulo.almacen[posicion];
							// Para luego modificarlo con el set
							articulo.setDescripcion(descripcion);
						} catch (InvalidDescriptionException e) {
							e.toString();
						}
						break;

					case 2:
						try {
							// Le pedimos al usuario el precio de compra del nuevo artículo
							System.out.println("Introduzca el nuevo precio de compra del artículo");
							// Y lo asignamos
							precioDeCompra = sc.nextDouble();
							// Y limpiamos el buffer
							sc.nextLine();

							// Asignamos a articulo el artículo perteneciente a que se encuentre en dicha
							// posición en el almacén
							articulo = ArrayArticulo.almacen[posicion];
							// Para luego modificarlo con el set
							articulo.setPrecioDeCompra(precioDeCompra);
						} catch (NegativePrecioCompraException e) {
							e.toString();
						}
						break;

					case 3:
						try {
							// Le pedimos al usuario el nuevo precio de venta del artículo
							System.out.println("Introduzca el nuevo precio de venta del artículo");
							// Y lo asignamos
							precioDeVenta = sc.nextDouble();
							// Y limpiamos el buffer
							sc.nextLine();

							// Asignamos a articulo el artículo perteneciente a que se encuentre en dicha
							// posición en el almacén
							articulo = ArrayArticulo.almacen[posicion];
							// Para luego modificarlo con el set
							articulo.setPrecioDeVenta(precioDeVenta);
						} catch (NegativePrecioVentaException e) {
							e.toString();
						}
						break;

					default:
						break;

					}
					// Mensaje de que los cambios se han realizado
					System.out.println("Artículo modificado con éxito");

					// En caso contrario
				} else
					// Mostramos este otro mensaje
					System.out.println("No existe artículo con ese código en el almacén");
				} catch(InvalidCodeException e) {
					e.toString();
				}
				break;
			case 5:
				try {
				// Le pedimos al usuario el código del artículo
				System.out.println("Introduzca el código del artículo");
				// Y lo asignamos
				codigo = sc.nextLine();

				// Asignamos a nuestro objeto un nuevo artículo con el código introducido por el
				// usuario
				articulo = new Articulo(codigo);
				// Asignamos la posición en la que se encuentra llamando a la función
				// encontrarArticulo()
				posicion = ArrayArticulo.encontrarArticulo(articulo);

				// Si la posición es mayor o igual que 0
				if (posicion >= 0) {
					// Pedimos al usuario una cantidad para incrementar el stock
					System.out.println("¿Cuánta mercancía entra?");
					// Y la asignamos
					cantidad = sc.nextInt();
					// Limpiamos el buffer
					sc.nextLine();

					// Asignamos a articulo el artículo perteneciente a que se encuentre en dicha
					// posición en el almacén
					articulo = ArrayArticulo.almacen[posicion];
					// Llamamos al set y al get del stock para incrementarlo con dicha cantidad
					articulo.setStock(articulo.getStock() + cantidad);

					// Mensaje al final de la operación
					System.out.println("Operación realizada con éxito");

					// En caso contrario
				} else
					// Mostramos este otro mensaje
					System.out.println("No existe artículo con ese código en el almacén");
				} catch(InvalidCodeException e) {
					e.toString();
				} catch(NegativeStockException e) {
					e.toString();
				}
				break;
			case 6:
				try {
				// Le pedimos al usuario el código del artículo
				System.out.println("Introduzca el código del artículo");
				// Y lo asignamos
				codigo = sc.nextLine();

				// Asignamos a nuestro objeto un nuevo artículo con el código introducido por el
				// usuario
				articulo = new Articulo(codigo);
				// Asignamos la posición en la que se encuentra llamando a la función
				// encontrarArticulo()
				posicion = ArrayArticulo.encontrarArticulo(articulo);

				// Si la posición es mayor o igual que 0
				if (posicion >= 0) {
					// Pedimos al usuario una cantidad para incrementar el stock
					System.out.println("¿Cuánta mercancía sale?");
					// Y la asignamos
					cantidad = sc.nextInt();
					// Limpiamos el buffer
					sc.nextLine();

					// Asignamos a articulo el artículo perteneciente a que se encuentre en dicha
					// posición en el almacén
					articulo = ArrayArticulo.almacen[posicion];

					// Si el stock del artículo es mayor que la cantidad a sacar
					if (articulo.getStock() > cantidad) {
						// Llamamos al set y al get del stock para decrementarlo con dicha cantidad
						articulo.setStock(articulo.getStock() - cantidad);

						// Mensaje al final de la operación
						System.out.println("Operación realizada con éxito");
					}
					// En caso contrario
					else
						// Mostramos este mensaje
						System.out.println("Insuficientes artículos en el stock");

					// Si el artículo no ha sido encontrado
				} else
					// Mostramos este otro mensaje
					System.out.println("No existe artículo con ese código en el almacén");
				} catch(InvalidCodeException e) {
					e.toString();
				} catch(NegativeStockException e) {
					e.toString();
				}
				break;
			case 7:
				break;

			}

			// Mientras la opción sea distinta de 7 repetiremos de nuevo las instrucciones
			// del do
		} while (opcion != 7);

		// Mostramos el mensaje de salida del programa
		System.out.println("Saliendo del programa");

		// Cerramos el Scanner
		sc.close();

	}

	/**
	 * Funcion que muestra el siguiente menu
	 */
	public static void mostrarMenu() {
		System.out.println("1. Listado");
		System.out.println("2. Alta");
		System.out.println("3. Baja");
		System.out.println("4. Modificación");
		System.out.println("5. Entrada de mercancía");
		System.out.println("6. Salida de mercancía");
		System.out.println("7. Salir");
		System.out.println();
		// Le pedimos al usuario una opción
		System.out.println("Seleccione una opción");

	}

}
