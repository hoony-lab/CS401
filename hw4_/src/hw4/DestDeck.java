package hw4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DestDeck {

	List<CardDest> destDeck;

	public DestDeck() {
		Square.Dest[] dests = Square.Dest.values();
		destDeck = new ArrayList<>();
		for (int destIndex1 = 0; destIndex1 < dests.length - 1; destIndex1++) {
			for (int destIndex = 0; destIndex < dests.length - 1; destIndex++) {
				destDeck.add(new CardDest(dests[destIndex]));
			}
		}
	}

	public void shuffle() {
		Collections.shuffle(destDeck);
	}

	public CardDest drawDest() {
		int lastIndex = destDeck.size() - 1;
		CardDest result;
		if (lastIndex < 0) {
			return null;
		}
		result = destDeck.get(lastIndex);
		destDeck.remove(lastIndex);
		return result;
	}
}
