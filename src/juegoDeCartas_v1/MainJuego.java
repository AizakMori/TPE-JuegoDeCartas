package juegoDeCartas_v1;

import Jugadores.*;
import mazo_cartas_pocima.*;
import pocimas.*;

//ASUMI QUE NO SE VAN A AGREGAR NUEVOS ATRIBUTOS A FUTURO POR ENDE DIRECTAMENTE SE CREAN EN LA CLASE JUGADOR PARA QUE ESTE LOS SELECCIONE
public class MainJuego {

	public static void main(String[] args) {
		Mazo m1 = new Mazo();
		Jugador j1 = new Jugador("Luis");
		Jugador j2 = new JugadorAmbicioso("Mary");
		
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
		//-----------------------AÑADIDO DE CARTAS AL MAZO----------------------------------------
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
		//---------------------CREACION DE POCIMAS-------------------------------------
		Pocima p1 = new PocimaFortalecedora();			//POCIMA DE SERIE VIENE CON 35% DE EFECTO BASE A TODOS LOS ATRIBUTOS
		Pocima p2 = new PocimaFortalecedora();			//POCIMA PERSONALIZADA CON NOMBRE Y PORCENTAJE EN INT DE EFECTO EN TODOS LOS ATRIBUTOS
		Pocima p3 = new PocimaMagica();					//POCIMA DE SERIE TODOS LOS ATRIBUTOS A 25
		Pocima p4 = new PocimaMagica("Mucha potencia magica", 500);		//POCIMA PERSONALIZADA TODOS LOS ATRIBUTOS ELEGIDOS
		Pocima p5 = new PocimaDebilitadora();							//POCIMA DE SERIE RESTA UN 35% EN TODOS LOS ATRIBUTOS
		Pocima p6 = new PocimaDebilitadora("NERF THIS", 75);			//POCIMA PERSONALIZADA RESTA EN INT TODOS LOS ATRIBUTOS 
		Pocima p7 = new PocimaSelectiva();				//POCIMA DE SERIE VIENE CON UN 35% AL ATRIBUTO VELOCIDAD SI ES ELEGIDO EN LA RONDA
		//PARAMETROS(NOMBRE / EFECTO EN INT / ATRIBUTO: 0.ALTURA 1.PESO 2.VELOCIDAD 3.FUERZA 4.PELEAS GANADAS)
		Pocima p8 = new PocimaSelectiva("MAGIA A LA FUERZA", 50, 3);				//CASO ESPECIAL POCIMA SELECTIVA PERSONALIZADA
		
		//-------------AÑADIDO DE LAS POCIMAS COCKTAIL-------
		PocimaCocktail p9 = new PocimaCocktail("La Poderosa");
		PocimaCocktail p10 = new PocimaCocktail("Trago amargo");
		p10.addPocima(p5);
		p10.addPocima(p6);
		p10.addPocima(p7);
		p9.addPocima(p1);
		p9.addPocima(p4);
		p9.addPocima(p7);
		//---------------ADD DE POCIMAS AL MAZO------------
		m1.addPocima(p1);
		m1.addPocima(p2);
		m1.addPocima(p3);
		m1.addPocima(p4);
		m1.addPocima(p5);
		m1.addPocima(p6);
		m1.addPocima(p7);
		m1.addPocima(p8);
		m1.addPocima(p9);
		//---------------INICIO DE JUEGO-----------------
		Juego game = new Juego(m1, j1, j2);  //MAZO / JUGADOR 1 / JUGADOR 2
		game.setRondas(20);					//RONDAS DEFAULT 15 SE PUEDE CAMBIAR
		game.jugar();
	}
}
