package leeCode.huiwen;

import org.springframework.util.Assert;

import java.util.ArrayList;

public class ShuZi {
    public static void main(String[] args) {
        System.out.println(isHuiWen(122221));

        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        node1.next=node2;

        ListNode node3 = new ListNode(-129);
        ListNode node4 = new ListNode(-129);
        node3.next=node4;

        Assert.isTrue(!isPalindrome(node1), "错误1");
        Assert.isTrue(isPalindrome(node3), "错误3");

        System.out.println(isPalindrome(node1));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ArrayList list = new ArrayList();
        ListNode current = head;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }

        int start = 0;
        int end = list.size() - 1;
        while(start <= end) {
            if (!list.get(start).equals(list.get(end))) {
                return false;
            }
            start ++;
            end --;
        }
        return true;

    }
    /**
     * 数字回文
     * 复杂度O(n)
     * @param num
     * @return
     */
    public static boolean isHuiWen(int num) {
        if (num < 0 || (num % 10 == 0 && num != 0)) {
            return false;
        }
        int reverse = 0;
        while (num > reverse) {
            reverse = reverse * 10 + num % 10;
            num /= 10;
        }
        ArrayList arrayList = new ArrayList();
        return num == reverse || reverse/10 == num;
    }
}
