package blackjack;

import com.sun.javafx.application.LauncherImpl;

public class Main {
    public static void main(String[] args) {
        LauncherImpl.launchApplication(Game.class, SlashScreenLoader.class, args);
    }
}