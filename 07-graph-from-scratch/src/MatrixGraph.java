// Yönsüz grafiği komşuluk matrisiyle temsil eder.
public class MatrixGraph {
    private final int[][] adjacencyMatrix;
    private final int vertexCount;

    public MatrixGraph(int vertexCount) {
        if (vertexCount <= 0) {
            throw new IllegalArgumentException("Vertex count must be positive.");
        }

        this.vertexCount = vertexCount;
        adjacencyMatrix = new int[vertexCount][vertexCount];
    }

    public void addUndirectedEdge(int firstVertex, int secondVertex) {
        validateVertex(firstVertex);
        validateVertex(secondVertex);

        if (firstVertex == secondVertex) {
            throw new IllegalArgumentException("Self-loops are not supported.");
        }

        // Grafik yönsüz olduğu için bağlantı matrisin iki yönünde de işaretlenir.
        adjacencyMatrix[firstVertex][secondVertex] = 1;
        adjacencyMatrix[secondVertex][firstVertex] = 1;
    }

    public void removeUndirectedEdge(int firstVertex, int secondVertex) {
        validateVertex(firstVertex);
        validateVertex(secondVertex);
        adjacencyMatrix[firstVertex][secondVertex] = 0;
        adjacencyMatrix[secondVertex][firstVertex] = 0;
    }

    public boolean hasEdge(int firstVertex, int secondVertex) {
        validateVertex(firstVertex);
        validateVertex(secondVertex);
        return adjacencyMatrix[firstVertex][secondVertex] == 1;
    }

    public int degree(int vertex) {
        validateVertex(vertex);
        int degree = 0;

        for (int neighbor = 0; neighbor < vertexCount; neighbor++) {
            degree += adjacencyMatrix[vertex][neighbor];
        }

        return degree;
    }

    public void depthFirstSearch(int startVertex) {
        validateVertex(startVertex);
        boolean[] visited = new boolean[vertexCount];

        // DFS, bir dalı sonuna kadar izledikten sonra önceki düğüme geri döner.
        depthFirstSearchRecursive(startVertex, visited);
        System.out.println();
    }

    private void depthFirstSearchRecursive(int currentVertex, boolean[] visited) {
        visited[currentVertex] = true;
        System.out.print(vertexName(currentVertex) + " ");

        // Ziyaret edilmemiş her komşu aynı yöntemle derinlemesine gezilir.
        for (int neighbor = 0; neighbor < vertexCount; neighbor++) {
            if (adjacencyMatrix[currentVertex][neighbor] == 1 && !visited[neighbor]) {
                depthFirstSearchRecursive(neighbor, visited);
            }
        }
    }

    public void breadthFirstSearch(int startVertex) {
        validateVertex(startVertex);
        boolean[] visited = new boolean[vertexCount];
        IntQueue queue = new IntQueue(vertexCount);

        visited[startVertex] = true;
        queue.offer(startVertex);

        // BFS, kuyruğa eklenen düğümleri seviye seviye ziyaret eder.
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(vertexName(currentVertex) + " ");

            for (int neighbor = 0; neighbor < vertexCount; neighbor++) {
                if (adjacencyMatrix[currentVertex][neighbor] == 1 && !visited[neighbor]) {
                    // Aynı düğümün kuyruğa birden fazla kez eklenmesini önler.
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        System.out.println();
    }

    public boolean pathExists(int source, int destination) {
        validateVertex(source);
        validateVertex(destination);

        if (source == destination) {
            return true;
        }

        boolean[] visited = new boolean[vertexCount];
        IntQueue queue = new IntQueue(vertexCount);
        visited[source] = true;
        queue.offer(source);

        // Hedefe ulaşılır ulaşılmaz arama sonlandırılır.
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            for (int neighbor = 0; neighbor < vertexCount; neighbor++) {
                if (adjacencyMatrix[currentVertex][neighbor] == 1 && !visited[neighbor]) {
                    if (neighbor == destination) {
                        return true;
                    }

                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        return false;
    }

    public int countConnectedComponents() {
        boolean[] visited = new boolean[vertexCount];
        int componentCount = 0;

        // Ziyaret edilmemiş her düğüm yeni bir bağlı bileşenin başlangıcıdır.
        for (int vertex = 0; vertex < vertexCount; vertex++) {
            if (!visited[vertex]) {
                componentCount++;
                visitComponent(vertex, visited);
            }
        }

        return componentCount;
    }

    private void visitComponent(int currentVertex, boolean[] visited) {
        visited[currentVertex] = true;

        for (int neighbor = 0; neighbor < vertexCount; neighbor++) {
            if (adjacencyMatrix[currentVertex][neighbor] == 1 && !visited[neighbor]) {
                visitComponent(neighbor, visited);
            }
        }
    }

    public void printMatrix() {
        System.out.print("  ");
        for (int vertex = 0; vertex < vertexCount; vertex++) {
            System.out.print(vertexName(vertex) + " ");
        }
        System.out.println();

        for (int row = 0; row < vertexCount; row++) {
            System.out.print(vertexName(row) + " ");

            for (int column = 0; column < vertexCount; column++) {
                System.out.print(adjacencyMatrix[row][column] + " ");
            }

            System.out.println();
        }
    }

    private char vertexName(int vertex) {
        return (char) ('A' + vertex);
    }

    private void validateVertex(int vertex) {
        if (vertex < 0 || vertex >= vertexCount) {
            throw new IndexOutOfBoundsException("Invalid vertex: " + vertex);
        }
    }
}
