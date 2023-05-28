package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class N_meetings_in_1_room {
    public static int maxMeetings(int start[], int end[], int n)
    {
        // time complexity is O(nlogn) space is O(2N);
       
        int meeting[][]=new int[n][2];
        for(int i=0;i<n;i++){
            meeting[i][0]=start[i];
            meeting[i][1]=end[i];
        }
        Arrays.sort(meeting,Comparator.comparingDouble(o->o[1]));
        
        int count=1;
        int currEnd=meeting[0][1];
        
        for(int i=1;i<n;i++){
            if(meeting[i][0]>currEnd){
                count++;
                currEnd=meeting[i][1];
            }
        }
        return count;
    }
}
