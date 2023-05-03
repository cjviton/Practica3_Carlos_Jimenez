package usuario;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UtilTest {

	@Test
	void testMensaje() {
		String texto= "correcto";
		System.out.println("correcto");
		
		assertEquals(texto,"correcto");			
	}

	

}
