public class MyQueue {
    private String[] items;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public MyQueue(int capacity) {
        this.capacity = capacity;
        this.items = new String[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(String name) {
        if (isFull()) {
            System.out.println("Queue dolu. Yeni kişi eklenemedi.");
            return;
        }

        rear = (rear + 1) % capacity;
        items[rear] = name;
        size++;

        System.out.println(name + " sıraya eklendi.");
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Sırada bekleyen kişi yok.");
            return;
        }

        String servedPerson = items[front];
        items[front] = null;

        front = (front + 1) % capacity;
        size--;

        System.out.println("Hizmet alan kişi: " + servedPerson);

        if (isEmpty()) {
            System.out.println("Sıra boşaldı.");
        } else {
            System.out.println("Yeni sıradaki kişi: " + items[front]);
        }
    }

    public String peek() {
        if (isEmpty()) {
            System.out.println("Sırada bekleyen kişi yok.");
            return null;
        }

        System.out.println("Sıradaki kişi: " + items[front]);
        return items[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue boş.");
            return;
        }

        System.out.print("Queue içeriği: ");

        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(items[index]);

            if (i < size - 1) {
                System.out.print(" <- ");
            }
        }

        System.out.println();
    }
}
