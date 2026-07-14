/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode reverse(ListNode head, int times) {
        ListNode prev = null;
        ListNode curr = head;

        while (times > 0 && curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            times--;
        }

        head.next = curr;
        return prev;
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode left = head;
        ListNode prevleft = null;
        ListNode res = null;

        while (left != null && left.next != null) {

            ListNode nextleft = left.next.next;

            ListNode newHead = reverse(left, 2);

            if (prevleft != null)
                prevleft.next = newHead;

            if (res == null)
                res = newHead;

            prevleft = left;
            left = nextleft;
        }

        return res;
    }
}