package Arrays;
public class P11_Trapping_Rain_Water {
    
        public static int trap(int[] height) {
            int l = 0; 
            int r = height.length-1;
    
            int leftMax = 0;
            int rightMax = 0;
            int ans = 0;
    
            while(l<=r){
                if(height[l]<=height[r]){
                    if(height[l]>=leftMax){
                        leftMax = height[l];
                    }else{
                        ans +=leftMax-height[l];
                    }
                    l++;
                }
    
                else{
                    if(height[r]>=rightMax){
                        rightMax = height[r];
                    }else{
                        ans +=rightMax-height[r];
                    }
    
                    r--;
                }
            }
            return ans;
        
    }

    public static void main(String[] args) {
        int[] nums = {4,2,0,3,2,5};
        System.out.println(trap(nums));
    }
}
