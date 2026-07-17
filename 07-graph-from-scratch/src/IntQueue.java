// BFS işlemlerinde kullanılmak üzere dizi tabanlı dairesel bir kuyruk uygular.
public class IntQueue {
    private int[] values;
    private int front;
    private int rear;
    private int size;

    public IntQueue(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive.");
        }

        values = new int[initialCapacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    public void offer(int value) {
        ensureCapacity();
        values[rear] = value;

        // Mod işlemi, dizinin sonundan sonra kuyruğun başa dönmesini sağlar.
        rear = (rear + 1) % values.length;
        size++;
    }

    public int poll() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }

        int value = values[front];
        values[front] = 0;

        // Çıkarılan elemandan sonraki konum yeni kuyruk başı olur.
        front = (front + 1) % values.length;
        size--;
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (size < values.length) {
            return;
        }

        // Dairesel kuyruğun sırası bozulmadan elemanlar daha büyük diziye taşınır.
        int[] newValues = new int[values.length * 2];

        for (int index = 0; index < size; index++) {
            newValues[index] = values[(front + index) % values.length];
        }

        values = newValues;
        front = 0;
        rear = size;
    }
}
