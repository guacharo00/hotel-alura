package jdbc.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.factory.ConnectionFactory;

public class UserController {
	
	public boolean iniciarSecion(String user, String pass) throws SQLException {
		Connection con = new ConnectionFactory().recuperaConexion();
		
		PreparedStatement statement = con.prepareStatement("SELECT ID, USUARIO, PASSWORD FROM USUARIOS WHERE USUARIO = ? AND PASSWORD = ?");
		statement.setString(1, user);
		statement.setString(2, pass);
		
		statement.execute();
		
		ResultSet rs = statement.getResultSet();
		
		boolean isLogged;
		
		if(rs.next()) {
			isLogged = true;
		} else {
			isLogged = false;
		}
			
		con.close();
		
		return isLogged;
		
	}
	
}
