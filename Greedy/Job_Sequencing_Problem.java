package Greedy;

import java.util.Arrays;

public class Job_Sequencing_Problem {
    public static int[] JobScheduling(Job arr[], int n) {
        

        // sort array according to profit and find max deadline

        Arrays.sort(arr, (a, b) -> b.profit - a.profit);
        int mx = 0;
        for (int i = 0; i < n; i++)
            mx = Math.max(mx, arr[i].deadline);

        // make a filled array to find the position of task
        int filled[] = new int[mx];
        Arrays.fill(filled, -1);
        int count = 0;
        int profit = 0;

        // fill the array according to max profit at max time available

        for (int i = 0; i < n; i++) {
            for (int j = arr[i].deadline - 1; j >= 0; j--) {
                if (filled[j] == -1) {
                    filled[j] = 1;
                    count++;
                    profit += arr[i].profit;
                    break;
                }
            }
        }

        // return the count and profit

        return new int[] { count, profit };

    }

    public static void main(String[] args) {
        int N = 5;
        Job job = new Job(1, 4, 20);
        Job job1 = new Job(2, 1, 10);
        Job job3 = new Job(3, 1, 40);
        Job job4 = new Job(4, 1, 30);

        Job arr[] = { job, job1, job3, job4 };

        System.out.println(JobScheduling(arr, N)[0] + " " + JobScheduling(arr, N)[1]);
    }
}

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}
