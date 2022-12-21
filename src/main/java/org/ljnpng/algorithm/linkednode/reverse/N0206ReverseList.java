package org.ljnpng.algorithm.linkednode.reverse;

import org.ljnpng.algorithm.domain.ListNode;

public class N0206ReverseList {

    /**
     * 使用迭代解决反转链表
     * 假设 1 -> 2 -> 3 -> 4
     * @param head 链表头
     * @return 新的链表头
     *
     */
    public ListNode reverseList(ListNode head) {
        // pre = null, cur = 1
        ListNode pre = null, cur = head;
        while (cur != null) {
            // next = 2
            ListNode next = cur.next;
            // 1 -> 2 ==> 1 -> null
            cur.next = pre;
            // pre = 1
            pre = cur;
            // cur = 2
            cur = next;
        }
        return pre;
   }

    /**
     *
     * 使用递归解决
     * <br/>
     * 假设 1 -> 2 -> 3 -> 4
     * @param head 头节点
     * @return 反转后的节点，即尾节点
     *
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            // head == null 用于快速筛选出 [] 空链表的情况
            // 实际用于判断是 head.next == null,  相当于一直递归找到尾节点
            return head;
        }

        // reverseList2 递归到底后返回的就是尾节点 也就是 newHead = 4
        ListNode newHead = reverseList2(head.next);

        // head 就是倒数第二个节点，下面这一句 相当于  3 -> 4 -> null ==> 3 <-> 4
        head.next.next = head;

        // 3 <-> 4  ==> null <- 3 <- 4
        head.next = null;

        // return 4
        return newHead;
    }
}
