

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
}

