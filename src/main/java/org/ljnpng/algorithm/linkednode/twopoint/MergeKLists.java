package org.ljnpng.algorithm.linkednode.twopoint;

import org.ljnpng.algorithm.domain.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(1);
        ListNode p = dummy;
        // 定义capacity 避免扩容造成耗时
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length,Comparator.comparingInt(o -> o.val));
        for (ListNode list : lists) {
            if (list != null) {
                priorityQueue.add(list);
            }
        }
        while (!priorityQueue.isEmpty()) {
            p.next = priorityQueue.poll();
            p = p.next;
            if (p.next != null) {
                priorityQueue.add(p.next);
            }
        }
        return dummy.next;
    }
}
