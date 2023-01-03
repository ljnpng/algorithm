package org.ljnpng.algorithm.array.two;


/**
 * 1. 先对角线镜像反转
 * 2. 再对每行反转
 */
public class N0048Rotate {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for (int[] ints : matrix) {
            reverse(ints);
        }

    }

    private void reverse(int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }
}
