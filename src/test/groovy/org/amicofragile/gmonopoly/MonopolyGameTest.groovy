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
	
	@Test
	void everyPlayerPlaysTwentyRounds() {
		def board = new Board()
		def players = []
		def horse = new Player(name : "Horse")
		def horseRoundCount = 0
		horse.metaClass.roll = { int dicesValue ->
			horseRoundCount++
		}
		players.add(horse)
		
		def cat = new Player(name : "Cat")
		def catRoundCount = 0
		cat.metaClass.roll = { int dicesValue ->
			catRoundCount++
		}
		players.add(cat)
		def game = new MonopolyGame(board, players)
		game.play()
		assertEquals(20, horseRoundCount)
		assertEquals(20, catRoundCount)
	}
	
	@org.junit.Test
	void givenTwoPlayersInHundredGamesThanBothPossibleOrdersOccur() {
		def accumulator = ""
		def pl1 = new Player(name : "PL1")
		pl1.metaClass.roll = { int dicesValue ->
			accumulator += "1"
		}
		def pl2 = new Player(name : "PL2")
		pl2.metaClass.roll = { int dicesValue ->
			accumulator += "2"
		}
		def players = []
		players.add(pl1)
		players.add(pl2)
		
		def order12occurred = false
		def order21occurred = false
		100.times {
			def game = new MonopolyGame(new Board(), players)
			accumulator = ""
			game.play()
			if(accumulator.equals("12" * 20)) {
				order12occurred = true
			} else if (accumulator.equals("21" * 20)) {
				order21occurred = true
			} else {
			println accumulator
				fail("Order cant'change during the game")
			}
		}
		assertTrue(order12occurred)
		assertTrue(order21occurred)
	}
}
