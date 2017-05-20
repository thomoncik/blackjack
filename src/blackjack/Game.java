package blackjack;

/**
 * @author Tomasz Homoncik
 */
class FooState implements State {
    private int iter = 0;

    FooState() {
        onEnter();
    }

    @Override
    public void onEnter() {
        System.out.println("Enter foo");
    }

    @Override
    public void onExit() {
        System.out.println("Exit foo");
    }

    @Override
    public void run() {
        System.out.println("Run foo " + iter);
        iter++;
        if (iter == 4) {
            onExit();
            StateManager.getInstance().setCurrentState(new FooState());
        }
    }
}

public class Game {

    public static void main(String[] args) {
        StateManager.getInstance().setCurrentState(new FooState());

        while (true) {
            StateManager.getInstance().getCurrentState().run();
        }
    }
}
