package Strings;
// First Program

public class P1_Valid_Palindrome {
    public static boolean isPalindrome(String s) {

        String a = "";
        String b = "";
        for (int i = 0; i < s.length(); i++) {
            if ((((int) s.charAt(i) >= 65 && (int) s.charAt(i) <= 90)
                    || ((int) s.charAt(i) >= 97 && (int) s.charAt(i) <= 122)
                    || ((int) s.charAt(i) >= 48 && (int) s.charAt(i) <= 57))) {
                a += s.charAt(i) + "";

            }

        }
        for (int i = a.length() - 1; i >= 0; i--) {
            b += a.charAt(i);
        }

        if (a.toLowerCase().equals(b.toLowerCase())) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}
