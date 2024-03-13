package pocimas;

import mazo_cartas_pocima.Carta;

public class PocimaMagica extends Pocima {
	public static int NUMMAGICO = 25;
	public PocimaMagica() {
		super("Pocima Magica");
	}
	public PocimaMagica(String nom, int i) {
		super(nom);
		setNumero(i);
	}
	@Override
	public void aplicar(Carta c, int i) {
		c.setAltura(NUMMAGICO);
		c.setFuerza(NUMMAGICO);
		c.setPeleasGanadas(NUMMAGICO);
		c.setPeso(NUMMAGICO);
		c.setVelocidad(NUMMAGICO);
	}
	public static void setNumero(int j) {
		NUMMAGICO = j;
	}
}
