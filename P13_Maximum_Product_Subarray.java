public class P13_Maximum_Product_Subarray {

    public static int maxProduct(int[] nums) {
        int lmax=nums[0];//set maximum value while traversing from left to right with a value within array
        int rmax=nums[0];//set maximum value while traversing from right to left with a value within array
        int product=1;//product stores the maximum possible product
        boolean hasZero=false;//check if there exist a zero in array bcz for zero we will skip comparision and it will help us in resetting our subarray into concideration.
        for(int i=0;i<nums.length;i++){
            product*=nums[i];
            if(product==0){//reset product if found zero and skip comparision
                hasZero=true;
                product=1;
                continue;
            }
            lmax=Math.max(lmax,product);
        }
        product=1;
        for(int i=nums.length-1;i>=0;i--){
            product*=nums[i];
            if(product==0){//reset product if found zero and skip comparision
                hasZero=true;
                product=1;
                continue;
            }
            rmax=Math.max(rmax,product);
        }
        if(hasZero) return Math.max(Math.max(rmax,lmax),0);//if has zero give it a chance 
        return Math.max(rmax,lmax);//if doesn't have zero compare.
    }
public static void main(String[] args) {
    int[] nums = {-2,3,-4};
    System.out.println(maxProduct(nums));
}
}

