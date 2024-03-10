package Jugadores;
import mazo_cartas_pocima.*;
import atributos.*;
import herramientas.Mensajes;
public class JugadorAmbicioso extends Jugador {
	public JugadorAmbicioso(String nom) {
		super(nom);
	}
	public int getAtributoAlto() {
		Carta aVer = mazo.verCarta();
		int aux = aVer.getAtributoMasAlto();
		return aux;
		}
	
	public Comparador atributoSeleccionado() {
		Comparador comp = null;
		int aux = getAtributoAlto();
		for (int i = 0; i<5; i++) {
			Comparador compAux = comparadores.get(i);
			if(compAux.getNum() == aux) {
				comp = compAux; 
				}
		}
		Mensajes.atributoSelec(this.getNombre(), comp.getNombre());
		return comp;
	}
	
}