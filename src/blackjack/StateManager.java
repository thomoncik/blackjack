package blackjack;

/**
 * @author Tomasz Homoncik
 */
public class StateManager {
    private static StateManager ourInstance = new StateManager();
    private static State currentState;

    private StateManager() {

    }

    public static StateManager getInstance() {
        return ourInstance;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State state) {
        if (currentState != null) {
            currentState.onExit();
        }
        state.onEnter();
        currentState = state;
    }
}
