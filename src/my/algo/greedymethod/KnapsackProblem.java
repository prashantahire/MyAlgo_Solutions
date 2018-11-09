

package my.algo.greedymethod;


import java.util.ArrayList;
import java.util.List;

/**
 * Greedy method approach
 * COntraint: Allowed weight: maxweight
 * Objective: Maximum profit
 * 
 * @author prashant
 *
 */
public class KnapsackProblem {

    /**
     * Constraint: Sack can have max weight of 15 Problem statement: Select items such that gives max profit
     */
    public List<KnapSackItem> solutionKnapsackProblem(List<KnapSackItem> items, int maxWeight) {
        for (KnapSackItem item : items) {
            item.profitperwt = item.profit / item.weight;
        }
        items.sort((e1, e2) -> {
            if (e1.profitperwt < e2.profitperwt)
                return 1;
            else if (e1.profitperwt == e2.profitperwt)
                return 0;
            else
                return -1;

        });
        int i = 0;
        List<KnapSackItem> finalist = new ArrayList<>();
        while (maxWeight > 0 && i < items.size()) {
            if ((maxWeight - items.get(i).weight) < 0) {
                items.get(i).weight = maxWeight;
                items.get(i).profit = (int)items.get(i).profitperwt * maxWeight;
                finalist.add(items.get(i));
                maxWeight = maxWeight - items.get(i).weight;
            }
            else {
                finalist.add(items.get(i));
                maxWeight = maxWeight - items.get(i).weight;
            }
            i++;
        }
        return finalist;
    }

    public static void main(String... args) {
        List<KnapSackItem> items = new ArrayList<>();
        items.add(new KnapSackItem(2, 10));
        items.add(new KnapSackItem(3, 5));
        items.add(new KnapSackItem(5, 15));
        items.add(new KnapSackItem(7, 7));
        items.add(new KnapSackItem(1, 6));
        items.add(new KnapSackItem(4, 18));
        items.add(new KnapSackItem(1, 3));

        List<KnapSackItem> selectedItems = new KnapsackProblem().solutionKnapsackProblem(items, 15);
        System.out.println("Done...! Max Profit : " + selectedItems.stream().mapToInt(item -> item.profit).sum());
        
    }
}


class KnapSackItem {
    int weight;
    int profit;
    double profitperwt;

    public KnapSackItem(int weight, int profit) {
        this.weight = weight;
        this.profit = profit;
    }
}
