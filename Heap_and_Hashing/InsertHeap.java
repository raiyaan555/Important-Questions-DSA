package Heap_and_Hashing;

public class InsertHeap {
    void insert(int A[], int n, int value){
        n = n+1;
        A[n] = value;
        int i = n;


        while(i>1){
            int parent  = i/2;

            if(A[parent]<A[i]){
                int temp = A[parent];
                A[parent] = A[i];
                A[i] = temp;
                i=parent;

            }else{
                return;
            }
        }
    }
}
