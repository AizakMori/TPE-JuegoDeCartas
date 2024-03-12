package Jugadores;
public class JugadorObstinado extends Jugador {
	public final int NEGATIVO = -1;
	private int select;
	public JugadorObstinado(String nom) {			//POR SI SOLO LO CREAS CON NOMBRE
		this(nom, -1);
	}
	public JugadorObstinado(String nom, int i) {	//POR SI QUERES CREARLO TAMBIEN CON EL NUMERO DE ATRIBUTO QUE VA A QUEDAR
		super(nom);
		select = i;
	}
	public int atributoSeleccionado(int indx) {
		if(select != NEGATIVO) {
			select = (int)(Math.random() * indx);
		}
		return select;
	}
}
