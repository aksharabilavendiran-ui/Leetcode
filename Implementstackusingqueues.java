import java.util.*;

class MyStack {

    Queue<

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {

        queue.add(x);

        for(int i = 0; i < queue.size() - 1; i++) {

            queue.add(queue.remove());

        }
    }

    public int pop() {

        return queue.remove();

    }

    public int top() {

        return queue.peek();

    }

    public boolean empty() {

        return queue.isEmpty();

    }
}
