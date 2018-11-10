/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxview;

import heptalion.Board;
import heptalion.Direction;
import heptalion.Domino;
import heptalion.Game;
import heptalion.Player;
import heptalion.Symbol;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 *
 * @author villa
 */
class BoardView {
    private Game game;
    private Board board;
    private GridPane boardPane;
    private ArrayList<ArrayList<Button>> squares = new ArrayList<>();
    // keep track of choices for one move
    private Domino dominoToPlay;
    private int squaresChosen = 0;
    // coordinates of squares chosen
    private int row0, col0, row1, col1;
    private PlayerView player0View, player1View, currentPlayerView;
    
    /**
     * Construct a view for the board
     * Add a Button for each square to a GridPane
     */
    BoardView(Game _game, PlayerView _player0View, PlayerView _player1View) {
        game = _game;
        board = game.getBoard();
        currentPlayerView = player0View = _player0View;
        player1View = _player1View;
        boardPane = new GridPane();
        for (int row = 0; row < board.getRows(); row++) {
            squares.add(new ArrayList<>(board.getCols()));
            for (int col = 0; col < board.getCols(); col++) {
                Symbol sym = board.getSquare(row, col);
                if (sym != Symbol.BLANK) {
                    Button button = new Button(sym.toString());
                    button.setOnAction(new SquareHandler(row, col));
                    boardPane.add(button, row, col);
                    squares.get(row).add(button);
                }
                else squares.get(row).add(null);
            }
        }
    }
    
    /**
     * 
     * @return 
     */
    GridPane getBoardView() { return boardPane; }
    
    // Get board attached to view
    Board getBoard() { return board; }
    
    // Event handler for all squares
    class SquareHandler implements EventHandler<ActionEvent> {

        final int handlerRow, handlerCol;

        SquareHandler(int row, int col) {
            handlerRow = row;
            handlerCol = col;
        }

        @Override
        public void handle(ActionEvent event) {
            Player currentPlayer = currentPlayerView.getPlayer();
            dominoToPlay = currentPlayerView.getChoice();
            // must choose domino first
            if (dominoToPlay == null) {
                return;
            }
            // record coordinates for first square chosen
            if (squaresChosen == 0) {
                row0 = handlerRow;
                col0 = handlerCol;
                squaresChosen++;
                return;
            }
            // choosing 2nd square
            row1 = handlerRow;
            col1 = handlerCol;
            // check for valid move
            try {
                Direction dir = Direction.computeDirection(row0, col0, row1, col1);
                if (board.place(dominoToPlay, row0, col0, dir)) {
                    // update board view
                    // alternative: remove button from children of gridpane
                    squares.get(row0).get(col0).setDisable(true);
                    squares.get(row1).get(col1).setDisable(true);
                    // remove domino from current player
                    currentPlayer.remove(dominoToPlay);
                    // update player view?
                    currentPlayerView.remove(dominoToPlay);
                    currentPlayerView.clearChoice();
                    // switch to next player
                    game.getNextPlayer();
                    squaresChosen = 0;
                    if (currentPlayerView == player0View)
                        currentPlayerView = player1View;
                    else currentPlayerView = player0View;
                }
            } catch (Direction.InvalidDirectionException notAdjacent) {
                // ignore this choice
            }
        }
    }
}
