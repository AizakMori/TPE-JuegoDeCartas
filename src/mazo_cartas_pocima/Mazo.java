package mazo_cartas_pocima;

import java.util.ArrayList;

import pocimas.Pocima;

public class Mazo {
	private ArrayList<Carta> cartas;
	private ArrayList<Pocima> pocimas;

	public Mazo() {
		cartas = new ArrayList<>();
		pocimas = new ArrayList<>();
	}
	public void addCarta(Carta c) {					//REALIZA LA VERIFICACION DE LA CARTA ANTES DE AÑADIRLA
		if(c.verificar()) 
			cartas.add(c);
	}
	public void addPocima(Pocima p) {
		pocimas.add(p);
	}
	public Carta repartirCarta() {					//REPARTE A PARTIR DE LA CARTA "EN LA PARTE SUPERIOR DEL MAZO"
		int cant = cartas.size()-1;
		Carta aux = cartas.get(cant);
		cartas.remove(cant);
		if(pocimas.size()!=0) {						//REPARTIR SI HAY POCIMAS EN EL ARRAY
			int i = randomizador(2);				//QUE HAYA 50% DE PROBABILIDADES DE QUE SE AGREGUE UNA POCIMA
			if(i == 0) {
			int indx = randomizador(pocimas.size());
			Pocima pocimaAux = pocimas.get(indx);
			aux.addPocima(pocimaAux);
			pocimas.remove(indx);
			return aux;
			}
		}

		return aux;
	}
	public Carta entregarCarta() {					//ENTREGA PRIMER CARTA
		Carta aux = cartas.get(0);
		cartas.remove(0);
		return aux;
	}
	public Carta verCarta() {						//PARA EL JUGADOR AMBICIOSO
		Carta aux = cartas.get(0);
		return aux;
	}
	public boolean quedanCartas() {					//VERIFICA SI QUEDAN CARTAS
		return cartas.size()!=0;
	}
	public int cantCartas() {						//VERIFICA LA CANTIDAD DE CARTAS RESTANTES 
		int aux = cartas.size();
		return aux;
	}
	public String imprimirPrimerCarta() {			//LLAMA AL TOSTRING DE LA CARTA PARA IMPRIMIRLA
		Carta aux = cartas.get(0);
		return aux.toString();
	}
	public void ultimoLugar(Carta c) {				//COLOCA LA CARTA EN EL ULTIMO LUGAR EN CASO DE EMPATE
		cartas.add(cartas.size(), c);
	}
	public int randomizador(int i) {
		return (int)(Math.random()*i);
	}
}
