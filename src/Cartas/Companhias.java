package Cartas;

import org.json.JSONObject;

public class Companhias extends Cartas{
	private int hipoteca;
	private int multiplicador;
	private int precoaluguel;
	
	public Companhias(JSONObject father, JSONObject child) {
	
			this.tipo = "companhia";
			this.name = (String)child.getString("name");
			this.multiplicador = (int)child.getInt("multiplicador");
			this.hipoteca = (int)child.getInt("hipoteca");
			this.precoaluguel = this.hipoteca*2;
			this.posicao = (int)father.getInt("posicao")-1;
		
	}
	
	public int getHipoteca() {
		return hipoteca;
	}
	public int getMultiplicador() {
		return multiplicador;
	}
	public int getPrecoaluguel() {
		return precoaluguel;
	}
}
