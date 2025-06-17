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
    Map<Node, Node> map;
    public Node copyRandomList(Node head) {
        map = new HashMap<>();
        return  copyNode(head);
    }

    Node copyNode(Node l){
        if(l == null){
            return l;
        }

        Node nex = copyNode(l.next);
        Node n = map.containsKey(l) ? map.get(l) : new Node(l.val);
        map.put(l, n);

        n.next = nex;
        
        if(l.random != null){
            Node ran = map.containsKey(l.random) ? map.get(l.random) : new Node(l.random.val);
            n.random = ran;
            map.put(l.random, ran);
        }

        return n;

    }
}
