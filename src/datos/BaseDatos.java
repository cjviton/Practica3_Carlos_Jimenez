package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDatos {
	
	public static void ejecutarSql (String sql) {
		
		Connection conexion = null;     //De este modo establezco una conexión con al base de datos
		Statement sentenciaSQL = null;  //Esta clase me permite ejecutar sentencias SQL sobre esa conexión
		int resultado=0;                //Esta variable se refiere al número de cambios que ha sufrido la BD.
						                //lo voy a usar para saber si se ha insertado algo en la BD o no


		try {
			// conectar con la base de datos
			Class.forName("com.mysql.jdbc.Driver"); //Cargo el driver que previamente he guardado en lib e instalado en mi este proyecto
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/mi_musica", "root", ""); //Establezco la dirección, el usuario y el password

			// creamos sentencias ejecutables sobre esa conexión
			sentenciaSQL = conexion.createStatement();  //Sobre esa conexión genero un objeto de la clase statement que me va apermitir generar sentencias SQL


			resultado = sentenciaSQL.executeUpdate(sql);     //EL EXECUTEUPDATE ME PERMITE EJECUTAR SENTENCIAS DEL TIPO INSERT, DELETE Y UPDATE  
															 //PARA EJECUTAR SENTENCIAS DEL TIPO SELECT TENGO QUE USAR EL MÉTODO EXECUTEQUERY
			if (resultado >= 1) {
				System.out.println("Se ha insertado bien.");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			// System.out.println("Error");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				sentenciaSQL.close();
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		System.out.println("Conectado/desconectado");
		
	}
				
}
	
	


