package my.algo.backtracking;
public class GraphColoringProblem {

    private static boolean isBoundingConditionSatisfied(int graph[][], int[] colors, int v, int clr) {
        for (int i = 0; i < graph.length; i++)
            if (graph[v][i] == 1 && clr == colors[i])
                return false;
        return true;
    }

    private static boolean graphColoringRec(int graph[][], int numberOfColors, int[] colors, int v) {
        if (v == graph.length)
            return true;
        for (int c = 1; c <= numberOfColors; c++) {
            if (isBoundingConditionSatisfied(graph, colors, v, c)) {
                colors[v] = c;

                if (graphColoringRec(graph, numberOfColors, colors, v + 1))
                    return true;

                colors[v] = 0;
            }
        }
        return false;
    }
  
}
