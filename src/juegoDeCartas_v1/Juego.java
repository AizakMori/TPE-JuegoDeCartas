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
	public static int MAXRONDAS = 10;
	public int nroRondas;

	public Juego(Mazo m1, Jugador j1, Jugador j2) {
		mazoGeneral = m1;
		this.j1 = j1;
		this.j2 = j2;
		nroRondas = 1;
	}
	public void jugar() {
		repartir();
		while((nroRondas < MAXRONDAS) && (j1.cantCartas()>0) && (j2.cantCartas()>0)) {							//MIENTRAS QUE LAS RONDAS NO LLEGUEN A 0 Y LOS JUGADORES TENGAN CARTAS
			Mensajes.ronda(nroRondas);
			comparar();																							//INVOCA AL METODO CORE DEL JUEGO
			Mensajes.finalRonda(j1.getNombre(),j1.cantCartas(), j2.getNombre(),j2.cantCartas());				//MUESTRA POR PANTALLA LA CANTIDAD DE CARTAS RESTANTES
		}
		if(j1.cantCartas()>j2.cantCartas()) 																	//MENSAJE FINAL DE LA PARTIDA
			Mensajes.finDePartida(j1.getNombre());
		else
			Mensajes.finDePartida(j2.getNombre());

	}

	public static void setRondas(int rondas) {																	//METODO STATIC PARA CAMBIAR EL NUMERO DE RONDAS
		MAXRONDAS = rondas;
	}
	
	private void repartir() {																					//REPARTIR CARTAS DEL MAZO DE JUEGO
		if(nroRondas == 1) {
			Mensajes.imprimirRepartir();
			while(mazoGeneral.quedanCartas()) {
				j1.addCarta(mazoGeneral.repartirCarta());														//ENTREGA DE CARTAS A LOS JUGADORES EMPEZANDO POR EL 1
				if(mazoGeneral.quedanCartas()) {
					j2.addCarta(mazoGeneral.repartirCarta());
				}
			}
		}
	}
	private Comparador obtenerComparador() {																	//LE PREGUNTAMOS AL JUGADOR DE TURNO QUE COMPARADOR USAR
		if(j1.isGanador()) {																					//VERIFICAR QUE JUGADOR TIENE EL TURNO
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

	public void comparar() {																				//METODO COMPARADOR
		Carta cartaJ1 = j1.jugarCarta();																	//LOS JUGADORES PONEN LAS CARTAS EN JUEGO
		Carta cartaJ2 = j2.jugarCarta();
		Comparador comp = obtenerComparador();																//SE PIDE EL COMPARADOR AL JUGADOR DE TURNO
		getDatos(comp.getNombre(), cartaJ1, cartaJ2);
		//Mensajes.mostrarComparacion(cartaJ1, cartaJ2, comp.getNombre());
		int resultado = comp.compare(cartaJ1, cartaJ2);														//SE UTILIZA EL COMPARADOR SELECCIONADO
		
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
			System.out.println("La carta de " + j1.getNombre() + " es " + cartaj1.getNombre() + " con " + tipoAtributo + " " + cartaj1.getFuerza() );
			System.out.println("La carta de " + j2.getNombre() + " es " + cartaj2.getNombre() + " con " + tipoAtributo + " " + cartaj2.getFuerza() );
			break;
		case "Altura":
			System.out.println("La carta de " + j1.getNombre() + " es " + cartaj1.getNombre() + " con " + tipoAtributo + " " + cartaj1.getAltura() );
			System.out.println("La carta de " + j2.getNombre() + " es " + cartaj2.getNombre() + " con " + tipoAtributo + " " + cartaj2.getAltura() );
			break;
		case "Peleas Ganadas":
			System.out.println("La carta de " + j1.getNombre() + " es " + cartaj1.getNombre() + " con " + tipoAtributo + " " + cartaj1.getPeleasGanadas() );
			System.out.println("La carta de " + j2.getNombre() + " es " + cartaj2.getNombre() + " con " + tipoAtributo + " " + cartaj2.getPeleasGanadas() );
			break;
		case "Velocidad":
			System.out.println("La carta de " + j1.getNombre() + " es " + cartaj1.getNombre() + " con " + tipoAtributo + " " + cartaj1.getVelocidad() );
			System.out.println("La carta de " + j2.getNombre() + " es " + cartaj2.getNombre() + " con " + tipoAtributo + " " + cartaj2.getVelocidad() );
			break;
		case "Peso":
			System.out.println("La carta de " + j1.getNombre() + " es " + cartaj1.getNombre() + " con " + tipoAtributo + " " + cartaj1.getPeso() );
			System.out.println("La carta de " + j2.getNombre() + " es " + cartaj2.getNombre() + " con " + tipoAtributo + " " + cartaj2.getPeso() );
			break;
			
		default:
			break;
		}
	}
}
