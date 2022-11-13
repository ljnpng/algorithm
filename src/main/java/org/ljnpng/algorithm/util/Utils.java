package org.ljnpng.algorithm.util;

import org.ljnpng.algorithm.domain.ListNode;

import java.util.Arrays;

public class Utils {
    public static int[] stringToIntegerArray(String input) {

        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        return Arrays.stream(input.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static ListNode stringToListNode(String input) {
        int[] nodeValues = stringToIntegerArray(input);
        ListNode dummyNode = new ListNode(-1);
        ListNode p = dummyNode;
        for (int nodeValue : nodeValues) {
            p.next = new ListNode(nodeValue);
            p = p.next;
        }
        return dummyNode.next;
    }

    public static void prettyPrintLinkedList(ListNode node) {
        while (node != null && node.next != null) {
            System.out.println(node.val + "->");
            node = node.next;
        }

        if (node == null) {
            System.out.println("Empty");
        } else {
            System.out.println(node.val);
        }

    }
}
