package leetcode.queue;

public class MyCircularQueue {

    private int[] data;

    private int head;
    private int tail;

    private int len;

    /** false deQueue operation, true enQueue operation */
    private boolean isEnQueue = false;



    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        data = new int[k];
        head = 0;
        tail = 0;

        len = k;
    }

    private int Increment(int index) {
        if (index + 1 >= len) {
            index = 0;
        } else {
            index++;
        }
        return index;
    }

    private int Decrement(int index) {
        if (index - 1 < 0) {
            index = len - 1;
        } else {
            index--;
        }
        return index;
    }


    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        isEnQueue = true;
        data[tail] = value;
        tail = Increment(tail);
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        isEnQueue = false;
        data[head] = 0;
        head = Increment(head);
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) {
            return 0;
        }
        return data[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) {
            return 0;
        }
        return data[Decrement(tail)];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return ((head == tail) && !isEnQueue);
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return ((head == tail) && isEnQueue);
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        System.out.println(myCircularQueue.enQueue(1));
        System.out.println(myCircularQueue.enQueue(2));
        System.out.println(myCircularQueue.enQueue(3));
        System.out.println(myCircularQueue.enQueue(4));
        System.out.println(myCircularQueue.Rear());


    }
}


