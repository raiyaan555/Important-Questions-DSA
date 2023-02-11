package Greedy;

public class Paper_Cut_into_Minimum_Number_of_Squares {

    public static int minimumSquare(int n, int m) {
        int a = Math.min(n, m);
        int b = Math.max(n, m);
        int ans = 0;

        while (a>0 && (b / a) > 0) {
            int b1 = b;
            int r = b/a;
            ans+=r;
            b = a;
            a = b1-(r*a);
        }
        return ans;

    }

    public static void main(String[] args) {
        int n = 30, m = 36;
        System.out.println(minimumSquare(n, m));
    }
}
