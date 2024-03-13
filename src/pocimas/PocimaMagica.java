package pocimas;
import mazo_cartas_pocima.*;

public class PocimaMagica extends Pocima {
	public int numMagico;
	public PocimaMagica() {
		this("Pocima Magica", 25);
	}
	public PocimaMagica(String nom, int i) {
		super(nom);
		numMagico = i;
	}
	@Override
	public void aplicar(Carta c, int i) {
		c.setAltura(numMagico);
		c.setFuerza(numMagico);
		c.setPeleasGanadas(numMagico);
		c.setPeso(numMagico);
		c.setVelocidad(numMagico);
	}
	public void setNumero(int j) {
		numMagico = j;
	}
}
