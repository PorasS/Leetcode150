/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
  public Node copyRandomList(Node head) {

    Node current = head;
    Map < Node, Node > map = new HashMap < > ();
    while (current != null) {
      Node newNode = new Node(current.val);
      map.put(current, newNode);
      current = current.next;
    }

    Node newHead = map.get(head);
    Node curr = head;
    while (curr != null) {
      Node newNode = map.get(curr);
      newNode.random = map.get(curr.random);
      newNode.next = map.get(curr.next);
      curr = curr.next;
    }
    return newHead;
  }
}
