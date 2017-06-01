package blackjack.controller;

import blackjack.AssetManager;
import blackjack.GameState;
import blackjack.MenuState;
import blackjack.StateManager;
import blackjack.model.Table;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import blackjack.AssetManager;
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
//                            bet = ((GameState) StateManager.getInstance().getCurrentState()).getBet();
//                            printBet.setText("YOUR CASH " + bet + "$");
//                            table = new Table();
//                            String url = table.getPlayer().getHand().getIthCard(0).toString();
//                            //String url1 = "https://ofbiz-vm2.apache.org:8443/images/products/GZ-1000/small.png";
////                            File file = new File(url);
//
//                            playerFirstCard.setImage(new Image("file:view/img/cards/3_of_clubs.png"));
//                            playerFirstCard.setVisible(true);
//                            HBox hbox = new HBox(playerFirstCard);
//
//                            Scene scene = new Scene(hbox, 900, 900);
//                            ((GameState) StateManager.getInstance().getCurrentState()).getStage().setScene(scene);
//                            ((GameState) StateManager.getInstance().getCurrentState()).getStage().show();
//                           // final HBox pictureRegion = new HBox();
//
//                           // pictureRegion.getChildren().add(playerFirstCard);
//
//                            System.out.println("GOT IMAGE");
                            // a bit mess
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
