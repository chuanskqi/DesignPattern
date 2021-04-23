package argorithm.list;

import com.google.gson.Gson;

import java.util.HashSet;
import java.util.Set;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static void main(String[] args) {


        testHasCycle();
    }

    public static void testReverseList() {
        Solution solution = new Solution();
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        solution.reverseList(node1);
    }

    public static void testHasCycle() {
        Solution solution = new Solution();
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        //node5.next = node2;

        boolean hasCycle = solution.hasCycleByCpu(node1);

        System.out.println(hasCycle);
    }
}

class Solution {

    public boolean hasCycleByCpu(ListNode head) {
        ListNode current = head;

        if (current == null || current.next == null) {
            return false;
        }

        ListNode fast = current.next.next;
        ListNode slow = current.next;

        while (fast != null && fast.next != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
    /**
     * 循环链表检测-内存
     * @param head
     * @return
     */
    public boolean hasCycleByMemory(ListNode head) {

        ListNode current = head;
        Set<ListNode> sets = new HashSet<>();

        while (current != null) {
            boolean success = sets.add(current);
            if (!success) {
                return true;
            }
            current = current.next;
        }
        //current = null
        return false;
    }

    /**
     * 单链表的反转
     *
     * 逐渐递增当前指针current,将当前指针的下一个节点指向前一个节点
     * 需要保存前一个节点pre
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode current = head;

        while (current != null) {
            //保存下一个引用
            ListNode next = current.next;
            //反转列表
            current.next = pre;

            //前进指针
            pre = current;
            current = next;
        }
        //current = null;
        //pre是反转后的首节点
        return pre;
    }
}


