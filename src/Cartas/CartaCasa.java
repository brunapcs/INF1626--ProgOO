package Cartas;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CartaCasa extends Cartas{
	private String cor;
	private int[] aluguel;
	private int valorcasa;
	private int valorhotel;
	private int qtdCasas;
	private int hipoteca;
	
	public CartaCasa(JSONObject j) {
		this.posicao = (int)j.get("posicao")-1;
		this.name = (String)j.get("name");
		this.tipo = (String)j.get("tipo");
		this.cor = (String)j.get("cor");
		this.qtdCasas = 0;
		this.valorcasa = this.valorhotel = (int)j.get("casa");
		
		JSONArray v = (JSONArray)j.get("aluguel");
	}

	public String getCor() {
		return cor;
	}

	public int[] getAluguel() {
		return aluguel;
	}

	public int getvalorCasa() {
		return valorcasa;
	}

	public int getvalorHotel() {
		return valorhotel;
	}
	
	public int getQtdCasas() {
		return qtdCasas;
	}

	public int getHipoteca() {
		return hipoteca;
	}
	
	public int getPosicao() {
		return posicao;
	}
}
