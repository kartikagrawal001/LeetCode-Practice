class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(head == null || left == right) return head;

        ListNode l = null;
        if(left > 1){
            l = head;
            int c1 = 1;
            while(c1 < left - 1){
                l = l.next;
                c1++;
            }
        }

        ListNode r = head;
        int c2 = 1;
        while(c2 < right){
            r = r.next;
            c2++;
        }

        ListNode lsave = l;
        ListNode rsave = r.next;
        r.next = null;

        ListNode midhead;
        if(l == null){
            midhead = head;
        }else{
            midhead = l.next;
            l.next = null;
        }

        ListNode prev = null;
        ListNode curr = midhead;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        if(lsave != null){
            lsave.next = prev;
        }else{
            head = prev;
        }

        ListNode tem = head;
        while(tem.next != null){
            tem = tem.next;
        }

        tem.next = rsave;

        return head;
    }
}