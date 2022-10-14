package learnAI;

import java.util.Stack;

public class DepthFirstSearch {
    private boolean[] marked;
    public DepthFirstSearch(Graph g, int v) {
        // init vertex marked with default value false
        marked = new boolean[g.V()];
        dfs(g, v);
    }
    private void dfs(Graph g, int v) {
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        int currentVertex;

        while (!stack.isEmpty()) {
            currentVertex = stack.pop();
            if (marked[currentVertex]) continue;

            marked[currentVertex] = true;
            for (Integer i : g.adj(currentVertex))
                if (!marked[i])
                    stack.push(i);
        }
    }
    public boolean marked(int v) { return marked[v]; }
}