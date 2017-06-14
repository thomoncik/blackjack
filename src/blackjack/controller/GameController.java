package blackjack.controller;

import blackjack.*;
import blackjack.model.Card;
import blackjack.model.Table;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    public Label playerHandValue;
    @FXML
    public Button okButton;
    @FXML
    public AnchorPane endingPane;
    public Label dealerValue;
    public Label playerValue;
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

    public void enterMenu() {
        StateManager.getInstance().setCurrentState(new MenuState((Stage) anchorPane.getScene().getWindow()));
    }

    public void splitAction() {
        ((GameState) StateManager.getInstance().getCurrentState()).getTable().getPlayer().split();
    }

    public void doubleAction() {
        ((GameState) StateManager.getInstance().getCurrentState()).getTable().getPlayer().doubleDown();
    }

    public void hitAction() {
        ((GameState) StateManager.getInstance().getCurrentState()).getTable().getPlayer().hit();
    }

    public void standAction() {
        ((GameState) StateManager.getInstance().getCurrentState()).getTable().getPlayer().stand();
    }

    public void buyInsuranceAction() {
        ((GameState) StateManager.getInstance().getCurrentState()).getTable().getPlayer().insurance();
    }

    public void okAction() {
        Table table = ((GameState) StateManager.getInstance().getCurrentState()).getTable();
        StateManager.getInstance().setCurrentState(new BettingState((Stage) anchorPane.getScene().getWindow(), table));
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
                        if (!(StateManager.getInstance().getCurrentState() instanceof GameState)) {
                            return;
                        }

                        GameState state = (GameState) StateManager.getInstance().getCurrentState();

                        int bet = state.getBet();
                        Table table = state.getTable();
                        int handValue = table.getPlayer().getValue();

                        boolean end = !table.isDealerRound() && !table.isPlayerRound();
                        anchorPane.setVisible(!end);
                        endingPane.setVisible(end);

                        playerValue.setText("Player: " + handValue);
                        dealerValue.setText("Dealer: " + table.getDealer().getValue());

                        printBet.setText("BET " + bet + "$");
                        playerHandValue.setText(handValue + "");

                        Card lastPlayerCard = table.getPlayer().getHand().getCards().get(table.getPlayer().getHand().getCards().size() - 1);
                        playerFirstCard.setImage(AssetManager.getInstance().getAsset(lastPlayerCard.toString()));

                        Card lastDealerCard = table.getDealer().getHand().getCards().get(table.getDealer().getHand().getCards().size() - 1);
                        if (table.isPlayerRound()) {
                            lastDealerCard = table.getDealer().getHand().getCardByIndex(0);
                        }
                        dealerFirstCard.setImage(AssetManager.getInstance().getAsset(lastDealerCard.toString()));

                        splitButton.setVisible(table.getPlayer().canSplit());
                        doubleButton.setVisible(table.getPlayer().canDoubleDown());
                        insuranceButton.setVisible(table.canBuyInsurance());

                        if (table.isDealerRound()) {
                            table.getDealer().hit();
                            System.out.println(lastDealerCard);
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
