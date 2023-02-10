package Greedy;

import java.util.Arrays;

public class Fractional_Knapsack_Problem {
    double fractionalKnapsack(int W, Item arr[], int n) {
        // Your code here

        Arrays.sort(arr,
                (a, b) -> ((double) b.value / (double) b.weight > (double) a.value / (double) a.weight) ? 1 : -1);
        double res = 0.0;
        int wt = W;
        for (int i = 0; i < n; i++) {
            if (arr[i].weight <= wt) {
                res += arr[i].value;
                wt -= arr[i].weight;
            } else {
                int remWt = wt;
                double v = ((double) arr[i].value / (double) arr[i].weight) * (double) remWt;
                res += v;
                break;
            }
        }
        return res;
    }

    class Item {
        int value, weight;
        Item(int x, int y){
            this.value = x;
            this.weight = y;
        }
    }
}
