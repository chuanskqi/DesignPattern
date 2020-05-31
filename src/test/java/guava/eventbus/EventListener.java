package guava.eventbus;

import com.google.common.eventbus.Subscribe;

public class EventListener {

    @Subscribe
    public void onEvent(Event e) {
        System.out.println(e.getName() + "-----------");
    }
}
