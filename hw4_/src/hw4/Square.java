package hw4;

public class Square {

	public enum Dest {
		CA, NY, PA, MI, BLANK;

		static final String rep[] = { "C", "N", "P", "M", " " };

		@Override
		public String toString() {
			return rep[this.ordinal()];
		}
	}

	public enum Route {
		BLUE, GREEN, YELLOW, BLACK, GREY;
		// PINK, WHITE, ORANGE, RED;
		static final String repr[] = { "blue", "green", "yellow", "black", "grey" };

		@Override
		public String toString() {
			return repr[this.ordinal()];
		}
	}

	private Dest destValue;
	private Route routeValue;

	public Square() {
		destValue = Dest.BLANK;
		routeValue = Route.GREY;
	}

	public Square(Dest _value) {
		destValue = _value;
	}

	public Square(Route _value) {
		routeValue = _value;
	}

	public boolean hasDest(Dest target) {
		return destValue.equals(target);
	}

	public boolean hasRoute(Route target) {
		return routeValue.equals(target);
	}

	public void markUsed() {
		destValue = Dest.BLANK;
	}

	@Override
	public String toString() {
		if (true)
			return destValue.toString();
		else
			return routeValue.toString();
	}

}
