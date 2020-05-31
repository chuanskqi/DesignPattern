package design.state;

public class MarioStateMachine {
    private int score;
    private State currentState;


    private static final State[][] transitionTable = {
            {State.SUPER,State.CAPE,State.FIRE,State.SMALL},
            {State.SUPER,State.CAPE,State.FIRE,State.SMALL},
            {State.CAPE,State.CAPE,State.CAPE,State.SMALL},
            {State.FIRE,State.FIRE,State.FIRE,State.SMALL}
    };


    public MarioStateMachine() {
        this.score = 0;
        this.currentState = State.SMALL;
    }

    public void obtainMushRoom() {
        System.out.println("遇到蘑菇");
    }

}
