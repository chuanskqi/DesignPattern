package argorithm.stack;

public class Stack {
    private Object[] datas;
    private int count;
    private int size;

    public Stack(int size) {
        datas = new Object[size];
        this.size = size;
        this.count = 0;
    }

    public void push(Object obj) {
        if (count == size) {
            return ;
        }
        datas[count++] = obj;
    }

    public Object pop() {
        return datas[--count];
    }

    public static void main(String[] args) {
        Stack stack = new Stack(2);
        stack.push(1);
        stack.push(2);

        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
