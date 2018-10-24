package hw4;

import hw4.Square.Route;

public class CardRoute {

	Square square;
	Route route;

    CardRoute(Route _route) {
    	route = _route;
    }
  
    Route getRoute() {
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