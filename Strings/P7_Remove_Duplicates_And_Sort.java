package Strings;

import java.util.ArrayList;
import java.util.Collections;


public class P7_Remove_Duplicates_And_Sort {
    public static String removeDuplicateLetters(String s) {
        ArrayList<Character> list = new ArrayList<>();
        String w ="";

        for(int i = 0; i<s.length();i++){
            list.add(s.charAt(i));
        }

        Collections.sort(list);

        w = w+list.get(0);
        
        for(int i =1;i<list.size();i++){
            if(list.get(i) != list.get(i-1)){
                w = w+list.get(i);
            }
        }
        return w;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("dfasbcvcc"));
        
    }
}
