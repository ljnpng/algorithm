package org.ljnpng.algorithm.dp;

public class N0509Fib {

    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int q = 0, p = 1;
        int ans = 1;
        for (int i = 2; i <= n; i++) {
            ans = q + p;
            q = p;
            p = ans;
        }
        return ans;
    }
}
