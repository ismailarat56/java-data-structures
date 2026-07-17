// Min-heap, eklenen değerler arasındaki en küçük değeri her zaman kökte tutar.
public class MinHeap {
    private int[] heap;
    private int size;

    public MinHeap(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive.");
        }

        heap = new int[initialCapacity];
        size = 0;
    }

    public void insert(int value) {
        ensureCapacity();

        // Yeni değer önce dizinin sonuna eklenir, ardından doğru konuma yükseltilir.
        heap[size] = value;
        heapifyUp(size);
        size++;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty.");
        }

        return heap[0];
    }

    public int extractMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty.");
        }

        int minimum = heap[0];
        size--;

        // Son eleman köke taşınır; böylece dizide boşluk oluşması engellenir.
        if (size > 0) {
            heap[0] = heap[size];
        }
        heap[size] = 0;

        if (size > 0) {
            heapifyDown(0);
        }

        return minimum;
    }

    private void heapifyUp(int index) {
        // Çocuk ebeveynden küçük olduğu sürece yerlerini değiştirir.
        while (index > 0) {
            int parent = parentIndex(index);

            if (heap[index] >= heap[parent]) {
                break;
            }

            swap(index, parent);
            index = parent;
        }
    }

    private void heapifyDown(int index) {
        // Düğüm, iki çocuğunun en küçüğüyle karşılaştırılarak aşağı indirilir.
        while (true) {
            int left = leftChildIndex(index);
            int right = rightChildIndex(index);
            int smallest = index;

            if (left < size && heap[left] < heap[smallest]) {
                smallest = left;
            }

            if (right < size && heap[right] < heap[smallest]) {
                smallest = right;
            }

            if (smallest == index) {
                break;
            }

            swap(index, smallest);
            index = smallest;
        }
    }

    private int parentIndex(int index) {
        return (index - 1) / 2;
    }

    private int leftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int rightChildIndex(int index) {
        return 2 * index + 2;
    }

    private void swap(int firstIndex, int secondIndex) {
        int temporary = heap[firstIndex];
        heap[firstIndex] = heap[secondIndex];
        heap[secondIndex] = temporary;
    }

    private void ensureCapacity() {
        if (size < heap.length) {
            return;
        }

        // Dizi dolduğunda kapasite iki katına çıkarılır.
        int[] newHeap = new int[heap.length * 2];

        for (int index = 0; index < heap.length; index++) {
            newHeap[index] = heap[index];
        }

        heap = newHeap;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printHeap() {
        System.out.print("[");

        for (int index = 0; index < size; index++) {
            System.out.print(heap[index]);

            if (index < size - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }
}
