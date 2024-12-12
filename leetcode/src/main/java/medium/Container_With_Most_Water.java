package medium;

public class Container_With_Most_Water {
    public static void main(String[] args) {
        int[] input = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(input));
    }

    public static int maxArea(int[] height) {
        int maxArea = 0;
        // List<Integer> areas = new ArrayList<>();
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            int lH = height[l];
            int rH = height[r];
            int h = Math.min(lH, rH);
            int width = (r + 1) - (l + 1);
            int area = h * width;
            if (area > maxArea) {
                maxArea = area;
            }
            if (rH > lH) {
                l++;
            } else{
                r--;
            }
        }
        return maxArea;
    }
}
