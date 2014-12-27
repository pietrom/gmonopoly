package org.amicofragile.gmonopoly

import static org.junit.Assert.*;

class BoardLocationTest {
	@org.junit.Test
	void boardLocationHoldsAName() {
		def name = "South Station"
		def location = new BoardLocation(name)
		assertEquals(name, location.name)
	}
	
	@org.junit.Test
	void boardLocationHasNext() {
		def loc1 = new BoardLocation("L1")
		def loc2 = new BoardLocation("L2")
		loc1.next = loc2
		assertEquals(loc2, loc1.next())
	}
	
	@org.junit.Test
	void nextNavigationCanBeRecursive() {
		def loc0 = new BoardLocation("L0")
		def prev = loc0
		(1..5).each {
			println it
			def loc = new BoardLocation("L${it}")
			prev.next = loc
			prev = loc
		}
		assertEquals("L4", loc0.next(4).name)
	}
}
