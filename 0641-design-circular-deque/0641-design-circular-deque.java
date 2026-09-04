class MyCircularDeque {

    int[] arr;
    int front;
    int rear;
    int size;
    int k;

    public MyCircularDeque(int k) {
        this.k = k;
        arr = new int[k];

        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean insertFront(int value) {

        if (size == k) return false;

        if (size == 0) {
            front = 0;
            rear = 0;
        } else {
            front = (front - 1 + k) % k;
        }

        arr[front] = value;
        size++;

        return true;
    }

    public boolean insertLast(int value) {

        if (size == k) return false;

        if (size == 0) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % k;
        }

        arr[rear] = value;
        size++;

        return true;
    }

    public boolean deleteFront() {

        if (size == 0) return false;

        if (size == 1) {
            front = 0;
            rear = -1;
        } else {
            front = (front + 1) % k;
        }

        size--;

        return true;
    }

    public boolean deleteLast() {

        if (size == 0) return false;

        if (size == 1) {
            front = 0;
            rear = -1;
        } else {
            rear = (rear - 1 + k) % k;
        }

        size--;

        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;

        return arr[front];
    }

    public int getRear() {
        if (isEmpty()) return -1;

        return arr[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == k;
    }
}