package datos;

import control_utilidades.Cancion;

public class InsertSqlES {
	public static String cancionAsql(Cancion miCancion) {

		// INSERT INTO canciones_espanol (titulo, artista, genero, ano, estado_animo)
		// VALUES ('" + + "', ' " ++ "', '" ++ "', " ++ ", '"+ +"');

		return "INSERT INTO canciones_espanol (titulo, artista, genero, ano, estado_animo)" + " VALUES ('"
				+ miCancion.getTitulo() + "', ' " + miCancion.getArtista() + "', '" + miCancion.getGenero() + "', "
				+ miCancion.getAno() + ", '" + miCancion.getEstadoAnimo() + "');";

	}

}
