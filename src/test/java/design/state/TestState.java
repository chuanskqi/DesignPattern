package design.state;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

public class TestState {
    public static void main(String[] args) throws InterruptedException {
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

        int[][] table = {
                {1,2},
                {3,4}
        };



        System.out.println(table[0][0]);
        System.out.println(table[0][1]);

        Gson gson = new Gson();

        Request<BussiB> b = new Request<>();
        BussiB bussiB = new BussiB();
        bussiB.setAge("2");
        b.setBussi(bussiB);
        String str = gson.toJson(b);
        new Thread(()->{
            System.out.println("----A-----");
            Request<BussiA> requestA = gson.fromJson(str, Request.class);
            System.out.println(requestA.getBussi().getName());
            System.out.println("----A-----");
        }).start();
        new Thread(()->{
            System.out.println("----B-----");
            Request<BussiB> requestB = gson.fromJson(str, Request.class);
            System.out.println(requestB.getBussi().getAge());
            System.out.println("----B-----");
        }).start();

        TimeUnit.SECONDS.sleep(2);
        System.out.println("---------");

        ArrayList<String> list = new ArrayList<>();
        list.add("123");
        System.out.println(10 >> 1);
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

class Request<T> {
    private T bussi;

    public T getBussi() {
        return bussi;
    }

    public void setBussi(T bussi) {
        this.bussi = bussi;
    }
}
class BussiB {
    private String age;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
class BussiA {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
