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
   public ListNode swapPairs(ListNode head) {

     if (head == null || head.next == null) {
       return head;
     }

     ListNode newHead = head.next;
     swapNodes(head, null);
     return newHead;
   }

   public void swapNodes(ListNode node, ListNode prev) {

     if (node == null || node.next == null) {
       return;
     }

     ListNode nextNodeToSwap = node.next.next;
     ListNode nextNode = node.next;
     nextNode.next = node;
     node.next = nextNodeToSwap;

     if (prev != null) {
       prev.next = nextNode;
     }

     prev = node;

     swapNodes(nextNodeToSwap, prev);
   }
 }
