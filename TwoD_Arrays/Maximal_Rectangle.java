package TwoD_Arrays;

import java.util.*;

import javax.swing.plaf.synth.SynthScrollPaneUI;

public class Maximal_Rectangle {
    static int largestarea(int R, int C, int row[]) {

        Stack<Integer> result = new Stack<Integer>();

        int top_val;

        int max_area = 0;

        int area = 0;

        int i = 0;
        while (i < C) {

            if (result.empty()
                    || row[result.peek()] <= row[i])
                result.push(i++);

            else {

                top_val = row[result.peek()];
                result.pop();
                area = top_val * i;

                if (!result.empty())
                    area = top_val * (i - result.peek() - 1);
                max_area = Math.max(area, max_area);
            }
        }

        while (!result.empty()) {
            top_val = row[result.peek()];
            result.pop();
            area = top_val * i;
            if (!result.empty())
                area = top_val * (i - result.peek() - 1);

            max_area = Math.max(area, max_area);
        }
        return max_area;
    }

    public static int maximalRectangle(int[][] matrix) {
        int maxArea = Integer.MIN_VALUE;
        int[] height = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (matrix[i][j] == 1)
                    height[j]++;
                else
                    height[j] = 0;

            }
            int area = largestarea(matrix.length, matrix[0].length, height);
            maxArea = Math.max(area, maxArea);

        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[][] M = { { 0, 1, 1, 0 },
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 0, 0 } };

        System.out.println(maximalRectangle(M));
    }
}
