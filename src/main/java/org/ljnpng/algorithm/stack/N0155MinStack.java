package org.ljnpng.algorithm.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class N0155MinStack {

    private final Deque<StackValue> stack;

    public N0155MinStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int val) {
        Integer min = stack.isEmpty() ? val : Math.min(stack.peek().min, val);
        stack.push(new StackValue(val, min));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().value;
    }

    public int getMin() {
        return stack.peek().min;

    }

    private static class StackValue {
        Integer value;

        Integer min;

        StackValue(Integer value, Integer min) {
            this.value = value;
            this.min = min;
        }
    }

}
