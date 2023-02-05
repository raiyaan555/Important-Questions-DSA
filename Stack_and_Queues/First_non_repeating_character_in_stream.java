package Stack_and_Queues;

import java.util.LinkedList;
import java.util.Queue;

public class First_non_repeating_character_in_stream {
    public String FirstNonRepeating(String A) {
        // code
        int[] charCount = new int[26];

        Queue<Character> q = new LinkedList<Character>();

        char[] ch = A.toCharArray();
        String w = "";

        for (int i = 0; i < ch.length; i++) {
            q.add(ch[i]);
            charCount[ch[i] - 'a']++;

            while (!q.isEmpty()) {
                if (charCount[q.peek() - 'a'] > 1) {
                    q.remove();
                } else {
                    w = w + q.peek();
                    break;
                }
            }
            if (q.isEmpty())
                w = w + '#';
        }
        return w;
    }
}
