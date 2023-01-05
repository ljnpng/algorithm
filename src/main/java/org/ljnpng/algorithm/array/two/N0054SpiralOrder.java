package org.ljnpng.algorithm.array.two;

import java.util.ArrayList;
import java.util.List;

/**
 * 1  2  3  4
 * 5  6  7  8
 * 9 10 11 12
 */
public class N0054SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0, bottom = matrix.length - 1,
                left = 0, right = matrix[0].length - 1;
        int num = (bottom + 1) * (right + 1);
        List<Integer> res = new ArrayList<>();
        while (num > 0) {
            for (int i = left; i <= right && num > 0; i++) {
                res.add(matrix[top][i]);
                num--;
            }
            top++;
            for (int i = top; i <= bottom && num > 0; i++) {
                res.add(matrix[i][right]);
                num--;
            }
            right--;
            for (int i = right; i >= left && num > 0; i--) {
                res.add(matrix[bottom][i]);
                num--;
            }
            bottom--;
            for (int i = bottom; i >= top && num > 0; i--) {
                res.add(matrix[i][left]);
                num--;
            }
            left++;
        }
        return res;
    }
}
