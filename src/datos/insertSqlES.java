package datos;

import control_utilidades.Cancion;

/**
 * Clase insertSqlES Conecta con la base de datos y con el método insertSqlES y
 * genera la sentencia INSERT en la lista de canciones en español
 * 
 * @author Carlos Jiménez
 * @version 1.0
 */
public class InsertSqlES {
	/**
	 * Clase insertSqlES Conecta con la base de datos y y genera la sentencia INSERT
	 * en la lista de canciones en español
	 * 
	 * @author Carlos Jiménez
	 * @version 1.0
	 */

	public static String cancionAsql(Cancion miCancion) {

		// INSERT INTO canciones_espanol (titulo, artista, genero, ano, estado_animo)
		// VALUES ('" + + "', ' " ++ "', '" ++ "', " ++ ", '"+ +"');

		return "INSERT INTO canciones_espanol (titulo, artista, genero, ano, estado_animo)" + " VALUES ('"
				+ miCancion.getTitulo() + "', ' " + miCancion.getArtista() + "', '" + miCancion.getGenero() + "', "
				+ miCancion.getAno() + ", '" + miCancion.getEstadoAnimo() + "');";

	}

}
