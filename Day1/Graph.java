import java.util.ArrayList;
import java.util.List;

/**
 * A very simple (and literal) example of an AStarGraph.
 * Created by hug.
 */
public class Graph {
    /* Represents the list of edges from a single vertex. */
    private class EdgeList {
        private List<WeightedEdge<Integer>> list;
        private EdgeList() {
            list = new ArrayList<>();
        }
    }

    private EdgeList[] adj;

    public Graph(int V) {
        adj = new EdgeList[V];
        for (int i = 0; i < V; i += 1) {
            adj[i] = new EdgeList();
        }
    }

    public List<WeightedEdge<Integer>> neighbors(Integer v) {
        return adj[v].list;
    }

    public void addEdge(int p, int q, double w) {
        WeightedEdge<Integer> e = new WeightedEdge<>(p, q, w);
        adj[p].list.add(e);
    }

}