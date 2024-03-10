package mazo_cartas_pocima;

import java.util.ArrayList;

public class Mazo {
	protected ArrayList<Carta> cartas;
	
	public Mazo() {
		cartas = new ArrayList<>();
	}
	public void addCarta(Carta c) {					//REALIZA LA VERIFICACION DE LA CARTA ANTES DE AÑADIRLA
		if(c.verificar()) 
			cartas.add(c);
	}
	public Carta repartirCarta() {					//REPARTE A PARTIR DE LA CARTA "EN LA PARTE SUPERIOR DEL MAZO"
		Carta aux = cartas.get(cartas.size()-1);
		cartas.remove(cartas.size()-1);
		return aux;
	}
	public Carta entregarCarta() {					//ENTREGA PRIMER CARTA
		Carta aux = cartas.get(0);
		cartas.remove(0);
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
}
