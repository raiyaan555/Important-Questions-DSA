package Strings;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Word_break {
    class Solution {
        Boolean[] mem;

        public boolean wordBreak(String s, List<String> wordDict) {
            mem = new Boolean[s.length()];
            return wordBreak(0, s, new HashSet<String>(wordDict));
        }

        private boolean wordBreak(int p, String s, Set<String> dict) {
            int n = s.length();
            if (p == n) {
                return true;
            }
            if (mem[p] != null) {
                return mem[p];
            }
            for (int i = p + 1; i <= n; i++) {
                if (dict.contains(s.substring(p, i)) && wordBreak(i, s, dict)) {
                    return mem[p] = true;
                }
            }
            return mem[p] = false;
        }
    }
}
