package Greedy;

import java.util.Arrays;

public class Job_Sequencing_Problem {
    static int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        
        Arrays.sort( arr , (Job j1 , Job j2)->(int)(j2.profit - j1.profit ) );
        
        boolean[] slotAvail = new boolean[101];
        
        
        int profit = 0;
        int day = 0;
        
        for(int i =0; i<arr.length;i++){
            for(int j=Math.min(n, arr[i].deadline-1);j>=0;j--){
                if(slotAvail[j]==false){
                    day+=1;
                    profit+=arr[i].profit;
                    slotAvail[j] = true;
                    break;
                }
            }
        }
        
        return new int[]{day,profit};
    }
    public static void main(String[] args) {
        int N = 5;
        Job job = new Job(1,4,20);
        Job job1 = new Job(2,1,10);
        Job job3 = new Job(3,1,40);
        Job job4 = new Job(4,1,30);

        Job arr[] = {job, job1, job3, job4};

        System.out.println(JobScheduling(arr, N)[0]+" "+JobScheduling(arr, N)[1]);
    }
}

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

