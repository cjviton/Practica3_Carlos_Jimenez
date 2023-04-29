package control_utilidades;

import java.util.Scanner;

/**
 * Clase utilidades con métodos
 * 
 * @author Carlos @ version 1.0
 */
public class Util {

	/**
	 * Muestra un mensaje por consola
	 * 
	 * @param mensaje a mostrar
	 * @author Carlos Jiménez
	 * @version 1.0
	 */

	public static void mensaje(String mensaje) {
		System.out.println(mensaje);
	}

	/**
	 * Muestra un menú con 3 opciones en consola. Devolverá mensaje de error si no
	 * elige entre 1 y 3
	 * 
	 * @param opcion1 Texto con nuestra opcón 1
	 * @param opcion2 Texto con nuestra opcón 2
	 * @param opcion3 Texto con nuestra opcón 3
	 * @return devuelve un número entero entre 1 y 3
	 * @author Carlos Jiménez
	 * @version 1.0
	 */

	public static int menu3opciones(String opcion1, String opcion2, String opcion3) {

		System.out.println("1.-" + opcion1);
		System.out.println("2.-" + opcion2);
		System.out.println("3.-" + opcion3);

		int numero;
		boolean valido = true;

		Scanner lector = new Scanner(System.in);

		do {
			numero = lector.nextInt();
			lector.nextLine();
			if (numero < 1 || numero > 3) {
				System.out.println("El número introducido no es correcto");
				valido = false;
			} else {
				valido = true;
			}
		} while (!valido);
		return numero;

	}

	/**
	 * Muestra un menú con 5 opciones en consola. Devolverá mensaje de error si no
	 * elige entre 1 y 5
	 * 
	 * @param opcion1 Texto con nuestra opcón 1
	 * @param opcion2 Texto con nuestra opcón 2
	 * @param opcion3 Texto con nuestra opcón 3
	 * @param opcion4 Texto con nuestra opcón 4
	 * @param opcion5 Texto con nuestra opcón 5
	 * @return devuelve un número entero entre 1 y 5
	 * @author Carlos Jiménez
	 * @version 1.0
	 */

	public static int menu5opciones(String opcion1, String opcion2, String opcion3, String opcion4, String opcion5) {

		System.out.println("1.-" + opcion1);
		System.out.println("2.-" + opcion2);
		System.out.println("3.-" + opcion3);
		System.out.println("4.-" + opcion4);
		System.out.println("5.-" + opcion5);

		int numero;
		boolean valido = true;

		Scanner lector = new Scanner(System.in);

		do {
			numero = lector.nextInt();
			lector.nextLine();
			if (numero < 1 || numero > 5) {
				System.out.println("El número introducido no es correcto");
				valido = false;
			} else {
				valido = true;
			}
		} while (!valido);
		return numero;

	}

	/**
	 * Método para pedir un palabra.
	 * 
	 * @author Carlos_Jiménez
	 * @version 1.0
	 * @param texto Es el mensaje que se mostrará al usuario para pedir la palabra.
	 * @return Palabra introducida por el usuario.
	 */

	public static String pedirString(String texto) {

		String palabra;
		Scanner lector = new Scanner(System.in);
		System.out.println(texto);
		palabra = lector.nextLine();

		return palabra;
	}

	/**
	 * Método para pedir un número entero.
	 * 
	 * @author Carlos_Jiménez
	 * @version 1.0
	 * @param texto Es el mensaje que se mostrará al usuario para pedir el número.
	 * @return El número entero introducido por el usuario.
	 */

	public static int pedirInt(String texto) {

		int numero;

		Scanner lector = new Scanner(System.in);

		System.out.println(texto);
		numero = lector.nextInt();
		lector.nextLine();

		return numero;
	}

}
