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
      public static void  graphColoring(int graph[][], int numberOfColors) {
        int colors[] = new int[graph.length];
        System.out.println(graphColoringRec(graph, numberOfColors, colors, 0));
        for(int i=0; i<graph.length; i++) {
            System.out.print("   "+colors[i]);
        }

    }

    public static void main(String ...args) {
        int graph[][] = {{0, 1, 1, 1}, 
                {1, 0, 1, 0}, 
                {1, 1, 0, 1}, 
                {1, 0, 1, 0}};
        graphColoring(graph, 3);

    }  
}
