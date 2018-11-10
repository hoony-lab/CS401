package lab4_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab4.Board;
import lab4.Deck;
import lab4.Domino;
import lab4.Square;

class Lab44 {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("BeforeAll");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("AfterAll");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("BeforeEach");
		
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("AfterEach");
	}

	@Test
	void test() {
		
		System.out.println("Test");
		Board board = new Board();
		Domino domino = new Domino();
		Deck deck = new Deck();
		Square square = new Square();
		char[] testDomino = {'@','#'};
		
		try {
			assertEquals(true, square.match(domino.getDominoNum(testDomino)) ,
					"domino in board");
		} catch (Exception e) {
			// TODO: handle exception
			fail("Not yet implemented");
		}
	}
}
