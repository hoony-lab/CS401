package hw4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RouteDeck {

	List<CardRoute> routeDeck;

	public RouteDeck() {
		Square.Route[] routes = Square.Route.values();
		routeDeck = new ArrayList<>();
		for (int routeIndex1 = 0; routeIndex1 < routes.length - 1; routeIndex1++) {
			for (int routeIndex = 0; routeIndex < routes.length - 1; routeIndex++) {
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
