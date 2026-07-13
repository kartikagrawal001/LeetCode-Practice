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
    public ListNode removeNodes(ListNode head) {
        Stack<Integer> st = new Stack<>();
        ListNode temp = head;
        while(temp!=null){
            if(st.isEmpty())st.push(temp.val);
            else{
                while(!st.isEmpty() && st.peek()<temp.val)st.pop();
                st.push(temp.val);
            }
            temp = temp.next;
        }
        Stack<Integer> st2 = new Stack<>();
        while(!st.isEmpty()){
            st2.push(st.peek());
            st.pop();
        }
        ListNode anshead = new ListNode(st2.peek());
        st2.pop();
        ListNode dummy = anshead;
        while(!st2.isEmpty()){
            ListNode tem = new ListNode(st2.peek());
            st2.pop();
            dummy.next = tem;
            dummy = tem;
        }
        return anshead;
    }
}