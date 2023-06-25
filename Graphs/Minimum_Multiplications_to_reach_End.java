package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Minimum_Multiplications_to_reach_End {
    class Pair {

        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    class Solution {

        int minimumMultiplications(int[] arr, int start, int end) {

            // Your code here
            Queue<Pair> q = new LinkedList<>();

            q.offer(new Pair(start, 0));

            int[] dist = new int[100000];
            Arrays.fill(dist, (int) 1e9);
            dist[start] = 0;
            int mod = 100000;

            while (!q.isEmpty()) {
                int node = q.peek().first;
                int steps = q.peek().second;

                q.remove();

                for (int i : arr) {
                    int num = (i * node) % mod;
                    if (steps + 1 < dist[num]) {
                        dist[num] = steps + 1;
                        if (num == end)
                            return steps + 1;
                        q.offer(new Pair(num, steps + 1));
                    }
                }

            }
            return -1;
        }
    }

}
