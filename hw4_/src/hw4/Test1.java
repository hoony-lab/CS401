package hw4;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import hw4.Square.Route;

public class Test1 {

	@Test
	public void test() {
		Board board = new Board();

		CardRoute cardRoute = new CardRoute(Route.BLUE);
		CardRoute cardRoute2 = new CardRoute(Route.BLACK);
		List<CardRoute> routeOnHand = new ArrayList<>();
		routeOnHand.add(cardRoute);
		routeOnHand.add(cardRoute2);

		// 1. place train car on board
		assertEquals(board.placeRoute(routeOnHand.get(0), 0, 0, 0, 3), true);
		// 2. place another train car on board
		assertEquals(board.placeRoute(routeOnHand.get(1), 3, 0, 3, 4), true);

	}

}
