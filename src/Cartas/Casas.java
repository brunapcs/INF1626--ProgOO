package Cartas;

import org.json.JSONArray;
import org.json.JSONObject;

public class Casas extends Cartas{
	private String cor;
	private int[] aluguel;
	private int valorcasa;
	private int valorhotel;
	private int qtdCasas;
	private int hipoteca;
	
	public Casas(JSONObject father, JSONObject child) {
		if((String)father.getString("tipo") == "terreno")
		this.posicao = (int)father.getInt("posicao")-1;
		this.name = (String)child.getString("name");
		this.tipo = "terreno";
		this.cor = (String)child.get("cor");
		this.qtdCasas = 0;
		this.valorcasa = this.valorhotel = (int)child.getInt("casa");
		this.qtdCasas = 0;
		
		JSONArray v = child.optJSONArray("aluguel");
		aluguel = new int[v.length()];
		
		for(int j = 0; j < v.length(); j++) {
			aluguel[j] = v.optInt(j);
		}
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
}
