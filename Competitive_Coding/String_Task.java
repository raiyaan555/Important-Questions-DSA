package Competitive_Coding;

import java.util.Scanner;

public class String_Task {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        StringBuilder sb = new StringBuilder();

        for(char c: s.toCharArray()){
            if(c>='A'&& c<='Z'){
                if(c!='A'&& c!='E'&& c!='I'&& c!='O'&&c!='U'&& c!='Y'){
                    sb.append('.');
                    sb.append(Character.toLowerCase(c));
                }
            }
             else{
                     if(c!='a'&& c!='e'&& c!='i'&& c!='o'&& c!='u' && c!='y'){
                        sb.append('.');
                        sb.append(c);
                     }
                } 
        }
        System.out.println(sb.toString());

        }
}
