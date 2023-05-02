package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase BaseDatosSelect
 * Conecta con la base de datos y 
 * con el método BaseDatosVacia
 * devuelve un booleano confirmando si contiene
 * registros o si está vacía
 * @author Carlos Jiménez
 * @version 1.0
 */
public class BaseDatosVacia {
	
	/**
	 *  Conecta con la base de datos y 
     * devuelve un booleano confirmando si contiene
     * registros o si está vacía
	 * @param sql Sentencia Sql a ejecutar
	 * @return
	 * @author Carlos Jiménez
	 * @version 1.0
	 */
	public static boolean bdVacia(String sql) {
	
	    boolean vacia=true;
		Connection conexion=null;
		Statement sentenciaSQL = null;
		int numero=0;
		
		try {		
			Class.forName("com.mysql.jdbc.Driver");            //conectar con la base de datos
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/mi_musica", "root", ""); 
					                                           // proporcionamos la dirección, el administrador y la clave	
			
			sentenciaSQL = conexion.createStatement();         //creamos sentencias ejecutables sobre esa conexión
			 
			                                                   //almaceno el resultado de la sql en un resulset (conjunto de registros)
			ResultSet rs  = sentenciaSQL.executeQuery(sql); 
		    
		    
		     if(rs.next()) {								   // chequeo que el result set no sea vacío, moviendo el cursor a la 
		    	                                               // primer fila. (El cursor inicia antes de la primer fila)
		        numero= rs.getInt(1);                          //Si hay resultados obtengo el valor. 
		        	if (numero > 0 ) {
		        		 vacia=false;
     	        	}
		       
		     }
			
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}		
		System.out.println("Conectado/desconectado");
		return vacia;
	}
}
