package control_utilidades;

import java.util.ArrayList;

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

		miListaEs.add(new Cancion(titulo, artista, genero, ano, EstadoAnimo));
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

		for (Cancion item : miListaEs) {

			switch (atributo) {

			case 1:// modifiac título

				if (item.getTitulo().equals(datoAcambiar)) {
					item.setTitulo(datoNuevo);
				}
				break;

			case 2:// modifica artista

				if (item.getArtista().equals(datoAcambiar)) {
					item.setArtista(datoNuevo);
				}
				break;

			case 3:// Modifica Genero

				if (item.getGenero().equals(datoAcambiar)) {
					item.setGenero(datoNuevo);
				}
				break;

			case 5:// Modifica estado de ánimo
				if (item.getEstadoAnimo().equals(datoAcambiar)) {
					item.setEstadoAnimo(datoNuevo);
				}
				break;
			}
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

		for (Cancion item : miListaEs) {
			if (item.getAno() == datoAcambiar) {
				item.setAno(datoNuevo);
			}
		}
	}

	/**
	 * Elimina un objeto de la clase canción apartir del título en listas de música
	 * 
	 * @param datoAeliminar
	 * @author Carlos Jimenez
	 * @version 1.0
	 */
	public void eliminar(String datoAeliminar) {
		int longitud = miListaEs.size();
		int i = 0;
		boolean encontrado = false;

		if (longitud > 0) {
			do {
				if (miListaEs.get(i).getTitulo().equals(datoAeliminar)) {
					miListaEs.remove(i);
					encontrado = true;
				}
				i++;
			} while (i < longitud && !encontrado);

		}
	}

	/**
	 * Busca en los atributos de tipo string de listas de música
	 * 
	 * @param atributo
	 * @param textoAbuscar
	 */
	public void buscar(int atributo, String textoAbuscar) {

		for (Cancion item : miListaEs) {

			switch (atributo) {

			case 1:// Busca por título

				if (item.getTitulo().equals(textoAbuscar)) {
					System.out.println(item);
				}
				break;

			case 2:// Busca por artista

				if (item.getArtista().equals(textoAbuscar)) {
					System.out.println(item);
				}
				break;

			case 3:// Busca por Genero

				if (item.getGenero().equals(textoAbuscar)) {
					System.out.println(item);
				}
				break;

			case 5:// Busca por estado de ánimo

				if (item.getEstadoAnimo().equals(textoAbuscar)) {
					System.out.println(item);
					break;
				}
			}
		}
	}

	/**
	 * Busca en los atributos de tipo integer de listas de música
	 * 
	 * @param atributo
	 * @param datoAbuscar
	 */
	public void buscarInt(int datoAbuscar) { // Busca por año
		for (Cancion item : miListaEs) {

			if (item.getAno() == datoAbuscar) {
				System.out.println(item);
			}
		}
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

}
