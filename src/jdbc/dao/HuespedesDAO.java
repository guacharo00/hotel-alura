package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.modelo.HuespedesModelo;


public class HuespedesDAO {

	private Connection con;

	public HuespedesDAO(Connection connection) {
		this.con = connection;
	}
	
	public void guardar(HuespedesModelo huespede) {
		
		try {
			
			String sql = "INSERT INTO HUESPEDES (nombre, apellido, fecha_nacimineto, nacionalidad, telefono, id_reserva) VALUES (?, ?, ?, ?, ?, ?)";
			
			try (PreparedStatement pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
				
				pstm.setString(1, huespede.getNombre());
				pstm.setString(2, huespede.getApellido());
				pstm.setDate(3, huespede.getFecha_nacimiento());
				pstm.setString(4, huespede.getNacionalidad());
				pstm.setString(5, huespede.getTelefono());
				pstm.setInt(6, huespede.getId_reserrva());
				
				pstm.executeUpdate();
				
				try (ResultSet rs = pstm.getGeneratedKeys()){
					
					while(rs.next()) {
						huespede.setId(rs.getInt(1));
					}
					
				}
				
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
}
