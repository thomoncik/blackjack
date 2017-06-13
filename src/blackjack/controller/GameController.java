package blackjack.controller;

import blackjack.AssetManager;
import blackjack.GameState;
import blackjack.MenuState;
import blackjack.StateManager;
import blackjack.model.Table;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    public Button splitButton;
    @FXML
    public Button doubleButton;
    @FXML
    public Button hitButton;
    @FXML
    public Button standButton;
    @FXML
    public Button insuranceButton;
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
    javafx.scene.control.Label printBet = new Label("BET");


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DataUpdater dataUpdater = new DataUpdater();
        dataUpdater.start();
    }

    public void enterMenu(MouseEvent mouseEvent) {
        StateManager.getInstance().setCurrentState(new MenuState((Stage) anchorPane.getScene().getWindow()));
    }

    public void splitAction(MouseEvent mouseEvent) {
        ((GameState) StateManager.getInstance().getCurrentState()).getTable().getPlayer().split();
    }

    public void doubleAction(MouseEvent mouseEvent) {

    }

    public void hitAction(MouseEvent mouseEvent) {

    }

    public void standAction(MouseEvent mouseEvent) {

    }

    public void buyInsuranceAction(MouseEvent mouseEvent) {

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
                        int bet = ((GameState) StateManager.getInstance().getCurrentState()).getBet();
                        Table table = ((GameState) StateManager.getInstance().getCurrentState()).getTable();

                        printBet.setText("BET " + bet + "$");
                        playerFirstCard.setImage(AssetManager.getInstance().getAsset(table.getPlayer().getHand().getCardByIndex(0).toString()));
                        dealerFirstCard.setImage(AssetManager.getInstance().getAsset(table.getDealer().getHand().getCardByIndex(0).toString()));

                        splitButton.setVisible(table.getPlayer().canSplit());
                        doubleButton.setVisible(table.getPlayer().canDoubleDown());
                        insuranceButton.setVisible(table.getPlayer().canBuyInsurance());
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
