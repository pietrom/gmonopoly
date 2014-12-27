package org.amicofragile.gmonopoly

class BoardLocation {
	def name
	def next
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
}
