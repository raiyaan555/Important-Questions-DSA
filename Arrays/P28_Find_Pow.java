package Arrays;

public class P28_Find_Pow {

    // brute force approach for myPow

    public static double myPow(double x, int n) {

        double ans = 1.00000;
        if (n > 0) {
            for (int i = 0; i < n; i++) {
             
                ans = ans * x;
            }
            
        } else {
            for (int i = 0; i < Math.abs(n); i++) {
                
                ans = ans / x;
            }
            
        }
        return ans; 
    }

    public static void main(String[] args) {
        
        System.out.println(myPow(2, -2));
    }
}
