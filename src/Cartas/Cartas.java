package Cartas;

public class Cartas {
	public int posicao;
	public String name;
	public String tipo;
	public boolean alugado = false; 
	public int proprietario; 
	
	public int getPosicao() {
		return posicao;
	}

	public String getName() {
		return name;
	}

	public String getTipo() {
		return tipo;
	}
	
	public Cartas getCarta(int indice) {
		return this;
	}
}
