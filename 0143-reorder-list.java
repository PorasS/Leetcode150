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

  ListNode fast = null;
  public void reorderList(ListNode head) {

    if(head == null || head.next == null){
        return;
    }

    fast = head;
    ListNode slow = head;

    while(fast!=null){
        if(fast.next == null){
          break;
        }
        slow = slow.next;
        fast = fast.next.next;
    }

    reverseHalfList(slow);

    ListNode l = head;
    ListNode r = fast;

    while(l!=null){
      if(l == r){
        break;
      }

      ListNode t1 = l.next;
      ListNode t2 = r.next;

      if(r == t1 && t2==null){
        break;
      }

      l.next = r;
      r.next = t1;

      l = t1;
      r = t2;
    }

  }


  public ListNode reverseHalfList(ListNode node){

    if(node.next == null){
      fast = node;
      return node;
    }

    ListNode nextNode = reverseHalfList(node.next);

    nextNode.next = node;
    node.next = null;

    return node;
  }
}
