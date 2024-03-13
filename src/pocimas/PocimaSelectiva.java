package pocimas;
import mazo_cartas_pocima.*;

public class PocimaSelectiva extends Pocima {
	private int atributoSelec;
	private int modificador;
	
	public PocimaSelectiva() {
		this("SelectivaVelocidad",35,2);
	}
	public PocimaSelectiva(String nom, int num, int at) {
		super(nom);
		modificador = num;
		atributoSelec = at;
	}
	
	@Override
	public void aplicar(Carta c, int i) {
		if(i == atributoSelec) {
			switch(atributoSelec) {
			case 0:
				int altura = c.getAltura();
				c.setAltura(altura + porcentaje(altura));
				break;
			case 1:
				int peso = c.getPeso();
				c.setPeso(peso + porcentaje(peso));
				break;
			case 2:
				int vel = c.getVelocidad();
				c.setVelocidad(vel + porcentaje(vel));
				break;
			case 3:
				int fuerza = c.getFuerza();
				c.setFuerza(fuerza + porcentaje(fuerza));
				break;
			case 4:
				int peleas = c.getPeleasGanadas();
				c.setPeleasGanadas(peleas + porcentaje(peleas));
				break;
			default:
				break;
			
			}
		}
	}
	public int porcentaje(int i) {
		return (int)((i * modificador)/100);
	}

}
