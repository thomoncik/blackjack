package blackjack.controller;

import blackjack.MenuState;
import blackjack.StateManager;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Created by Jan on 5/27/2017.
 */
public class GameController {
    @FXML
    AnchorPane anchorPane;

    public void enterMenu(MouseEvent mouseEvent) {
        StateManager.getInstance().setCurrentState(new MenuState((Stage) anchorPane.getScene().getWindow()));
    }
}
