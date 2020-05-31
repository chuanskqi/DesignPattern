package argorithm.queue;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.apache.shiro.web.filter.mgt.DefaultFilter;

/**
 * 先进先出
 */
public class ArrayQueue {
    private Object[] arrays;
    //大小
    private int size;
    private int tail;
    private int head;
    public ArrayQueue(int size) {
        arrays = new Object[size];
        this.size = size;
    }

    public boolean enqueue(Object obj) {
        if (size == tail) {
            return false;
        }
        arrays[tail ++] = obj;
        return true;
    }

    public Object dequeue() {
        return null;
    }
}
