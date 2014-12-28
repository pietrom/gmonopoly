package org.amicofragile.gmonopoly

import static org.junit.Assert.*;

import org.junit.Test;
import org.omg.PortableInterceptor.LOCATION_FORWARD;

class PlayerTest {
	def static final NAME = "Merckx"
	def static final LOCATION = new BoardLocation("Somewhere")

	@org.junit.Test
	void playerHoldsNameAndLocation() {
		def player = new Player(NAME, LOCATION)
		assertEquals(NAME, player.name)
		assertEquals(LOCATION, player.location)
	}

	@org.junit.Test
	void checkInToALocation() {
		def player = new Player(NAME)
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
		def player = new Player(NAME, start)
		player.move(dicesValue)
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
		def player = new Player(NAME)
		player.checkInTo(start)
		assertTrue(start.players.contains(player))
		assertFalse(stop.players.contains(player))
		player.move(3)
		assertFalse(start.players.contains(player))
		assertTrue(stop.players.contains(player))
	}
	
	@org.junit.Test
	void moveFromStartLocation() {
		def board = new Board()
		(0..39).each {
			board.addLocation(new BoardLocation("BL${it}"))
		}
		def player = new Player(NAME, board.getLocationAt(0))
		def dices = new DicePair()
		dices.metaClass.generateStepsNumber = { 7 }
		player.play(dices)
		assertEquals(board.getLocationAt(7), player.location)
	}
	
	@org.junit.Test
	void moveCrossingBoardLimit() {
		def board = new Board()
		(0..39).each {
			board.addLocation(new BoardLocation("BL${it}"))
		}
		def player = new Player(NAME, board.getLocationAt(39))
		def dices = new DicePair()
		dices.metaClass.generateStepsNumber = { 6 }
		player.play(dices)
		assertEquals(board.getLocationAt(5), player.location)
	}
}
