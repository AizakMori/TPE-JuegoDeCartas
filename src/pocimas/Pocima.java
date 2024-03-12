package pocimas;

import mazo_cartas_pocima.Carta;

public abstract class Pocima {
	private String nombre;
	public Pocima(String nom) {
		this.nombre = nom;
	}
	public String getNombre() {
		return nombre;
	}
	public void imprimir(){
		System.out.println("Se aplico " + this.getNombre());
	}
	
	public abstract void aplicar(Carta c);
}
