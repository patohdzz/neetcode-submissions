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
    public ListNode reverseList(ListNode head) {
         if(head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;
        // iterate through linked list
        while(curr != null) {
            // set next node to curr.next, move current's next pointer 
            // backwards to prev to reverse, set prev to curr and 
            // curr to next
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        return prev;
    }
}
