package Jugadores;
import java.util.ArrayList;
import atributos.*;
import mazo_cartas_pocima.*;

public class Jugador {
	private Mazo mazo;
	private ArrayList<Comparador> comparadores;
	private String nombre;
	private boolean ganador;
	
	public Jugador(String nom) {
		nombre = nom;
		mazo = new Mazo();
		setComparadores();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Comparador atributoSeleccionado() {
		int indx = herramientas.Random.getRandom(comparadores.size())-1;
		return comparadores.get(indx);
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
	public String imprimirCarta() {
		return mazo.imprimirPrimerCarta();
	}
	public Carta jugarCarta() {
		return mazo.entregarCarta();
	}
	public int cantCartas() {
		return mazo.cantCartas();
	}
	public void empate(Carta c){
		ganador = false;
		mazo.ultimoLugar(c);
	}
	public void setComparadores() {
		Comparador comp1 = new Fuerza();
		Comparador comp2 = new Altura();
		Comparador comp3 = new Peso();
		Comparador comp4 = new Velocidad();
		Comparador comp5 = new Peleas_Ganadas();
		
		comparadores.add(comp1);
		comparadores.add(comp2);
		comparadores.add(comp3);
		comparadores.add(comp4);
		comparadores.add(comp5);
	}
}
