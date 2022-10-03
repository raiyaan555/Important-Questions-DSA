package Arrays;
public class P17_Container_with_Most_Water {
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int water = 0;

        while (left < right) {
            water = Math.max(water, (Math.min(height[right], height[left])) * (right - left));

            if (height[right] > height[left])
                left++;
            else
                right--;

        }
        return water;
    }
    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(nums));
    }
}
