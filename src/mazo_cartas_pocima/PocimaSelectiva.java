package mazo_cartas_pocima;

public class PocimaSelectiva extends Pocima {
	public static int CANTIDAD = 25;
	public PocimaSelectiva() {
		this("PocimaSelectiva", 23);
	}
	public PocimaSelectiva(String nom, int i) {
		super(nom);
		setNumeroMagico(i);
	}
	public static void setNumeroMagico(int num) {
		CANTIDAD = num;
	}
	@Override
	public void aplicar(Carta c) {
		// TODO Auto-generated method stub

	}

}
