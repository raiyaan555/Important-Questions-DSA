import java.util.*;

class P1_Max_Min {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the desired characters in array");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int i, min, max;

        if (n % 2 == 0) {
            if (arr[0] > arr[1]) {
                max = arr[0];
                min = arr[1];

            } else {
                max = arr[1];
                min = arr[0];
            }
            i = 2;
        } else {
            min = arr[0];
            max = arr[0];
            i = 1;
        }

        while (i < (n - 1)) {
            if (arr[i] > arr[i + 1]) {
                if (arr[i] > max) {
                    max = arr[i];
                }
                if (arr[i + 1] < min) {
                    min = arr[i + 1];
                }
            } else {
                if (arr[i + 1] > max) {
                    max = arr[i + 1];
                }
                if (arr[i] < min) {
                    min = arr[i];
                }
            }
            i += 2;
        }

        System.out.println("Min: " + min);

        System.out.println("Max: " + max);

    }
}