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
    public ListNode doubleIt(ListNode head) {
        ListNode node=head;
        int carry=doubleList(node);
        if(carry==0)
            return head;
        else
        {
            ListNode newHead = new ListNode(carry);
            newHead.next=head;
            return newHead;
        }
    }
    
    int doubleList(ListNode node)
    {
        if(node==null)
            return 0;
        int prevCarry=doubleList(node.next);
        int carry=(node.val*2+prevCarry)/10;
        node.val=(node.val*2+prevCarry)%10;
        return carry;
    }
    
}