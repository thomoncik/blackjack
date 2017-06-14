package blackjack.controller;

import blackjack.BettingState;
import blackjack.GameState;
import blackjack.MenuState;
import blackjack.StateManager;
import blackjack.model.Player;
import blackjack.model.Table;
import javafx.fxml.FXML;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BettingController {
    @FXML
    javafx.scene.control.Label printBet;
    @FXML
    javafx.scene.control.Label printMyCash;
    @FXML
    javafx.scene.control.Button add5;
    @FXML
    javafx.scene.control.Button add10;
    @FXML
    javafx.scene.control.Button add25;
    @FXML
    javafx.scene.control.Button add50;
    @FXML
    javafx.scene.control.Button add100;
    @FXML
    javafx.scene.control.Button switchToFirstRound;
    @FXML
    AnchorPane anchorPane;

    @FXML

    public void enterMenu() {
        StateManager.getInstance().setCurrentState(new MenuState((Stage) anchorPane.getScene().getWindow()));
    }

    public void enterToFirstRound() {
        Table table = ((BettingState) StateManager.getInstance().getCurrentState()).getTable();
        GameState gState = new GameState((Stage) anchorPane.getScene().getWindow(), table.getPlayer().getBet(), table);
        StateManager.getInstance().setCurrentState(gState);
    }

    private void printBetAndCash() {
        Table table = ((BettingState) StateManager.getInstance().getCurrentState()).getTable();
        printBet.setText("Bet: " + table.getPlayer().getBet() + "$");
        printMyCash.setText("Bank: " + table.getPlayer().getBank() + "$");
    }

    private void addToBet(int cash) {
        Player player = ((BettingState) StateManager.getInstance().getCurrentState()).getTable().getPlayer();
        player.setBet(player.getBet() + cash);
        player.setBank(player.getBank() - cash);
    }

    private void substractFromBet(int cash) {
        Player player = ((BettingState) StateManager.getInstance().getCurrentState()).getTable().getPlayer();
        player.setBet(player.getBet() - cash);
        player.setBank(player.getBank() + cash);
    }

    private boolean checkIfCanMakeThisMove(boolean amIAddingToBet, int cash) {
        Player player = ((BettingState) StateManager.getInstance().getCurrentState()).getTable().getPlayer();

        if (amIAddingToBet) {
            if (cash > player.getBank()) return false;
        } else {
            if (player.getBet() < cash) return false;
        }

        return true;
    }

    public void add5(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.SECONDARY) {
            if (!checkIfCanMakeThisMove(false, 5)) {
                System.out.println("Can't make this move");
                return;
            }
            substractFromBet(5);
        } else {
            if (!checkIfCanMakeThisMove(true, 5)) {
                System.out.println("Can't make this move");
                return;
            }
            addToBet(5);
        }
        printBetAndCash();
    }

    public void add10(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.SECONDARY) {
            if (!checkIfCanMakeThisMove(false, 10)) {
                System.out.println("Can't make this move");
                return;
            }
            substractFromBet(10);
        } else {
            if (!checkIfCanMakeThisMove(true, 10)) {
                System.out.println("Can't make this move");
                return;
            }
            addToBet(10);
        }
        printBetAndCash();

    }

    public void add25(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.SECONDARY) {
            if (!checkIfCanMakeThisMove(false, 25)) {
                System.out.println("Can't make this move");
                return;
            }
            substractFromBet(25);
        } else {
            if (!checkIfCanMakeThisMove(true, 25)) {
                System.out.println("Can't make this move");
                return;
            }
            addToBet(25);
        }
        printBetAndCash();
    }

    public void add50(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.SECONDARY) {
            if (!checkIfCanMakeThisMove(false, 50)) {
                System.out.println("Can't make this move");
                return;
            }
            substractFromBet(50);
        } else {
            if (!checkIfCanMakeThisMove(true, 50)) {
                System.out.println("Can't make this move");
                return;
            }
            addToBet(50);
        }
        printBetAndCash();
    }

    public void add100(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.SECONDARY) {
            if (!checkIfCanMakeThisMove(false, 100)) {
                System.out.println("Can't make this move");
                return;
            }
            substractFromBet(100);
        } else {
            if (!checkIfCanMakeThisMove(true, 100)) {
                System.out.println("Can't make this move");
                return;
            }
            addToBet(100);
        }
        printBetAndCash();
    }
}
