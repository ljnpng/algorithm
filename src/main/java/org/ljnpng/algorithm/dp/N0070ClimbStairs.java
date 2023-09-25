package org.ljnpng.algorithm.dp;

public class N0070ClimbStairs {

    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int pre2 = 1, pre1 = 2;
        int ans = pre1 + pre2;
        for (int i = 3; i <= n; i++) {
            ans = pre1 + pre2;
            pre2 = pre1;
            pre1 = ans;
        }
        return ans;
    }
}
