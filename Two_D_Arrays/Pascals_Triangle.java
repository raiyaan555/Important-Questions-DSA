package Two_D_Arrays;

import java.util.ArrayList;
import java.util.List;

// optimal solution time complexity is O(n^2) while the space comlexity is 0(n);

public class Pascals_Triangle {
    public List<Integer> findAns(int r) {
        int ans = 1;
        List<Integer> answer = new ArrayList<>();
        answer.add(1);
        for (int j = 1; j < r; j++) {
            ans = ans * (r - j);
            ans = ans / j;
            answer.add(ans);
        }
        return answer;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> finalAns = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            finalAns.add(findAns(i));
        }
        return finalAns;
    }
}
