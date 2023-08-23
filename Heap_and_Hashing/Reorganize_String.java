
package Heap_and_Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Reorganize_String {
    class Solution {
        public String reorganizeString(String s) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
            pq.addAll(map.keySet());
            StringBuilder ans = new StringBuilder();
            while (pq.size() > 1) {
                char f = pq.remove();
                char sec = pq.remove();
                ans.append(f);
                ans.append(sec);
                map.put(f, map.get(f) - 1);
                map.put(sec, map.get(sec) - 1);

                if (map.get(f) > 0) {
                    pq.offer(f);
                }
                if (map.get(sec) > 0) {
                    pq.offer(sec);
                }
            }

            if (!pq.isEmpty()) {
                if (map.get(pq.peek()) > 1) {
                    return "";
                } else {
                    ans.append(pq.poll());
                }
            }

            return ans.toString();

        }
    }
}
