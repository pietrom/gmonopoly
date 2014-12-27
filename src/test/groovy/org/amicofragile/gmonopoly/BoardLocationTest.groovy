package org.amicofragile.gmonopoly

import static org.junit.Assert.*;

class BoardLocationTest {
	@org.junit.Test
	void boardLocationHoldsAName() {
		def name = "South Station"
		def location = new BoardLocation(name)
		assertEquals(name, location.name)
	}
}
