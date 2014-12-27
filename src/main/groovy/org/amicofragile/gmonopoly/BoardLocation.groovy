package org.amicofragile.gmonopoly

class BoardLocation {
	def name
	def next
	def players = []
	
	def BoardLocation(String name) {
		this.name = name
	}
	
	def next() {
		next
	}
	
	def next(int steps) {
		if(steps == 1) {
			next()
		} else {
			next.next(steps -1)
		}
	}
	
	def checkIn(Player p) {
		players << p
	}
	
	def String toString() {
		"${name}: " + players.join(", ")
	}
}
