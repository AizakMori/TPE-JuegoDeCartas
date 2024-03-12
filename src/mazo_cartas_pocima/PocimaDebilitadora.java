package mazo_cartas_pocima;

public class PocimaDebilitadora extends Pocima {
	public  int porcentaje;
	public PocimaDebilitadora() {
		this("Debilitadora", 50);
	}
	public PocimaDebilitadora(String nom, int num) {
		super(nom);
		porcentaje = num;
	}
	public void aplicar(Carta c) {
		System.out.println("Se aplico pocima debilitadora");
		int fuerzaOr = c.getFuerza();
		int alturaOr = c.getAltura();
		int pesoOr = c.getPeso();
		int peleaOr = c.getPeleasGanadas();
		int veloOr = c.getVelocidad();

		int aux1 = (alturaOr - ((alturaOr * porcentaje)/100));
		int aux2 = (pesoOr - ((pesoOr * porcentaje)/100));
		int aux3 = (veloOr - ((veloOr * porcentaje)/100));
		int aux4 = (fuerzaOr - ((fuerzaOr * porcentaje)/100));
		int aux5 = (peleaOr - ((peleaOr * porcentaje)/100));
		c.setAltura(aux1);
		c.setPeso(aux2);
		c.setVelocidad(aux3);
		c.setFuerza(aux4);
		c.setPeleasGanadas(aux5);
		/*System.out.println(aux1);
		System.out.println(aux2);
		System.out.println(aux3);
		System.out.println(aux4);
		System.out.println(aux5);*/
	}

}
