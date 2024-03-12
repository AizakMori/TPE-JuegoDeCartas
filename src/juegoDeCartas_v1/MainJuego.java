package juegoDeCartas_v1;

import Jugadores.*;
import mazo_cartas_pocima.*;
import pocimas.*;

//ASUMI QUE NO SE VAN A AGREGAR NUEVOS ATRIBUTOS A FUTURO POR ENDE DIRECTAMENTE SE CREAN EN LA CLASE JUGADOR PARA QUE ESTE LOS SELECCIONE
public class MainJuego {

	public static void main(String[] args) {
		Mazo m1 = new Mazo();
		Jugador j1 = new Jugador("Luis");
		Jugador j2 = new Jugador("Mary");
		
		//SIMPLIFIQUE LOS ATRIBUTOS A INT
		// NOMBRE // ALTURA EN CM // PESO EN KG // VELOCIDAD // FUERZA  // PELEASGANADAS
		Carta c1 = new Carta("Superman", 183, 100, 2000, 10000, 100 );		
		Carta c2 = new Carta("Batman", 180, 80, 30, 90, 85 );
		Carta c3 = new Carta("Acuaman", 185, 83, 50, 110, 70 );
		Carta c4 = new Carta("WorderWoman", 179, 72, 100, 150, 90 );
		Carta c5 = new Carta("Robin Damian Wane", 155, 51, 25, 40, 10 );
		Carta c7 = new Carta("Robin Dick Grayson", 180, 80, 30, 90, 70);
		Carta c6 = new Carta("Cyborg", 190, 150, 90, 110, 50 );
		Carta c8 = new Carta("Raven", 170, 55, 120, 150, 25 );
		Carta c9 = new Carta("Starfire", 180, 70, 150, 100, 75);
		Carta c10 = new Carta("Chico bestia", 170, 65, 150, 300, 20);
		Carta c11 = new Carta("Terra", 170, 60, 25, 90, 10);
		m1.addCarta(c1);
		m1.addCarta(c2);
		m1.addCarta(c3);
		m1.addCarta(c4);
		m1.addCarta(c5);
		m1.addCarta(c6);
		m1.addCarta(c7);
		m1.addCarta(c8);
		m1.addCarta(c9);
		m1.addCarta(c10);
		m1.addCarta(c11);
		
		Pocima p2 = new PocimaMagica();
		Pocima p3 = new PocimaMagica();
		Pocima p4 = new PocimaMagica();
		Pocima p1 = new PocimaDebilitadora();
		Pocima p5 = new PocimaDebilitadora();
		Pocima p6 = new PocimaDebilitadora();
		m1.addPocima(p1);
		m1.addPocima(p2);
		m1.addPocima(p3);
		m1.addPocima(p4);
		m1.addPocima(p5);
		m1.addPocima(p6);
		
		Juego game = new Juego(m1, j1, j2);  //MAZO / JUGADOR 1 / JUGADOR 2
		game.jugar();
	}
}
