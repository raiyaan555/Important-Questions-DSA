package Tries;

public class Count_Distinct_Substrings {

    Count_Distinct_Substrings links[] = new Count_Distinct_Substrings[26];
    boolean flag = false;

    boolean containsKey(char ch) {
        return (links[ch - 'a'] != null);
    }

    Count_Distinct_Substrings get(char ch) {
        return links[ch - 'a'];
    }

    void put(char ch, Count_Distinct_Substrings node) {
        links[ch - 'a'] = node;
    }
    

    void setEnd() {
        flag = true;
    }
}

class Solution {

    public static int countDistinctSubstrings(String s) {
        Count_Distinct_Substrings root = new Count_Distinct_Substrings();
        int n = s.length();
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            Count_Distinct_Substrings node = root;
            for (int j = i; j < n; j++) {
                if (!node.containsKey(s.charAt(j))) {
                    node.put(s.charAt(j), new Count_Distinct_Substrings());
                    cnt++;
                }
                node = node.get(s.charAt(j));
            }
        }
        return cnt + 1;

    }
}
