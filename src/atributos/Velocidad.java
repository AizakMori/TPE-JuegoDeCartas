package atributos;

import juegoDeCartas_v1.Carta;

public class Velocidad extends Comparador {
	public Velocidad() {
		super("Velocidad");
	}
	@Override
	public int compare(Carta c1, Carta c2) {
		return Double.compare(c1.getVelocidad(), c2.getVelocidad());
	}

}
