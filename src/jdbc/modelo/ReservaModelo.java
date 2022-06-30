package jdbc.modelo;

import java.sql.Date;

public class ReservaModelo {

	private int id;
	private Date fechaE, fechaS; 
	private int valor;
	private String formaPago;
	
	public ReservaModelo(Date fechaE, Date fechaS, int valor, String formaPago) {
		super();
		this.fechaE = fechaE;
		this.fechaS = fechaS;
		this.valor = valor;
		this.formaPago = formaPago;
	}

	public Date getFechaE() {
		return fechaE;
	}

	public Date getFechaS() {
		return fechaS;
	}

	public int getValor() {
		return valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFormaPago() {
		return formaPago;
	}
}
