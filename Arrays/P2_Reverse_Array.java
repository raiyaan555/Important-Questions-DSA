package Arrays;
import java.util.*;

public class P2_Reverse_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the desired characters in array");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for(int i=arr.length-1; i>=0; i--){
            System.out.print(arr[i]+" ");
        }

    }
}


