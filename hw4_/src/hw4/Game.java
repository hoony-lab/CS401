package hw4;

import java.util.Scanner;

public class Game {

	Board board;
	Player[] players;
	DestDeck destDeck;
	RouteDeck routeDeck;
	static int num_players;
	static Scanner stdin = new Scanner(System.in);

	private static final int MAX_TRIES = 3;
	private static final String QUIT = "Q";

	public Game(int _numPlayers) {

		board = new Board();
		destDeck = new DestDeck();
		routeDeck = new RouteDeck();
		initPlayers(_numPlayers);
	}

	private void initPlayers(int num_players) {
		players = new Player[num_players];
		String name;
		destDeck.shuffle();
		routeDeck.shuffle();

		for (int playerIndex = 0; playerIndex < num_players; playerIndex++) {
			System.out.print("Please enter the name of player " + playerIndex + ": ");
			name = stdin.next();
			players[playerIndex] = new Player(name, board);
		}
		dealDestCard();
		dealRouteCard();
	}

	private void dealDestCard() {
		CardDest nextDest = destDeck.drawDest();
		int nextPlayer = 0;
		while (nextDest != null) {
			players[nextPlayer].addDest(nextDest);
			nextPlayer = otherPlayer(nextPlayer);
			nextDest = destDeck.drawDest();
		}
	}

	private void dealRouteCard() {
		CardRoute nextRoute = routeDeck.drawRoute();
		int nextPlayer = 0;
		while (nextRoute != null) {
			players[nextPlayer].addRoute(nextRoute);
			nextPlayer = otherPlayer(nextPlayer);
			nextRoute = routeDeck.drawRoute();
		}
	}

	private void play() {
		int nextPlayer = 0;
		while (true) {
			if (!playCard(players[nextPlayer])) {
				announceWinner(players[otherPlayer(nextPlayer)]);
				return;
			}
			nextPlayer = otherPlayer(nextPlayer);
		}
	}

	public boolean playCard(Player player) {
		int cardToPlay;
		String quit;
		int r1, c1, r2, c2;

		int tries = MAX_TRIES;
		boolean successful = false;

		while (tries > 0) {
			// System.out.println(board);
			System.out.println(player);
			System.out.print("Enter " + QUIT + " to quit, any other nonblank to continue: ");
			quit = stdin.next().toUpperCase();

			if (quit.equals(QUIT))
				return false;

			cardToPlay = getValidIndex(0, player.destOnHand.size());
			System.out.print("Please pick row to place card: ");
			r1 = stdin.nextInt();
			System.out.print("Please pick column to place card: ");
			c1 = stdin.nextInt();
			System.out.print("Please pick row to place card: ");
			r2 = stdin.nextInt();
			System.out.print("Please pick column to place card: ");
			c2 = stdin.nextInt();

			if (board.placeDest(player.getDest(cardToPlay), player.getRoute(cardToPlay), r1, c1, r2, c2)) {
				player.removeDest(cardToPlay);
				player.removeRoute(cardToPlay);
				return true;
			}

			System.out.println("Not a legal move. Attempts left = " + --tries);
		}
		return false;

	}

	private int getValidIndex(int low, int high) {
		int cardToPlay = -1;
		boolean valid = false;

		while (!valid) {
			System.out.print("Please choose the index of the domino you wish to play: ");
			cardToPlay = stdin.nextInt();
			valid = low <= cardToPlay && cardToPlay < high;
		}
		return cardToPlay;
	}

	private void announceWinner(Player winningPlayer) {
		System.out.println(winningPlayer.getName() + " has won!");
	}

	private int otherPlayer(int nextPlayer) {
		return 1 - nextPlayer;
	}

	public static void main(String[] args) {
		System.out.print("How many players ? > ");
		num_players = stdin.nextInt();
		Game ticket2ride = new Game(num_players);
		ticket2ride.play();

	}

}