package pocimas;

import mazo_cartas_pocima.Carta;

public class PocimaMagica extends Pocima {
	public static int NUMMAGICO = 4;
	public PocimaMagica() {
		super("Pocima Magica");
	}
	public PocimaMagica(String nom) {
		super(nom);
	}
	@Override
	public void aplicar(Carta c) {
		imprimir();
		c.setAltura(NUMMAGICO);
		c.setFuerza(NUMMAGICO);
		c.setPeleasGanadas(NUMMAGICO);
		c.setPeso(NUMMAGICO);
		c.setVelocidad(NUMMAGICO);
	}
	public static void setNumeroMagico(int num) {
		NUMMAGICO = num;
	}
}
