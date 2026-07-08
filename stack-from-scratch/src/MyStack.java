public class MyStack {
    private String[] items;
    private int top;
    private int capacity;

    public MyStack(int capacity) {
        this.capacity = capacity;
        this.items = new String[capacity];
        this.top = -1;
    }

    public void push(String action) {
        if (isFull()) {
            System.out.println("Stack dolu. Yeni işlem eklenemedi.");
            return;
        }

        top++;
        items[top] = action;
        System.out.println("İşlem eklendi: " + action);
    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("Geri alınacak işlem yok.");
            return null;
        }

        String removedAction = items[top];
        items[top] = null;
        top--;

        return removedAction;
    }

    public String peek() {
        if (isEmpty()) {
            return null;
        }

        return items[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public int size() {
        return top + 1;
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack boş.");
            return;
        }

        System.out.println("Stack içeriği:");
        for (int i = top; i >= 0; i--) {
            System.out.println(items[i]);
        }
    }
}
