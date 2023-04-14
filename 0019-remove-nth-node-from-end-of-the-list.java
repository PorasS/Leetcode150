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
  public ListNode removeNthFromEnd(ListNode head, int n) {

    int totalNodes = 0;
    ListNode curr = head;

    while (curr != null) {
      curr = curr.next;
      totalNodes++;
    }

    int removalIndex = totalNodes - n;
    int pos = 1;
    curr = head;

    if (removalIndex == 0) {
      return head.next;
    }

    while (pos != removalIndex) {
      curr = curr.next;
      pos++;
    }
    curr.next = curr.next.next;
    return head;
  }
}
