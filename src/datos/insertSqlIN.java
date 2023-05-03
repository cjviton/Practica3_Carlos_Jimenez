package datos;

import control_utilidades.Cancion;

/**
 * Clase insertSqlIN Conecta con la base de datos y con el método insertSqlIN y
 * genera la sentencia INSERT en la lista de canciones en ingles
 * 
 * @author Carlos Jiménez
 * @version 1.0
 */

public class InsertSqlIN { // Genero la sentencia SQL de inserción para ingles

	public static String cancionAsql(Cancion miCancion) {

		/**
		 * Clase insertSqlIN Conecta con la base de datos y y genera la sentencia INSERT
		 * en la lista de canciones en ingles
		 * 
		 * @author Carlos Jiménez
		 * @version 1.0
		 */

		// INSERT INTO canciones_espanol (titulo, artista, genero, ano, estado_animo)
		// VALUES ('" + + "', ' " ++ "', '" ++ "', " ++ ", '"+ +"');

		return "INSERT INTO canciones_ingles (titulo, artista, genero, ano, estado_animo)" + " VALUES ('"
				+ miCancion.getTitulo() + "', ' " + miCancion.getArtista() + "', '" + miCancion.getGenero() + "', "
				+ miCancion.getAno() + ", '" + miCancion.getEstadoAnimo() + "');";

	}

}
