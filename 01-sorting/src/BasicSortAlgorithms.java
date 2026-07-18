public class BasicSortAlgorithms {

    // Bubble Sort, yan yana duran sayıları karşılaştırır.
    public static void bubbleSort(int[] numbers, SortMetrics metrics) {
        // Her turda en büyük sayılardan biri dizinin sonuna gider.
        for (int pass = 0; pass < numbers.length - 1; pass++) {
            boolean swapped = false;

            // Son taraftaki sıralı sayıları yeniden kontrol etmeyiz.
            for (int i = 0; i < numbers.length - 1 - pass; i++) {
                metrics.addComparison();

                // Soldaki sayı büyükse iki sayının yerini değiştiririz.
                if (numbers[i] > numbers[i + 1]) {
                    swap(numbers, i, i + 1);
                    metrics.addSwap();
                    swapped = true;
                }
            }

            // Bu turda swap olmadıysa dizi zaten sıralıdır.
            if (!swapped) {
                break;
            }
        }
    }

    // Selection Sort, her turda en küçük sayıyı bulur.
    public static void selectionSort(int[] numbers, SortMetrics metrics) {
        // i, sıradaki sayının yerleştirileceği konumu gösterir.
        for (int i = 0; i < numbers.length - 1; i++) {
            int smallestIndex = i;

            // Sıralanmamış bölümdeki en küçük sayıyı ararız.
            for (int j = i + 1; j < numbers.length; j++) {
                metrics.addComparison();

                if (numbers[j] < numbers[smallestIndex]) {
                    smallestIndex = j;
                }
            }

            // En küçük sayı başka bir yerdeyse i konumuna taşırız.
            if (smallestIndex != i) {
                swap(numbers, i, smallestIndex);
                metrics.addSwap();
            }
        }
    }

    // Insertion Sort, sayıları sıralı bölümde doğru yere ekler.
    public static void insertionSort(int[] numbers, SortMetrics metrics) {
        // İlk sayıyı sıralı kabul ettiğimiz için 1. indexten başlarız.
        for (int i = 1; i < numbers.length; i++) {
            int currentNumber = numbers[i];
            int position = i - 1;

            // Büyük sayıları bir konum sağa kaydırırız.
            while (position >= 0) {
                metrics.addComparison();

                if (numbers[position] <= currentNumber) {
                    break;
                }

                numbers[position + 1] = numbers[position];
                position--;
            }

            // currentNumber değerini açılan doğru yere yerleştiririz.
            numbers[position + 1] = currentNumber;
        }
    }

    // Counting Sort, yalnızca sıfır ve pozitif sayılarla çalışır.
    public static int[] countingSort(int[] numbers) {
        // Boş dizi geldiyse boş bir sonuç döndürürüz.
        if (numbers.length == 0) {
            return new int[0];
        }

        int largestNumber = numbers[0];

        // En büyük sayıyı bulur ve negatif sayı kontrolü yaparız.
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                System.out.println(
                    "Counting Sort cannot use negative numbers."
                );
                return new int[0];
            }

            if (numbers[i] > largestNumber) {
                largestNumber = numbers[i];
            }
        }

        // Her index, o sayının kaç kez geçtiğini tutar.
        int[] counts = new int[largestNumber + 1];

        // Dizideki sayıların tekrar miktarını sayarız.
        for (int i = 0; i < numbers.length; i++) {
            counts[numbers[i]]++;
        }

        int[] sortedNumbers = new int[numbers.length];
        int sortedIndex = 0;

        // Sayıları küçükten büyüğe sonuç dizisine ekleriz.
        for (int number = 0; number < counts.length; number++) {
            for (int count = 0; count < counts[number]; count++) {
                sortedNumbers[sortedIndex] = number;
                sortedIndex++;
            }
        }

        return sortedNumbers;
    }

    // Bir diziyi hazır metot kullanmadan yazıya çevirir.
    public static String arrayToString(int[] numbers) {
        String text = "[";

        for (int i = 0; i < numbers.length; i++) {
            text = text + numbers[i];

            if (i < numbers.length - 1) {
                text = text + ", ";
            }
        }

        text = text + "]";
        return text;
    }

    // İki sayının dizideki yerini değiştirir.
    private static void swap(int[] numbers, int first, int second) {
        int temp = numbers[first];
        numbers[first] = numbers[second];
        numbers[second] = temp;
    }
}
