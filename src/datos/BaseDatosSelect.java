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
			
			Class.forName("com.mysql.jdbc.Driver");          // conectar con la base de datos
			
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/mi_musica", "root", "");   // proporcionamos la dirección, el administrador y  la clave
																											
			sentenciaSQL = conexion.createStatement();      // creamos sentencias ejecutables sobre esa conexión

			// System.out.println(sql);                     //Si tengo algún problema me servirá para mostrar y copiar la SQL 
		                                                	//para ejecutarla en la base de datos y ver el resultado
			
			rs = sentenciaSQL.executeQuery(sql);
           
						
			while (rs.next()) {                             // chequeo que el result set no sea vacío, moviendo el cursor a la
				                                            // primer fila. (El cursor inicia antes de la primer fila)
				                                            // Si hay resultados obtengo el valor. 
				System.out.println( "Título: " + rs.getString("titulo") +  "  - Artista: " + rs.getString("artista") +  ",  - Genero: " + rs.getString("genero") + "  - Año: " + rs.getInt("ano") + "  - Estado de ánimo:  " + rs.getString("estado_animo"));
			}

		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {
			try {
				sentenciaSQL.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		System.out.println("Conectado/desconectado");
	}
}
