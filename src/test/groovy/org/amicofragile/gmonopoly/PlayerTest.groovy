package org.amicofragile.gmonopoly

import static org.junit.Assert.*;

import org.junit.Test;
import org.omg.PortableInterceptor.LOCATION_FORWARD;

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

	@org.junit.Test
	void givenADicesValueThePlayerMovesAwayOfValue() {
		def start = new BoardLocation("START")
		def stop = new BoardLocation("STOP")
		def dicesValue = 11
		def registeredSteps
		start.metaClass.next = { int i ->
			registeredSteps = i
			stop
		}
		def player = new Player(name : NAME, location: start)
		player.roll(dicesValue)
		assertEquals(stop, player.location)
		assertEquals(dicesValue, registeredSteps)
	}
	
	@Test
	void checkOutCheckIn() {
		def start = new BoardLocation("START")
		def stop = new BoardLocation("STOP")
		start.metaClass.next = { int i ->
			stop
		}
		def player = new Player(name : NAME)
		player.checkInTo(start)
		assertTrue(start.players.contains(player))
		assertFalse(stop.players.contains(player))
		player.roll(3)
		assertFalse(start.players.contains(player))
		assertTrue(stop.players.contains(player))
	}
}
