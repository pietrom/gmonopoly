package org.amicofragile.gmonopoly

class Player {
	def String name
	def BoardLocation location
	
	def checkInTo(loc) {
		loc.checkIn(this)
		location = loc
	}
	
	def String toString() {
		name
	}
	
	def roll(int dicesValue) {
		location.checkOut(this)
		location = location.next(dicesValue)
		location.checkIn(this)
	}
}
