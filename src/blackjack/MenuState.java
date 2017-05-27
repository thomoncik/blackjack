package blackjack;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Tomasz Homoncik
 */
public class MenuState implements State {
    private Stage stage;

    public MenuState(Stage primaryStage) {
        stage = primaryStage;
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("view/fxml/main-menu.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle("Blackjack");
        stage.setScene(new Scene(root, 375, 667));
        stage.show();
    }

    @Override
    public void onEnter() {
        System.out.println("Enter menu");
    }

    @Override
    public void onExit() {
        System.out.println("Exit menu");
    }

    @Override
    public void run() {

    }
}