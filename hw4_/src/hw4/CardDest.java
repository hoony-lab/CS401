package hw4;

import hw4.Square.Symbol;

public class CardDest {

	Symbol dest;

    CardDest(Symbol _dest) {
        dest = _dest;
    }
  
    Symbol getDest() {
        return dest;
    }
	
    @Override
    public String toString() {
        return dest.toString();
    }
}

//1. claim a route

//draw train car cards

//draw destination tickets