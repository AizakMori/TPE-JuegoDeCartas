package juegoDeCartas_v1;

import atributos.Comparador;
//import herramientas.Mensajes;

public class Juego {
	private Mazo mazoGeneral;
	private Jugador j1;
	private Jugador j2;
	private Comparador atributo;
	private boolean primeraRonda;
	private boolean partidaTerminada;
	public static int MAXRONDAS = 6;
	public int nroRondas;
	
	private String SEPARADORRONDA = "-------------------- ronda " ;
	private String SEPARADOR = " -------------------- ";
	private final String GANADOR = "Gana la ronda: ";
	private final String EMPATE = "Hubo empate, conservan sus cartas";
	private final String POSEE = " posee: ";
	private final String REPARTIR = "Repartiendo del mazo a los jugadores...";
	private final String SELECCION = "Se selecciono competir por el atributo: ";
	private final String GANADORPARTIDA = "GANADOR DE ESTA PARTIDA ES: ";


	public Juego(Mazo m1, Jugador j1, Jugador j2) {
		mazoGeneral = m1;
		this.j1 = j1;
		this.j2 = j2;
		primeraRonda = true;
		partidaTerminada = false;
		nroRondas = 1;
	}
	public void comenzarJuego() {
		repartir();
	}
	public void continuarJuego() {
		if(partidaTerminada != true) {
			limpiarGanador();
			comparar();
			mostrarGanador();
			mostrarCantCartas();
		}
	}
	public static void setRondas(int rondas) {
		MAXRONDAS = rondas;
	}
	
	public void limpiarGanador() {
		j1.setGanador(false);
		j2.setGanador(false);
	}

	public void repartir() {
		if(primeraRonda==true) {
			System.out.println(REPARTIR);
			while(mazoGeneral.quedanCartas()) {
				j1.addCarta(mazoGeneral.entregarCarta());
				if(mazoGeneral.quedanCartas()) {
					j2.addCarta(mazoGeneral.entregarCarta());
				}
			}
		}
	}
	


	public boolean verificarGanador(Jugador j) {
		if(j.isGanador())
			return true;
		return false;
	}


	public void setAtributoCompetidor(Comparador c1) {
		if(partidaTerminada != true) {
			atributo = c1;
			imprimir(SEPARADORRONDA + nroRondas + SEPARADOR);
			imprimir(SELECCION + c1.getNombre());						
		}
	}


	public void comparar() {
		int resultado = atributo.compare(j1.mostrarCarta(), j2.mostrarCarta());
		if(resultado == 1) {
			j1.setGanador(true);
			j1.addCarta(j2.entregarCarta());
		}else if(resultado == -1) {
			j2.setGanador(true);
			j2.addCarta(j1.entregarCarta());
		}else {
			limpiarGanador();
		}
		nroRondas++;
	}



	public void mostrarGanador() {
		if(verificarGanador(j1)) {
			imprimir(GANADOR + j1.getNombre());
		}else if(verificarGanador(j2))
			imprimir(GANADOR + j2.getNombre());
		else
			imprimir(EMPATE);
	}


	public void mostrarCantCartas() {
		finalDePartida();
		imprimir(j1.getNombre() + POSEE + j1.cantCartas() + " y " + j2.getNombre() + POSEE + j2.cantCartas());
	}

	public void finalDePartida() {
		int cantJ1 = j1.cantCartas();
		int cantJ2 = j2.cantCartas();
		if(cantJ1 == 0 || cantJ2 == 0 && (nroRondas < MAXRONDAS)) {
			if(cantJ1>0) {
				imprimir(GANADORPARTIDA + j1.getNombre());
			}else {
				imprimir(GANADORPARTIDA + j2.getNombre());
			}
			partidaTerminada = true;
		}

	}
	
	public void imprimir(String s) {
		System.out.println(s);
	}
}
