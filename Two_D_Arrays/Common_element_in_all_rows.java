package Two_D_Arrays;

import java.util.*;
import java.util.Map.Entry;

import javax.print.attribute.HashAttributeSet;
import java.util.*;

public class Common_element_in_all_rows {

    static int findCommon(int mat[][]) {
        int M = mat.length;
        int N = mat[0].length;
        // A hash map to store count of elements
        HashMap<Integer, Integer> cnt = new HashMap<Integer, Integer>();

        int i, j;

        for (i = 0; i < M; i++) {

            
            if (cnt.containsKey(mat[i][0])) {
                cnt.put(mat[i][0],
                        cnt.get(mat[i][0]) + 1);
            } else {
                cnt.put(mat[i][0], 1);
            }

           
            for (j = 1; j < N; j++) {

                
                if (mat[i][j] != mat[i][j - 1])
                    if (cnt.containsKey(mat[i][j])) {
                        cnt.put(mat[i][j],
                                cnt.get(mat[i][j]) + 1);
                    } else {
                        cnt.put(mat[i][j], 1);
                    }
            }
        }

        
        for (Map.Entry<Integer, Integer> ele : cnt.entrySet()) {
            if (ele.getValue() == M)
                return ele.getKey();
        }

        // No such element found
        return -1;
    }

    public static void main(String[] args) {
        int[][] ch = { { 1, 2, 3, 4, 5 },
                { 2, 4, 5, 8, 10 },
                { 3, 5, 7, 9, 11 },
                { 1, 3, 5, 7, 9 },
        };
        System.out.println(findCommon(ch));
    }
}
