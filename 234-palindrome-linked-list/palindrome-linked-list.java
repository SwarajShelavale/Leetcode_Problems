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
    public boolean isPalindrome(ListNode head) {
        Stack<Integer>st = new Stack<>();
        ListNode node = head;
        while(node!=null)
        {
            st.push(node.val);
            node=node.next;
        }
        node=head;
        while(!st.isEmpty())
        {
            if(st.peek()!=node.val)
                return false;
            st.pop();
            node=node.next;
        }
        return true;
    }
}