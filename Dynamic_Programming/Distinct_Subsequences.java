package Dynamic_Programming;

public class Distinct_Subsequences {
    class Solution {
        int prime =(int)(Math.pow(10,9)+7);
        public int numDistinct(String s, String t) {
            int dp[] = new int[t.length()+1];
                dp[0] = 1;
                
            for(int i = 1;i<=s.length();i++){
                for(int j=t.length();j>=1;j--){
                    if(s.charAt(i-1)==t.charAt(j-1)){
                       dp[j] = (dp[j]+dp[j-1])%prime;
                    }
                    else{
                        dp[j] = dp[j];
                    }
                }
            }
            return dp[t.length()];
    
            // for(int i[]: dp){
            //     Arrays.fill(i,-1);
            // }
    
            // return f(s.length(),t.length(),dp,s,t);
        }
    
        int f(int i, int j, int dp[][],String s, String t){
            if(j==0) return 1;
            if(i==0) return 0;
            if(dp[i][j]!=-1) return dp[i][j];
    
            if(s.charAt(i-1)==t.charAt(j-1)){
                return dp[i][j] = f(i-1,j,dp,s,t)+f(i-1,j-1,dp,s,t);
            }else{
                return dp[i][j] = f(i-1,j,dp,s,t);
            }
    
        }
    }
}
