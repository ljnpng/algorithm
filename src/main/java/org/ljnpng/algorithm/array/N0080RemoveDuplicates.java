package org.ljnpng.algorithm.array;

public class N0080RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int i = 0, j = 1;
        int count = 0;
        for (; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
                count = 0;
            } else if(count < 1){
                count++;
                nums[++i] = nums[j];
            }
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
