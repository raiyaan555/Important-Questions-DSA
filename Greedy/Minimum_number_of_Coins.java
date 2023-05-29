package Greedy;

import java.util.ArrayList;
import java.util.List;

public class Minimum_number_of_Coins {

    // O(n*M) and space is O(N);
    
    static List<Integer> minPartition(int N) {
        List<Integer> list = new ArrayList<>();
        // code here
        int[] currency = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };

        for (int i = currency.length - 1; i >= 0; i--) {

            while (N >= currency[i]) {
                list.add(currency[i]);
                N -= currency[i];
            }

        }

        return list;

    }
}
