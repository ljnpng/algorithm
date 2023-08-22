package org.ljnpng.algorithm.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.function.BinaryOperator;

public class N0150EvalRPN {

    public int evalRPN(String[] tokens) {
        Map<String, BinaryOperator<Integer>> operator = Map.of(
                "+", Integer::sum,
                "-", (n0, n1) -> n0 - n1,
                "*", (n0, n1) -> n0 * n1,
                "/", (n0, n1) -> n0 / n1
        );
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            BinaryOperator<Integer> op = operator.get(token);
            if (op != null) {
                Integer n1 = stack.pop();
                Integer n0 = stack.pop();
                stack.push(op.apply(n0, n1));
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}
