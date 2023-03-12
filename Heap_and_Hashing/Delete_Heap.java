package Heap_and_Hashing;

public class Delete_Heap {
    void delete(int a[], int n) {

        a[1] = a[n];

        n = n - 1;

        int i = 1;

        while (i < n) {
            int left = a[2 * i];
            int right = a[2 * i + 1];

            int larger = left > right ? 2 * i : 2 * i + 1;

            if (a[i] < a[larger]) {
                int temp = a[i];
                a[i] = a[larger];
                a[larger] = temp;
                i = larger;
            } else
                return;
        }

    }
}
