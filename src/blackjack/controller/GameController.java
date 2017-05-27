package blackjack.controller;

import blackjack.MenuState;
import blackjack.StateManager;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;

/**
 * Created by Jan on 5/27/2017.
 */
public class GameController {
    public javafx.scene.image.ImageView p;
    @FXML
    AnchorPane anchorPane;
    @FXML
    javafx.scene.image.ImageView playerFirstCard;
    @FXML
    javafx.scene.image.ImageView playerSecondCard;
    @FXML
    javafx.scene.image.ImageView dealerFirstCard;
    @FXML
    javafx.scene.image.ImageView dealerSecondCard;

    public void enterMenu(MouseEvent mouseEvent) {
        StateManager.getInstance().setCurrentState(new MenuState((Stage) anchorPane.getScene().getWindow()));
    }
}
