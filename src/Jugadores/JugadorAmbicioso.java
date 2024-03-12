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
	
	public int atributoSeleccionado(int i) {			//BUENO AL AMBICIOSO NO LE INTERESA LA CANTIDAD DE COMPARADORES QUE EXISTEN JAJA
		int aux = getAtributoAlto();
		return aux;
	}
	
}