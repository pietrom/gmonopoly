package org.amicofragile.gmonopoly

class Player {
	def String name
	def BoardLocation location
	
	def checkInTo(loc) {
		location = loc
	}
}