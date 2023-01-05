package org.ljnpng.algorithm.array.two;

public class N0059GenerateMatrix {

    public int[][] generateMatrix(int n) {
        int left = 0, right = n - 1;
        int top = 0, bottom = n - 1;
        int[][] matrix = new int[n][n];
        int count = 1, sum = n * n;
        while (count <= sum) {
            for (int i = left; i <= right && count <= sum; i++) {
                matrix[top][i] = count;
                count++;
            }
            top++;
            for (int i = top; i <= bottom && count <= sum; i++) {
                matrix[i][right] = count;
                count++;
            }
            right--;
            for (int i = right; i >= left && count <= sum; i--) {
                matrix[bottom][i] = count;
                count++;
            }
            bottom--;
            for (int i = bottom; i >= top && count <= sum; i--) {
                matrix[i][left] = count;
                count++;
            }
            left++;
        }
        return matrix;
    }
}
