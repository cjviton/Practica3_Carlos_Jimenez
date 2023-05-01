package control_utilidades;

import java.util.ArrayList;
import datos.BaseDatos;
import datos.BaseDatosSelect;
import usuario.Util;
/**
 * Objetos de la calse Listan In
 * @author Carlos
 * @ version 1.0
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
	 * Añade canciones en mi lista de ingles mediante scanner
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
	 * Verifica si la lista está vacía
	 * 
	 * @author Carlos Jimenez 
	 * @version1.0
	 */
	public boolean vacia() {
		boolean vacio = true;
		if (miListaIn.isEmpty()) {

		} else {
			vacio = false;
		}
		return vacio;
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

		for (Cancion item : miListaIn) {

			switch (atributo) {

			case 1:// modifiac título

				if (item.getTitulo().equals(datoAcambiar)) {
					item.setTitulo(datoNuevo);
					//Inserto la sentencia SQL para que modifique el titulo en la base de datos
					String sql= ("UPDATE canciones_ingles SET titulo = '"+ datoNuevo+"' WHERE titulo = '"+datoAcambiar+"';");
					BaseDatos.ejecutarSql(sql);		
				}
				break;

			case 2:// modifica artista

				if (item.getArtista().equals(datoAcambiar)) {
					item.setArtista(datoNuevo);
					//Inserto la sentencia SQL para que modifique el artista en la base de datos
					String sql= ("UPDATE canciones_ingles SET artista = '"+ datoNuevo+"' WHERE artista = '"+datoAcambiar+"';");
					BaseDatos.ejecutarSql(sql);	
				}
				break;

			case 3:// Modifica Genero

				if (item.getGenero().equals(datoAcambiar)) {
					item.setGenero(datoNuevo);
					//Inserto la sentencia SQL para que modifique el genero en la base de datos
					String sql= ("UPDATE canciones_ingles SET genero = '"+ datoNuevo+"' WHERE genero = '"+datoAcambiar+"';");
					BaseDatos.ejecutarSql(sql);	
				}
				break;

			case 5:// Modifica estado de ánimo
				if (item.getEstadoAnimo().equals(datoAcambiar)) {
					item.setEstadoAnimo(datoNuevo);
					//Inserto la sentencia SQL para que modifique el estado de animo en la base de datos
					String sql= ("UPDATE canciones_ingles SET estado_animo = '"+ datoNuevo+"' WHERE estado_animo = '"+datoAcambiar+"';");
					BaseDatos.ejecutarSql(sql);	
				}
				break;
			}
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

		for (Cancion item : miListaIn) {
			if (item.getAno() == datoAcambiar) {
				item.setAno(datoNuevo);
				//Inserto la sentencia SQL para que modifique el año en la base de datos
				String sql= ("UPDATE canciones_ingles SET ano = '"+ datoNuevo+"' WHERE ano = '"+datoAcambiar+"';");
				BaseDatos.ejecutarSql(sql);	
			}
		}
	}

	/**
	 * Elimina un objeto de la clase canción apartir del título
	 * @param datoAeliminar
	 * @author Carlos Jimenez
	 * @version 1.0
	 */
	public void eliminar(String datoAeliminar) {
		int longitud = miListaIn.size();
		int i=0;
		boolean encontrado = false;
				
		if (longitud > 0 ) {
			do {
				if (miListaIn.get(i).getTitulo().equals(datoAeliminar)) {
					miListaIn.remove(i);
					//Inserto la sentencia SQL para que elimine la canción de la base de datos
					String sql= ("DELETE FROM canciones_ingles WHERE titulo = '" + datoAeliminar + "';"); 
					BaseDatos.ejecutarSql(sql);	
					encontrado=true;
				}
				i++;
			}while (i < longitud && !encontrado);
		
		}
	}
	
	
	/**
	 * Busca en los atributos de tipo string de listas de música
	 * @param atributo
	 * @param textoAbuscar
	 */
      public void buscar(int atributo, String textoAbuscar) {

			switch (atributo) {

			case 1:// Busca por título

				//Inserto la sentencia SQL para que busque la canción de la base de datos por título
				BaseDatosSelect.ejecutarSqlSelect("SELECT titulo,artista,genero,ano,estado_animo FROM canciones_ingles WHERE titulo = '" + textoAbuscar + "';");
				
				break;

			case 2:// Busca por artista

				//Inserto la sentencia SQL para que busque la canción de la base de datos por artista
				BaseDatosSelect.ejecutarSqlSelect("SELECT titulo,artista,genero,ano,estado_animo FROM canciones_ingles WHERE artista = '" + textoAbuscar + "';");
				break;

			case 3:// Busca por Genero

				//Inserto la sentencia SQL para que busque la canción de la base de datos por genero
				BaseDatosSelect.ejecutarSqlSelect("SELECT titulo,artista,genero,ano,estado_animo FROM canciones_ingles WHERE genero = '" + textoAbuscar + "';");
				break;

			case 5:// Busca por estado de ánimo

				//Inserto la sentencia SQL para que busque la canción de la base de datos por estado de ánimo
				BaseDatosSelect.ejecutarSqlSelect("SELECT titulo,artista,genero,ano,estado_animo FROM canciones_ingles WHERE estado_animo = '" + textoAbuscar + "';");
				break;
			}
		}
  

	
	/**
	 * Busca en los atributos de tipo integer de listas de música
	 * @param atributo
	 * @param datoAbuscar
	 */
	public void buscarInt(int datoAbuscar) { //Busca por año
	
			//Inserto la sentencia SQL para que busque la canción de la base de datos por año
			BaseDatosSelect.ejecutarSqlSelect("SELECT titulo,artista,genero,ano,estado_animo FROM canciones_ingles WHERE ano = '" + datoAbuscar + "';");
	   }	
	}


