import java.util.ArrayList;
import java.util.List;

public class P24_Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> subsets = new ArrayList();
        generateSubsets(1, n, new ArrayList(), subsets, k);
        return subsets;
    }

    static void generateSubsets(int start, int n, List<Integer> current, List<List<Integer>> subsets, int k) {
        if (current.size() == k) {
            subsets.add(new ArrayList(current));
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(i);
            generateSubsets(i+1, n, current, subsets, k);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

        System.out.println(combine(4, 2));
    }

}
