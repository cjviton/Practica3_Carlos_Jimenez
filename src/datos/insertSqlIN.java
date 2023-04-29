package datos;

import control_utilidades.Cancion;

public class insertSqlIN {      //Genero la sentencia SQL de inserción para ingles

	public static String cancionAsql(Cancion miCancion) {

		// INSERT INTO canciones_espanol (titulo, artista, genero, ano, estado_animo)
		// VALUES ('" + + "', ' " ++ "', '" ++ "', " ++ ", '"+ +"');

		return "INSERT INTO canciones_ingles (titulo, artista, genero, ano, estado_animo)" + " VALUES ('"
				+ miCancion.getTitulo() + "', ' " + miCancion.getArtista() + "', '" + miCancion.getGenero() + "', "
				+ miCancion.getAno() + ", '" + miCancion.getEstadoAnimo() + "');";

	}

}
