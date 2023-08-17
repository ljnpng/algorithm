package org.ljnpng.algorithm.hash;

public class N0202IsHappy {

    // 重点判断是不是会陷入循环, 如果陷入循环, 也即是说, 会出现重复的数字, 那么就不是快乐数
    // 1. 用快慢指针判断是否会陷入循环
    // 2. 用哈希表判断是否会陷入循环

    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = squareSum(slow);
            fast = squareSum(fast);
            fast = squareSum(fast);
        } while (slow != fast);
        return slow == 1;
    }

    private int squareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
