package juegoDeCartas_v1;
import java.util.ArrayList;
import Jugadores.*;
import atributos.*;
import mazo_cartas_pocima.*;
import herramientas.*;



public class Juego {
	private Mazo mazoGeneral;
	private Jugador j1;
	private Jugador j2;
	public static int MAXRONDAS = 6;
	public final int MAXJUGADORES = 2;
	public int nroRondas;

	public Juego(Mazo m1, Jugador j1, Jugador j2) {
		mazoGeneral = m1;
		this.j1 = j1;
		this.j2 = j2;
		nroRondas = 1;
	}
	public void jugar() {
		repartir();
		while((nroRondas < MAXRONDAS) && (j1.cantCartas()>0) && (j2.cantCartas()>0)) {
			Mensajes.ronda(nroRondas);
			comparar();		
		}
		Mensajes.finalPartida(j1.getNombre(),j1.cantCartas(), j2.getNombre(),j2.cantCartas());
	}

	public static void setRondas(int rondas) {
		MAXRONDAS = rondas;
	}
	private void repartir() {
		if(nroRondas == 1) {
			Mensajes.imprimirRepartir();
			while(mazoGeneral.quedanCartas()) {
				j1.addCarta(mazoGeneral.repartirCarta());
				if(mazoGeneral.quedanCartas()) {
					j2.addCarta(mazoGeneral.repartirCarta());
				}
			}
		}
	}
	private Comparador obtenerComparador() {
		if(j1.isGanador()) {
			return j1.atributoSeleccionado();
		}else if(j2.isGanador()) {
			return j2.atributoSeleccionado();
		}else {
			if(j1.cantCartas() > j2.cantCartas()) 
				return j2.atributoSeleccionado();
			else 
				return j1.atributoSeleccionado();

		}
	}

	public void comparar() {
		Carta cartaJ1 = j1.jugarCarta();
		Carta cartaJ2 = j2.jugarCarta();
		Comparador comp = obtenerComparador();
		//Mensajes.mostrarComparacion(cartaJ1, cartaJ2, comp.getNombre());
		int resultado = comp.compare(cartaJ1, cartaJ2);
		if(resultado == 1) {
			j1.setGanador(true);
			j1.addCarta(cartaJ2);
			Mensajes.ganadorRonda(j1.getNombre());
		}else if(resultado == -1) {
			j2.setGanador(true);
			j2.addCarta(cartaJ1);
			Mensajes.ganadorRonda(j1.getNombre());
		}else {
			j1.empate(cartaJ1);
			j2.empate(cartaJ2);
			Mensajes.empate();
		}
		nroRondas++;
	}
}
