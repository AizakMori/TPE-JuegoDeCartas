package pocimas;
import java.util.ArrayList;

import mazo_cartas_pocima.Carta;

public class PocimaCocktail extends Pocima {
	private ArrayList<Pocima> pocimas;
	public PocimaCocktail() {
		this("Cocktail");
	}
	public PocimaCocktail(String nom) {
		super(nom);
		pocimas = new ArrayList<>();
	}

	@Override
	public void aplicar(Carta c, int i) {
		for(Pocima p: pocimas) {
			p.aplicar(c, i);
		}
	}
	public void addPocima(Pocima p) {
		if(p != null) {
			pocimas.add(p);
		}
	}
}
