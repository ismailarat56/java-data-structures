// Segment ağacı, aralık toplamı sorgularını ve tekil güncellemeleri logaritmik sürede yapar.
public class SegmentTree {
    private final int[] values;
    private final long[] tree;
    private final int length;

    public SegmentTree(int[] sourceValues) {
        if (sourceValues == null || sourceValues.length == 0) {
            throw new IllegalArgumentException("Source values cannot be empty.");
        }

        length = sourceValues.length;
        values = new int[length];
        tree = new long[length * 4];

        for (int index = 0; index < length; index++) {
            values[index] = sourceValues[index];
        }

        // Düğümler 1. indeksten başlayacak şekilde ağaç rekürsif olarak kurulur.
        build(1, 0, length - 1);
    }

    private void build(int node, int start, int end) {
        if (start == end) {
            // Yaprak düğüm yalnızca bir dizi değerini tutar.
            tree[node] = values[start];
            return;
        }

        int middle = start + (end - start) / 2;
        build(node * 2, start, middle);
        build(node * 2 + 1, middle + 1, end);

        // İç düğüm, sol ve sağ çocuk aralıklarının toplamını saklar.
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    public long rangeSum(int left, int right) {
        validateRange(left, right);
        return query(1, 0, length - 1, left, right);
    }

    private long query(
        int node,
        int start,
        int end,
        int queryLeft,
        int queryRight
    ) {
        // Aralıklar çakışmıyorsa bu dalın toplama katkısı sıfırdır.
        if (queryRight < start || end < queryLeft) {
            return 0;
        }

        // Düğüm aralığı sorgunun tamamen içindeyse hazır toplam kullanılır.
        if (queryLeft <= start && end <= queryRight) {
            return tree[node];
        }

        int middle = start + (end - start) / 2;

        // Kısmi çakışmada sorgu iki çocuğa bölünür ve sonuçlar birleştirilir.
        long leftSum = query(node * 2, start, middle, queryLeft, queryRight);
        long rightSum = query(node * 2 + 1, middle + 1, end, queryLeft, queryRight);
        return leftSum + rightSum;
    }

    public void update(int index, int newValue) {
        validateIndex(index);
        values[index] = newValue;
        updateRecursive(1, 0, length - 1, index, newValue);
    }

    private void updateRecursive(
        int node,
        int start,
        int end,
        int index,
        int newValue
    ) {
        if (start == end) {
            tree[node] = newValue;
            return;
        }

        int middle = start + (end - start) / 2;

        // Güncellenecek indeks hangi yarıdaysa yalnızca o dala ilerlenir.
        if (index <= middle) {
            updateRecursive(node * 2, start, middle, index, newValue);
        } else {
            updateRecursive(node * 2 + 1, middle + 1, end, index, newValue);
        }

        // Güncelleme sonrası köke kadar olan toplamlar yeniden hesaplanır.
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    public void printTreeArray() {
        System.out.print("[");

        for (int index = 1; index < tree.length; index++) {
            System.out.print(tree[index]);

            if (index < tree.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    private void validateRange(int left, int right) {
        if (left < 0 || right >= length || left > right) {
            throw new IndexOutOfBoundsException(
                "Invalid range: [" + left + ", " + right + "]"
            );
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }
}
