package mazo_cartas_pocima;

public class PocimaFortalecedora extends Pocima {
	public  int porcentaje;
	public PocimaFortalecedora() {
		this("Fortalecedora", 25);
	}
	public PocimaFortalecedora(String nom, int i) {
		super(nom);
		porcentaje = i;
	}
	@Override
	public void aplicar(Carta c) {
		System.out.println("Se aplico pocima fortalecedora");
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

		int aux1 = alturaOr + res1;
		int aux2 = pesoOr + res2;
		int aux3 = veloOr + res3;
		int aux4 = fuerzaOr + res4;
		int aux5 = peleaOr + res5;
		c.setAltura(aux1);
		c.setPeso(aux2);
		c.setVelocidad(aux3);
		c.setFuerza(aux4);
		c.setPeleasGanadas(aux5);
		System.out.println(res4);
	}
}
