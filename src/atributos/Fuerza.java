package atributos;

import mazo_cartas_pocima.Carta;

public class Fuerza extends Comparador {
	public Fuerza() {
		super("Fuerza");
	}
	@Override
	public int compare(Carta c1, Carta c2) {
		return Double.compare(c1.getFuerza(), c2.getFuerza());
	}
	@Override
	public int getNum() {
		// TODO Auto-generated method stub
		return 3;
	}
}
