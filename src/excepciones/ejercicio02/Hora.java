package excepciones.ejercicio02;

/**
 * Clase que representa el instante de tiempo compuesto por la hora y los
 * minutos
 */
public class Hora {

	/**
	 * Numero que representa las horas
	 */
	protected int hora;
	/**
	 * Numero que representa los minutos
	 */
	protected int minuto;

	/**
	 * Constructor con todos los atributos
	 * 
	 * @param hora   Numero de las horas
	 * @param minuto Numero de los minutos
	 */
	public Hora(int hora, int minuto) {
		// Para las horas, sólo admitirá números del 0 al 23
		if (hora >= 0 && hora <= 23)
			this.hora = hora;
		// Para los minutos, sólo admitirá números del 0 al 59
		if (minuto >= 0 && minuto <= 59)
			this.minuto = minuto;
	}

	/**
	 * Funcion que incrementa la hora en un minuto
	 */
	public void inc() {
		// Incrementamos el número de minutos
		this.minuto++;

		// Si ahora el minuto es 60
		if (this.minuto == 60) {
			// Pasa a ser 0
			this.minuto = 0;
			// Y la hora se incrementa
			this.hora++;
			
			// Y si, ahora, la hora es 24
			if (this.hora == 24) {
				// Ésta también pasa a ser 0
				this.hora = 0;
			}
		}

	}

	/**
	 * Indica si es posible o no asignar a los minutos el valor del atributo, si es
	 * posible lo modifica
	 * 
	 * @param valor Nuevo valor a asignar a los minutos
	 * @return True o false segun si se ha podido llevar a cabo la modificacion
	 */
	public boolean setMinutos(int valor) {

		// Variable que indica si se ha hecho la operación, inicializada como false
		boolean hecho = false;

		// Si el valor está entre 0 y 59
		if (valor >= 0 && valor <= 59) {
			// Lo asignamos al minuto
			this.minuto = valor;
			// Y hecho será true
			hecho = true;
		}

		// Devuelve el valor de hecho
		return hecho;

	}

	/**
	 * Indica si es posible o no asignar a las horas el valor del atributo, si es
	 * posible lo modifica
	 * 
	 * @param valor Nuevo valor a asignar a las horas
	 * @return True o false segun si se ha podido llevar a cabo la modificacion
	 */
	public boolean setHora(int valor) {

		// Variable que indica si se ha hecho la operación, inicializada como false
		boolean hecho = false;

		// Si el valor está entre 0 y 59
		if (valor >= 0 && valor <= 23) {
			// Lo asignamos a la hora
			this.hora = valor;
			// Y hecho será true
			hecho = true;
		}

		// Devuelve el valor de hecho
		return hecho;

	}

	/**
	 * Metodo toString() sobreescrito para que muestre la hora en su correspondiente
	 * formato
	 */
	@Override
	public String toString() {

		// Cadena que devolverá la función
		String cadena = "";

		// Si la hora es menor que 10
		if (this.hora < 10)
			// Se concatena un 0
			cadena += "0";

		// Concatenamos la hora con dos puntos
		cadena += this.hora + ":";

		// Si el minuto es menor que 10
		if (this.minuto < 10)
			// Se concatena un 0
			cadena += "0";

		// Concatenamos el minuto
		cadena += this.minuto;

		// Devuelve la cadena creada
		return cadena;
	}

}
