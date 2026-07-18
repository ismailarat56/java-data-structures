public class SortMetrics {
    // Algoritmanın yaptığı işlem sayılarını saklarız.
    private long comparisons;
    private long swaps;

    // Her karşılaştırmadan sonra sayacı bir artırırız.
    public void addComparison() {
        comparisons++;
    }

    // Her swap işleminden sonra sayacı bir artırırız.
    public void addSwap() {
        swaps++;
    }

    // Karşılaştırma sayısını okumak için kullanılır.
    public long getComparisons() {
        return comparisons;
    }

    // Swap sayısını okumak için kullanılır.
    public long getSwaps() {
        return swaps;
    }
}
