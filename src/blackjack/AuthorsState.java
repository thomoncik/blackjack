package blackjack;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Tomasz Homoncik
 */
public class AuthorsState implements State {
    private Stage stage;

    public AuthorsState(Stage primaryStage) {
        stage = primaryStage;
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("view/fxml/authors.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root, 375, 667));
        stage.show();
    }

    @Override
    public void onEnter() {
        System.out.println("Enter high scores");
    }

    @Override
    public void onExit() {
        System.out.println("Exit high scores");
    }

    @Override
    public void run() {

    }
}
