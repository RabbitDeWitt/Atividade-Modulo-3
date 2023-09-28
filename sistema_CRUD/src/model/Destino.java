package model;

public class Destino {

	private int idDestino;
	private String nome;
	private float valor;
	private String estado;
	private String pais;
	
	public Destino(String nome, String estado, String pais) {
		this.nome = nome;
		this.estado = estado;
		this.pais = pais;
	}
	
	public Destino(int id, String nome, String estado, String pais, float valor){
		this.idDestino = id;
		this.nome = nome;
		this.estado = estado;
		this.valor = valor;
		this.pais = pais;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getIdDestino() {
		return idDestino;
	}

}
