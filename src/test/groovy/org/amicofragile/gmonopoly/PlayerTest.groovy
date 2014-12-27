package org.amicofragile.gmonopoly

import static org.junit.Assert.*;

class PlayerTest {
	def static final NAME = "Merckx"
	def static final LOCATION = new BoardLocation("Somewhere")
	
	@org.junit.Test
	void playerHoldsNameAndLocation() {
		def player = new Player(name : NAME, location: LOCATION)
		assertEquals(NAME, player.name)
		assertEquals(LOCATION, player.location)
	}
	
	@org.junit.Test
	void checkInToALocation() {
		def player = new Player(name : NAME)
		assertNull(player.location)
		player.checkInTo(LOCATION)
		assertEquals(LOCATION, player.location)
	}
}
