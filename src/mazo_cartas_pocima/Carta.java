package mazo_cartas_pocima;

public class Carta {
	private String nombre;
	private int altura;
	private int peso;
	private int velocidad;
	private int fuerza;
	private int peleasGanadas;
	
	public Carta(String nom,int alt, int aPeso, int aVel, int aFuerza, int pel) {
		nombre = nom;
		altura = alt;
		peso = aPeso;
		velocidad = aVel;
		fuerza = aFuerza;
		peleasGanadas = pel;
	}
	
	public String getNombre() {
		return nombre;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public double getFuerza() {
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
	
	public boolean verificar() {
		if(!nombre.isEmpty() && altura > 0 && peso > 0 && velocidad > 0 && fuerza > 0 && peleasGanadas >=0)
			return true;
		else 
			return false;
	}
	public String toString() {
		return "Nombre: " + this.getNombre() + " Altura: " + this.getAltura() + " Peso: " + this.getPeso() +
				" Fuerza: " + this.getFuerza() + "Peleas ganadas: " + this.getPeleasGanadas();
	}
}
