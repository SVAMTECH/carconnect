package impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AdminServiceImplTest {

	@Test
	void testAuthentication() {
		AdminServiceImpl ad = new AdminServiceImpl();
		boolean actual = ad.authenticate(null, null);
		boolean expected = false;
		Assertions.assertEquals(expected,actual);
	}

}
