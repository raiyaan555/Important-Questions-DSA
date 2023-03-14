package Heap_and_Hashing;

public class Heapify {
    void heapify(int a[], int n, int i){
        int largest = i;
        int l = 2*i;
        int r = 2*i+1;


        if(l<=n && a[l]>a[largest]){
            largest = l;
        }

        if(r<=n && a[r]>a[largest]){
            largest = r;
        }

        if(largest!=i){
            int temp = a[largest];
            a[largest] = a[i];
            a[i] = temp;

            heapify(a, n, largest);

        }

    }

    void buildHeap(int a[], int n){
        for(int i = n/2; i>0; i--){
            heapify(a, n, i);
        }
    }


    // Heap Sort

    void HeapSort(int a[], int n){
        for (int i = n; i>1; i--){
            int temp = a[1];
            a[1] = a[i];
            a[i] = temp;

            heapify(a, i-1, 1);

        }
    }
}
