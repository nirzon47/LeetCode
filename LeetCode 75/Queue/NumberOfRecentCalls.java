import java.util.*;

public class NumberOfRecentCalls {
    Queue<Integer> queue = new LinkedList<>();

    public NumberOfRecentCalls() {
    }

    public static void main(String[] args) {
        NumberOfRecentCalls obj = new NumberOfRecentCalls();
        System.out.println(obj.ping(1));
        System.out.println(obj.ping(2));
        System.out.println(obj.ping(3));
        System.out.println(obj.ping(3000));
        System.out.println(obj.ping(3001));
    }

    public int ping(int t) {
        // Adds the time in the queue
        queue.add(t);
        // If the head of the queue is more than the current time - 3000, removes the head
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        // returns the size of the queue
        return queue.size();
    }
}
