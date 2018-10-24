package hw4;

import hw4.Square.Dest;

public class CardDest {

	Square square;
	Dest dest;

    CardDest(Dest _dest) {
        dest = _dest;
    }
  
    Dest getDest() {
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