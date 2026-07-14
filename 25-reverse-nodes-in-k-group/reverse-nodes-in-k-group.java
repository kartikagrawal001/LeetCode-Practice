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
    public void reverse(ListNode head, int size) {
        ListNode prev = null;
        ListNode current = head;
        int times = size;
        while (times > 0 && current != null) {
            ListNode nex = current.next;
            current.next = prev;
            prev = current;
            current = nex;
            times--;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null)return head;
        ListNode left = head;
        ListNode prevleft = null;
        ListNode res = null;
        ListNode nextleft = null;
        ListNode right = null;
        int size = k;
        while(left!=null){
            right = left;
            for(int i=0;i<size-1;i++){
                if(right==null)break;
                else right = right.next;
            }
            if(right!=null){
                nextleft = right.next;
                reverse(left,size);
                if(prevleft!=null)prevleft.next = right;
                if(res==null)res = right;
                prevleft = left;
                left = nextleft;
            }
            else{
                if(prevleft!=null)prevleft.next = left;
                if(res==null)res = left;
                break;
            }
        }
        return res;
    }
}
