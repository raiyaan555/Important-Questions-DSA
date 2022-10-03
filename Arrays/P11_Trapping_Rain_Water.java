package Arrays;
public class P11_Trapping_Rain_Water {
    public static int trap(int[] height) {
        int[] left = new int[height.length];
        int leftMax = 0;
        int rightMax = 0;
        int[] right = new int[height.length];
        int sum=0;

        for (int i = 0; i < height.length; i++) {
            if (leftMax < height[i]) {
                leftMax = height[i];
            }
             left[i] = leftMax;
        }

        for (int i = height.length-1; i >= 0; i--) {
            if (rightMax < height[i]) {
                rightMax = height[i];
            }
            right[i] = rightMax;
        }

        for (int i = 0; i < height.length; i++) {
            sum = sum+(Math.min(left[i],right[i]))-height[i];
        }
        System.out.println("Left ->");
        for (int i = 0; i < height.length; i++) {
            System.out.print(left[i]+" ");
        }
        System.out.println();
        System.out.println("Right ->");
        for (int i = 0; i < height.length; i++) {
            System.out.print(right[i]+" ");
        }
        System.out.println();
        System.out.println("Height ->");
        for (int i = 0; i < height.length; i++) {
            System.out.print(height[i]+" ");
        }
        System.out.println();
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {4,2,0,3,2,5};
        System.out.println(trap(nums));
    }
}
