package Recursion;

public class Reverse_Array {
   
    public static void reveseArray(int left, int right,int a[]){
        if(left>=right)
        return;
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
        reveseArray(left+1, right-1, a);
    }
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6};
        reveseArray(0,a.length-1,a);
        for(int i = 0; i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}
