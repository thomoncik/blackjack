package blackjack.controller;

import blackjack.AuthorsState;
import blackjack.BettingState;
import blackjack.StateManager;
import blackjack.model.Table;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author Tomasz Homoncik
 */
public class MenuController {
    @FXML
    AnchorPane anchorPane;

    public void exit(MouseEvent mouseEvent) {
        Platform.exit();
    }

    public void startGame(MouseEvent mouseEvent) {
        StateManager.getInstance().setCurrentState(new BettingState((Stage) anchorPane.getScene().getWindow(), new Table()));
    }

    public void enterAuthors(MouseEvent mouseEvent) {
        StateManager.getInstance().setCurrentState(new AuthorsState((Stage) anchorPane.getScene().getWindow()));
    }
}
