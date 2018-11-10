package lab4;

public class Domino {
//	Player player = new Player();
	Deck deck = new Deck();
	
//			{{"!", "!", "#"},
//			{"#", "@", "!"},
//			{"@", "!", "#"}};

	char [][] dominos = {{ '!', '#' },	// 2, 6, 7, 9, 12
			  				{ '!', '@' },	// 4, 5, 8, 11
			  				{ '@', '#' }};	// 3, 10

	public Domino() {

		}
	
	public char[] getDomino(int num) {
		return dominos[num];
	}
	public int getDominoNum(char[] dom) {
		if(dom.equals(dominos[0]))
			return 1;
		else if(dom.equals(dominos[1]))
			return 2;
		else if(dom.equals(dominos[2]))
			return 3;
		else
			return 0;

	}
}