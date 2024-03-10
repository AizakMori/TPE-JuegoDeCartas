package Jugadores;
import atributos.*;
import herramientas.Mensajes;

public class JugadorObstinado extends Jugador {
	private Comparador atributoObstinado;
	private boolean selec;
	public JugadorObstinado(String nom) {
		super(nom);
		selec = false;
	}
	
	public Comparador atributoSeleccionado() {
		if(selec == false) {
			int indx = (int)(Math.random()*comparadores.size());
			atributoObstinado = comparadores.get(indx);
			selec = true;
		}
		Mensajes.atributoSelec(this.getNombre(), atributoObstinado.getNombre());
		return atributoObstinado;
	}
}
