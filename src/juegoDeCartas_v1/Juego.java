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
	public int maxRondas;
	public int nroRondas;
	
	public Juego(Mazo m1, Jugador j1, Jugador j2) {
		this(m1, j1, j2, 15);
	}
	public Juego(Mazo m1, Jugador j1, Jugador j2, int rond) {
		mazoGeneral = m1;
		this.j1 = j1;
		this.j2 = j2;
		maxRondas = rond;
		nroRondas = 1;
		comparadores = new ArrayList<>();
		setComparadores();
	}
	/*------------------------------------------JUEGO---------------------------------------------------------*/
	public void jugar() {
		repartir();
		while((nroRondas <= maxRondas) && (j1.cantCartas()>0) && (j2.cantCartas()>0)) {	
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

	public void setRondas(int rondas) {	
		maxRondas = rondas;
	}

	/*------------------------------------REPARTIR-----------------------------------------------------*/
	private void repartir() {	
		Mensajes.imprimirRepartir();
		while(mazoGeneral.quedanCartas()) {
			j1.addCarta(mazoGeneral.repartirCarta());	
			if(mazoGeneral.quedanCartas()) {
				j2.addCarta(mazoGeneral.repartirCarta());
			}
		}
	}

	/*------------------------------------COMPARAR Y ASIGNAR GANADOR-------------------------------*/
	public void comparar() {
		int numComp = elegido.getNum();
		Carta cartaJ1 = j1.jugarCarta();
		Carta cartaJ2 = j2.jugarCarta();

		Mensajes.mostrarCarta(elegido.getNombre(), j1.getNombre(), cartaJ1.getNombre(), cartaJ1.getAtributo(numComp));
		verificarPocimas(cartaJ1);
		Mensajes.mostrarCarta(elegido.getNombre(), j2.getNombre(), cartaJ2.getNombre(), cartaJ2.getAtributo(numComp));
		verificarPocimas(cartaJ2);
		
		int res = elegido.compare(cartaJ1, cartaJ2);
		procesarResultadoRonda(res, cartaJ1, cartaJ2);
		
		nroRondas++;
	}

	private void procesarResultadoRonda(int res, Carta cartaJ1, Carta cartaJ2) {
		if (res == 1) {
			j1.setGanador(true);
			j2.setGanador(false);
			j1.finalDelMazo(cartaJ1);
			j1.finalDelMazo(cartaJ2);
			Mensajes.ganadorRonda(j1.getNombre());
		} else if (res == -1) {
			j2.setGanador(true);
			j1.setGanador(false);
			j2.finalDelMazo(cartaJ2);
			j2.finalDelMazo(cartaJ1);
			Mensajes.ganadorRonda(j2.getNombre());
		} else {
			j1.finalDelMazo(cartaJ1);
			j2.finalDelMazo(cartaJ2);
			Mensajes.empate();
		}
	}
	private void obtenerComparador() {					// AQUI SE LE PIDE AL JUGADOR UN NUMERO DEL 0 AL 5 QUE CORRESPONDE A LOS ATRIBUTOS
		int indx = comparadores.size();
		if(j1.isGanador() == true) {	
			elegido = elegir(j1.atributoSeleccionado(indx));
			Mensajes.atributoSelec(j1.getNombre(), elegido.getNombre());
		}else if(j2.isGanador()== true) {
			elegido = elegir(j2.atributoSeleccionado(indx));
			Mensajes.atributoSelec(j2.getNombre(), elegido.getNombre());
		}else {
			int rand = (int)(Math.random()*comparadores.size());
			elegido = comparadores.get(rand);
			Mensajes.random(elegido.getNombre());
		}
	}
	
	private Comparador elegir(int i) {					//DECIDI IDENTIFICAR A CADA METODO POR UN NUMERO CORRESPONDIENTE Y DE AHI SE ELIGEN
		Comparador eleg = null;
		for(Comparador e: comparadores) {
			if(e.getNum() == i)
				eleg = e;
		}
		return eleg;
	}
	
	public void verificarPocimas(Carta c1) {
		if(c1.usada() != true) {
			c1.aplicarPocima(elegido.getNum());
			c1.seUsoUnaPocima();
		}
	}
	public void setComparadores() {						//PARA EVITAR CUALQUIER PROBLEMA PREFERI METER LA INTANCIA DE LOS COMPARADORES EN UN METODO
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
