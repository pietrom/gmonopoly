package org.amicofragile.gmonopoly

class Board {
	def List locations = []
	def first, last
	
	def addLocation(BoardLocation l) {
		if(locations.isEmpty()) {
			first = l
			last = l
		} else {
			last.next = l
			last = l
		}
		locations << l
	}
	
	def getLocationAt(int index) {
		locations[index]
	}
}
