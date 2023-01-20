package Searching_and_Sorting;

public class Check_if_reversing_sub_array_make_the_array_sorted {
    public static void reverse(int[]arr, int a, int b){

        while(a<b){
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
            a++;
            b--;
        }
    }

    public static boolean checkReverseSub(int[] arr){
        int x  = -1;
        int y = -1;

        for(int i = 0; i<arr.length-1; i++){
            if(arr[i]>arr[i+1]){
                if(x==-1){
                    x = i;
                }
                y = i+1;
            }
        }

        if(x!=-1){
            reverse(arr, x, y);
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
              return false;
            }
    }
    return true;
}

public static void main(String[] args) {
    int[] arr = {10,20,30,40,50,60,70};
    System.out.println(checkReverseSub(arr));
}
}
