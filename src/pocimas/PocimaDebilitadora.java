package pocimas;

import mazo_cartas_pocima.Carta;

public class PocimaDebilitadora extends Pocima {
	public  int porcentaje;
	public PocimaDebilitadora() {
		this("Debilitadora", 35);
	}
	public PocimaDebilitadora(String nom, int num) {
		super(nom);
		porcentaje = num;
	}
	public void aplicar(Carta c, int i) {
		int fuerzaOr = c.getFuerza();
		int alturaOr = c.getAltura();
		int pesoOr = c.getPeso();
		int peleaOr = c.getPeleasGanadas();
		int veloOr = c.getVelocidad();
		int res1 = (int)((alturaOr * porcentaje) / 100);
		int res2 = (int)((pesoOr * porcentaje) / 100);
		int res3 = (int)((veloOr * porcentaje) / 100);
		int res4 = (int)((fuerzaOr * porcentaje) / 100);
		int res5 = (int)((peleaOr * porcentaje) / 100);

		int aux1 = alturaOr - res1;
		int aux2 = pesoOr - res2;
		int aux3 = veloOr - res3;
		int aux4 = fuerzaOr - res4;
		int aux5 = peleaOr - res5;
		c.setAltura(aux1);
		c.setPeso(aux2);
		c.setVelocidad(aux3);
		c.setFuerza(aux4);
		c.setPeleasGanadas(aux5);
	}
}
