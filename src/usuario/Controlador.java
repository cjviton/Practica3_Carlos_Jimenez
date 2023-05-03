package usuario;

import control_utilidades.ListaES;
import control_utilidades.ListaIN;
import datos.BaseDatosSelect;

/**
 * Clase controlador para ejecución del programa
 * 
 * @author Carlos Jiménez
 * @verion 1.0
 *
 */
public class Controlador {
	public static void main(String[] args) {

		int opcion = 0;
		int opcionCancionesES = 0;
		int opcionCancionesIN = 0;

		ListaES miListaEspanol = new ListaES("Carlos"); // Creo mi lista para español
		ListaIN miListaIngles = new ListaIN("Diana"); // Creo mi lista para ingles

		boolean vaciaEs = false;
		boolean vaciaIn = false;

		int parametroAmodidficarEs = 0;
		String datoOutEs;
		String datoInEs;
		int datoOutEsInteger = 0;
		int datoInEsInteger = 0;

		int parametroAmodidficarIn = 0;
		String datoOutIn;
		String datoInIn;
		int datoOutInInteger = 0;
		int datoInInInteger = 0;

		String cancionDelEs;
		String cancionDelIn;

		int parametroAbuscarEs = 0;
		int parametroAbuscarIn = 0;
		String datoFindEs;
		String datoFindIn;
		int datoFindEsInteger = 0;
		int datoFindInInteger = 0;
		;

		try {
			Util.mensaje(
					"*******************************************************************************************************");
			Util.mensaje(
					"******************************_____HOLA, BIENVENIDO A TU SPOTIFY____***********************************");
			Util.mensaje(
					"*******************************************************************************************************");
			opcion = 0;
			while (opcion != 3) { // El switch se debe repetir hasta que elija la opción 3 Salir.Devolverá mensaje
									// de error si no elige entre 1 y 3

				opcion = Util.menu3opciones("¿Quiéres tu lista de reproducción en español?",
						"¿Quiéres tu lista de reproducción en ingles?", "¿Quiéres Salir?");

				switch (opcion) {// Este switch nos introduce en el menú de listas en español o en ingles
				case 1:// canciones español
					opcionCancionesES = 0;
					while (opcionCancionesES != 5) { // El switch se debe repetir hasta que elija la opción 5 Salir.
														// Devolverá mensaje de error si no elige entre 1 y 5

						Util.mensaje("¿Qué quiéres hacer en tu lista de reproducción en español?");

						opcionCancionesES = Util.menu5opciones("¿Quiéres añadir una canción?",
								"¿Quieres modificar una canción?", "¿Quiéres eliminar una canción?",
								"¿Quieres busccar una canción?", "¿Quiéres salir?");

						switch (opcionCancionesES) {// Este switch nos intruduce dentro del menú de canciones en español

						case 1:// Añadir canción español
							Util.mensaje("Aquí puedes añadir tu nueva canción a la lista de reproducción");
							miListaEspanol.addcancionEs();

							Util.mensaje("Esta es tu lista de canciones en español");
							BaseDatosSelect.ejecutarSqlSelect("SELECT * FROM canciones_espanol ;"); // Muestro las
																									// canciones de mi
																									// BBDD mediante
																									// Select

							break;

						case 2:// Modificar canción español
								// Si la lista está vacía, me informa y no y no me deja modidficar.

							vaciaEs = datos.BaseDatosVacia.bdVacia("SELECT COUNT(*) FROM canciones_espanol");

							if (vaciaEs == true) {
								System.out.println("No se pueden modificar canciones porque tu lista está vacia.");
							} else { // Muestra la lista de canciones para confirmar
										// el dato a modificar

								Util.mensaje("Esta es tu lista d canciones en español");
								BaseDatosSelect.ejecutarSqlSelect("SELECT * FROM canciones_espanol ;"); // Muestro las
																										// canciones de
																										// mi BBDD
																										// mediante
																										// Select

								Util.mensaje("¿Qué quiéres modificar?");
								parametroAmodidficarEs = Util.menu5opciones("Titulo", "Artista", "Género", "Año",
										"Estado de ánimo");

								if (parametroAmodidficarEs == 4) {// Hago una condición por si el parámetro a cambiar es
																	// año de tipo Integer

									datoOutEsInteger = Util.pedirInt("¿Cuál quiéres modificar?");

									datoInEsInteger = Util.pedirInt("¿Cuál quiéres introducir en su lugar?");

									miListaEspanol.cambiarAtributo(datoOutEsInteger, datoInEsInteger);

									Util.mensaje("Esta es tu lista de canciones en español");
									BaseDatosSelect.ejecutarSqlSelect("SELECT * FROM canciones_espanol ;"); // Muestro
																											// las
																											// canciones
																											// de mi
																											// BBDD
																											// mediante
																											// Select

								} else {

									datoOutEs = Util.pedirString("¿Cuál quiéres modificar?");

									datoInEs = Util.pedirString("¿Cuál quiéres introducir en su lugar?");

									miListaEspanol.cambiarAtributo(parametroAmodidficarEs, datoOutEs, datoInEs);

									Util.mensaje("Esta es tu lista de canciones en español");
									BaseDatosSelect.ejecutarSqlSelect("SELECT * FROM canciones_espanol ;"); // Muestro
																											// las
																											// canciones
																											// de mi
																											// BBDD
																											// mediante
																											// Select
								}
							}

							break;

						case 3:// Eliminar canción español
								// Si la lista está vacía, me informa y no y no me deja modidficar.
							vaciaEs = datos.BaseDatosVacia.bdVacia("SELECT COUNT(*) FROM canciones_espanol");

							if (vaciaEs == true) {
								System.out.println("No se pueden modificar canciones porque tu lista está vacia.");
							} else {
								Util.mensaje("Esta es tu lista de canciones en español");
								BaseDatosSelect.ejecutarSqlSelect("SELECT * FROM canciones_espanol ;"); // Muestro las
																										// canciones de
																										// mi BBDD
																										// mediante
																										// Select

								cancionDelEs = Util.pedirString("¿Qué canción quieres eliminar?");

								miListaEspanol.eliminar(cancionDelEs);

								Util.mensaje("Esta es tu lista de canciones en español");
								BaseDatosSelect.ejecutarSqlSelect("SELECT * FROM canciones_espanol ;"); // Muestro las
																										// canciones de
																										// mi BBDD
																										// mediante
																										// Select
							}

							break;

						case 4:// Buscar canción español
								// Si la lista está vacía, me informa y no y no me deja modidficar.

							vaciaEs = datos.BaseDatosVacia.bdVacia("SELECT COUNT(*) FROM canciones_espanol");

							if (vaciaEs == true) {
								System.out.println("No se pueden buscar canciones porque tu lista está vacia.");
							} else {

								Util.mensaje("Esta es tu lista de canciones en español");
								BaseDatosSelect.ejecutarSqlSelect("SELECT * FROM canciones_espanol ;"); // Muestro las
																										// canciones de
																										// mi BBDD
																										// mediante
																										// Select

								Util.mensaje("¿Qué tipo de busqueda quiéres hacer?");
								parametroAbuscarEs = Util.menu5opciones("Titulo", "Artista", "Género", "Año",
										"Estado de ánimo");

								if (parametroAbuscarEs == 4) {// Hago una condición por si el parámetro a cambiar es
																// año de tipo Integer

									datoFindEsInteger = Util.pedirInt("¿La música de que año te apetece escuchar?");

									miListaEspanol.buscarInt(datoFindEsInteger);

								} else {

									datoFindEs = Util.pedirString("¿Qué palabra quieres usar para la búsqueda?");

									miListaEspanol.buscar(parametroAbuscarEs, datoFindEs);

								}

							}

							break;
						}
					}

					break;

//-------------------------------------------------------INGLES------------------------------------------------------------------------

				case 2:// canciones ingles
					opcionCancionesIN = 0;
					while (opcionCancionesIN != 5) { // El switch se debe repetir hasta que elija la opción 5 Salir.
						// Devolverá mensaje de error si no elige entre 1 y 5

						Util.mensaje("¿Qué quiéres hacer en tu lista de reproducción en ingles?");

						opcionCancionesIN = Util.menu5opciones("¿Quiéres añadir una canción?",
								"¿Quieres modificar una canción?", "¿Quiéres eliminar una canción?",
								"¿Quieres busccar una canción?", "¿Quiéres salir?");

						switch (opcionCancionesIN) {

						case 1:// Añadir canción ingles
							Util.mensaje("Aquí puedes añadir tu nueva canción a la lista de reproducción");
							miListaIngles.addcancionIn();

							Util.mensaje("Esta es tu lista de canciones en ingles");
							BaseDatosSelect.ejecutarSqlSelect("SELECT * FROM canciones_ingles ;"); // Muestro las
																									// canciones de mi
																									// BBDD mediante
																									// Select

							break;

						case 2:// Modificar canción ingles

							// Si la lista está vacía, me informa y no y no me deja modidficar.
							vaciaIn = datos.BaseDatosVacia.bdVacia("SELECT COUNT(*) FROM canciones_ingles");

							if (vaciaIn == true) {
								System.out.println("No se pueden modificar canciones porque tu lista está vacia.");
							} else { // Muestra la lista de canciones para confirmar
								// el dato a modificar
								Util.mensaje("Esta es tu lista de canciones en ingles");
								BaseDatosSelect.ejecutarSqlSelect("SELECT * FROM canciones_ingles ;"); // Muestro las
																										// canciones de
																										// mi BBDD
																										// mediante
																										// Select

								Util.mensaje("¿Qué quiéres modificar?");
								parametroAmodidficarIn = Util.menu5opciones("Titulo", "Artista", "Género", "Año",
										"Estado de ánimo");

								if (parametroAmodidficarIn == 4) {// Hago una condición por si el parámetro a cambiar es
																	// año de tipo Integer

									datoOutInInteger = Util.pedirInt("¿Cuál quiéres modificar?");

									datoInInInteger = Util.pedirInt("¿Cuál quiéres introducir en su lugar?");

									miListaIngles.cambiarAtributo(datoOutInInteger, datoInInInteger);

								} else {

									datoOutIn = Util.pedirString("¿Cuál quiéres modificar?");

									datoInIn = Util.pedirString("¿Cuál quiéres introducir en su lugar?");

									miListaIngles.cambiarAtributo(parametroAmodidficarIn, datoOutIn, datoInIn);

									Util.mensaje("Esta es tu lista de canciones en ingles");
									BaseDatosSelect.ejecutarSqlSelect("SELECT * FROM canciones_ingles ;"); // Muestro
																											// las
																											// canciones
																											// de mi
																											// BBDD
																											// mediante
																											// Select
								}
							}

							break;

						case 3:// Eliminar canción ingles

							// Si la lista está vacía, me informa y no y no me deja modidficar.
							vaciaIn = datos.BaseDatosVacia.bdVacia("SELECT COUNT(*) FROM canciones_ingles");

							if (vaciaIn == true) {
								System.out.println("No se pueden eliminar canciones porque tu lista está vacia.");
							} else {
								Util.mensaje("Esta es tu lista de canciones en ingles");
								BaseDatosSelect.ejecutarSqlSelect("SELECT * FROM canciones_ingles ;"); // Muestro las
																										// canciones de
																										// mi BBDD
																										// mediante
																										// Select

								cancionDelIn = Util.pedirString("¿Qué canción quieres eliminar?");

								miListaIngles.eliminar(cancionDelIn);

								Util.mensaje("Esta es tu lista de canciones en ingles");
								BaseDatosSelect.ejecutarSqlSelect("SELECT * FROM canciones_ingles ;"); // Muestro las
																										// canciones de
																										// mi BBDD
																										// mediante
																										// Select

							}

							break;

						case 4:// Buscar canción ingles

							// Si la lista está vacía, me informa y no y no me deja modidficar.
							vaciaIn = datos.BaseDatosVacia.bdVacia("SELECT COUNT(*) FROM canciones_ingles");

							if (vaciaIn == true) {
								System.out.println("No se pueden buscar canciones porque tu lista está vacia.");
							} else {

								Util.mensaje("Esta es tu lista de canciones en ingles");
								BaseDatosSelect.ejecutarSqlSelect("SELECT * FROM canciones_ingles ;"); // Muestro las
																										// canciones de
																										// mi BBDD
																										// mediante
																										// Select

								Util.mensaje("¿Qué tipo de busqueda quiéres hacer?");
								parametroAbuscarIn = Util.menu5opciones("Titulo", "Artista", "Género", "Año",
										"Estado de ánimo");

								if (parametroAbuscarIn == 4) {// Hago una condición por si el parámetro a cambiar es
																// año de tipo Integer

									datoFindInInteger = Util.pedirInt("¿La música de que año te apetece escuchar?");

									miListaIngles.buscarInt(datoFindInInteger);

								} else {

									datoFindIn = Util.pedirString("¿Qué palabra quieres usar para la búsqueda?");

									miListaIngles.buscar(parametroAbuscarIn, datoFindIn);

								}

							}

							break;

						}
					}
					break;
				}
			}

		} catch (Exception e) {
			System.out.println("Has introducido un dato erroneo. Vuelve a iniciar el programa");
		}

	}

}
