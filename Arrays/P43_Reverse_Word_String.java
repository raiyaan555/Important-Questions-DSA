package Arrays;

public class P43_Reverse_Word_String {
    class Solution {
        public String reverseWords(String s) {
            String[] st = s.trim().split("\\s+");
            String w = "";
            for (int i = st.length - 1; i > 0; i--) {
                w = w + st[i] + " ";
            }
            return w + st[0];
        }
    }
}
