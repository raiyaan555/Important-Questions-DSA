package Competitive_Coding;

import java.util.Scanner;

public class Team {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int a = 0;

        while(n-->0){
            int[] team = new int[3];

            for(int i =0; i<3;i++){
                team[i] = sc.nextInt();
            }

            int c = 0; 
            
            for(int i = 0 ; i<3;i++){
                if(team[i]==1){
                  ++c;
                }
            }
            if(c>=2){
                a++;
            }
        }
        System.out.println(a);
    }
}
