public class MyHashMap {
    private Entry[] table;
    private int capacity;
    private int size;

    public MyHashMap(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity 0'dan büyük olmalıdır.");
        }

        this.capacity = capacity;
        this.table = new Entry[capacity];
        this.size = 0;
    }

    public int hash(int key) {
        return Math.abs(key % capacity);
    }

    public void put(int key, String value) {
        int index = hash(key);
        Entry current = table[index];

        if (current == null) {
            table[index] = new Entry(key, value);
            size++;
            return;
        }

        while (current != null) {
            if (current.key == key) {
                current.value = value;
                return;
            }

            if (current.next == null) {
                break;
            }

            current = current.next;
        }

        current.next = new Entry(key, value);
        size++;
    }

    public String get(int key) {
        int index = hash(key);
        Entry current = table[index];

        while (current != null) {
            if (current.key == key) {
                return current.value;
            }

            current = current.next;
        }

        return null;
    }

    public boolean containsKey(int key) {
        int index = hash(key);
        Entry current = table[index];

        while (current != null) {
            if (current.key == key) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    public boolean remove(int key) {
        int index = hash(key);
        Entry current = table[index];
        Entry previous = null;

        while (current != null) {
            if (current.key == key) {
                if (previous == null) {
                    table[index] = current.next;
                } else {
                    previous.next = current.next;
                }

                size--;
                return true;
            }

            previous = current;
            current = current.next;
        }

        return false;
    }

    public int size() {
        return size;
    }

    public void printTable() {
        System.out.println();
        System.out.println("Hash Table Durumu:");

        for (int i = 0; i < capacity; i++) {
            System.out.print("table[" + i + "]");

            Entry current = table[i];

            while (current != null) {
                System.out.print(" -> " + current.key + ": " + current.value);
                current = current.next;
            }

            System.out.println(" -> null");
        }
    }
}
