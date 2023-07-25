package org.ljnpng.algorithm.array;

import java.util.*;

public class N0380RandomizedSet {
    private List<Integer> nums;

    private Map<Integer, Integer> dic;

    private Random random;

    public N0380RandomizedSet() {
        nums = new ArrayList<>();
        dic = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (dic.containsKey(val)) {
            return false;
        }
        dic.put(val, nums.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!dic.containsKey(val)) {
            return false;
        }
        int last = nums.get(nums.size() - 1);
        Integer index = dic.get(val);
        nums.set(index, last);
        dic.put(last, index); // 必须先添加后删除, index 刚好是最后一个元素的时候 才能正确remove
        nums.remove(nums.size() - 1);
        dic.remove(val);
        return true;
    }

    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}
