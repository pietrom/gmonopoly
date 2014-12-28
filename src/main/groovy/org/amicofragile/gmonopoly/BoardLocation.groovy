package org.amicofragile.gmonopoly

class BoardLocation {
	private String name
	private BoardLocation next
	private List players = []
	
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
	
	def checkOut(Player p) {
		players.remove(p)
	}
	
	def String toString() {
		"${name}: " + players.join(", ")
	}
}
