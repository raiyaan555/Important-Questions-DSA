package Competitive_Coding;

import java.util.Scanner;

public class WayTooLongWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while(n-->0){
            String s = sc.next();
            String ans = "";
            if(s.length()>10){
                ans = s.charAt(0)+Integer.toString(s.length()-2)+s.charAt(s.length()-1);
            }else ans = s;

            System.out.println(ans);
        }
        
        
    }
}
