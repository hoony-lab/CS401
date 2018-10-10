package lab4;

public class Square {
	int i1,j1,i2,j2;
	char [][] board_check = {{' ',' ',' '},
			{' ',' ',' '},
			{' ',' ',' '}};

	public Square() {
		
	}
	
	public boolean match(int dominoNum) {
		
//		{{"!", "!", "#"},
//		{"#", "@", "!"},
//		{"@", "!", "#"}};

		int key = dominoNum;
		
		switch (key) {
		case 1 : //{ '!', '#' } 2, 6, 7, 9, 12
			if(board_check[0][2] != ' ' || board_check[1][0] != ' ' ||
					board_check[2][2] != ' ')
				return false;
			//else if()
			// player pick where to place(scan)
			// then save coordinates
			// which can check on boards that is not vacency
			else
				break;
			
		case 2 : //{ '!', '@' } 4, 5, 8, 11
			if(board_check[1][1] != ' ' || board_check[2][0] != ' ')
				return false;
			else
				break;
			
		case 3 : //{ '@', '#' } 3, 10
			if(board_check[1][1] != ' ' || board_check[2][0] != ' ')
				return false;
			else
				break;
			
		default:
			break;
		}
		
		return true;
	}
	
	public char[][] getBoard(){
		return board_check;
	}
	
	void setBoard(int i1,int j1,int i2, int j2) {
		board_check[i1][j1] = 'x';
		board_check[i2][j2] = 'x';
	}
}
