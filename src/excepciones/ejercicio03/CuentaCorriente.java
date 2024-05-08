package excepciones.ejercicio03;

/**
 * Clase que representa la cuenta corriente
 */
public class CuentaCorriente {

	/**
	 * DNI del titular de la cuenta
	 */
	private String dni = "";
	/**
	 * Nombre del titular de la cuenta
	 */
	private String nombre = "";
	/**
	 * Saldo de la cuenta
	 */
	private double saldo;

	/**
	 * Constructor con el DNI del titular de la cuenta como parametro
	 * 
	 * @param dni DNI del titular de la cuenta
	 * @throws InvalidDniException Excepcion que indica que el dni es invalido
	 */
	public CuentaCorriente(String dni) throws InvalidDniException {
		// El parámetro dni, no admitirá null ni caracter vacío
		if (dni != null && !dni.equals(""))
			this.dni = dni;
		// En caso contrario
		else
			// Lanzará esta excepción
			throw new InvalidDniException();
	}

	/**
	 * Constructor con todos los atributos como parametro
	 * 
	 * @param dni    DNI del titular de la cuenta
	 * @param nombre Nombre del titular de la cuenta
	 * @param saldo  Saldo inicial de la cuenta
	 * @throws InvalidDniException    Excepcion que indica que el dni es invalido
	 * @throws InvalidNameException   Excepcion que indica que el nombre es invalido
	 * @throws NegativeSaldoException Excepcion que indica que el saldo es negativo
	 */
	public CuentaCorriente(String dni, String nombre, double saldo)
			throws InvalidDniException, InvalidNameException, NegativeSaldoException {
		// Para el dni, llama al constructor con un solo parámetro
		this(dni);
		// El parámetro nombre, no admitirá null ni caracter vacío
		if (nombre != null && !nombre.equals(""))
			this.nombre = nombre;
		// En caso contrario
		else
			// Lanzará esta excepción
			throw new InvalidNameException();
		// El parámetro saldo, debe ser mayor o igual que 0
		if (saldo >= 0)
			this.saldo = saldo;
		// En caso contrario
		else
			// Lanzará esta excepción
			throw new NegativeSaldoException();

	}

	/**
	 * Metodo que devuelve el valor del dni de la cuenta
	 * 
	 * @return Valor del atributo dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Metodo que devuelve el valor del nombre de la cuenta
	 * 
	 * @return Valor del atributo nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo que modifica el valor del nombre por el dato introducido en el
	 * parametro
	 * 
	 * @param nombre Nuevo nombre que se le asigna
	 * @throws InvalidNameException
	 */
	public void setNombre(String nombre) throws InvalidNameException {
		// El parámetro nombre, no admitirá null ni caracter vacío
		if (nombre != null && !nombre.equals(""))
			this.nombre = nombre;
		// En caso contrario
		else
			// Lanzará esta excepción
			throw new InvalidNameException();
	}

	/**
	 * Metodo que devuelve el valor del saldo de la cuenta
	 * 
	 * @return Valor del atributo saldo
	 */
	public double getSaldo() {
		return saldo;
	}

	/**
	 * Metodo que modifica el valor del saldo por el dato introducido en el
	 * parametro
	 * 
	 * @param nombre Nuevo saldo que se le asigna
	 * @throws NegativeSaldoException
	 */
	public void setSaldo(double saldo) throws NegativeSaldoException {
		// El parámetro saldo, debe ser mayor o igual que 0
		if (saldo >= 0)
			this.saldo = saldo;
		// En caso contrario
		else
			// Lanzará esta excepción
			throw new NegativeSaldoException();
	}

	/**
	 * Metodo toString sobreescrito
	 */
	@Override
	public String toString() {
		// Cadena que devolverá la función
		String cadena = "--------------------------\n";

		// Le concatenamos cada uno de los datos
		cadena += "Titular de la cuenta: " + this.nombre + "\n";
		cadena += "DNI del titular " + this.dni + "\n";
		cadena += "Saldo actual: " + this.saldo + "€\n";

		// Devolverá la cadena completa
		return cadena;
	}

	/**
	 * Metodo equals sobreescrito
	 */
	@Override
	public boolean equals(Object obj) {
		// Variable que determina si ambos objetos son iguales
		boolean iguales = false;

		// Hacemos una copia del parámetro y lo casteamos como tipo CuentaCorriente
		CuentaCorriente cuenta2 = (CuentaCorriente) obj;

		// Si ambos objetos tienen el mismo dni
		if (this.dni.equals(cuenta2.dni))
			// Asignamos iguales como true
			iguales = true;

		// Devolverá el valor de iguales
		return iguales;
	}
}
