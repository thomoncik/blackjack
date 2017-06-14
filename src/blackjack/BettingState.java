package blackjack;

import blackjack.model.Table;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Jan on 5/27/2017.
 */
public class BettingState implements State {
    private Stage stage;
    private Table table;

    public BettingState(Stage primaryStage, Table table) {
        stage = primaryStage;
        this.table = table;

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("view/fxml/betting.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root, 375, 667));
        stage.show();
    }

    @Override
    public void onEnter() {
        System.out.println("Enter betting");
    }

    @Override
    public void onExit() {
        System.out.println("Exit betting");
    }

    @Override
    public void run() {

    }

    public Table getTable() {
        return table;
    }
}
