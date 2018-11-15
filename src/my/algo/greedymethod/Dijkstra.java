package my.algo.greedymethod;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Works with directed/non-directed non negative graph.
//Time complexity with array O(V^2 +E )... With PQ (V*logV+E*logV)
public class Dijkstra {
class WGraph {
    int vertices;
    List<WNode>[] adj;

    @SuppressWarnings("unchecked")
    WGraph(int v) {
        vertices = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }

    }

    void addEdge(int u, int v, int wt) {
        adj[u].add(new WNode(v, wt));
    }
}

class WNode {
    int value;
    int weight;

    public WNode(int val, int wt) {
        this.value = val;
        this.weight = wt;
    }

}