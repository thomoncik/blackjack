package blackjack;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Tomasz Homoncik
 */
public class GameState implements State {
    private Stage stage;
    private int bet;

    public GameState(Stage primaryStage, int bet) {
        this.bet = bet;
        stage = primaryStage;
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("view/fxml/game.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root, 375, 667));
        stage.show();
    }

    public int getBet(){
        return bet;
    }

    public Stage getStage(){
        return stage;
    }

    @Override
    public void onEnter() {
        System.out.println("Enter game");
    }

    @Override
    public void onExit() {
        System.out.println("Exit game");
    }

    @Override
    public void run() {

    }
}