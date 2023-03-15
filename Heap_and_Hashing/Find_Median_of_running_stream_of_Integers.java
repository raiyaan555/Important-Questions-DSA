package Heap_and_Hashing;

import java.util.Collections;
import java.util.PriorityQueue;

public class Find_Median_of_running_stream_of_Integers {
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public static void insertNum(int a[]) {

        for (int i = 0; i < a.length; i++) {
            if (maxHeap.isEmpty() || maxHeap.peek() >= a[i]) {
                maxHeap.add(a[i]);
            } else {
                minHeap.add(a[i]);
            }

            if (maxHeap.size() > minHeap.size() + 1)
                minHeap.add(maxHeap.poll());

            else if (maxHeap.size() < minHeap.size())
                maxHeap.add(minHeap.poll());

        }

    }

    public static double findMedian(){
        if(maxHeap.size() == minHeap.size()){
            return ((maxHeap.peek()+minHeap.peek())/2.0);
        }

        return maxHeap.peek();
    }

    public static void main(String[] args) {
        
        int a[] = {3,1,5,4,6,7,8,9,11,44,22};

        insertNum(a);
        System.out.println(findMedian());
    }
}
