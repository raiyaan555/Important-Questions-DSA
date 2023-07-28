package Recursion;

public class Predict_the_Winner {
    class Solution {
        public boolean PredictTheWinner(int[] nums) {
            return f(0, nums.length - 1, nums, 0, 0, true);
        }

        boolean f(int i, int j, int[] nums, int score1, int score2, boolean chance) {

            if (i > j) {
                return score1 >= score2;
            }
            if (chance) {
                System.out.println("score1 " + score1);
                return f(i + 1, j, nums, score1 + nums[i], score2, !chance)
                        || f(i, j - 1, nums, score1 + nums[j], score2, !chance);
            } else {
                System.out.println("score2 " + score2);
                return f(i + 1, j, nums, score1, score2 + nums[i], !chance)
                        && f(i, j - 1, nums, score1, score2 + nums[j], !chance);
            }

        }
    }
}
