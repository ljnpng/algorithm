package org.ljnpng.algorithm.array;

public class N0080RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;
        int i = 1, j = 2;
        while(j < n) {
            if (nums[i - 1] != nums[j]) nums[++i] = nums[j];
            j++;
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        N0080RemoveDuplicates n0080RemoveDuplicates = new N0080RemoveDuplicates();
        int len = n0080RemoveDuplicates.removeDuplicates(nums);
        System.out.println(len);
    }
}
