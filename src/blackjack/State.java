package blackjack;

/**
 * @author Tomasz Homoncik
 */
public interface State {
    void onEnter();

    void onExit();

    void run();
}
