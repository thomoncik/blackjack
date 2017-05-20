package blackjack.controller;

import javafx.application.Platform;
import javafx.scene.input.MouseEvent;

/**
 * @author Tomasz Homoncik
 */
public class MenuController {
    public void exit(MouseEvent mouseEvent) {
        Platform.exit();
    }
}
