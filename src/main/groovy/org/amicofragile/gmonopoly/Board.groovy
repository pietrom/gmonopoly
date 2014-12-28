package org.amicofragile.gmonopoly

class Board {
	private List locations = []
	private BoardLocation first, last
	
	def addLocation(BoardLocation l) {
		if(locations.isEmpty()) {
			first = l
			last = l
		} else {
			last.next = l
			l.next = first
			last = l
		}
		locations << l
	}
	
	def getLocationAt(int index) {
		locations[index]
	}
	
	def String toString() {
		locations.join("\n")
	}
}
