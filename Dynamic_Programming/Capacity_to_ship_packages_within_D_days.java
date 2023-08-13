package Dynamic_Programming;

public class Capacity_to_ship_packages_within_D_days {
    class Solution {
        public int func(int[] weights, int mid){
            int day = 1;
            int load = 0;
            for(int i=0;i<weights.length;i++){
                if(load+weights[i]>mid){
                    day++;
                    load = weights[i];
                }else load+=weights[i];
            }
            return day;
        }
        public int[] findLimits(int[] w){
            int lower = Integer.MIN_VALUE;
            int upper = 0;
    
            for(int i:w){
                lower = Math.max(lower,i);
                upper +=i;
            }
            return new int[]{lower,upper};
        }
        public int shipWithinDays(int[] weights, int days) {
            int left = findLimits(weights)[0];
            int right = findLimits(weights)[1];
    
            while(left<=right){
                int mid = (left+right)/2;
                int day = func(weights,mid);
                if(day<=days){
                    right  = mid-1;
                }else left = mid+1;
            }
            return left;
        }
    }
}
