

package my.algo.backtracking;


public class HamiltonianCycle {

    private static boolean isBoundingConditionSatisfied(int graph[][], int path[], int vidx, int v) {
        if (graph[path[vidx - 1]][v] == 0)
            return false;
        for (int i = 0; i < vidx; i++)
            if (path[i] == v)
                return false;
        
        return true;
    }

    public static boolean isHamiltonianCycle(int graph[][], int path[], int vidx) {

        if (vidx == graph.length) {
            if (graph[path[vidx - 1]][path[0]] == 1) {
                print(path);
                return true;
            }
            else
                return false;
        }

        for (int v = 1; v < graph.length; v++) {
            
            if(isBoundingConditionSatisfied(graph, path, vidx, v)) {
                
                path[vidx] = v;
                
                if(isHamiltonianCycle(graph, path, vidx+1))
                    return true;
                
                path[vidx]= -1;
            }
        }
        
        return false;

    }

}
