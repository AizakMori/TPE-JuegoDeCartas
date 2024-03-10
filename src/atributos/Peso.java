package atributos;

import mazo_cartas_pocima.Carta;

public class Peso extends Comparador {
	public Peso() {
		super("Peso");
	}
	@Override
	public int compare(Carta c1, Carta c2) {
		return Double.compare(c1.getPeso(), c2.getPeso());
	}

}
