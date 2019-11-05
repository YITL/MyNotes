package others;



public class ArrayQueue {
    private String[] arr;
    private int size;
    private int head = 0;
    private int tail = 0;
    public ArrayQueue (int size) {
        this.size = size;
        arr = new String[size];
    }
    public boolean offer(String item) {
        if ((tail+1) % size == head) return false;
        arr[tail] = item;
        tail = (tail+1) % size;
        return true;
    }
    public String poll() {
        if (head == tail) return null;
        String res = arr[head];
        head = (head+1) % size;
        return res;
    }
}
