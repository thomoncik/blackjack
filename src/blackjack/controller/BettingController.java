package blackjack.controller;

import blackjack.GameState;
import blackjack.MenuState;
import blackjack.StateManager;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.awt.*;
import java.awt.Button;
import java.awt.Label;

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


    int sumOfBets = 0;
    int myCash = 1000;

    public void enterMenu(MouseEvent mouseEvent) {
        StateManager.getInstance().setCurrentState(new MenuState((Stage) anchorPane.getScene().getWindow()));
    }

    public void enterToFirstRound(MouseEvent mouseEvent) {
        GameState gState = new GameState((Stage) anchorPane.getScene().getWindow(), sumOfBets);
        //gState.setBet(sumOfBets);
        StateManager.getInstance().setCurrentState(gState);
    }

    private void printBetAndCash(){
        printBet.setText("BET "+sumOfBets+"$");
        printMyCash.setText("YOUR CASH "+myCash+"$");
    }

    private void addToBet(int cash){
        sumOfBets += cash;
        myCash -= cash;
    }
    private void substractFromBet(int cash){
        sumOfBets -= cash;
        myCash += cash;
    }

    private boolean checkIfCanMakeThisMove(boolean amIAddingToBet, int cash){
        if( amIAddingToBet ){
            if( cash > myCash ) return false;
        }
        else{
            if( sumOfBets < cash ) return false;
        }
        return true;
    }

    public void add5(MouseEvent mouseEvent) {
        if( mouseEvent.getButton() == MouseButton.SECONDARY ) {
            if( !checkIfCanMakeThisMove(false, 5) ) {
                System.out.println("Can't make this move");
                return;
            }
            substractFromBet(5);
        }
        else{
            if( !checkIfCanMakeThisMove(true, 5) ){
                System.out.println("Can't make this move");
                return;
            }
            addToBet(5);
        }
        printBetAndCash();
    }
    public void add10(MouseEvent mouseEvent) {
        if( mouseEvent.getButton() == MouseButton.SECONDARY ) {
            if( !checkIfCanMakeThisMove(false, 10) ) {
                System.out.println("Can't make this move");
                return;
            }
            substractFromBet(10);
        }
        else{
            if( !checkIfCanMakeThisMove(true, 10) ){
                System.out.println("Can't make this move");
                return;
            }
            addToBet(10);
        }
        printBetAndCash();

    }
    public void add25(MouseEvent mouseEvent) {
        if( mouseEvent.getButton() == MouseButton.SECONDARY ) {
            if( !checkIfCanMakeThisMove(false, 25) ) {
                System.out.println("Can't make this move");
                return;
            }
            substractFromBet(25);
        }
        else{
            if( !checkIfCanMakeThisMove(true, 25) ){
                System.out.println("Can't make this move");
                return;
            }
            addToBet(25);
        }
        printBetAndCash();
    }
    public void add50(MouseEvent mouseEvent) {
        if( mouseEvent.getButton() == MouseButton.SECONDARY ) {
            if( !checkIfCanMakeThisMove(false, 50) ) {
                System.out.println("Can't make this move");
                return;
            }
            substractFromBet(50);
        }
        else{
            if( !checkIfCanMakeThisMove(true, 50) ){
                System.out.println("Can't make this move");
                return;
            }
            addToBet(50);
        }
        printBetAndCash();
    }
    public void add100(MouseEvent mouseEvent) {
        if( mouseEvent.getButton() == MouseButton.SECONDARY ) {
            if( !checkIfCanMakeThisMove(false, 100) ) {
                System.out.println("Can't make this move");
                return;
            }
            substractFromBet(100);
        }
        else{
            if( !checkIfCanMakeThisMove(true, 100) ){
                System.out.println("Can't make this move");
                return;
            }
            addToBet(100);
        }
        printBetAndCash();
    }
}
