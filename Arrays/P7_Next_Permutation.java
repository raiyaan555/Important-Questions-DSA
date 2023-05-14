package Arrays;

// optimal solution with time comlexity o(N) and space complexity O(1);

public class P7_Next_Permutation {
    public static void main(String[] args) {
    int[] nums={3,2,1};
       nextPermutation(nums);
    }


    public static void  swap(int[]A, int i, int j){
        int temp =A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void nextPermutation(int[] nums) {
        int index1=0;
        int index2=0;
        if(nums==null || nums.length<=1){
            return;
        }
        for (int i = nums.length-2;  i>=0 ;i--){
            if(nums[i]<nums[i+1]){
                index1 = i;
                break;
            }
        }

        for (int i = nums.length-1;  i>=0 ;i--){
                if(nums[i]>nums[index1]){
                    index2=i;
                     break;
                }
            }
            swap(nums, index1, index2);
                if(index1==0 && index2==0){
                    for (int i = nums.length-1;i>=index1;i--){
                        int k=index1+1;
                        swap(nums,i,k);
                        k++;
                    }
                }else{
                    for (int i = nums.length-1;i>=index1+1;i--){
                        int k=index1+1;
                        swap(nums,i,k);
                        k++;
                }
            }
        
            
            for (int i = 0;  i<=nums.length-1;i++){
               System.out.print(nums[i]+",");
            }
        }
        
}



