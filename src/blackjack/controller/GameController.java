package blackjack.controller;

import blackjack.GameState;
import blackjack.MenuState;
import blackjack.StateManager;
import blackjack.model.Table;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Jan on 5/27/2017.
 */
public class GameController implements Initializable {
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
    private int bet;
    @FXML
    javafx.scene.control.Label printBet = new Label("YOUR CASH " + bet + "$");
    private Table table;

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
                    Platform.runLater(() -> {
                        bet = ((GameState) StateManager.getInstance().getCurrentState()).getBet();
                        printBet.setText("YOUR CASH " + bet + "$");
                        table = (table == null) ? new Table() : table;
                        playerFirstCard.setImage(AssetManager.getInstance().getAsset(table.getPlayer().getHand().getIthCard(0).toString()));
                        dealerFirstCard.setImage(AssetManager.getInstance().getAsset(table.getDealer().getHand().getIthCard(0).toString()));
                    });
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
