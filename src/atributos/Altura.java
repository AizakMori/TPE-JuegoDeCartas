package atributos;

import mazo_cartas_pocima.Carta;

public class Altura extends Comparador {
	public Altura() {
		super("Altura");
	}
	@Override
	public int compare(Carta c1, Carta c2) {
		return Double.compare(c1.getAltura(), c2.getAltura());
	}
	@Override
	public int getNum() {
		// TODO Auto-generated method stub
		return 0;
	}
}
