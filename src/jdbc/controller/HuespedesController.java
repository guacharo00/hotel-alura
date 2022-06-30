package jdbc.controller;

import java.sql.Connection;

import jdbc.dao.HuespedesDAO;
import jdbc.factory.ConnectionFactory;
import jdbc.modelo.HuespedesModelo;

public class HuespedesController {

	private HuespedesDAO huespedesDAO;
	
	public HuespedesController() {
		Connection con = new ConnectionFactory().recuperaConexion();
		this.huespedesDAO = new HuespedesDAO(con);
	}
	
	public void guardar(HuespedesModelo huespede) {
		this.huespedesDAO.guardar(huespede);
	}
	
}
