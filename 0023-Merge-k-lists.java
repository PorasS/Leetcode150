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
  public ListNode mergeKLists(ListNode[] lists) {

    Set < ListNode > sortedSet = new TreeSet < > ((e1, e2) -> e1.val > e2.val ? 1 : -1);

    for (ListNode head: lists) {
      ListNode current = head;
      while (current != null) {
        sortedSet.add(current);
        current = current.next;
      }
    }

    ListNode head = null;
    ListNode prevNode = null;
    for (ListNode ln: sortedSet) {
      ln.next = null;
      if (head == null) {
        head = ln;
      } else {
        prevNode.next = ln;
      }
      prevNode = ln;
    }

    return head;
  }
}
