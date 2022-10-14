package learnAI;

import java.util.LinkedList;

public class DepthFirstPaths {
	private boolean[] marked;
	private int[] edgeTo;
	private int s;

	public DepthFirstPaths(Graph g, int s) {
		marked = new boolean[g.V()];
		edgeTo = new int[g.V()];
		this.s = s;
		dfs(g, s);
	}

	private void dfs(Graph g, int v) {
		marked[v] = true;
		for (Integer i : g.adj(v))
			if (!marked[i]) {
				edgeTo[i] = v;
				dfs(g, i);
			}
	}

	public boolean hasPathTo(int w) {
		return marked[w];
	}

	public Iterable<Integer> pathTo(int w) {
		if (!hasPathTo(w))
			return null;
		LinkedList<Integer> path = new LinkedList<>();
		for (int i = w; i != s; i = edgeTo[i])
			path.addFirst(i);
		path.addFirst(s);
		return path;
	}

	public static void main(String[] args) {
		Graph g = new Graph(20);
		g.addEdge(0, 1);
		g.addEdge(0, 4);
		g.addEdge(0, 5);
		g.addEdge(1, 0);
		g.addEdge(1, 2);
		g.addEdge(2, 1);
		g.addEdge(2, 3);
		g.addEdge(2, 5);
		g.addEdge(3, 2);
		g.addEdge(3, 6);
		g.addEdge(4, 0);
		g.addEdge(4, 8);
		g.addEdge(5, 0);
		g.addEdge(5, 2);
		g.addEdge(6, 3);
		g.addEdge(6, 7);
		g.addEdge(6, 9);
		g.addEdge(6, 10);
		g.addEdge(7, 6);
		g.addEdge(7, 14);
		g.addEdge(8, 4);
		g.addEdge(8, 9);
		g.addEdge(8, 12);
		g.addEdge(8, 13);
		g.addEdge(9, 8);
		g.addEdge(9, 5);
		g.addEdge(9, 6);
		g.addEdge(10, 6);
		g.addEdge(10, 14);
		g.addEdge(11, 15);
		g.addEdge(12, 8);
		g.addEdge(13, 14);
		g.addEdge(13, 8);
		g.addEdge(14, 10);
		g.addEdge(14, 13);
		g.addEdge(14, 15);
		g.addEdge(15, 11);

		DepthFirstPaths path = new DepthFirstPaths(g, 0);
		Iterable<Integer> rs = path.pathTo(11);
		System.out.println(rs);

	}
}