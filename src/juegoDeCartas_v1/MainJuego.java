package juegoDeCartas_v1;

import Jugadores.Jugador;
import atributos.Altura;
import atributos.Comparador;
import atributos.Fuerza;
import atributos.Peleas_Ganadas;
import atributos.Peso;
import atributos.Velocidad;
import mazo_cartas_pocima.Carta;
import mazo_cartas_pocima.Mazo;

public class MainJuego {

	public static void main(String[] args) {
		Mazo m1 = new Mazo();
		Jugador j1 = new Jugador("Luis");
		Jugador j2 = new Jugador("Mary");
		
		
		
		Carta c1 = new Carta("Superman", 1.83, 100.0, 2000, 10000, 100 );	// NOMBRE // ALTURA // PESO // VELOCIDAD // FUERZA  // PELEASGANADAS
		Carta c2 = new Carta("Batman", 1.80, 80.0, 30, 90, 85 );
		Carta c3 = new Carta("Acuaman", 1.85, 83.0, 50, 100, 70 );
		Carta c4 = new Carta("WorderWoman", 1.79, 72.0, 100, 150, 90 );
		Carta c5 = new Carta("Robin", 1.55, 51.0, 25, 40, 10 );
		Carta c6 = new Carta("Cyborg", 1.90, 150.0, 90, 110, 50 );
		m1.addCarta(c1);
		m1.addCarta(c2);
		m1.addCarta(c3);
		m1.addCarta(c4);
		m1.addCarta(c5);
		m1.addCarta(c6);
		
		Juego game = new Juego(m1, j1, j2);  //MAZO / JUGADOR 1 / JUGADOR 2
		game.jugar();
	}
}
