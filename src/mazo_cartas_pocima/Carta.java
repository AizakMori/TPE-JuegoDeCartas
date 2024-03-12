package mazo_cartas_pocima;
import herramientas.*;
import pocimas.*;

public class Carta extends Cartas{
	private String nombre;
	private int altura;
	private int peso;
	private int velocidad;
	private int fuerza;
	private int peleasGanadas;
	private Pocima pocima;
	private boolean seUsoPocima;

	public Carta(String nom,int alt, int aPeso, int aVel, int aFuerza, int pel) {
		nombre = nom;
		altura = alt;
		peso = aPeso;
		velocidad = aVel;
		fuerza = aFuerza;
		peleasGanadas = pel;
		seUsoPocima = true;
	}

	public String getNombre() {
		return nombre;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public int getPeleasGanadas() {
		return peleasGanadas;
	}

	public void setPeleasGanadas(int peleasGanadas) {
		this.peleasGanadas = peleasGanadas;
	}


	public void aplicarPocima(int i) {
		if(seUsoPocima != true && pocima != null) {
			pocima.aplicar(this, i);
			Mensajes.mostrarPocima(pocima.getNombre(), this.getAtributo(i));
			seUsoPocima = true;			
		}
	}
	public void addPocima(Pocima p) {
		seUsoPocima = false;
		pocima = p;
	}
	public boolean usada() {
		return seUsoPocima;
	}
	public boolean verificar() {
		if(!nombre.isEmpty() && altura > 0 && peso > 0 && velocidad > 0 && fuerza > 0 && peleasGanadas >=0)
			return true;
		else 
			return false;
	}
	public int getAtributoMasAlto() {
		int max = this.getAltura();
		int numAt = 0;
		if((this.getPeso()) > max) {
			max = this.getPeso();
			numAt = 1;
		}
		if((this.getVelocidad()) > max) {
			max = this.getVelocidad();
			numAt = 2;
		}
		if((this.getFuerza()) > max) {
			max=this.getFuerza();
			numAt = 3;
		}
		if((this.getPeleasGanadas())>max) {
			max= this.getPeleasGanadas();
			numAt = 4;
		}
		return numAt;
	}
	public String toString() {
		return "Nombre: " + this.getNombre() + " Altura: " + this.getAltura() + " Peso: " + this.getPeso() +
				" Fuerza: " + this.getFuerza() + "Peleas ganadas: " + this.getPeleasGanadas();
	}
	public void getDatos(int comp, String jugador) {
		switch(comp) {
		case 0:
			System.out.println("La carta de " + jugador + " es " + this.getNombre() + " con Altura de: " + this.getAltura() );
			break;
		case 1:
			System.out.println("La carta de " + jugador + " es " + this.getNombre() + " con un peso de: " + this.getPeso() );
			break;
		case 2:
			System.out.println("La carta de " + jugador + " es " + this.getNombre() + " con una velocidad de: " + this.getVelocidad() );
			break;
		case 3: 
			System.out.println("La carta de " + jugador + " es " + this.getNombre() + " con una Fuerza de: "  + this.getFuerza() );
			break;
		case 4:
			System.out.println("La carta de " + jugador + " es " + this.getNombre() + " con un total de Peleas ganadas: " + this.getPeleasGanadas() );
			break;
		default:
			break;
		}
	}
	public int getAtributo(int i) {
		switch(i) {
		case 0:
			return this.getAltura();
		case 1:
			return this.getPeso();
		case 2:
			return this.getVelocidad();
		case 3: 
			return this.getFuerza();
		case 4:
			return this.getPeleasGanadas();
		default:
			return -1;
		}
	}
}
