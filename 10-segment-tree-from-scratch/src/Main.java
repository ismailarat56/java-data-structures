public class Main {
    public static void main(String[] args) {
        int[] sales = {2, 1, 5, 3, 4, 7};
        SegmentTree segmentTree = new SegmentTree(sales);

        System.out.println("Tree array:");
        segmentTree.printTreeArray();

        // Farklı aralıklar üzerinde toplam sorguları çalıştırılır.
        printQueries(segmentTree);

        // Tek bir değer değiştiğinde yalnızca o değerin bulunduğu dal güncellenir.
        System.out.println("Update index 2 to 6");
        segmentTree.update(2, 6);
        printQueries(segmentTree);
    }

    private static void printQueries(SegmentTree segmentTree) {
        System.out.println("Sum [0, 5]: " + segmentTree.rangeSum(0, 5));
        System.out.println("Sum [1, 4]: " + segmentTree.rangeSum(1, 4));
        System.out.println("Sum [2, 2]: " + segmentTree.rangeSum(2, 2));
        System.out.println("Sum [3, 5]: " + segmentTree.rangeSum(3, 5));
    }
}
