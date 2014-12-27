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
}
