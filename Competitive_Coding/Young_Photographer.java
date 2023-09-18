package Competitive_Coding;

import java.util.Scanner;

public class Young_Photographer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int l = 0,r = 1001;
        int count = 0;
        while(n-->0){
            int a  = sc.nextInt();
            int b = sc.nextInt();
            
            if(a>b){
                l = Math.max(l,b);
                r = Math.min(r,a);
            }else{
                l = Math.max(l,a);
                r = Math.min(r,b);
            }

            if(x<l || x>r){
                count  = Math.min(Math.abs(l-x),Math.abs(x-r));
            }
            
        }

        System.out.println("l- "+l+" r- "+r);
        if(l>r){
                System.out.println(-1);
            }else{
                 System.out.println(count);
            }
       

    }
}
