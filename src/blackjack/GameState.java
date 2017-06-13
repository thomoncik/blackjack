package blackjack;

import blackjack.model.Table;
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
    private Table table;

    public GameState(Stage primaryStage, int bet) {
        this.bet = bet;
        stage = primaryStage;
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("view/fxml/game.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (root != null) {
            stage.setScene(new Scene(root, 375, 667));
        }
        run();
    }

    @Override
    public void onEnter() {
        this.table = new Table();
    }

    @Override
    public void onExit() {

    }

    @Override
    public void run() {
        stage.show();
    }

    public int getBet() {
        return bet;
    }

    public Stage getStage() {
        return stage;
    }

    public Table getTable() {
        return table;
    }
}