package Greedy;

public class Smallest_Number {
    static String smallestNumber(int S, int D) {
        // code here
        String ans = "";
        if (S != 0 && S <= 9 * D) {
            for (int i = D - 1; i >= 0; i--) {
                if (S > 9) {
                    ans = '9' + ans;
                    S -= 9;
                } else {
                    if (i == 0) {
                        ans = Integer.toString(S) + ans;
                    } else {
                        ans = Integer.toString(S - 1) + ans;
                        i--;
                        while (i > 0) {
                            ans = '0' + ans;
                            i--;
                        }
                        ans = '1' + ans;
                        break;
                    }
                }
            }
        } else {
            return "-1";
        }
        return ans;
    }

}
