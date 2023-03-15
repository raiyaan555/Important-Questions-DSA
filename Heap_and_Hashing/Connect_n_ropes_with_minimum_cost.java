package Heap_and_Hashing;

import java.util.PriorityQueue;

public class Connect_n_ropes_with_minimum_cost {
    static int minCost(int a[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i<a.length; i++){
            pq.add(a[i]);
        }


        int ans = 0;

        while(pq.size()>1){
            int first = pq.poll();
            int second = pq.poll();

            ans += first+second;

            pq.add(first+second);

        }
        return ans;
    }

    public static void main(String[] args) {
        int a[] = {2,5,4,8,6,9};
        System.out.println(minCost(a));
    }
}
