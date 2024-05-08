package excepciones.ejercicio02;

/**
 * Clase que representa la hora exacta, es la superclase Hora incluyendo los
 * segundos
 */
public class HoraExacta extends Hora {

	/**
	 * Numero que representa los segundos
	 */
	private int segundo;

	/**
	 * Constructor con todos los parametros, incluidos los heredados
	 * 
	 * @param hora    Numero de las horas
	 * @param minuto  Numero de los minutos
	 * @param segundo Numero de los segundos
	 */
	public HoraExacta(int hora, int minuto, int segundo) {
		// Llama al constructor de la superclase con las horas y los minutos
		super(hora, minuto);
		// Para los segundos, sólo admitirá números del 0 al 59
		if (segundo >= 0 && segundo <= 59)
			this.segundo = segundo;
	}

	/**
	 * Indica si es posible o no asignar a los segundos el valor del atributo, si es
	 * posible lo modifica
	 * 
	 * @param valor Nuevo valor a asignar a los segundos
	 * @return True o false segun si se ha podido llevar a cabo la modificacion
	 */
	public boolean setSegundo(int valor) {

		// Variable que indica si se ha hecho la operación, inicializada como false
		boolean hecho = false;

		// Si el valor está entre 0 y 59
		if (valor >= 0 && valor <= 59) {
			// Lo asignamos al minuto
			this.segundo = valor;
			// Y hecho será true
			hecho = true;
		}

		// Devuelve el valor de hecho
		return hecho;

	}

	/**
	 * Funcion que incrementa la hora en un segundo
	 */
	@Override
	public void inc() {
		// Incrementamos el número de segundos
		this.segundo++;

		// Si ahora el segundo es 60
		if (this.segundo == 60) {
			// Pasa a ser 0
			this.segundo = 0;
			// Y llama al método inc() de la superclase para incrementar el minuto
			super.inc();
		}

	}

	/**
	 * Metodo toString() sobreescrito para que muestre la hora en su correspondiente
	 * formato, incluidos los segundos
	 */
	@Override
	public String toString() {
		// Cadena que devolverá la función
		String cadena = "";

		// Le concatenamos el valor devuelto por el método toString de la superclase con
		// dos puntos
		cadena += super.toString() + ":";

		// Si el segundo es menor que 10
		if (this.segundo < 10)
			// Se concatena un 0
			cadena += "0";

		// Concatenamos el segundo
		cadena += this.segundo;

		// Devuelve la cadena creada
		return cadena;
	}
}
