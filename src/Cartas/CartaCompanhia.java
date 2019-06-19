package Cartas;

import org.json.simple.JSONObject;



public class CartaCompanhia extends Cartas {
	private int hipoteca;
	private int multiplicador;
	private int aluguel;
	
	
	public CartaCompanhia(JSONObject jobj) {
			this.tipo = (String)jobj.get("companhia");
			this.name = (String)jobj.get("name");
			this.multiplicador = (int)jobj.get("multiplicador");
			this.hipoteca = (int)jobj.get("hipoteca");
			this.aluguel = this.hipoteca*2;
			this.posicao = (int)jobj.get("posicao") - 1;
		
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
