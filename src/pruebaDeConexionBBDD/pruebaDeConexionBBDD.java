package pruebaDeConexionBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class pruebaDeConexionBBDD {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost",
					"root", "");

			conexion.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
			//System.out.println("Error");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Conectado/desconectado");
		
	}

}
