package org.amicofragile.gmonopoly

class Player {
	private String name
	private BoardLocation location
	
	def Player(String name) {
		this(name, null)
	}
	
	def Player(String name, BoardLocation location) {
		this.name = name
		this.location = location
	}
	
	def checkInTo(loc) {
		loc.checkIn(this)
		location = loc
	}
	
	def String toString() {
		name
	}
	
	def move(int dicesValue) {
		location.checkOut(this)
		location = location.next(dicesValue)
		location.checkIn(this)
	}
	
	def play(DicePair gen) {
		int steps = gen.generateStepsNumber()
		move(steps)
	}
}
