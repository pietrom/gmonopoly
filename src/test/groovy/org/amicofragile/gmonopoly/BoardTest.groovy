package org.amicofragile.gmonopoly

import static org.junit.Assert.*;

class BoardTest {
	@org.junit.Test
	void gameBoardHoldsAListOfLocations() {
		def board = new Board()
		(1..10).each {
			board.addLocation(new BoardLocation("BL${it}"))
		}
		def fourth = board.getLocationAt(3)
		assertEquals("BL4", fourth.name)
	}
	
	@org.junit.Test
	void gameBoardHandlesNextPointers() {
		def board = new Board()
		(1..10).each {
			board.addLocation(new BoardLocation("BL${it}"))
		}
		def first = board.getLocationAt(0)
		def sixth = board.getLocationAt(5)
		assertEquals(sixth, first.next(5))
	}
}
