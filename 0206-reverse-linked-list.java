Approach: Iterator
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
    ListNode headNode = null;
    public ListNode reverseList(ListNode head) {

        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;

        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}


---------------------------------------------------------------------------
 Approach: Recursion
 
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
    ListNode headNode = null;
    public ListNode reverseList(ListNode head) {
        headNode = head;
        if(head == null){
            return head;
        }
        reverse(headNode, null);  
        return headNode;
    }

    public void reverse(ListNode current, ListNode prev){
        if(current.next != null){
            reverse(current.next, current);
            current.next = prev;
            if(prev!=null){
                prev.next = null;
            }
            
        }else{
            headNode = current;
            current.next = prev;
            if(prev!=null){
                prev.next = null;
            }         
        }
    }
}
