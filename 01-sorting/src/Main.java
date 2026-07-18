public class Main {

    public static void main(String[] args) {
        int[] originalNumbers = {5, 3, 8, 1, 2};

        // Her algoritmanın aynı sayılarla çalışması için diziyi kopyalarız.
        int[] bubbleNumbers = copyArray(originalNumbers);
        int[] selectionNumbers = copyArray(originalNumbers);
        int[] insertionNumbers = copyArray(originalNumbers);

        // Her algoritma için ayrı bir ölçüm nesnesi oluştururuz.
        SortMetrics bubbleMetrics = new SortMetrics();
        SortMetrics selectionMetrics = new SortMetrics();
        SortMetrics insertionMetrics = new SortMetrics();

        // Bubble Sort çalışırken geçen süreyi ölçeriz.
        long bubbleStart = System.nanoTime();
        BasicSortAlgorithms.bubbleSort(bubbleNumbers, bubbleMetrics);
        long bubbleTime = System.nanoTime() - bubbleStart;

        // Selection Sort çalışırken geçen süreyi ölçeriz.
        long selectionStart = System.nanoTime();
        BasicSortAlgorithms.selectionSort(selectionNumbers, selectionMetrics);
        long selectionTime = System.nanoTime() - selectionStart;

        // Insertion Sort çalışırken geçen süreyi ölçeriz.
        long insertionStart = System.nanoTime();
        BasicSortAlgorithms.insertionSort(insertionNumbers, insertionMetrics);
        long insertionTime = System.nanoTime() - insertionStart;

        System.out.println("SORTED RESULTS");
        System.out.println("==============");
        System.out.println(
            "Original:       "
                + BasicSortAlgorithms.arrayToString(originalNumbers)
        );
        System.out.println(
            "Bubble Sort:    "
                + BasicSortAlgorithms.arrayToString(bubbleNumbers)
        );
        System.out.println(
            "Selection Sort: "
                + BasicSortAlgorithms.arrayToString(selectionNumbers)
        );
        System.out.println(
            "Insertion Sort: "
                + BasicSortAlgorithms.arrayToString(insertionNumbers)
        );

        // Counting Sort için yalnızca sıfır ve pozitif sayılar kullanırız.
        int[] countingNumbers = {4, 2, 2, 8, 3, 3, 1};
        int[] countingResult = BasicSortAlgorithms.countingSort(
            countingNumbers
        );

        System.out.println(
            "Counting Sort:  "
                + BasicSortAlgorithms.arrayToString(countingResult)
        );

        System.out.println("");
        System.out.println("METRICS");
        System.out.println("=======");
        printMetrics("Bubble Sort", bubbleMetrics, bubbleTime);
        printMetrics("Selection Sort", selectionMetrics, selectionTime);
        printMetrics("Insertion Sort", insertionMetrics, insertionTime);

        // Son olarak üç temel sıralamanın doğru çalıştığını kontrol ederiz.
        boolean allSorted = isSorted(bubbleNumbers)
            && isSorted(selectionNumbers)
            && isSorted(insertionNumbers);

        System.out.println("");
        System.out.println("All basic sorts are correct: " + allSorted);
    }

    // Hazır kopyalama metodu yerine yeni bir dizi oluştururuz.
    private static int[] copyArray(int[] numbers) {
        int[] copy = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            copy[i] = numbers[i];
        }

        return copy;
    }

    // Dizinin küçükten büyüğe sıralı olup olmadığını kontrol eder.
    private static boolean isSorted(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i - 1] > numbers[i]) {
                return false;
            }
        }

        return true;
    }

    // Bir algoritmanın ölçüm sonucunu tek satırda gösterir.
    private static void printMetrics(
        String name,
        SortMetrics metrics,
        long time
    ) {
        System.out.println(
            name
                + " | comparisons: "
                + metrics.getComparisons()
                + " | swaps: "
                + metrics.getSwaps()
                + " | time: "
                + time
                + " ns"
        );
    }
}
