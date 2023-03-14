package Heap_and_Hashing;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class Print_kth_largest_element_in_array {
    static int kthLargest(int a[], int k){
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

    static int kthSmallest(int a[], int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i =0; i<k;i++){
            pq.add(a[i]);
        }

        for(int i = k; i<a.length;i++){
            if(pq.peek() > a[i]){
                pq.remove();
                pq.add(a[i]);
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int arr[] = {20, 10,60,30,40,50};

        System.out.println(kthLargest(arr, 3));
        System.out.println(kthSmallest(arr, 3));
    }
}
