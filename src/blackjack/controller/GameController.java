package blackjack.controller;

import blackjack.GameState;
import blackjack.MenuState;
import blackjack.StateManager;
import blackjack.model.Table;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Jan on 5/27/2017.
 */
public class GameController implements Initializable {
    public javafx.scene.image.ImageView p;
    int bet;
    Table table;
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
    @FXML
    javafx.scene.control.Label printBet = new Label("YOUR CASH " + bet + "$");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DataUpdater dataUpdater = new DataUpdater();
        dataUpdater.start();
    }

    public void enterMenu(MouseEvent mouseEvent) {
        StateManager.getInstance().setCurrentState(new MenuState((Stage) anchorPane.getScene().getWindow()));
    }

    class DataUpdater extends Thread {
        DataUpdater() {
            this.setDaemon(true);
        }

        @Override
        public void run() {
            while (true) {
                if (StateManager.getInstance().getCurrentState() instanceof GameState) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            bet = ((GameState) StateManager.getInstance().getCurrentState()).getBet();
                            printBet.setText("YOUR CASH " + bet + "$");
//                            table = new Table();
//                            String url = "file:view/img/cards/" + table.getPlayer().getHand().getIthCard(0).toString() + ".png";
//                            String url1 = "http://picresize.com/popup.html?images/rsz_12_of_clubs.png";
//                            File file = new File(url);
//                            playerFirstCard.setImage(new Image(file.toURI().toString()));
                        }
                    });
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
