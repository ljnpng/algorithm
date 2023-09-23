package org.ljnpng.algorithm.array;

public class N0074SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        return binarySearch(matrix, 0, row * col - 1, target, col);
    }

    private boolean binarySearch(int[][] matrix, int start, int end, int target, int col) {
        if (start > end) {
            return false;
        }
        int mid = start + (end - start) / 2;
        int ans = matrix[mid / col][mid % col];
        if (ans == target) {
            return true;
        } else if (ans > target) {
            return binarySearch(matrix, start, mid - 1, target, col);
        } else {
            return binarySearch(matrix, mid + 1, end, target, col);
        }

    }

}
