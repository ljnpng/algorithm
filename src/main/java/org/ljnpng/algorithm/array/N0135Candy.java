package org.ljnpng.algorithm.array;

public class N0135Candy {

    public int candy(int[] ratings) {
        int sum = 0;
        int n = ratings.length;
        if (n == 1) {
            return 1;
        }

        int[] L = new int[n];
        L[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                L[i] = L[i - 1] + 1;
            } else {
                L[i] = 1;
            }
        }
        int R = 1;
        sum += Math.max(R, L[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                R += 1;
            } else {
                R = 1;
            }
            sum += Math.max(L[i], R);
        }
        return sum;
    }
}
