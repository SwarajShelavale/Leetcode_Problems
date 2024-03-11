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
    public ListNode addTwoNumbers(ListNode node1, ListNode node2) {
       int carry=0;
       ListNode newHead=new ListNode(0),cur=newHead;
       while(node1!=null || node2!=null)
       {
           int sum=0;
           if(node1!=null)
           {
               sum+=node1.val;
               node1=node1.next;
           }

           if(node2!=null)
           {
               sum+=node2.val;
               node2=node2.next;
           }

           cur.next=new ListNode((sum+carry)%10);
           carry=(sum+carry)/10;
           cur=cur.next;
       }
       if(carry==1)
       {
           cur.next=new ListNode(1);
       }

       return newHead.next;
    }
}