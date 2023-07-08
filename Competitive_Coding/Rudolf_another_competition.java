package Competitive_Coding;

import java.util.*;

public class Rudolf_another_competition {

   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        for (int testCase = 0; testCase < t; testCase++) {
            int n = scanner.nextInt(); // Number of participants
            int m = scanner.nextInt(); // Number of problems
            int h = scanner.nextInt(); // Duration of the competition

            int[][] times = new int[n][m]; // Array to store times for each participant

            // Read times for each participant
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    times[i][j] = scanner.nextInt();
                }
            }

            int[] penalties = new int[n]; // Array to store penalties for each participant

            // Calculate penalties for each participant
            for (int i = 0; i < n; i++) {
                penalties[i] = calculatePenalty(times[i], h);
            }

            int rudolfPlace = calculateRudolfPlace(penalties);
            System.out.println(rudolfPlace);
        }
    }

    static int calculatePenalty(int[] times, int h) {
        Arrays.sort(times); // Sort times in ascending order
        int penalty = 0;
        int solvedProblems = 0;

        for (int i = 0; i < times.length; i++) {
            if (penalty + times[i] <= h) {
                penalty += times[i];
                solvedProblems++;
            } else {
                break;
            }
        }

        return penalty + (times.length - solvedProblems);
    }

    static int calculateRudolfPlace(int[] penalties) {
        int rudolfPenalty = penalties[0];
        int count = 1;

        for (int i = 1; i < penalties.length; i++) {
            if (penalties[i] < rudolfPenalty) {
                count++;
            }
        }

        return count;
    }
}
