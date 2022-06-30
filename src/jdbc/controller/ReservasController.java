package jdbc.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import jdbc.dao.ReservaDAO;
import jdbc.factory.ConnectionFactory;
import jdbc.modelo.ReservaModelo;

public class ReservasController {
	
	private ReservaDAO reservaDAO;

	public ReservasController() {
		Connection con = new ConnectionFactory().recuperaConexion();
		this.reservaDAO = new ReservaDAO(con);
	}
	
	public void guardar(ReservaModelo reserva) {
		this.reservaDAO.guardar(reserva);
	}
	
}
