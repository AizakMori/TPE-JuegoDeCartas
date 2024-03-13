package Jugadores;
import mazo_cartas_pocima.*;

public class JugadorAmbicioso extends Jugador {
	public JugadorAmbicioso(String nom) {
		super(nom);
	}
	public int getAtributoAlto() {
			Carta c = mazo.verCarta();
			int max = c.getAltura();
			int numAt = 0;
			if((c.getPeso()) > max) {
				max = c.getPeso();
				numAt = 1;
			}
			if((c.getVelocidad()) > max) {
				max = c.getVelocidad();
				numAt = 2;
			}
			if((c.getFuerza()) > max) {
				max=c.getFuerza();
				numAt = 3;
			}
			if((c.getPeleasGanadas())>max) {
				max= c.getPeleasGanadas();
				numAt = 4;
			}
			return numAt;
		}
	
	public int atributoSeleccionado(int i) {			//BUENO AL AMBICIOSO NO LE INTERESA LA CANTIDAD DE COMPARADORES QUE EXISTEN JAJA
		int aux = getAtributoAlto();
		return aux;
	}
	
}