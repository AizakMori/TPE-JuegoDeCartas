package juegoDeCartas_v1;

public class MazoJugador extends Mazo{
	public MazoJugador() {
		super();
	}
	public Carta mostrarCarta() {
		Carta aux = cartas.get(0);
		return aux;
	}
	public Carta entregarCarta() {
		Carta aux = cartas.get(0);
		cartas.remove(0);
		return aux;
	}

}
