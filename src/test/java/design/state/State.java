package design.state;

public enum State {
    SMALL(0),
    //火,
    SUPER(1),
    FIRE(2),
    //斗笠
    CAPE(3);
    private int value;
    private State(int value) {
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}
