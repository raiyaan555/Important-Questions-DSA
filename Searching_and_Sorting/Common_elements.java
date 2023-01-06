package Searching_and_Sorting;

import java.util.*;

public class Common_elements {

    static ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) 
    {
        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        ArrayList<Integer> list = new ArrayList<>();

        int i = 0, j= 0 , k= 0 ;

        while(i<n1 && j<n2 && k<n3){

            if (A[i] == B[j] && B[j] == C[k]) {
                if(!list.contains(A[i])){
                    list.add(A[i]);
                }
                i++;
                j++;
                k++;
            }

            else if(A[i]<B[j]){
                i++;
            }

            else if(B[j]<C[k]){
                j++;
            }

            else
            k++;
        }

        return list;


    }
    public static void main(String[] args) {

        int n1 = 6; 
        int[] A = {1, 5, 10, 20, 40, 80};
        int n2 = 5; 
        int[] B = {6, 7, 20, 80, 100};
        int n3 = 8; 
        int[] C = {3, 4, 15, 20, 30, 70, 80, 120};

        System.out.println(commonElements(A, B, C, n1, n2, n3));
        
    }
}
