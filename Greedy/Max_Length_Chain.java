package Greedy;
import java.util.Arrays;

public class Max_Length_Chain {
    int maxChainLength(Pair arr[], int n)
    {
       // your code here
       
        Arrays.sort(arr, (obj1,obj2) -> obj1.y - obj2.y);

        int chainLen = 0;
        int chainEnd = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            if(arr[i].x > chainEnd) {
                chainLen++;
                chainEnd = arr[i].y;
            }
        }
        return chainLen;
        
    }

    
}
class Pair
{
    int x;
    int y;
    
    public Pair(int a, int b)
    {
        x = a;
        y = b;
    }
}