package control_utilidades;

import java.util.ArrayList;
import datos.BaseDatos;
import datos.BaseDatosSelect;
import usuario.Util;

/**
 * Objetos de la calse Listan Ingles
 * 
 * @author Carlos @ version 1.0
 */
public class ListaIN {

	private String ususario;
	private ArrayList<Cancion> miListaIn = new ArrayList<Cancion>();

	public ListaIN(String ususario) {
		super();
		this.ususario = ususario;
	}

	public String getUsusario() {
		return ususario;
	}

	public void setUsusario(String ususario) {
		this.ususario = ususario;
	}

	public ArrayList<Cancion> getMilistaIn() {
		return miListaIn;
	}

	public void setMilistaIn(ArrayList<Cancion> milistaIn) {
		this.miListaIn = milistaIn;
	}

	@Override
	public String toString() {
		return "ListaIN [ususario=" + ususario + ", miListaIn=" + miListaIn + "]";
	}

	/**
	 * Añade canciones en mi lista de ingles mediante scanner genera INSERT en la
	 * base de datos
	 * 
	 * @author Carlos Jiménez
	 * @version 1.0
	 */
	public void addcancionIn() { // Añadir cancines en mi lista de español mediante scanner

		String titulo = "";
		String artista = "";
		String genero = "";
		int ano = 0;
		String EstadoAnimo = "";

		titulo = Util.pedirString("Titulo");
		artista = Util.pedirString("Artista");
		genero = Util.pedirString("Genero");
		ano = Util.pedirInt("Año");
		EstadoAnimo = Util.pedirString("Estado de ánimo");

		Cancion miCancion = new Cancion(titulo, artista, genero, ano, EstadoAnimo);
		miListaIn.add(miCancion);
		String sql = datos.InsertSqlIN.cancionAsql(miCancion);
		BaseDatos.ejecutarSql(sql);
	}

	/**
	 * Modifica el parametro de tipo String de un objeto tipo Cancion. Este método
	 * se complementa co el método menu5opciones o con el método menu3opciones, que
	 * devuelve un dato de tipo integer, que será el que añadiremos en el parametro.
	 * No he sabido com hecer un método totalmente reutilizable para modificar
	 * parámetros de todo tipo de objetos.
	 * 
	 * @param atributo     Es de tipo Integer. complementar con método
	 *                     menuo_opciones
	 * @param datoAcambiar
	 * @param datoNuevo
	 * @author Carlos jimenez
	 * @version 1.o
	 */
	public void cambiarAtributo(int atributo, String datoAcambiar, String datoNuevo) {

		switch (atributo) {

		case 1:// modifiac título

			// Inserto la sentencia SQL para que modifique el titulo en la base de datos
			String sqlTitulo = ("UPDATE canciones_ingles SET titulo = '" + datoNuevo + "' WHERE titulo = '"
					+ datoAcambiar + "';");
			BaseDatos.ejecutarSql(sqlTitulo);

			break;

		case 2:// modifica artista

			// Inserto la sentencia SQL para que modifique el artista en la base de datos
			String sqlArtista = ("UPDATE canciones_ingles SET artista = '" + datoNuevo + "' WHERE artista = '"
					+ datoAcambiar + "';");
			BaseDatos.ejecutarSql(sqlArtista);

			break;

		case 3:// Modifica Genero

			// Inserto la sentencia SQL para que modifique el genero en la base de datos
			String sqlGenero = ("UPDATE canciones_ingles SET genero = '" + datoNuevo + "' WHERE genero = '"
					+ datoAcambiar + "';");
			BaseDatos.ejecutarSql(sqlGenero);

			break;

		case 5:// Modifica estado de ánimo

			// Inserto la sentencia SQL para que modifique el estado de animo en la base de
			// datos
			String sqlEstado = ("UPDATE canciones_ingles SET estado_animo = '" + datoNuevo + "' WHERE estado_animo = '"
					+ datoAcambiar + "';");
			BaseDatos.ejecutarSql(sqlEstado);

			break;
		}
	}

	/**
	 * Modifica el parametro año de tipo Integer de un objeto tipo Cancion
	 * 
	 * @param datoAcambiar
	 * @param datoNuevo
	 * @author Carlos Jimenez
	 * @vesion 1.0
	 */
	public void cambiarAtributo(int datoAcambiar, int datoNuevo) {

		// Inserto la sentencia SQL para que modifique el año en la base de datos
		String sqlAno = ("UPDATE canciones_ingles SET ano = '" + datoNuevo + "' WHERE ano = '" + datoAcambiar + "';");
		BaseDatos.ejecutarSql(sqlAno);
	}

	/**
	 * Elimina un objeto de la clase canción apartir del título
	 * 
	 * @param datoAeliminar
	 * @author Carlos Jimenez
	 * @version 1.0
	 */
	public void eliminar(String datoAeliminar) {

		// Inserto la sentencia SQL para que elimine la canción de la base de datos
		String sql = ("DELETE FROM canciones_ingles WHERE titulo = '" + datoAeliminar + "';");
		BaseDatos.ejecutarSql(sql);
	}

	/**
	 * Busca en los atributos de tipo string de listas de música Hace un SELECT
	 * sobre la base de datos
	 * 
	 * @param atributo
	 * @param textoAbuscar
	 */
	public void buscar(int atributo, String textoAbuscar) {

		switch (atributo) {

		case 1:// Busca por título

			// Inserto la sentencia SQL para que busque la canción de la base de datos por
			// título
			BaseDatosSelect.ejecutarSqlSelect(
					"SELECT titulo,artista,genero,ano,estado_animo FROM canciones_ingles WHERE titulo = '"
							+ textoAbuscar + "';");

			break;

		case 2:// Busca por artista

			// Inserto la sentencia SQL para que busque la canción de la base de datos por
			// artista
			BaseDatosSelect.ejecutarSqlSelect(
					"SELECT titulo,artista,genero,ano,estado_animo FROM canciones_ingles WHERE artista = '"
							+ textoAbuscar + "';");
			break;

		case 3:// Busca por Genero

			// Inserto la sentencia SQL para que busque la canción de la base de datos por
			// genero
			BaseDatosSelect.ejecutarSqlSelect(
					"SELECT titulo,artista,genero,ano,estado_animo FROM canciones_ingles WHERE genero = '"
							+ textoAbuscar + "';");
			break;

		case 5:// Busca por estado de ánimo

			// Inserto la sentencia SQL para que busque la canción de la base de datos por
			// estado de ánimo
			BaseDatosSelect.ejecutarSqlSelect(
					"SELECT titulo,artista,genero,ano,estado_animo FROM canciones_ingles WHERE estado_animo = '"
							+ textoAbuscar + "';");
			break;
		}
	}

	/**
	 * Busca en los atributos de tipo integer de listas de música Hace un SELECT
	 * sobre la base de datos
	 * 
	 * @param atributo
	 * @param datoAbuscar
	 */
	public void buscarInt(int datoAbuscar) { // Busca por año

		// Inserto la sentencia SQL para que busque la canción de la base de datos por
		// año
		BaseDatosSelect
				.ejecutarSqlSelect("SELECT titulo,artista,genero,ano,estado_animo FROM canciones_ingles WHERE ano = '"
						+ datoAbuscar + "';");
	}

}
