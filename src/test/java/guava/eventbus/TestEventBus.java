package guava.eventbus;

import com.google.common.eventbus.EventBus;

public class TestEventBus {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus("demo");
        eventBus.register(new EventListener());

        Event e = new Event();
        e.setName("test");
        eventBus.post(e);
    }
}
