package my.algo.greedymethod;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Greedy method approach.
 * Constraint: Job should be finish within deadline.
 * Objective: Maximize profit.
 * 
 * @author prashant
 */
public class JobSequenceProblem {


    public List<Job> scheduledJobsForMaxProfit(List<Job> joblist) {
        int maxSlot = 0;
        for (Job job : joblist) {
            if (job.deadline > maxSlot)
                maxSlot = job.deadline;
        }
        joblist.sort((e1, e2) -> {
            if (e1.profit < e2.profit)
                return 1;
            else if (e1.profit > e2.profit)
                return -1;
            else
                return 0;
        });

        Job scheduledJobs[] = new Job[maxSlot];
        int count = 0;
        for (Job job : joblist) {
            if (scheduledJobs[job.deadline - 1] == null) {
                scheduledJobs[job.deadline - 1] = job;
                count++;
            }
            else {
                for (int i = job.deadline - 2; i >= 0; i--) {
                    if (scheduledJobs[i] == null) {
                        scheduledJobs[i] = job;
                        count++;
                        break;
                    }
                }
            }
            if (count == (maxSlot)) {
                break;
            }
        }
        return Arrays.asList(scheduledJobs);
    }

}


class Job {
    int profit;
    int deadline;

    Job(int profit, int deadline) {
        this.profit = profit;
        this.deadline = deadline;
    }
}
