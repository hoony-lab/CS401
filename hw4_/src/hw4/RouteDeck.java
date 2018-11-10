package hw4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RouteDeck {

	List<CardRoute> routeDeck;

	public RouteDeck() {
		Square.Symbol[] routes = Square.Symbol.values();
		routeDeck = new ArrayList<>();
		for (int routeIndex1 = 3; routeIndex1 < routes.length - 1; routeIndex1++) {
			for (int routeIndex = 3; routeIndex < routes.length - 1; routeIndex++) {
				routeDeck.add(new CardRoute(routes[routeIndex]));
			}
		}
	}

	public void shuffle() {
		Collections.shuffle(routeDeck);
	}

	public CardRoute drawRoute() {
		int lastIndex = routeDeck.size() - 1;
		CardRoute result;
		if (lastIndex < 0) {
			return null;
		}
		result = routeDeck.get(lastIndex);
		routeDeck.remove(lastIndex);
		return result;
	}
}
