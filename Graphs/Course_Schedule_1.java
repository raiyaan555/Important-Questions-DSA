package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Course_Schedule_1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        for(int i =0; i<numCourses;i++){
             for(int j :adj.get(i))
             {
                 indegree[j]++;
             }
        }

        Queue<Integer> q= new LinkedList<>();

        for(int i =0; i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        
        int c = 0; 

        while(!q.isEmpty()){
            int temp = q.remove();
            c++;

            for(int it:adj.get(temp)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }

        if(c==numCourses) return true;
        return false;


    }
}
