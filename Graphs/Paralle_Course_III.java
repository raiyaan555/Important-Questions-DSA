package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Paralle_Course_III {
    class Solution {
    List<List<Integer>> adjacencyList;  // Adjacency list to represent the course prerequisites
    List<Integer> inDegrees;  // In-degree of each course (number of prerequisites)

    // Kahn's Algorithm
    public int calculateMinimumTime(int n, int[] time) {
        int[] waitTime = new int[n + 1];  // keep track of wait time for each course
        Queue<Integer> q = new LinkedList<>();  // queue for topological sort
        int maxWaitTime = 0;  // Maximum wait time for completing all courses

        // Initialize the queue with courses that have no prerequisites
        for (int i = 1; i <= n; i++) {
            if (inDegrees.get(i) == 0) {
                q.offer(i);
                waitTime[i] = time[i - 1];
                maxWaitTime = Math.max(maxWaitTime, waitTime[i]);
            }
        }

        // Perform topological sort
        while (!q.isEmpty()) {
            int currentCourse = q.poll();

            // Process each course that depends on the current course
            for (int childCourse : adjacencyList.get(currentCourse)) {
                inDegrees.set(childCourse, inDegrees.get(childCourse) - 1);
                waitTime[childCourse] = Math.max(time[childCourse - 1] + waitTime[currentCourse], waitTime[childCourse]);
                maxWaitTime = Math.max(maxWaitTime, waitTime[childCourse]);

                // If all prerequisites are completed, update the wait time and add to the queue
                if (inDegrees.get(childCourse) == 0)
                    q.offer(childCourse);
            }
        }

        return maxWaitTime;
    }

    public int minimumTime(int n, int[][] relations, int[] time) {
        adjacencyList = new ArrayList<>(n + 1);
        inDegrees = new ArrayList<>(n + 1);

        for (int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
            inDegrees.add(0);
        }

        // Build the adjacency list and calculate in-degrees for each course
        for (int i = 0; i < relations.length; i++) {
            int[] prerequisitePair = relations[i];
            adjacencyList.get(prerequisitePair[0]).add(prerequisitePair[1]);
            inDegrees.set(prerequisitePair[1], inDegrees.get(prerequisitePair[1]) + 1);
        }

        return calculateMinimumTime(n, time);
    }
}
}
