package juegoDeCartas_v1;
import java.util.ArrayList;

import Jugadores.*;
import atributos.*;
import mazo_cartas_pocima.*;
import herramientas.*;



public class Juego {
	private Mazo mazoGeneral;
	private ArrayList<Comparador> comparadores;
	private Comparador elegido;
	private Jugador j1;
	private Jugador j2;
	public static int MAXRONDAS = 20;
	public int nroRondas;

	public Juego(Mazo m1, Jugador j1, Jugador j2) {
		mazoGeneral = m1;
		this.j1 = j1;
		this.j2 = j2;
		nroRondas = 1;
		comparadores = new ArrayList<>();
		setComparadores();
	}
	public void jugar() {
		repartir();
		while((nroRondas < MAXRONDAS) && (j1.cantCartas()>0) && (j2.cantCartas()>0)) {	
			Mensajes.ronda(nroRondas);
			obtenerComparador();
			comparar();
			Mensajes.finalRonda(j1.getNombre(),j1.cantCartas(), j2.getNombre(),j2.cantCartas());
		}
		if(j1.cantCartas()>j2.cantCartas())
			Mensajes.finDePartida(j1.getNombre());
		else
			Mensajes.finDePartida(j2.getNombre());
	}

	public static void setRondas(int rondas) {	
		MAXRONDAS = rondas;
	}

	private void repartir() {	
		Mensajes.imprimirRepartir();
		while(mazoGeneral.quedanCartas()) {
			j1.addCarta(mazoGeneral.repartirCarta());	
			if(mazoGeneral.quedanCartas()) {
				j2.addCarta(mazoGeneral.repartirCarta());
			}
		}
	}

	private void obtenerComparador() {
		int indx = comparadores.size();
		if(j1.isGanador()) {	
			elegido = comparadores.get(j1.atributoSeleccionado(indx));
		}else if(j2.isGanador()) {
			elegido = comparadores.get(j2.atributoSeleccionado(indx));
		}else {
			if(j1.cantCartas() > j2.cantCartas()) 
				elegido = comparadores.get(j1.atributoSeleccionado(indx));
			else 
				elegido = comparadores.get(j2.atributoSeleccionado(indx));
		}
	}

	public void comparar() {	
		int numComp = elegido.getNum();
		Carta cartaJ1 = j1.jugarCarta();
		Carta cartaJ2 = j2.jugarCarta();
		cartaJ1.getDatos(numComp, j1.getNombre());
		cartaJ2.getDatos(numComp, j2.getNombre());
		verificarPocimas(cartaJ1, cartaJ2);
		int resultado = elegido.compare(cartaJ1, cartaJ2);										
		if(resultado == 1) {
			j1.setGanador(true);
			j1.finalDelMazo(cartaJ1);
			j1.finalDelMazo(cartaJ2);
			Mensajes.ganadorRonda(j1.getNombre());
		}else if(resultado == -1) {
			j2.setGanador(true);
			j2.finalDelMazo(cartaJ2);
			j2.finalDelMazo(cartaJ1);
			Mensajes.ganadorRonda(j2.getNombre());
		}else {
			j1.finalDelMazo(cartaJ1);
			j2.finalDelMazo(cartaJ2);
			Mensajes.empate();
		}
		nroRondas++;
	}
	public void verificarPocimas(Carta c1, Carta c2) {
		if(c1.usada() != true) {
			c1.aplicarPocima(numComp);
			c1.getDatos(numComp, j1.getNombre());			
		}
		if(c1.usada()!= true) {
			c1.aplicarPocima(numComp);
			c1.getDatos(numComp, j2.getNombre());			
		}
	}
	public void setComparadores() {
		Comparador comp2 = new Altura();
		Comparador comp3 = new Peso();
		Comparador comp4 = new Velocidad();
		Comparador comp1 = new Fuerza();
		Comparador comp5 = new Peleas_Ganadas();
		
		comparadores.add(comp1);
		comparadores.add(comp2);
		comparadores.add(comp3);
		comparadores.add(comp4);
		comparadores.add(comp5);
	}
}
