package Arrays;

public class P41_Can_Place_Flowers {
    class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            if (n == 0)
                return true;
            if (flowerbed.length == 1 && flowerbed[0] == 0)
                return true;

            for (int i = 0; i < flowerbed.length; i++) {
                if (i == 0 && flowerbed[i] == 0) {
                    if (flowerbed[i + 1] != 1) {
                        flowerbed[i] = 1;
                        n--;
                        System.out.println("check1");
                    }
                } else if (i == flowerbed.length - 1 && flowerbed[i] == 0) {
                    if (flowerbed[i - 1] != 1) {
                        flowerbed[i] = 1;
                        n--;
                        System.out.println("check2");
                    }
                } else if (flowerbed[i] == 0) {
                    if (flowerbed[i - 1] != 1 && flowerbed[i + 1] != 1) {
                        flowerbed[i] = 1;
                        n--;
                        System.out.println("check3");
                    }
                }
            }
            if (n <= 0)
                return true;
            return false;
        }
    }
}
