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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        else if(l2==null)
            return l1;
        
        ListNode head=null,tail=null,cur1=l1,cur2=l2;
        if(cur1.val<cur2.val)
        {
            head=cur1;
            tail=cur1;
            cur1=cur1.next;
        }
        else
        {
            head=cur2;
            tail=cur2;
            cur2=cur2.next;
        }

        while(cur1!=null && cur2!=null)
        {
            if(cur1.val<cur2.val)
            {
                tail.next=cur1;
                tail=tail.next;
                cur1=cur1.next;
            }
            else
            {
                tail.next=cur2;
                tail=tail.next;
                cur2=cur2.next;
            }
        }

        if(cur1==null)
            tail.next=cur2;
        else
            tail.next=cur1;

        return head;
    }
}