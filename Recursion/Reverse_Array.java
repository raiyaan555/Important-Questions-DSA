package Recursion;

public class Reverse_Array {
   
    public static void reveseArray(int left, int right,char[]a){
        if(left>=right)
        return;
        char temp = a[left];
        a[left] = a[right];
        a[right] = temp;
        reveseArray(left+1, right-1, a);
    }
    public static void main(String[] args) {
        String s = "NITINI";
        char[] a = s.toCharArray();
        reveseArray(0,a.length-1,a);
        char []b = s.toCharArray();
        for(int i = 0; i<b.length;i++){
            if(b[i]!=a[i]) {
                System.out.println("false");
                return;
            } 
        }
        System.out.println("true");
    }
}
