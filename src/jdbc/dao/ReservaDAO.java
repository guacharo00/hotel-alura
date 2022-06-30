package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.modelo.ReservaModelo;

public class ReservaDAO {

	private Connection con;
	
	public ReservaDAO(Connection connection) {
		this.con = connection;
	}
	
	public void guardar(ReservaModelo reserva) {
		
		try {
			
			String sql = "INSERT INTO RESERVAS (fecha_entrada, fecha_salida, valor, forma_pago) VALUES (?, ?, ?, ?)";
			
			try (PreparedStatement pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
				
				pstm.setDate(1, reserva.getFechaE());
				pstm.setDate(2, reserva.getFechaS());
				pstm.setInt(3, reserva.getValor());
				pstm.setString(4, reserva.getFormaPago());
				
				pstm.executeUpdate();
				
				try (ResultSet rs = pstm.getGeneratedKeys()){
					
					while(rs.next()) {
						reserva.setId(rs.getInt(1));
					}
					
				}
				
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
