package Jugadores;
import java.util.ArrayList;
import atributos.*;
import herramientas.Mensajes;
import mazo_cartas_pocima.*;

public class Jugador {
	private String nombre;
	protected Mazo mazo;
	protected ArrayList<Comparador> comparadores;
	private boolean ganador;
	
	public Jugador(String nom) {
		nombre = nom;
		mazo = new Mazo();
		comparadores = new ArrayList<>();
		setComparadores();
		ganador = false;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Comparador atributoSeleccionado() {
		int indx =(int)(Math.random()*comparadores.size()); 
		Comparador comp = comparadores.get(indx);
		Mensajes.atributoSelec(this.getNombre(), comp.getNombre());
		return comp;
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
	public void finalDelMazo(Carta c){
		ganador = false;
		mazo.ultimoLugar(c);
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
