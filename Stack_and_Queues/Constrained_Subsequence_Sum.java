package Stack_and_Queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class Constrained_Subsequence_Sum {
 class Solution {
        public int constrainedSubsetSum(int[] A, int k) {
        int res = A[0];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < A.length; ++i) {
            A[i] += !q.isEmpty() ? q.peek() : 0;
            res = Math.max(res, A[i]);
            while (!q.isEmpty() && A[i] > q.peekLast())
                q.pollLast();
            if (A[i] > 0)
                q.offer(A[i]);
            if (i >= k && !q.isEmpty() && q.peek() == A[i - k])
                q.poll();
        }
        return res;
    }
}   
}
