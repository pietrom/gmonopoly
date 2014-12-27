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
	
	@org.junit.Test
	void gameBoardIsCircular() {
		def board = new Board()
		(1..40).each {
			board.addLocation(new BoardLocation("BL${it}"))
		}
		def loc36 = board.getLocationAt(37)
		def loc3 = board.getLocationAt(4)
		assertEquals(loc3, loc36.next(7))
	}
	
	@org.junit.Test
	void toStringShowsLocation() {
		def board = new Board()
		(1..5).each {
			board.addLocation(new BoardLocation("BL${it}"))
		}
		
	}
}
