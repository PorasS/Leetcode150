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
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

    //Approach 1:  Min Heap
    // PriorityQueue<ListNode> minHeap = new PriorityQueue<>((e1, e2) -> e1.val - e2.val); //minHeap

    // while(list1 != null){
    //     minHeap.add(list1);
    //     list1 = list1.next;
    // }

    // while(list2 != null){
    //     minHeap.add(list2);
    //     list2 = list2.next;
    // }

    // ListNode head = null;
    // ListNode prev = null;

    // if(minHeap.size() > 0){
    //     head = minHeap.poll();
    //     prev = head;
    // }

    // while(minHeap.size() > 0){
    //     ListNode node = minHeap.poll();
    //     node.next = null;
    //     prev.next = node;
    //     prev = node;
    // }

    // return head;

    //Approach 2:  Recursion

    if (list1 == null) {
      return list2;
    }

    if (list2 == null) {
      return list1;
    }

    if (list1.val < list2.val) {
      list1.next = mergeTwoLists(list1.next, list2);
      return list1;
    } else {
      list2.next = mergeTwoLists(list1, list2.next);
      return list2;
    }
  }
}
