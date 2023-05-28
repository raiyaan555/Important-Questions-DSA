package Greedy;

import java.util.Arrays;

public class Minimum_Platforms {
    static int findPlatform(int arr[], int dep[], int n)
    {
        
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int platformRequired = 1,result =1, 
        // because start from the second arrival train
        i =1, j = 0;
        
        while(i<n && j<n){
            if(arr[i]<=dep[j]){
                platformRequired +=1;
                i++;
            }else{
                platformRequired -=1;
                j++;
            }
            result = Math.max(result, platformRequired);
        }
        
        return result;
        
        
        
    }
    
}
