package atributos;

import juegoDeCartas_v1.Carta;

public class Fuerza extends Comparador {
	public final String NOMBRE = "Fuerza";
	public Fuerza() {
		super("Fuerza");
	}
	@Override
	public int compare(Carta c1, Carta c2) {
		return Double.compare(c1.getFuerza(), c2.getFuerza());
	}
}
