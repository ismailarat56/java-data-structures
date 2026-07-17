public class Main {
    public static void main(String[] args) {
        int[] sales = {2, 1, 5, 3, 4, 7};
        FenwickTree fenwickTree = new FenwickTree(sales);

        System.out.println("Fenwick tree array:");
        fenwickTree.printTreeArray();

        // Önek ve aralık toplamları ilk değerlerle kontrol edilir.
        printQueries(fenwickTree);

        // set, yeni değer ile eski değer arasındaki farkı ağaca uygular.
        System.out.println("Set index 2 to 6");
        fenwickTree.set(2, 6);
        fenwickTree.printTreeArray();
        printQueries(fenwickTree);
    }

    private static void printQueries(FenwickTree fenwickTree) {
        System.out.println("Prefix [0, 0]: " + fenwickTree.prefixSum(0));
        System.out.println("Prefix [0, 2]: " + fenwickTree.prefixSum(2));
        System.out.println("Prefix [0, 5]: " + fenwickTree.prefixSum(5));
        System.out.println("Sum [0, 5]: " + fenwickTree.rangeSum(0, 5));
        System.out.println("Sum [1, 4]: " + fenwickTree.rangeSum(1, 4));
        System.out.println("Sum [2, 2]: " + fenwickTree.rangeSum(2, 2));
        System.out.println("Sum [3, 5]: " + fenwickTree.rangeSum(3, 5));
    }
}
