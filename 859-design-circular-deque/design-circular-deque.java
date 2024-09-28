class MyCircularDeque {
    private int[] deque;
    private int front, rear, size;

    public MyCircularDeque(int k) {
        deque = new int[k + 1]; // Allocate size k+1 for circular structure
        front = 0;
        rear = 0;
        size = k + 1;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        front = (front - 1 + size) % size; // Move front pointer backward
        deque[front] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        deque[rear] = value;
        rear = (rear + 1) % size; // Move rear pointer forward
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % size; // Move front pointer forward
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        rear = (rear - 1 + size) % size; // Move rear pointer backward
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return deque[front];
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return deque[(rear - 1 + size) % size];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }
}