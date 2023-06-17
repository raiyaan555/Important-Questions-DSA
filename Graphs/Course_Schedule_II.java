package Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Course_Schedule_II {
    public int[] findOrder(int numCourses, int[][] prereq) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());

        int[] indegree = new int[numCourses];
        for (int i = 0; i < prereq.length; i++) {
            graph.get(prereq[i][1]).add(prereq[i][0]);
            indegree[prereq[i][0]]++;
        }

        Queue<Integer> que = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++)
            if (indegree[i] == 0)
                que.add(i);
        int[] ans = new int[numCourses];
        int idx = 0;

        while (que.size() != 0) {
            int rem = que.poll();
            ans[idx++] = rem;
            List<Integer> get = graph.get(rem);
            for (int ele : get) {
                indegree[ele]--;
                if (indegree[ele] == 0)
                    que.add(ele);
            }
        }
        if (idx != numCourses)
            return new int[0];
        else
            return ans;
    }
}
