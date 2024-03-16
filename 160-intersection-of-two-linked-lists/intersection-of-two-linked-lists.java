/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      
      //Find length of Both LinkedLists
      
        ListNode curA=headA,curB=headB;
        int lengthA=findLength(curA),lengthB=findLength(curB);
        if(lengthA>lengthB)
            curA=travelDifferance(curA,lengthA-lengthB);
        else
            curB=travelDifferance(curB,lengthB-lengthA);
        
        while(curA!=null && curB!=null)
        {
            if(curA==curB)
            {
                return curA;
            }
            curA=curA.next;
            curB=curB.next;
        }
        return null;
    }

    public int findLength(ListNode node)
    {
        int length=0;
        while(node!=null)
        {
            length++;
            node=node.next;
        }
        return length;
    }

    public ListNode travelDifferance(ListNode node,int diff)
    {
        while(node!=null && diff>0)
        {
            node=node.next;
            diff--;
        }
        return node;
    }
}