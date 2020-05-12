package design.state;

public class TestState {
    public static void main(String[] args) {
        State state = State.CAPE;
        int dcFlag = 1655;
        if (State.SUPER.getValue() == dcFlag) {
            System.out.println("是super");
        }
        System.out.println(state.getValue());
        if (DC_FLAG.JIE.value.equals("1")) {
            System.out.println("借标识");
        }

        System.out.println("".equals(null));
    }

    enum DC_FLAG {
        JIE("1"),
        DAI("2");
        private String value;
        private DC_FLAG(String value) {
            this.value = value;
        }
    }
}
