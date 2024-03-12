package Jugadores;
import java.util.ArrayList;
import atributos.*;
import herramientas.Mensajes;
import mazo_cartas_pocima.*;

public class Jugador {
	private String nombre;
	protected Mazo mazo;
	private boolean ganador;
	
	public Jugador(String nom) {
		nombre = nom;
		mazo = new Mazo();

		ganador = false;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int atributoSeleccionado(int i) {
		int indx =(int)(Math.random()*i); 
		return indx;
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
		Carta carta = mazo.entregarCarta();
		return carta;
	}
	public int cantCartas() {
		return mazo.cantCartas();
	}
	public void finalDelMazo(Carta c){
		ganador = false;
		mazo.ultimoLugar(c);
	}

}
