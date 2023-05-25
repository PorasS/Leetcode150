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
  ListNode pivot = null;
  ListNode pivotNext = null;
  public ListNode reverseKGroup(ListNode head, int k) {

    int length = 0;
    ListNode resHead = null;

    ListNode cur = head;
    while (cur != null) {
      length++;
      cur = cur.next;
    }

    cur = head;

    ListNode prev = null;
    while (length >= k) {
      ListNode node = reverseK(cur, k);
      if (resHead == null) {
        resHead = pivot;
      } else {
        cur.next = pivotNext;
        prev.next = pivot;
      }

      length -= k;
      node.next = pivotNext;
      cur = pivotNext;
      prev = node;

    }

    return resHead;

  }

  public ListNode reverseK(ListNode node, int k) {

    if (k == 1) {
      pivot = node;
      pivotNext = node.next;
      return node;
    }

    ListNode nextNode = reverseK(node.next, k - 1);
    nextNode.next = node;
    node.next = null;

    return node;
  }
}
