package Searching_and_Sorting;

import java.util.*;

public class Count_Sort {
    public static String countSort(String arr) {
        char[] ch = arr.toCharArray();
        char min = 'z';
        char max = 'a';

        for (char c : ch) {
            if (c >= min)
                max = c;

            else if (c <= max)
                min = c;
        }

        int range = max - min + 1;

        int[] freqArr = new int[range];

        for (int i = 0; i < ch.length; i++) {
            freqArr[(ch[i] - min)]++;
        }

        for (int i = 1; i < freqArr.length; i++) {
            freqArr[i] = freqArr[i] + freqArr[i - 1];
        }

        char[] ans = new char[ch.length];

        for (int i = ch.length - 1; i >= 0; i--) {
            int pos = freqArr[ch[i] - min];
            ans[pos - 1] = ch[i];
            freqArr[ch[i] - min]--;
        }

        for (int i = 0; i < ans.length; i++) {
            ch[i] = ans[i];
        }
        String ans1 = "";

        for (int i = 0; i < ch.length; i++) {
            ans1 = ans1 + ch[i];
        }

        return ans1;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the word ");
        String s = sc.next();

        System.out.println(countSort(s));

    }
}
