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
    public static void main(String... args) {
        List<Job> list = new ArrayList<>();
        list.add(new Job(35, 3));
        list.add(new Job(25, 4));
        list.add(new Job(12, 1));
        list.add(new Job(20, 2));
        list.add(new Job(5, 2));
        list.add(new Job(30, 4));
        list.add(new Job(15, 3));
        List<Job> scheduleJobs = new JobSequenceProblem().scheduledJobsForMaxProfit(list);
        System.out.println("Done..! Max profit: " + scheduleJobs.stream().mapToInt(job -> job != null ? job.profit : 0).sum());
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
