package blackjack.controller;

import blackjack.MenuState;
import blackjack.StateManager;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author Tomasz Homoncik
 */
public class HighScoresController {
    @FXML
    AnchorPane anchorPane;

    public void enterMenu(MouseEvent mouseEvent) {
        StateManager.getInstance().setCurrentState(new MenuState((Stage) anchorPane.getScene().getWindow()));
    }
}
