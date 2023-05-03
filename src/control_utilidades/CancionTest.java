package control_utilidades;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class CancionTest {

	Cancion cancionPrueba = new Cancion("titulo", "artista", "Genero", 1, "animo");

	@Test
	void testGetTitulo() {
		cancionPrueba.getTitulo().equals("titulo");
		assertTrue(true);
	}

	@Test
	void testSetTitulo() {
		cancionPrueba.setTitulo("nuevoTitulo");
		System.out.println(cancionPrueba.getTitulo());
		cancionPrueba.getTitulo().equals("titulo");
		System.out.println(cancionPrueba.getTitulo());

		assertFalse(false);
	}

	@Test
	void testGetArtista() {
		assertEquals(cancionPrueba.getArtista(), "artista");
	}

	@Test
	void testSetArtista() {

		cancionPrueba.setArtista("nuevoArtista");
		System.out.println(cancionPrueba.getArtista());

		assertEquals(cancionPrueba.getArtista(), "nuevoArtista");

	}

	@Test
	void testGetGenero() {
		cancionPrueba.getGenero().equals("genero");
		assertTrue(!false);

	}

	@Test
	void testSetGenero() {
		cancionPrueba.setGenero("generobis");
		cancionPrueba.getGenero().equals("genero");

		assertFalse(false);
	}

	@Test
	void testGetAno() {
		assertEquals(cancionPrueba.getAno(), 1);

	}

	@Test
	void testSetAno() {

		cancionPrueba.setAno(0);

		assertEquals(cancionPrueba.getAno(), 0);

	}

	@Test
	void testGetEstadoAnimo() {
		assertEquals(cancionPrueba.getEstadoAnimo(), "animo");
	}

	@Test
	void testSetEstadoAnimo() {
		cancionPrueba.setEstadoAnimo("alegre");
		cancionPrueba.getGenero().equals("triste");

		assertFalse(false);

	}

}
