package Cartas;

import org.json.JSONObject;

public class SorteReves extends Cartas{
	
	private String titulo; 
	private String tipo; 
	private int montante; 
	private int posicao; 
	
	
	public SorteReves(JSONObject father, JSONObject filho) {
		if(father.getString(tipo) == "SorteReves"){
		titulo = filho.getString("titulo"); 
		tipo = filho.getString("tipo"); 
		montante = filho.getInt("resultado");
		posicao = father.getInt("posicao") -1; 
	}
	
	public String getTitulo() {
		return titulo;
	}

	public String getTipo() {
		return tipo;
	}
	
	

}
