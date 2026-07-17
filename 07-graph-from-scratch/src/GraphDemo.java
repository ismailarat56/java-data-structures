public class GraphDemo {
    public static void main(String[] args) {
        // İlk grafik; dolaşma, derece ve yol sorgularını göstermek için bağlantılıdır.
        MatrixGraph cityGraph = new MatrixGraph(6);
        cityGraph.addUndirectedEdge(0, 1);
        cityGraph.addUndirectedEdge(0, 2);
        cityGraph.addUndirectedEdge(1, 3);
        cityGraph.addUndirectedEdge(2, 3);
        cityGraph.addUndirectedEdge(2, 4);
        cityGraph.addUndirectedEdge(4, 5);

        System.out.println("Adjacency matrix:");
        cityGraph.printMatrix();

        System.out.println("Degrees:");
        for (int vertex = 0; vertex < 6; vertex++) {
            char name = (char) ('A' + vertex);
            System.out.println(name + " = " + cityGraph.degree(vertex));
        }

        System.out.print("DFS from A: ");
        cityGraph.depthFirstSearch(0);
        System.out.print("BFS from A: ");
        cityGraph.breadthFirstSearch(0);

        System.out.println("Path A -> F: " + cityGraph.pathExists(0, 5));
        System.out.println("Path A -> A: " + cityGraph.pathExists(0, 0));

        cityGraph.removeUndirectedEdge(2, 4);
        System.out.println("C - E exists after removal: " + cityGraph.hasEdge(2, 4));
        cityGraph.addUndirectedEdge(2, 4);

        // Üç ayrı bağlı bileşen içeren ikinci bir grafik oluşturulur.
        MatrixGraph componentGraph = new MatrixGraph(6);
        componentGraph.addUndirectedEdge(0, 1);
        componentGraph.addUndirectedEdge(1, 2);
        componentGraph.addUndirectedEdge(3, 4);
        System.out.println("Connected components: " + componentGraph.countConnectedComponents());
        System.out.println("Path A -> D: " + componentGraph.pathExists(0, 3));
    }
}
