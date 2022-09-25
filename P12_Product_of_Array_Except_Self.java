public class P12_Product_of_Array_Except_Self {

    public static int[] productExceptSelf(int[] nums) {
        int product = 1;
        int productx =1;
        int ans[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            
           
            ans[i] = product;
            product *= nums[i];
           

        }
        for(int i: ans){
            System.out.print(i+" ");
        }
        System.out.println();

       

        for (int i = nums.length - 1; i >=0; i--) {
            ans[i] = ans[i] * productx;
            productx *=nums[i];
        }

        
        
        for(int i: ans){
            System.out.print(i+" ");
        }


        return ans;


    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        System.out.println(productExceptSelf(nums));
    }
}
