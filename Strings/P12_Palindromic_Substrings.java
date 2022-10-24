package Strings;

public class P12_Palindromic_Substrings {

  public static int countSubstrings(String s) {
    boolean[][] dp = new boolean[s.length()][s.length()];
    int count =0;

    for (int j = 0; j<s.length();j++){
        for(int i =0; i+j<s.length();i++){
            dp[i][i+j] = s.charAt(i) == s.charAt(i+j) && (j < 2 || dp[i+1][i+j-1]);

            // if (dp[i][i+j] && j > end - start) {
            //     start = i;
            //     end = i + j;
            // }
        }
    }

    for(int i =0; i<s.length();i++){
      for(int j =0; j<s.length();j++){
        if(dp[i][j]==true){
          count++;
        }
      }
    }
    return count;
  }
  public static void main(String[] args) {
       
    System.out.println(countSubstrings("aaa"));

}
}
