package blackjack;

/**
 * @author Tomasz Homoncik
 */
class StateManager {
    private static StateManager ourInstance = new StateManager();
    private static State currentState;

    private StateManager() {

    }

    static StateManager getInstance() {
        return ourInstance;
    }

    State getCurrentState() {
        return currentState;
    }

    void setCurrentState(State state) {
        currentState = state;
    }
}
