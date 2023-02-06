package Greedy;

import java.util.*;

public class Activity_Selection {
    public static int activitySelection(int start[], int end[], int n)
    {
       int act[][] = new int[n][3];
       for(int i=0;i<n;i++){
           act[i][0] = start[i];
           act[i][1] = end[i];
       }
       
       Arrays.sort(act,Comparator.comparingInt(o -> o[1])); // sorting in 2D Matrix using Lambda function
       
       int count = 1;
       int store = act[0][1];
       for(int i=1;i<n;i++){
           if(act[i][0] > store){
               count++;
               store = act[i][1];
           }
       }
       return count;
    }
}
