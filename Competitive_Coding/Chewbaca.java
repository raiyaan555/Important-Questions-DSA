package Competitive_Coding;

import java.util.Scanner;

public class Chewbaca {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char ch[] = s.toCharArray();
        String min = s;

        for(int i=0;i<s.length();i++){
            ch[i] = (char)(('9'-s.charAt(i))+48);
            String newString = new String(ch);
            if(newString.compareTo(min)<0 && newString.charAt(0)!='0'){
                min = newString.toString();
            }else{
                ch[i] = s.charAt(i);
            }
        }
        System.out.println(min);
    
    }   
}

