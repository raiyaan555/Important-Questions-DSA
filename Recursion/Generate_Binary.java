package Recursion;

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;
public class Generate_Binary {
    


class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      Generate_Binary obj = new Generate_Binary();
      List<String> ans = obj.generateBinaryStrings(n);
      for(String s : ans) System.out.print(s+" ");
      System.out.println();
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
 public static void solve(String s, int n ,ArrayList<String>ans){
     if(n==0) {ans.add(s); return;}
     
     if(s.length()>0 && s.charAt(s.length()-1)=='1'){
        //  return the ending with a number one so add 0
         String s1 = s+"0";
         n = n-1;
         solve(s1,n,ans);
     }else{
         String op1 = s+"0";
         String op2=s+"1";;
            solve(op1,n-1,ans);
            solve(op2,n-1,ans);
         
     }
 }
  public static List<String> generateBinaryStrings(int n) {
   ArrayList<String> list = new ArrayList<>();
   String s = "";
   solve(s,n,list);
   return list;
  }
}

public List<String> generateBinaryStrings(int n) {
    return null;
}
}
