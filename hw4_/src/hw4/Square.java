package hw4;

public class Square {

	// public enum Dest {
	// CA, NY, PA, MI, BLANK;
	//
	// static final String rep[] = { "C", "N", "P", "M", " " };
	//
	// @Override
	// public String toString() {
	// return rep[this.ordinal()];
	// }
	// }
	//
	// public enum Route {
	// BLUE, GREEN, YELLOW, BLACK, GREY;
	// // PINK, WHITE, ORANGE, RED;
	// static final String repr[] = { "blue", "green", "yellow", "black", "grey" };
	//
	// @Override
	// public String toString() {
	// return repr[this.ordinal()];
	// }
	// }

	public enum Symbol {
		CA, NY, PA, MI, BLUE, GREEN, YELLOW, BLACK, GREY, BLANK;
		static final String repr[] = { "C", "N", "P", "M", "blue", "grn", "yellow", "black", "grey", " " };

		@Override
		public String toString() {
			return repr[this.ordinal()];

		}
	}

	private Symbol value;

	public Square(Symbol _symbol) {
		value = _symbol;
	}

	public boolean hasSymbol(Symbol target) {
		return value.equals(target);
	}

	public void markUsed() {
		value = Symbol.BLANK;
	}

	@Override
	public String toString() {
		return value.toString();
	}

}
