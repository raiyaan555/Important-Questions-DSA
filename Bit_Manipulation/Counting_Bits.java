package Bit_Manipulation;

public class Counting_Bits {
    class Solution {
        public int[] countBits(int n) {
            
            int [] ans = new int[n+1];
    
            for(int i = 0; i<=n;i++){
                int a = i;
                int cnt = 0;
                while(a!=0){
                    a = a&a-1;
                    cnt++;
                }
                ans[i] = cnt;
            }
            return ans;
        }
    }
}
