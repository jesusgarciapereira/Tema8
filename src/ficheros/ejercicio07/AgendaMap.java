package ficheros.ejercicio07;

import java.util.Map;
import java.util.TreeMap;

public class AgendaMap {
	
	static Map<String,Long> agenda = new TreeMap<>();

	public static boolean introducirContacto(String nombre, long telefono) {
		boolean resultado = false;
		
		if(agenda.size() < 20 && !agenda.containsKey(nombre)) {
			agenda.put(nombre, telefono);
			resultado = true;
		}
		
		return resultado;
		
	}
	
	public static long buscarContacto(String nombre) {
		long numero = 0;
		
		if(agenda.containsKey(nombre)) {
			numero = agenda.get(nombre);
		}
		
		return numero;
	}
	
	public static void mostrarTodos() {
		for (Map.Entry<String,Long>  entry : agenda.entrySet()) {
			String key = entry.getKey();
			Long val = entry.getValue();
			System.out.println(key + ": " + val);
			
		}
		
	}
}
