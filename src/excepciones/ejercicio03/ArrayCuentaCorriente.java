package excepciones.ejercicio03;

/**
 * Clase en la que definiremos la tabla con las cuentas corrientes y las
 * funciones para gestionarlas
 */
public class ArrayCuentaCorriente {

	// Tabla en la que guardaremos nuestras cuentas corrientes, hasta 20
	public static CuentaCorriente cuentas[] = new CuentaCorriente[20];

	/**
	 * Funcion que muestra todas las cuentas de la tabla
	 */
	public static void muestraCuentas() {
		// Bucle for-each que recorre todos los elementos de la tabla
		for (CuentaCorriente cuenta : cuentas) {
			// Si la cuenta no es null
			if (cuenta != null)
				// La muestra
				System.out.println(cuenta);
		}

	}

	/**
	 * Funcion para anniadir una nueva cuenta dentro de la tabla cuentas
	 * 
	 * @param cuenta Cuenta corriente que añadiremos
	 * @return True o false segun si se ha hecho la operacion o no
	 */
	public static boolean abrirCuenta(CuentaCorriente cuenta) {
		// Contador para las posiciones de la tabla
		int i = 0;
		// Posición en la que se encuentra el artículo que creamos
		int posicion;
		// Boolean que indica si se ha ñadido un nuevo articulo, inicializado como false
		boolean creada = false;

		// Llamamos a la función encontrarCuenta para asignar el valor de la posición
		posicion = encontrarCuenta(cuenta);

		// Si no lo ha encontrado
		if (posicion == -1) {

			// Mientras el valor del contador sea menor a la longitud de la tabla cuentas y
			// dicho elemento sea null
			while (i < cuentas.length && cuentas[i] != null)
				// Incrementamos el contador
				i++;

			// Si el valor del contador es menor a la longitud de la tabla cuentas
			if (i < cuentas.length) {
				// Asignamos el objeto creado a dicha posición
				cuentas[i] = cuenta;
				// Y asignamos nuestro boolean como true
				creada = true;
			}
		}

		// Devolverá el valor de nuestro boolean
		return creada;

	}

	/**
	 * Funcion para borrar una cuenta presente en la tabla cuentas
	 * 
	 * @param cuenta Cuenta corriente que borrara
	 * @return True o false segun si se ha llevado a cabo la operacion o no
	 */
	public static boolean borrarCuenta(CuentaCorriente cuenta) {
		// Posición en la que se encuentra la cuenta que borraremos
		int posicion;
		// Boolean que indica si se ha borrado una cuenta, inicializado como false
		boolean borrado = false;

		// Llamamos a la función encontrarCuenta para asignar el valor de la posición
		posicion = encontrarCuenta(cuenta);

		// Si lo ha encontrado
		if (posicion >= 0) {
			// Asignamos el objeto de dicha posición como null
			cuentas[posicion] = null;
			// Y asignamos nuestro boolean como true
			borrado = true;
		}
		// Devolverá el valor de nuestro boolean
		return borrado;
	}

	/**
	 * Modifica el nombre del titular de la cuenta corriente que le indicamos en el
	 * parametro
	 * 
	 * @param cuenta Cuenta corriente a la que cambiaremos el nombre
	 * @param nombre Nuevo nombre que le asignamos
	 * @return True o false segun si se ha llevado a cabo la operacion o no
	 * @throws InvalidNameException 
	 */
	public static boolean cambiarNombre(CuentaCorriente cuenta, String nombre) throws InvalidNameException {
		// Posición en la que se encuentra la cuenta que modificaremos
		int posicion;
		// Boolean que indica si han modificado las horas extra
		boolean modificado = false;

		// Llamamos a la función encontrarCuenta para asignar el valor de la posición
		posicion = encontrarCuenta(cuenta);

		// Si lo ha encontrado
		if (posicion >= 0) {
			// Se llama al set para modificar el nombre de la cuenta corriente que se
			// encuentre en la posición correspondiente
			cuentas[posicion].setNombre(nombre);
			// Asignamos el boolean como true
			modificado = true;
		}

		// Devolverá el valor de nuestro boolean
		return modificado;
	}

	/**
	 * Modifica el saldo de la cuenta corriente que le indicamos en el parametro
	 * sumandole la cantidad de dinero
	 * 
	 * @param cuenta     Cuenta corriente a la que cambiaremos el saldo
	 * @param cantDinero Cantidad de dinero que ingresaremos
	 * @return True o false segun si se ha llevado a cabo la operacion o no
	 * @throws NegativeSaldoException 
	 */
	public static boolean ingresarDinero(CuentaCorriente cuenta, double cantDinero) throws NegativeSaldoException {
		// Posición en la que se encuentra la cuenta que modificaremos
		int posicion;
		// Boolean que indica si han modificado las horas extra
		boolean dineroIngresado = false;

		// Llamamos a la función encontrarCuenta para asignar el valor de la posición
		posicion = encontrarCuenta(cuenta);

		// Si lo ha encontrado
		if (posicion >= 0) {
			// Se llama al set para modificar el saldo de la cuenta corriente que se
			// encuentre en la posición correspondiente. Sumando la cantidad introducida
			cuentas[posicion].setSaldo(cuenta.getSaldo() + cantDinero);
			// Asignamos el boolean como true
			dineroIngresado = true;
		}

		// Devolverá el valor de nuestro boolean
		return dineroIngresado;
	}

	/**
	 * Modifica el saldo de la cuenta corriente que le indicamos en el parametro
	 * restandole la cantidad de dinero
	 * 
	 * @param cuenta     Cuenta corriente a la que cambiaremos el saldo
	 * @param cantDinero Cantidad de dinero que retiraremos
	 * @return True o false segun si se ha llevado a cabo la operacion o no
	 * @throws NegativeSaldoException 
	 */
	public static boolean sacarDinero(CuentaCorriente cuenta, double cantDinero) throws NegativeSaldoException {
		// Posición en la que se encuentra la cuenta que modificaremos
		int posicion;
		// Boolean que indica si han modificado las horas extra
		boolean dineroSacado = false;

		// Llamamos a la función encontrarCuenta para asignar el valor de la posición
		posicion = encontrarCuenta(cuenta);

		// Si lo ha encontrado y la cantidad a sacar es menor que el saldo de la cuenta
		if (posicion >= 0 && cantDinero < cuenta.getSaldo()) {
			// Se llama al set para modificar el saldo de la cuenta corriente que se
			// encuentre en la posición correspondiente. Restando la cantidad introducida
			cuentas[posicion].setSaldo(cuenta.getSaldo() - cantDinero);
			// Asignamos el boolean como true
			dineroSacado = true;
		}

		// Devolverá el valor de nuestro boolean
		return dineroSacado;
	}

	/**
	 * Funcion que devuelve la posicion en la que se encuentra la cuenta del
	 * parametro
	 * 
	 * @param cuenta Objeto de tipo CuentaCorriente que buscaremos
	 * @return Posicion en la que se encuentra la cuenta, -1 si no la encuentra
	 */
	public static int encontrarCuenta(CuentaCorriente cuenta) {
		// Contador
		int i = 0;
		// Posición en la que se encuentra la cuenta, -1 representa que no está
		int posicion = -1;

		// Mientras el contador sea menor que la longitud de la tabla y el objeto en que
		// nos encontremos no sea null y no se haya encontrado
		while (i < cuentas.length && cuentas[i] != null && posicion == -1) {

			// Si el contador es menor que la longitud de la tabla y el objeto en que nos
			// encontramos es igual al objeto del parámetro
			if (i < cuentas.length && cuentas[i].equals(cuenta))
				// Asignamos a la posición el valor del contador
				posicion = i;

			// Incrementamos el contador
			i++;
		}

		// Devolverá la posición en la que se encuentre
		return posicion;

	}
}
