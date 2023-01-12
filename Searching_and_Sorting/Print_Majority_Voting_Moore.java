package Searching_and_Sorting;

import javax.swing.text.DefaultStyledDocument.ElementSpec;

public class Print_Majority_Voting_Moore {

    public static int majorityProbable(int a[]) {
        int majority = 0;
        int count = 1;
       
        

        for (int i = 1; i < a.length; i++) {
            if (a[majority] == a[i]) {
                count++;
            } else {
                count--;
            }
        

            if (count <= 0) {
                count = 1;
                majority = i;
            }

        }

      
        return a[majority];
    }

    public static boolean checkMajority(int a[], int check) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (check == a[i]) {
                count++;
            }
        }

        if (count > (a.length) / 2) {
            return true;
        } else {
            return false;
        }
    }

    public static int majorityElement(int a[], int size) {

        int probableElement = majorityProbable(a);
        

        if (checkMajority(a, probableElement)) {
            return probableElement;
        }
        return -1;
    }

    public static void main(String[] args) {
        int N = 5;
        int A[] = { 3, 1, 3, 3, 2 };
        System.out.println(majorityElement(A, N));
    }

}
