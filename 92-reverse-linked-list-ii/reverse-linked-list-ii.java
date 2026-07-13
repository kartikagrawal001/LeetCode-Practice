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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null||head.next==null||left==right)return head;
        ListNode part1 = null;
        ListNode t = head; 
        int pos = 1;
        while(pos<left && t!=null){
            part1 = t;
            t = t.next;
            pos++;
        }
        ListNode prev = null;
        ListNode curr = t;
        int count = right-left+1;
        while(count>0){
            ListNode next  = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count--;
        }
        t.next = curr;
        if(part1!=null){
            part1.next = prev;
            return head;
        }
        return prev;
    }
}