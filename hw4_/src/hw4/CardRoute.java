package hw4;

import hw4.Square.Symbol;

public class CardRoute {

	Symbol route;

    CardRoute(Symbol _route) {
    	route = _route;
    }
  
    Symbol getRoute() {
        return route;
    }
	
    @Override
    public String toString() {
        return route.toString();
    }
}

//1. claim a route

//draw train car cards

//draw destination tickets