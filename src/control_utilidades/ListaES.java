package control_utilidades;

import java.util.ArrayList;
import datos.BaseDatos;
import datos.BaseDatosSelect;
import usuario.Util;

/**
 * Objetos de la clase ListaEs
 * 
 * @author Carlos
 * @verison 1.0
 *
 */
public class ListaES {

	private String usuario;
	private ArrayList<Cancion> miListaEs = new ArrayList<Cancion>();

	public ListaES(String usuario) {
		super();
		this.usuario = usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public ArrayList<Cancion> getMiListaEs() {
		return miListaEs;
	}

	public void setMiListaEs(ArrayList<Cancion> miListaEs) {
		this.miListaEs = miListaEs;
	}

	@Override
	public String toString() {
		return "ListaES [usuario=" + usuario + ", miListaEs=" + miListaEs + "]";
	}

	/**
	 * Añade canciones en mi lista de español mediante scanner
	 * 
	 * @author Carlos Jimenez
	 * @version 1.0
	 */
	public void addcancionEs() { // Añadir canciones en mi lista de español mediante scanner
        
		
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
        
		Cancion miCancion = new Cancion(titulo, artista, genero, ano, EstadoAnimo); //Inicializo la canción nombrándola para poder asignarla
		miListaEs.add(miCancion);                                                   //a la variable sql
		String sql = datos.InsertSqlES.cancionAsql(miCancion);
		BaseDatos.ejecutarSql(sql);
		
	}


	
	
	/**
	 * Modifica el parametro de tipo String de un objeto tipo Cancion. Este método
	 * se complementa co el meétodo menu5opciones o con el método menu3opciones, que
	 * devuelve un dato de tipo integer, que será el que añadiremos en el parametro.
	 * Funciona con atributos de listas de música
	 * 
	 * @param atributo     Es de tipo Integer. complementar con método menu_opciones
	 * @param datoAcambiar
	 * @param datoNuevo
	 * @author Carlos Jimenez
	 * @version 1.0
	 */
	public void cambiarAtributo(int atributo, String datoAcambiar, String datoNuevo) {

			switch (atributo) {

			case 1:// modifiac título
				
					//Inserto la sentencia SQL para que modifique el titulo en la base de datos
				    String sqlTitulo= ("UPDATE canciones_espanol SET titulo = '"+ datoNuevo+"' WHERE titulo = '"+datoAcambiar+"';");
					BaseDatos.ejecutarSql(sqlTitulo);				
				
				break;

			case 2:// modifica artista

					//Inserto la sentencia SQL para que modifique el artista en la base de datos
					String sqlArtista= ("UPDATE canciones_espanol SET artista = '"+ datoNuevo+"' WHERE artista = '"+datoAcambiar+"';");
					BaseDatos.ejecutarSql(sqlArtista);											
				
				break;

			case 3:// Modifica Genero

					//Inserto la sentencia SQL para que modifique el genero en la base de datos
					String sqlGenero= ("UPDATE canciones_espanol SET genero = '"+ datoNuevo+"' WHERE genero = '"+datoAcambiar+"';");
					BaseDatos.ejecutarSql(sqlGenero);	
				
				break;

			case 5:// Modifica estado de ánimo

					//Inserto la sentencia SQL para que modifique el estado de animo en la base de datos
					String sqlEstado= ("UPDATE canciones_espanol SET estado_animo = '"+ datoNuevo+"' WHERE estado_animo = '"+datoAcambiar+"';");
					BaseDatos.ejecutarSql(sqlEstado);	
				
				break;
			
		}
	}

	/**
	 * Modifica el parametro año Integer en canciones de listas de música
	 * 
	 * @param datoAcambiar
	 * @param datoNuevo
	 * @author Carlos Jimenez
	 * @version 1.0
	 */

	public void cambiarAtributo(int datoAcambiar, int datoNuevo) {

				//Inserto la sentencia SQL para que modifique el año en la base de datos
				String sqlAno= ("UPDATE canciones_espanol SET ano = '"+ datoNuevo+"' WHERE ano = '"+datoAcambiar+"';");
				BaseDatos.ejecutarSql(sqlAno);	
		}
		
	

	/**
	 * Elimina un objeto de la clase canción apartir del título en listas de música
	 * 
	 * @param datoAeliminar
	 * @author Carlos Jimenez
	 * @version 1.0
	 */
	public void eliminar(String datoAeliminar) {
		
					//Inserto la sentencia SQL para que elimine la canción de la base de datos
					String sql= ("DELETE FROM canciones_espanol WHERE titulo = '" + datoAeliminar + "';"); 
					BaseDatos.ejecutarSql(sql);	
			
	}

	/**
	 * Busca en los atributos de tipo string de listas de música
	 * 
	 * @param atributo
	 * @param textoAbuscar
	 */
	public void buscar(int atributo, String textoAbuscar) {

			switch (atributo) {

			case 1:// Busca por título				
	
				//Inserto la sentencia SQL para que busque la canción de la base de datos por título
				BaseDatosSelect.ejecutarSqlSelect("SELECT titulo,artista,genero,ano,estado_animo FROM canciones_espanol WHERE titulo = '" + textoAbuscar + "';");
		    	
			break;

			case 2:// Busca por artista
                //Inserto la sentencia SQL para que busque la canción de la base de datos por artista
				BaseDatosSelect.ejecutarSqlSelect("SELECT titulo,artista,genero,ano,estado_animo FROM canciones_espanol WHERE artista = '" + textoAbuscar + "';");
				
				break;

			case 3:// Busca por Genero

				//Inserto la sentencia SQL para que busque la canción de la base de datos por genero
				BaseDatosSelect.ejecutarSqlSelect("SELECT titulo,artista,genero,ano,estado_animo FROM canciones_espanol WHERE genero = '" + textoAbuscar + "';");
									
				break;

			case 5:// Busca por estado de ánimo

				//Inserto la sentencia SQL para que busque la canción de la base de datos por estado de ánimmo
				BaseDatosSelect.ejecutarSqlSelect("SELECT titulo,artista,genero,ano,estado_animo FROM canciones_espanol WHERE estado_animo = '" + textoAbuscar + "';");
				
				break;
			}
      }
	
	

	/**
	 * Busca en los atributos de tipo integer de listas de música
	 * 
	 * @param atributo
	 * @param datoAbuscar
	 */
	public void buscarInt(int datoAbuscar) { // Busca por año
		
			//Inserto la sentencia SQL para que busque la canción de la base de datos por año
			BaseDatosSelect.ejecutarSqlSelect("SELECT titulo,artista,genero,ano,estado_animo FROM canciones_espanol WHERE ano = '" + datoAbuscar + "';");
			
	}

	
	
	
	/**
	 * Cambia el contenido del parametro titulo del un objeto cancion
	 * 
	 * @param tituloAcambiar
	 * @param tituloNuevo
	 */
	public void cambiartitulo(String tituloAcambiar, String tituloNuevo) {

		for (Cancion item : miListaEs) {
			if (item.getTitulo().equals(tituloAcambiar)) {
				item.setTitulo(tituloNuevo);
			}
		}
	}

	/**
	 * Busca la posición en la lista del titulo introducido por parametro
	 * 
	 * @param tituloBuscado
	 * @return indice
	 */
	public int buscarCancionPorTitulo(String tituloBuscado) {
		int posicionBuscada = -1;
		for (int i = 0; i < miListaEs.size(); i++) {
			if (miListaEs.get(i).getTitulo().equals(tituloBuscado)) {
				posicionBuscada = i;
			}
		}
		return posicionBuscada;
	}
	
	/**
	 * Verifica si la lista está vacía
	 * 
	 * @author Carlos Jimenez @version1.0
	 */
	public boolean vacia() {
		boolean vacio = true;
		if (miListaEs.isEmpty()) {

		} else {
			vacio = false;
		}
		return vacio;
	}

}
