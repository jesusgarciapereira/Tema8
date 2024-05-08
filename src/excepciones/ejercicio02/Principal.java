package excepciones.ejercicio02;

public class Principal {

	public static void main(String[] args) {

		try {
			Hora h1 = new Hora(16, 35);
			Hora h2 = new HoraExacta(20, 23, 46);

			System.out.println(h1);
			System.out.println(h2);
			
			h1.setMinutos(2);
			h2.setHora(10);
			((HoraExacta) h2).setSegundo(-34);
			
		} catch (NegativeHourException e) {
			System.out.println(e.toString());

		} catch (NegativeMinuteException e) {
			System.out.println(e.toString());

		} catch (NegativeSecondException e) {
			System.out.println(e.toString());
		}
		
	}
}
