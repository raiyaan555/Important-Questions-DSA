package Strings;

public class P5_Longest_Common_Prefix {
    public static String longestCommonPrefix(String[] strs) {

        String checkString = strs[0];
        int counter = 0;
        int k;
        String longestPrefix = "";

        for (int i = 0; i < checkString.length(); i++) {
            char ch = checkString.charAt(i);

            for (int j = 1; j < strs.length; j++) {
                k = i;
                if (k < strs[j].length()) {
                    if (strs[j].charAt(k) == ch) {
                        counter++;
                    }

                }

            }

            if (counter == strs.length - 1) {

                longestPrefix = longestPrefix + ch;

            } else {
                return longestPrefix;
            }

            counter = 0;

        }

        return longestPrefix;

    }

    public static void main(String[] args) {
        String[] s = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(s));
    }
}
