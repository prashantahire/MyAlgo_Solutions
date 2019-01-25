

package my.algo.branchandbound;


import java.util.LinkedList;


public class JobSequencing {

    public static void  solve(int time[], int penalty[], int deadline[], int jobs) {

        LinkedList<Integer> queue = new LinkedList<>();

        int cost[][] = new int[jobs][jobs];
        int maxPenalty = Integer.MAX_VALUE;
        int penaltysum[][] = new int[jobs][jobs];
        int level = 0;
        queue.add(0);
        // while (!queue.isEmpty()) {
        // int node = queue.poll();
        int node = 0;
        do {
            for (int i = node; i < jobs; i++) {

                cost[level][i] = getcost(penalty, i, level, cost);
                penaltysum[level][i] = getpenalty(penalty, i, level, penaltysum);
                if (penaltysum[level][i] < maxPenalty)
                    maxPenalty = penaltysum[level][i];
                if (cost[level][i] < maxPenalty)
                    queue.add(i);
            }
            node = queue.poll();
            level++;
        } while (!queue.isEmpty());
        System.out.println(maxPenalty);
    }    
        private static int getcost(int penalty[], int node, int level, int cost[][]) {
        int sum = 0;
        for (int i = 0; i < node; i++)
            sum += penalty[i];
        for (int i = 0; i < level; i++)
            for (int j = 0; j < node; j++)
                sum = sum - cost[i][j];
        return sum;
    }
        private static int getpenalty(int penalty[], int node, int level, int ps[][]) {
        int sum = 0;
        for (int i = 0; i < penalty.length; i++)
            if (node != i)
                sum += penalty[i];
        for (int i = 0; i < level; i++)
            for (int j = 0; j < node - 1; j++)
                sum = sum - ps[i][j];
        return sum;
    }
}

