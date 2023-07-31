package org.ljnpng.algorithm.array;

public class N0042Trap {


    /*
     * dp 维护一个左边最大, 右边最大
     *
     * */
    public int trap(int[] height) {
        int n = height.length;
        int sum = 0;
        int[] leftWall = new int[n];
        for (int i = 0; i < n; i++) {
            leftWall[i] = i == 0 ? 0 : Math.max(height[i - 1], leftWall[i - 1]);
        }
        int rightWall = 0;
        for (int i = n - 1; i > 0; i--) {
            rightWall = i == n - 1 ? 0 : Math.max(rightWall, height[i + 1]);
            sum += Math.max(Math.min(rightWall, leftWall[i]) - height[i], 0);
        }
        return sum;
    }
}
