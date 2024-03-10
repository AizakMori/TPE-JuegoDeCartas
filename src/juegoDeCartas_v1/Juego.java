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
	public static int MAXRONDAS = 20;
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
		Comparador comp = obtenerComparador();															
		Carta cartaJ1 = j1.jugarCarta();															
		Carta cartaJ2 = j2.jugarCarta();
		int resultado = comp.compare(cartaJ1, cartaJ2);										
		getDatos(comp.getNombre(), cartaJ1, cartaJ2);
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
	
	public void getDatos(String tipoAtributo, Carta cartaj1, Carta cartaj2) {
		switch(tipoAtributo) {
		case "Fuerza": 
			System.out.println("La carta de " + j1.getNombre() + " es " + cartaj1.getNombre() + " con " + tipoAtributo + ": " + cartaj1.getFuerza() );
			System.out.println("La carta de " + j2.getNombre() + " es " + cartaj2.getNombre() + " con " + tipoAtributo + ": " + cartaj2.getFuerza() );
			break;
		case "Altura":
			System.out.println("La carta de " + j1.getNombre() + " es " + cartaj1.getNombre() + " con " + tipoAtributo + ": " + cartaj1.getAltura() );
			System.out.println("La carta de " + j2.getNombre() + " es " + cartaj2.getNombre() + " con " + tipoAtributo + ": " + cartaj2.getAltura() );
			break;
		case "Peleas Ganadas":
			System.out.println("La carta de " + j1.getNombre() + " es " + cartaj1.getNombre() + " con " + tipoAtributo + ": " + cartaj1.getPeleasGanadas() );
			System.out.println("La carta de " + j2.getNombre() + " es " + cartaj2.getNombre() + " con " + tipoAtributo + ": " + cartaj2.getPeleasGanadas() );
			break;
		case "Velocidad":
			System.out.println("La carta de " + j1.getNombre() + " es " + cartaj1.getNombre() + " con " + tipoAtributo + ": " + cartaj1.getVelocidad() );
			System.out.println("La carta de " + j2.getNombre() + " es " + cartaj2.getNombre() + " con " + tipoAtributo + ": " + cartaj2.getVelocidad() );
			break;
		case "Peso":
			System.out.println("La carta de " + j1.getNombre() + " es " + cartaj1.getNombre() + " con " + tipoAtributo + ": " + cartaj1.getPeso() );
			System.out.println("La carta de " + j2.getNombre() + " es " + cartaj2.getNombre() + " con " + tipoAtributo + ": " + cartaj2.getPeso() );
			break;
		default:
			break;
		}
	}
}
