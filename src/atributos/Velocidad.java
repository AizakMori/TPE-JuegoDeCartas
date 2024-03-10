package atributos;

import mazo_cartas_pocima.Carta;

public class Velocidad extends Comparador {
	public Velocidad() {
		super("Velocidad");
	}
	@Override
	public int compare(Carta c1, Carta c2) {
		return Double.compare(c1.getVelocidad(), c2.getVelocidad());
	}
	@Override
	public int getNum() {
		// TODO Auto-generated method stub
		return 2;
	}
	
}
