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


        if(list1 == null && list2 == null){
            return list1;
        }

        if(list1 == null && list2!=null){
            return list2;
        }

        if(list1!=null && list2==null){
            return list1;
        }

        ListNode head = null;
        ListNode c1 = null;
        ListNode c2 = null;

        if(list1.val>=list2.val){
            c1 = list1;
            c2 = list2;
            head = list2;
        }else{
            c1 = list2;
            c2 = list1;
            head = list1;
        }

        ListNode temp = null;
        while(c1!=null){
            temp = c1.next;
            mergeList(c1, c2);
            c1 = temp;
        }

        return head;
    }


    public void mergeList(ListNode c1, ListNode c2){
        ListNode next2 = null;
        while(c1.val >= c2.val && c2.next!=null && c1.val > c2.next.val){
            c2 = c2.next;
        } 

        next2 = c2.next;
        c2.next = c1;
        c1.next = next2;
    }
}
