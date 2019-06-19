package Cartas;

public class Cartas {
	public String name;
	public String tipo;
	public int posicao;
	public boolean status = false; 
	public int proprietario; 
	
	public String getName() {
		return name;
	}

	public String getTipo() {
		return tipo;
	}

	public int getPosicao() {
		return posicao;
	}
	
	public Cartas getCarta(int indice) {
		return this;
	}
	
	public int getProprietarioIndex() {
		return proprietario;
	}
	
	public boolean getStatus() {
		return status;
	}
}
