package control_utilidades;

/**
 * Objetos de la clase canción
 * Constructor con atributo id_cancion
 * y sin atributo id_concion
 * @author Carlos
 * @version 1.0
 *
 */
public class Cancion {
	private int id_cancion;
	private String titulo;
	private String artista;
	private String genero;
	private int ano;
	private String EstadoAnimo;

	// Genero dos constructores, uno con id_cancion y otro sin el. En el momento de
	// insertar en la base de datos
	// usaré el que no tiene id_cancion al ser autoincremental

	public Cancion(int id_cancion, String titulo, String artista, String genero, int ano, String estadoAnimo) {
		super();
		this.id_cancion = id_cancion;
		this.titulo = titulo;
		this.artista = artista;
		this.genero = genero;
		this.ano = ano;
		EstadoAnimo = estadoAnimo;
	}

	public Cancion(String titulo, String artista, String genero, int ano, String estadoAnimo) {
		super();
		this.titulo = titulo;
		this.artista = artista;
		this.genero = genero;
		this.ano = ano;
		EstadoAnimo = estadoAnimo;
	}

	public int getId_cancion() {
		return id_cancion;
	}

	public void setId_cancion(int id_cancion) {
		this.id_cancion = id_cancion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getEstadoAnimo() {
		return EstadoAnimo;
	}

	public void setEstadoAnimo(String estadoAnimo) {
		EstadoAnimo = estadoAnimo;
	}

	@Override
	public String toString() {
		return "Cancion [id_cancion=" + id_cancion + ", titulo=" + titulo + ", artista=" + artista + ", genero="
				+ genero + ", ano=" + ano + ", EstadoAnimo=" + EstadoAnimo + "]";
	}

}
