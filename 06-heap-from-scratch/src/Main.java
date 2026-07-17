public class Main {
    public static void main(String[] args) {
        // Küçük başlangıç kapasitesi, dinamik büyütme davranışını da test eder.
        MinHeap emergencyHeap = new MinHeap(3);
        int[] priorities = {40, 10, 30, 50, 20, 5, 35};

        System.out.println("Values are being inserted:");
        // Her eklemeden sonra en küçük değer köke doğru taşınır.
        for (int index = 0; index < priorities.length; index++) {
            emergencyHeap.insert(priorities[index]);
            System.out.print("After " + priorities[index] + ": ");
            emergencyHeap.printHeap();
        }

        System.out.println("Root: " + emergencyHeap.peek());
        System.out.println("Size: " + emergencyHeap.size());

        System.out.println("Extract order:");
        // Kök her çıkarıldığında sıradaki en küçük değer yeniden köke yerleşir.
        while (!emergencyHeap.isEmpty()) {
            System.out.print(emergencyHeap.extractMin());

            if (!emergencyHeap.isEmpty()) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
