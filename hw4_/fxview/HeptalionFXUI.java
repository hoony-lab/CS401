/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxview;

import heptalion.Board;
import heptalion.Game;
import heptalion.NameTooShort;
import heptalion.Player;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author villa
 */
public class HeptalionFXUI extends Application {
    
    @Override
    public void start(Stage primaryStage) throws NameTooShort {
        final int NUM_PLAYERS = 2;
        Game game = new Game(NUM_PLAYERS);
        game.addPlayer("Ann");
        game.addPlayer("Bob");
        game.dealDominoes();
        Board board = game.getBoard();
        PlayerView player0View = new PlayerView(game.getCurrentPlayer()),
                player1View = new PlayerView(game.getNextPlayer());
        Player current = game.getNextPlayer();
        BoardView boardView = new BoardView(game, player0View, player1View);
        
        VBox root = new VBox();
        root.getChildren().addAll(player0View.getPlayerView(),
                boardView.getBoardView(), player1View.getPlayerView());
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Heptalion imitation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
