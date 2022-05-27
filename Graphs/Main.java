package AishaADS;

public class Main {
    public static void main(String[] args) {
        Vertex<String> A = new Vertex<>("A");
        Vertex<String> B = new Vertex<>("B");
        Vertex<String> C = new Vertex<>("C");
        Vertex<String> D = new Vertex<>("D");
        Vertex<String> E = new Vertex<>("E");
        Vertex<String> F = new Vertex<>("F");
        Vertex<String> G = new Vertex<>("G");
        Vertex<String> H = new Vertex<>("H");
        A.addAdjacentVertex(B, 10);
        A.addAdjacentVertex(E, 0.5);
        A.addAdjacentVertex(D, 2.0);
        B.addAdjacentVertex(C, 3.0);
        C.addAdjacentVertex(B, 3.0);
        D.addAdjacentVertex(E, 1.0);
        D.addAdjacentVertex(G, 6.0);
        E.addAdjacentVertex(F, 7.0);
        E.addAdjacentVertex(H, 1.0);
        E.addAdjacentVertex(B, 8.0);
        F.addAdjacentVertex(B, 2.0);
        F.addAdjacentVertex(C, 8.0);
        F.addAdjacentVertex(H, 1.0);
        G.addAdjacentVertex(H, 2.0);
        H.addAdjacentVertex(D, 9.0);
        H.addAdjacentVertex(G, 5.0);
        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addVertex(A);
        graph.addVertex(B);
        graph.addVertex(C);
        graph.addVertex(D);
        graph.addVertex(E);
        graph.addVertex(F);
        graph.addVertex(G);
        graph.addVertex(H);
        Search<String> bfs = new BFS<>(graph, A);
        bfs.outputPath(B);
        Search<String> ds = new DijkstraSearch<>(graph, A);
        ds.outputPath(G);
    }
}
