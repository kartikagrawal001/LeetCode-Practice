class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode prev = null;
        if (head == null) {
            return null;
        }
        ListNode left = head;
        ListNode right = left;
        ListNode prevLeft = null;
        ListNode nextLeft = null;
        ListNode res = null;
        int size = 2;
        while (left != null) {
            right=left;
            for (int i = 0; i < size - 1; i++) {
                if (right == null)break;
                else right = right.next;    
            }
            if (right != null) {

                nextLeft = right.next;
                reverse(left, size);
                if (prevLeft != null) {
                    prevLeft.next = right;
                }
                if (res == null) {
                    res = right;
                }
                prevLeft = left;
                left = nextLeft;
            }

            else {
                if (prevLeft != null) {
                    prevLeft.next = left;
                }
                 if (res == null) {
                        res = left;
                    }   
                break;
            }

        }
        return res;

    }

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
}