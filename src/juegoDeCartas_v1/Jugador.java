package juegoDeCartas_v1;
import java.util.ArrayList;
import atributos.Comparador;


public class Jugador {
	private MazoJugador mazo;
	private ArrayList<Comparador> comparadores;
	private String nombre;
	private boolean ganador;
	
	public Jugador(String nom) {
		nombre = nom;
		mazo = new MazoJugador();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isGanador() {
		return ganador;
	}
	public void setGanador(boolean ganador) {
		this.ganador = ganador;
	}
	public void addCarta(Carta c1) {
		mazo.addCarta(c1);
	}
	public Carta mostrarCarta() {
		return mazo.mostrarCarta();
	}
	public String imprimirCarta() {
		return mazo.imprimirPrimerCarta();
	}
	public Carta entregarCarta() {
		return mazo.entregarCarta();
	}
	public int cantCartas() {
		return mazo.cantCartas();
	}
	public void setAtributo(){
		
	}
}
