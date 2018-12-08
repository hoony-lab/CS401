package hw4;

import java.math.*;

import hw4.Square.*;

public class Board {
	private final Square BLANK = new Square(Symbol.BLANK);

	// no cross updated YET
	// private final Square[][] board = {
	// { new Square(Dest.CA), new Square(Route.BLUE), new Square(Route.BLUE), new
	// Square(Route.BLUE), new Square(Dest.MI) },
	// { new Square(Route.GREEN), BLANK, BLANK, BLANK, new Square(Route.GREY) },
	// { new Square(Route.GREEN), BLANK, BLANK, BLANK, new Square(Route.GREY) },
	// { new Square(Dest.PA), new Square(Route.BLACK), new Square(Route.BLACK), new
	// Square(Route.BLACK), new Square(Dest.NY) }, };

	private final Square[][] board = {
			{ new Square(Symbol.CP), new Square(Symbol.BLUE), new Square(Symbol.BLUE), new Square(Symbol.BLUE),
					new Square(Symbol.MW) },
			{ new Square(Symbol.GREEN), BLANK, BLANK, BLANK, new Square(Symbol.GREY) },
			{ new Square(Symbol.GREEN), BLANK, BLANK, BLANK, new Square(Symbol.GREY) },
			{ new Square(Symbol.TS), new Square(Symbol.BLACK), new Square(Symbol.BLACK), new Square(Symbol.BLACK),
					new Square(Symbol.UN) }, };

	private static final String TOPGUIDE = "   0\t1\t2\t3\t4\n   __________________________________\n";
 
	public boolean placeDest(CardDest cardDest,CardDest cardDest2, CardRoute cardRoute, int r1, int c1, int r2, int c2) {
		if (invalidRow(r1) || invalidRow(c1) || invalidCol(r2) || invalidCol(c2))
			return false;
		if ((board[r1][c1].hasSymbol(cardDest.getDest()) && board[r2][c2].hasSymbol(cardDest2.getDest()))
				|| board[r1][c1].hasSymbol(cardDest2.getDest()) && board[r2][c2].hasSymbol(cardDest.getDest())) {
			board[r1][c1].markUsed();
			board[r2][c2].markUsed();
			placeRoute(cardRoute,r1,c1,r2,c2);
			return true;
		}
	
		// double a = Math.sqrt(Math.pow(r2 - r1, 2) - Math.pow(c2 - c1, 2));
		return false;

	}

	public boolean placeRoute(CardRoute cardRoute, int r1, int c1, int r2, int c2) {
		int midrow = Math.round(Math.abs((r2 + r1) / 2));
		int midcol = Math.round(Math.abs((c2 + c1) / 2));
		if (board[midrow][midcol].hasSymbol(cardRoute.getRoute())) {
			System.out.println("good job !");
			return true;
		}
		System.out.println("wrongggg");
		return false;
	}

	private boolean invalidRow(int row) {
		return (row < 0 || row >= board.length);
	}

	private boolean invalidCol(int col) {
		return (col < 0 || col >= board[0].length);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		int rowNum = 0;

		result.append(TOPGUIDE);

		for (Square[] row : board) {
			// Use last digit here to be consistent with digits across
			// the top and to make it easier to line things up
			result.append(lastDigit(rowNum++));
			result.append("| ");
			for (Square sq : row) {
				result.append(sq.toString() + '\t');
			}
			result.append('\n');
		}
		return result.toString();
	}

	private int lastDigit(int num) {
		return num % 10;
	}
}
