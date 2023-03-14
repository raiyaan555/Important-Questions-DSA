package Heap_and_Hashing;

import java.util.PriorityQueue;

public class Print_kth_largest_element_in_array {
    int kthLargest(int a[], int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i<k; i++){
            pq.add(a[i]);
        }

        for(int i = k; i<a.length;i++){
            if(pq.peek()<a[i]){
                pq.remove();
                pq.add(a[i]);
            }
        }
        return pq.peek();
    }
}
