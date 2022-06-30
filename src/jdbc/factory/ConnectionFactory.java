package jdbc.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	public DataSource dataSource;
	
	public ConnectionFactory () {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/alura_hotel?useTimeZone=true&serverTimeZone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("lokera8611");
		
		this.dataSource = comboPooledDataSource;
	}
	
	public Connection recuperaConexion() {
		try {
			return this.dataSource.getConnection();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
//	public Connection recuperaConexion() throws SQLException {
//		return DriverManager.getConnection(
//                "jdbc:mysql://localhost/alura_hotel?useTimeZone=true&serverTimeZone=UTC",
//                "root",
//                "lokera8611");
//	}
}
