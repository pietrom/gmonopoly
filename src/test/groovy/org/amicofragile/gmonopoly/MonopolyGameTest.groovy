package org.amicofragile.gmonopoly

import static org.junit.Assert.*;

import org.junit.Test;

class MonopolyGameTest {
	@org.junit.Test
	void initialLocationIsTheFirstForEveryUser() {
		def board = new Board()
		(0..10).each {
			board.addLocation(new BoardLocation("BL${it}"))
		}
		def players = []
		(1..3).each {
			players << new Player(name : "PL${it}")
		}
		def game = new MonopolyGame(board, players)
		(0..2).each {
			assertEquals(board.getLocationAt(0), players[it].location)
		}
	}
	
	@org.junit.Test(expected = IllegalArgumentException.class)
	void cantPlayWithLesserThanTwoPlayers() {
		def board = new Board()
		def players = []
		players.add(new Player(name : "Eddie"))
		def game = new MonopolyGame(board, players)
	}
	
	@org.junit.Test(expected = IllegalArgumentException.class)
	void cantPlayWithMoreThanEightPlayers() {
		def board = new Board()
		def players = []
		9.times {
			players.add(new Player(name : "PL${it}"))
		}
		def game = new MonopolyGame(board, players)
	}
}
