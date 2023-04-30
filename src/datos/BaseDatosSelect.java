package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDatosSelect {

	public static void ejecutarSqlSelect(String sql) {

		Connection conexion = null;
		Statement sentenciaSQL = null;
		ResultSet rs;
		int propietario = 1;
		//String sql = " ";

		try {
			// conectar con la base de datos
			Class.forName("com.mysql.jdbc.Driver");
			// proporcionamos la dirección, el administrador y  la clave
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/mi_musica", "root", "");
																									
			// creamos sentencias ejecutables sobre esa conexión
			sentenciaSQL = conexion.createStatement();

			// almaceno el resultado de la sql en un resulset (conjunto de registros)
			//sql = "SELECT * FROM canciones_espanol";
			// System.out.println(sql);      //Si tengo algún problema me servirá para mostrar y copiar la SQL 
			//para ejecutarla en la base de datos y ver el resultado

			rs = sentenciaSQL.executeQuery(sql);

			// chequeo que el result set no sea vacío, moviendo el cursor a la
			// primer fila. (El cursor inicia antes de la primer fila)
			while (rs.next()) {
				// Si hay resultados obtengo el valor.

				System.out.println( rs.getString("cancion") + rs.getInt("cancion"));
			}

		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			// System.out.println("Error");
		} finally {
			try {
				sentenciaSQL.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		System.out.println("Conectado/desconectado");

	}

}
