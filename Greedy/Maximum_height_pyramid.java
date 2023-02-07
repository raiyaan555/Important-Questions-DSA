package Greedy;

import java.util.Arrays;

public class Maximum_height_pyramid {

    public static int maxLevel(int[] a, int n) {
       Arrays.sort(a);

       int ans = 1;

       int prev_width = a[0];
       int prev_count = 1;


       int curr_count = 0;
       int curr_width = 0;

       for(int i =1; i<n;i++){
        curr_width +=a[i];
        curr_count+=1;

        if(curr_width>prev_width && curr_count>prev_count){
            prev_width=curr_width;
            prev_count = curr_count;
            curr_count = 0;
            curr_width = 0;
            ans++;
        }
       }
       return ans;

    }

    public static void main(String[] args) {

        int[] boxes = { 40, 100, 20, 30 };
        int n = boxes.length;
        System.out.println(maxLevel(boxes, n));
    }
}
