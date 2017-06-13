package blackjack.controller;

import blackjack.AssetManager;
import blackjack.MenuState;
import blackjack.StateManager;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Tomasz Homoncik
 */
public class SplashScreenController implements Initializable {
    @FXML
    javafx.scene.image.ImageView image;
    @FXML
    private GridPane gridPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AssetManager.LoadCards();
        new SplashScreen().start();
    }

    class SplashScreen extends Thread {
        @Override
        public void run() {
            try {
                image.setImage(new Image("file:img/blackjack.png"));
                Thread.sleep(3000);

                Platform.runLater(() -> {

                    Stage stage = new Stage();
                    StateManager.getInstance().setCurrentState(new MenuState(stage));

                    gridPane.getScene().getWindow().hide();
                });
            } catch (InterruptedException e) {
                Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
