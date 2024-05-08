package excepciones.ejercicio04;

/**
 * Clase en la que definiremos la tabla con los articulos y las funciones para
 * gestionar
 */
public class ArrayArticulo {

	/**
	 * Tabla de tipo Articulo en el que guardamos hasta 20 articulos diferentes
	 */
	public static Articulo almacen[] = new Articulo[20];

	/**
	 * Función que muestra cada uno de los artículos existentes en la tabla almacen
	 */
	public static void muestraArticulos() {
		// Bucle for-each que recorre cada elemento de la tabla almacen
		for (Articulo articulo : almacen) {
			// Si el elemento no es null
			if (articulo != null)
				// Lo muestra
				System.out.println(articulo);
		}

	}

	/**
	 * Funcion para anniadir un nuevo articulo dentro de la tabla almacen
	 * 
	 * @param codigo         Codigo del articulo
	 * @param descripcion    Descripcion del articulo
	 * @param precioDeCompra Precio de compra del articulo
	 * @param precioDeVenta  Precio de venta del articulo
	 * @param stock          Numero de unidades de cada articulo
	 * @return True o false segun si se ha hecho la operacion o no
	 * @throws InvalidCodeException          Excepcion que indica que el codigo es
	 *                                       invalido
	 * @throws InvalidDescriptionException   Excepcion que indica que la descripcion
	 *                                       es invalida
	 * @throws NegativePrecioCompraException Excepcion que indica que el precio de
	 *                                       compra es negativo
	 * @throws NegativePrecioVentaException  Excepcion que indica que el precio de
	 *                                       venta es negativo
	 * @throws NegativeStockException        Excepcion que indica que el stock es
	 *                                       negativo
	 */
	public static boolean anniadirArticulo(String codigo, String descripcion, double precioDeCompra,
			double precioDeVenta, int stock) throws InvalidCodeException, InvalidDescriptionException,
			NegativePrecioCompraException, NegativePrecioVentaException, NegativeStockException {
		// Contador para las posiciones de la tabla
		int i = 0;
		// Posición en la que se encuentra el artículo que creamos
		int posicion;
		// Boolean que indica si se ha ñadido un nuevo articulo, inicializado como false
		boolean anniadido = false;

		// Creamos un nuevo artículo con los datos introducidos en el parámetro
		Articulo articulo = new Articulo(codigo, descripcion, precioDeCompra, precioDeVenta, stock);
		// Llamamos a la función encontrarArticulo para asignar el valor de la posición
		posicion = encontrarArticulo(articulo);

		// Si no lo ha encontrado
		if (posicion == -1) {

			// Mientras el valor del contador sea menor a la longitud de la tabla almacen y
			// dicho elemento sea null
			while (i < almacen.length && almacen[i] != null)
				// Incrementamos el contador
				i++;

			// Si el valor del contador es menor a la longitud de la tabla almacén
			if (i < almacen.length) {
				// Asignamos el objeto creado a dicha posición
				almacen[i] = articulo;
				// Y asignamos nuestro boolean como true
				anniadido = true;
			}
		}

		// Devolverá el valor de nuestro boolean
		return anniadido;

	}

	/**
	 * Funcion para borrar un articulo presente en la tabla almacen
	 * 
	 * @param articulo Articulo que borrara
	 * @return True o false segun si se ha llevado a cabo la operacion o no
	 */
	public static boolean borrarArticulo(Articulo articulo) {
		// Posición en la que se encuentra el artículo que borraremos
		int posicion;
		// Boolean que indica si se ha borrado un articulo, inicializado como false
		boolean borrado = false;

		// Llamamos a la función encontrarArticulo para asignar el valor de la posición
		posicion = encontrarArticulo(articulo);

		// Si lo ha encontrado
		if (posicion >= 0) {
			// Asignamos el objeto de dicha posición como null
			almacen[posicion] = null;
			// Y asignamos nuestro boolean como true
			borrado = true;
		}
		// Devolverá el valor de nuestro boolean
		return borrado;
	}

	/**
	 * Funcion que indica si un articulo se encuentra en la tabla almacen
	 * 
	 * @param art Articulo a buscar
	 * @return True o false segun si el articulo esta en nuestro array o no
	 */
	public static int encontrarArticulo(Articulo art) {
		// Contador para recorrer la tabla
		int i = 0;
		// Variable que indica la posición en la que se encuentra el artículo, si no lo
		// encuentra será -1
		int posicion = -1;

		// Mientras el objeto en que nos encontramos no sea null y no se haya encontrado
		// nuestro objeto
		while (almacen[i] != null && posicion == -1) {

			// Si el contador es menor que la longitud de la tabla y el objeto en que nos
			// encontramos es igual al objeto del parámetro
			if (i < almacen.length && almacen[i].equals(art))
				// Asignamos a la posición el contador
				posicion = i;

			// Incrementamos el contador
			i++;
		}

		// Devuelve la posición en la que se encuentra
		return posicion;
	}
}
