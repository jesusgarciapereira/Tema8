package excepciones.ejercicio04;

/**
 * Clase que representa a los articulos de nuestro almacen
 */
public class Articulo {
	/**
	 * Codigo del articulo
	 */
	private String codigo = "";

	/**
	 * Descripcion del articulo
	 */
	private String descripcion = "";

	/**
	 * Precio de compra del articulo
	 */
	private double precioDeCompra;

	/**
	 * Precio de venta del articulo
	 */
	private double precioDeVenta;

	/**
	 * Numero de unidades de cada articulo
	 */
	private int stock;

	/**
	 * Constructor sin parametros
	 */
	public Articulo() {

	}

	/**
	 * Constructor con el codigo como unico parametro
	 * 
	 * @param codigo Codigo del articulo
	 * @throws InvalidCodeException Excepcion que indica que el codigo es invalido
	 */
	public Articulo(String codigo) throws InvalidCodeException {
		// Si el parámetro codigo es distinto de null y no es una cadena vacía
		if (codigo != null && !codigo.equals(""))
			// Se asigna al atributo codigo
			this.codigo = codigo;
		// En caso contrario
		else
			// Lanzará esta excepción
			throw new InvalidCodeException();
	}

	/**
	 * Constructor con todos los parametros
	 * 
	 * @param codigo         Codigo del articulo
	 * @param descripcion    Descripcion del articulo
	 * @param precioDeCompra Precio de compra del articulo
	 * @param precioDeVenta  Precio de venta del articulo
	 * @param stock          Numero de unidades de cada articulo
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
	public Articulo(String codigo, String descripcion, double precioDeCompra, double precioDeVenta, int stock)
			throws InvalidCodeException, InvalidDescriptionException, NegativePrecioCompraException,
			NegativePrecioVentaException, NegativeStockException {
		// Para el código llamamos al constructor anterior
		this(codigo);
		// Si el parámetro descripcion es distinto de null y no es una cadena vacía
		if (descripcion != null && !descripcion.equals(""))
			// Se asigna al atributo descripcion
			this.descripcion = descripcion;
		// En caso contrario
		else
			// Lanzará esta excepción
			throw new InvalidDescriptionException();
		// Si el parámetro precioDeCompra es mayor que 0
		if (precioDeCompra > 0)
			// Se asigna al atributo precioDeCompra
			this.precioDeCompra = precioDeCompra;
		// En caso contrario
		else
			// Lanzará esta excepción
			throw new NegativePrecioCompraException();
		// Si el parámetro precioDeVenta es mayor que 0
		if (precioDeVenta > 0)
			// Se asigna al atributo precioDeVenta
			this.precioDeVenta = precioDeVenta;
		// En caso contrario
		else
			// Lanzará esta excepción
			throw new NegativePrecioVentaException();
		// Si el parámetro stock es mayor o igual que 0
		if (stock >= 0)
			// Se asigna al atributo stock
			this.stock = stock;
		// En caso contrario
		else
			// Lanzará esta excepción
			throw new NegativeStockException();
	}

	/**
	 * Funcion que devuelve el valor del atributo codigo
	 * 
	 * @return El codigo del articulo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Funcion que devuelve el valor del atributo descripcion
	 * 
	 * @return La descripcion del articulo
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Funcion que modifica el valor del atributo descripcion
	 * 
	 * @param codigo Nueva descripcion que le asignamos
	 * @throws InvalidDescriptionException Excepcion que indica que la descripcion
	 *                                     es invalida
	 */
	public void setDescripcion(String descripcion) throws InvalidDescriptionException {
		// Si el parámetro descripcion es distinto de null y no es una cadena vacía
		if (descripcion != null && !descripcion.equals(""))
			// Se asigna al atributo descripcion
			this.descripcion = descripcion;
		// En caso contrario
		else
			// Lanzará esta excepción
			throw new InvalidDescriptionException();
	}

	/**
	 * Funcion que devuelve el valor del atributo precioDeCompra
	 * 
	 * @return El precio de compra del articulo
	 */
	public double getPrecioDeCompra() {
		return precioDeCompra;
	}

	/**
	 * Funcion que modifica el valor del atributo precioDeCompra
	 * 
	 * @param codigo Nuevo precio de compra que le asignamos
	 * @throws NegativePrecioCompraException Excepcion que indica que el precio de
	 *                                       compra es negativo
	 */
	public void setPrecioDeCompra(double precioDeCompra) throws NegativePrecioCompraException {
		// Si el parámetro precioDeCompra es mayor que 0
		if (precioDeCompra > 0)
			// Se asigna al atributo precioDeCompra
			this.precioDeCompra = precioDeCompra;
		// En caso contrario
		else
			// Lanzará esta excepción
			throw new NegativePrecioCompraException();
	}

	/**
	 * Funcion que devuelve el valor del atributo precioDeVenta
	 * 
	 * @return El precio de venta del articulo
	 */
	public double getPrecioDeVenta() {
		return precioDeVenta;
	}

	/**
	 * Funcion que modifica el valor del atributo precioDeVenta
	 * 
	 * @param codigo Nuevo precio de venta que le asignamos
	 * @throws NegativePrecioVentaException Excepcion que indica que el precio de
	 *                                      venta es negativo
	 */
	public void setPrecioDeVenta(double precioDeVenta) throws NegativePrecioVentaException {
		// Si el parámetro precioDeVenta es mayor que 0
		if (precioDeVenta > 0)
			// Se asigna al atributo precioDeVenta
			this.precioDeVenta = precioDeVenta;
		// En caso contrario
		else
			// Lanzará esta excepción
			throw new NegativePrecioVentaException();
	}

	/**
	 * Funcion que devuelve el valor del atributo stock
	 * 
	 * @return El stock del articulo
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * Funcion que modifica el valor del atributo stock
	 * 
	 * @param codigo Nuevo stock que le asignamos
	 * @throws NegativeStockException Excepcion que indica que el stock es negativo
	 */
	public void setStock(int stock) throws NegativeStockException {
		// Si el parámetro stock es mayor o igual que 0
		if (stock >= 0)
			// Se asigna al atributo stock
			this.stock = stock;
		// En caso contrario
		else
			// Lanzará esta excepción
			throw new NegativeStockException();
	}

	/**
	 * Metodo toString que devuelve una cadena con la informacion del articulo en
	 * este formato: Codigo: 1 Descripcion: Descripcion del articulo 1 ...
	 * 
	 * @return Devuelve una cadena con la informacion del articulo
	 */
	@Override
	public String toString() {
		// Texto que mostrará la función
		String cadena = "----------------------------------------------\n";

		// Le concatenamos cada dato a nuestra cadena
		cadena += "Código: " + this.codigo + "\n";
		cadena += "Descripción: " + this.descripcion + "\n";
		cadena += "Precio de compra: " + this.precioDeCompra + "\n";
		cadena += "Precio de venta: " + this.precioDeVenta + "\n";
		cadena += "Stock: " + this.stock + "\n";

		// Muestra todos los atributos del objeto de tipo Articulo
		return cadena;
	}

	/**
	 * Metodo equals sobreescrito que compara dos objetos de tipo Articulo y
	 * devuelve true o false segun si los codigos de ambos son iguales o no
	 * 
	 * @return iguales Variable que determina si los dos objetos tienen el mismo
	 *         codigo
	 */
	@Override
	public boolean equals(Object obj) {
		// Variable que devolverá la función, inicializada como false
		boolean iguales = false;

		// Hacemos una copia del parámetro, casteada como tipo Articulo
		Articulo art2 = (Articulo) obj;

		// Si ambos objetos tienen el mismo código
		if (this.codigo.equals(art2.codigo))
			// Asignamos nuestra variable como true
			iguales = true;

		// Devolverá el valor de la variable iguales
		return iguales;
	}

}
