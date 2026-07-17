// Fenwick ağacı, önek toplamlarını ve tekil güncellemeleri logaritmik sürede yapar.
public final class FenwickTree {
    private final long[] tree;
    private final int[] values;
    private final int length;

    public FenwickTree(int[] sourceValues) {
        if (sourceValues == null || sourceValues.length == 0) {
            throw new IllegalArgumentException("Source values cannot be empty.");
        }

        length = sourceValues.length;
        tree = new long[length + 1];
        values = new int[length];

        // Her değer add ile eklenerek Fenwick ağacının ilgili aralıkları oluşturulur.
        for (int index = 0; index < length; index++) {
            add(index, sourceValues[index]);
        }
    }

    public void add(int index, int delta) {
        validateIndex(index);
        values[index] += delta;
        int currentIndex = index + 1;

        // Dışarıdaki sıfır tabanlı indeks, ağaç içinde bir tabanlı kullanılır.
        while (currentIndex <= length) {
            tree[currentIndex] += delta;

            // lowbit kadar ilerlemek, bu değeri kapsayan bir sonraki aralığa geçer.
            currentIndex += lowbit(currentIndex);
        }
    }

    public void set(int index, int newValue) {
        validateIndex(index);

        // Fenwick ağacına yeni değerin tamamı değil, eski değerle farkı eklenir.
        int delta = newValue - values[index];
        add(index, delta);
    }

    public long prefixSum(int index) {
        validateIndex(index);
        long sum = 0;
        int currentIndex = index + 1;

        // lowbit çıkarılarak indeksi kapsayan aralıkların toplamı köke doğru toplanır.
        while (currentIndex > 0) {
            sum += tree[currentIndex];
            currentIndex -= lowbit(currentIndex);
        }

        return sum;
    }

    public long rangeSum(int left, int right) {
        validateRange(left, right);

        if (left == 0) {
            return prefixSum(right);
        }

        // [left, right] toplamı, iki önek toplamının farkıdır.
        return prefixSum(right) - prefixSum(left - 1);
    }

    private int lowbit(int value) {
        // İkili gösterimde en sağdaki 1 bitin temsil ettiği değeri döndürür.
        return value & -value;
    }

    public void printTreeArray() {
        System.out.print("[");

        for (int index = 1; index <= length; index++) {
            System.out.print(tree[index]);

            if (index < length) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }

    private void validateRange(int left, int right) {
        if (left < 0 || right >= length || left > right) {
            throw new IndexOutOfBoundsException(
                "Invalid range: [" + left + ", " + right + "]"
            );
        }
    }
}
