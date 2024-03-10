package atributos;

import mazo_cartas_pocima.Carta;

public class Peleas_Ganadas extends Comparador {
	public Peleas_Ganadas() {
		super("Peleas Ganadas");
	}
	@Override
	public int compare(Carta c1, Carta c2) {
		return Integer.compare(c1.getPeleasGanadas(), c2.getPeleasGanadas());
	}
	@Override
	public int getNum() {
		// TODO Auto-generated method stub
		return 4;
	}

}
