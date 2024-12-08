package easy;

public class Can_Place_Flowers {
    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{0}, 1));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        for (int i = 0; i < flowerbed.length;) {

            if (flowerbed[i] == 0) {
                boolean can = true;
                if (i > 0) {
                    can = flowerbed[i - 1] == 0;
                }
                if (can && i < flowerbed.length - 1) {
                    can = flowerbed[i + 1] == 0;
                }
                if (can) {
                    flowerbed[i] = 1;
                    n--;
                    if (n == 0) {
                        return true;
                    }
                    i += 2;
                    continue;
                }
            }
            i++;
        }
        return n == 0;
    }
}
