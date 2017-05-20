package blackjack;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// @TODO: Unit tests!
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/main-menu.fxml"));
        primaryStage.setTitle("Blackjack");
        primaryStage.setScene(new Scene(root, 375, 667));
        primaryStage.show();
    }
}