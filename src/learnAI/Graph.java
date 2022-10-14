package learnAI;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final int V;
    private int E;
    private int[][] adj;

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = new int[V][V];
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                adj[i][j] = 0;
    }
    public int V() { return V; }
    public int E() { return E; }
    public void addEdge(int v, int w) {
        adj[v][w] = 1;
        adj[w][v] = 1;
        E++;
    }
    public Iterable<Integer> adj(int v) {
        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < V; i++)
            if (this.adj[v][i] == 1)
                ls.add(i);
        return ls;
    }
}