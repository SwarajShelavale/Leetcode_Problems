class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode newHead = null;
        ListNode tail = null;
        int data = Integer.MIN_VALUE;
        ListNode temp = head;

        while (temp != null) {
            if (temp.next != null && temp.val == temp.next.val) {
                data = temp.val;
                temp = temp.next;
                continue;
            }

            if (temp.val != data) {
                if (newHead == null) {
                    newHead = temp;
                    tail = temp;
                } else {
                    tail.next = temp;
                    tail = temp;
                }
            }

            temp = temp.next;
        }

        if (tail != null) {
            tail.next = null;
        }

        return newHead;
    }
}