package atributos;

import mazo_cartas_pocima.Carta;

public abstract class Comparador{
	
	private String nombre;
	
	public Comparador(String n) {
		nombre = n;
	}
	public abstract int compare(Carta c1, Carta c2);
	
	public String getNombre() {
		return this.nombre;
	}
	public abstract int getNum();
}
