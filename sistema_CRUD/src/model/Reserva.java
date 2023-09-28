package model;

import java.util.Date;

public class Reserva {
	private int id;
	private Date dataPartida;
	private Date dataRetorno;
	private Cliente cliente;
	private Destino destino;
	private Pacote pacote;
	
	public Reserva(Date dataPartida, Date dataRetorno, Cliente cliente, Destino destino, Pacote pacote) {
		this.dataPartida = dataPartida;
		this.dataRetorno = dataRetorno;
		this.cliente = cliente;
		this.destino = destino;
		this.pacote = pacote;
	}

	public Reserva(int id, Date dataPartida, Date dataRetorno, Cliente cliente, Destino destino, Pacote pacote) {
		this.id = id;
		this.dataPartida = dataPartida;
		this.dataRetorno = dataRetorno;
		this.cliente = cliente;
		this.destino = destino;
		this.pacote = pacote;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataPartida() {
		return dataPartida;
	}

	public void setDataPartida(Date dataPartida) {
		this.dataPartida = dataPartida;
	}

	public Date getDataRetorno() {
		return dataRetorno;
	}

	public void setDataRetorno(Date dataRetorno) {
		this.dataRetorno = dataRetorno;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	public Pacote getPacote() {
		return pacote;
	}

	public void setPacote(Pacote pacote) {
		this.pacote = pacote;
	}
	
}
