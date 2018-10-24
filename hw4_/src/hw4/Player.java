package hw4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {

	String name;
	List<CardDest> destOnHand;
	List<CardRoute> routeOnHand;
	Board board;
	private static Scanner stdin = new Scanner(System.in);

	public Player(String _name, Board _board) {
		name = _name;
		board = _board;
		destOnHand = new ArrayList<>();
		routeOnHand = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	void addDest(CardDest dealt) {
		destOnHand.add(dealt);
	}
	void addRoute(CardRoute dealt) {
		routeOnHand.add(dealt);
	}
	public CardDest getDest(int cardToPlay) {
		return destOnHand.get(cardToPlay);
	}
	public CardRoute getRoute(int cardToPlay) {
		return routeOnHand.get(cardToPlay);
	}

	public void removeDest(int cardToPlay) {
		destOnHand.remove(cardToPlay);
	}
	public void removeRoute(int cardToPlay) {
		routeOnHand.remove(cardToPlay);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(name);
		result.append('\n');
		int cardIndex = 0;
		for (CardDest card : destOnHand) {
			result.append(cardIndex++);
			result.append(". ");
			result.append(card);
			result.append("    ");
		}
		result.append('\n');
		return result.toString();
	}
	
}
