package juegoDeCartas_v1;

import java.util.ArrayList;

public class Mazo {
	protected ArrayList<Carta> cartas;
	
	public Mazo() {
		cartas = new ArrayList<>();
	}
	
	public void addCarta(Carta c) {
		if(c.verificar()) 
			cartas.add(c);
	}
	
	public Carta entregarCarta() {
		Carta aux = cartas.get(cartas.size()-1);
		cartas.remove(cartas.size()-1);
		return aux;
	}
	
	public boolean quedanCartas() {
		return cartas.size()!=0;
	}
	
	public int cantCartas() {
		int aux = cartas.size();
		return aux;
	}
	
	public String imprimirPrimerCarta() {
		Carta aux = cartas.get(0);
		 return aux.toString();
	}
}
