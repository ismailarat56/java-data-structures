public class QueueDemo {
    public static void main(String[] args) {
        MyQueue callQueue = new MyQueue(5);

        callQueue.enqueue("Ali");
        callQueue.enqueue("Ayşe");
        callQueue.enqueue("Mehmet");
        callQueue.enqueue("Zeynep");
        callQueue.enqueue("Elif");

        System.out.println();

        callQueue.peek();

        System.out.println();

        callQueue.dequeue();

        System.out.println();

        callQueue.dequeue();

        System.out.println();

        callQueue.printQueue();

        System.out.println();

        callQueue.dequeue();
        callQueue.dequeue();
        callQueue.dequeue();

        System.out.println();

        callQueue.dequeue();
    }
}
