package design.state;

public class MarioStateMachine {
    private int score;
    private State currentState;
    public MarioStateMachine() {
        this.score = 0;
        this.currentState = State.SMALL;
    }

    public void obtainMushRoom() {
        System.out.println("遇到蘑菇");
    }

}
