package Competitive_Coding;

import java.util.Arrays;
import java.util.Scanner;

public class Taxi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }

        int limit = 4;
        int sum = 0;
        int count = 0;
        Arrays.sort(a);

        for(int i=a.length-1;i>=0;i--){
            sum+=a[i];
            if(sum>=limit){
                count++;
                sum=0;
            }else{
                
            }
        }
        if(a[n-1]>=4){
            count++;
        }
        System.out.println(count);
    }
}
