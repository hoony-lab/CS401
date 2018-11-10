/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxview;

import heptalion.Board;
import heptalion.Domino;
import heptalion.NameTooShort;
import heptalion.Player;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 * View for one player -- allow choice of dominoes
 * @author villa
 */
class PlayerView {
    private HBox handPane = new HBox();
    private ArrayList<Button> dominoes;
    private Player player;
    private Domino choice;
    
    // Construct view for one player
    public PlayerView(Player _player) {
        player = _player;
        handPane.getChildren().add(new Label(player.getName()));
        dominoes = new ArrayList<>();
        for (int dom = 0; dom < player.getHandSize(); dom++) {
            dominoes.add(new Button(player.get(dom).toString()));
            dominoes.get(dom).setOnAction(new DominoChooser(player.get(dom)));
            handPane.getChildren().add(dominoes.get(dom));
        }
    }
    // Get the pane containing the player view
    public HBox getPlayerView() { return handPane; }
    
    // Get player for this view
    public Player getPlayer() { return player; }
    
    // Get domino to play
    public Domino getChoice() { return choice; }
    
    // Clear choice (for after a successful move)
    public void clearChoice() { choice = null; }
    
    // Remove domino from view
    public void remove(Domino toRemove) {
        for (Node node : handPane.getChildren()) {
            if (node instanceof Button && ((Button) node).getText().equals(toRemove.toString())) {
                ((Button) node).setDisable(true);
            }
        }
    }

    // Handler to save current choice of domino to play
    private class DominoChooser implements EventHandler<ActionEvent> {
        private Domino target;
        public DominoChooser(Domino _target) {
            target = _target;
        }

        @Override
        public void handle(ActionEvent event) {
            choice = target;
        }
    }
}
