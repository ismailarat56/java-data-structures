// Union-Find, ayrık kümeleri birleştirir ve iki elemanın bağlılığını hızlıca sorgular.
public class UnionFind {
    private final int[] parent;
    // Rank, ağaçların gereksiz yere derinleşmesini önleyen yaklaşık yüksekliği tutar.
    private final int[] rank;
    // Bileşen boyutu yalnızca o bileşenin kök indeksinde anlamlıdır.
    private final int[] componentSize;
    private int componentCount;

    public UnionFind(int elementCount) {
        if (elementCount <= 0) {
            throw new IllegalArgumentException("Element count must be positive.");
        }

        parent = new int[elementCount];
        rank = new int[elementCount];
        componentSize = new int[elementCount];
        componentCount = elementCount;

        // Başlangıçta her eleman kendi kökü olan tek elemanlı bir bileşendir.
        for (int index = 0; index < elementCount; index++) {
            parent[index] = index;
            rank[index] = 0;
            componentSize[index] = 1;
        }
    }

    public int find(int element) {
        validateElement(element);

        if (parent[element] != element) {
            // Yol sıkıştırma ile eleman doğrudan köke bağlanır.
            parent[element] = find(parent[element]);
        }

        return parent[element];
    }

    public boolean union(int firstElement, int secondElement) {
        int firstRoot = find(firstElement);
        int secondRoot = find(secondElement);

        if (firstRoot == secondRoot) {
            return false;
        }

        // Düşük rank değerli ağaç, yüksek rank değerli ağacın altına bağlanır.
        if (rank[firstRoot] < rank[secondRoot]) {
            parent[firstRoot] = secondRoot;
            componentSize[secondRoot] += componentSize[firstRoot];
        } else if (rank[firstRoot] > rank[secondRoot]) {
            parent[secondRoot] = firstRoot;
            componentSize[firstRoot] += componentSize[secondRoot];
        } else {
            parent[secondRoot] = firstRoot;
            rank[firstRoot]++;
            componentSize[firstRoot] += componentSize[secondRoot];
        }

        // İki ayrı bileşen birleştiği için toplam bileşen sayısı bir azalır.
        componentCount--;
        return true;
    }

    public boolean connected(int firstElement, int secondElement) {
        return find(firstElement) == find(secondElement);
    }

    public int sizeOfComponent(int element) {
        int root = find(element);
        return componentSize[root];
    }

    public int componentCount() {
        return componentCount;
    }

    public void printParents() {
        System.out.print("[");

        for (int index = 0; index < parent.length; index++) {
            System.out.print(parent[index]);

            if (index < parent.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    private void validateElement(int element) {
        if (element < 0 || element >= parent.length) {
            throw new IndexOutOfBoundsException("Invalid element: " + element);
        }
    }
}
