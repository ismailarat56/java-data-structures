public class UnionFindDemo {
    public static void main(String[] args) {
        UnionFind network = new UnionFind(8);

        System.out.print("Start parents: ");
        network.printParents();
        System.out.println("Start components: " + network.componentCount());

        int[][] connections = {
            {0, 1},
            {1, 2},
            {3, 4},
            {5, 6},
            {6, 7},
            {2, 7}
        };

        // Her union işlemi iki farklı bileşeni tek bir bileşende birleştirir.
        for (int index = 0; index < connections.length; index++) {
            int first = connections[index][0];
            int second = connections[index][1];
            network.union(first, second);
            System.out.print("After union(" + first + ", " + second + "): ");
            network.printParents();
        }

        // Bağlantı ve bileşen boyutu sorguları, elemanların kökleri üzerinden yapılır.
        System.out.println("Components: " + network.componentCount());
        System.out.println("0 and 7: " + network.connected(0, 7));
        System.out.println("3 and 4: " + network.connected(3, 4));
        System.out.println("0 and 3: " + network.connected(0, 3));
        System.out.println("Size of component 0: " + network.sizeOfComponent(0));
        System.out.println("Size of component 3: " + network.sizeOfComponent(3));
    }
}
