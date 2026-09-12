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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy; // current group's previous node

        while (true) {
            // try reversing a group if more than k nodes left
            ListNode kth = getKth(groupPrev, k);
            if (kth == null) break;
            ListNode groupNext = kth.next;  // save the start of next group

            ListNode prev = groupNext;      // prev starts as groupNext, the node at boundary
            ListNode cur = groupPrev.next;  // cur starts at first node of current group
            while(cur != groupNext) {
                ListNode temp = cur.next;   // save what cur used to point to
                cur.next = prev;            // flip pointer, cur now points to prev which is start of next group
                prev = cur;                 // prev advanves to where cur is    
                cur = temp;                 // cur advances to where it was supposed to go
            }
            ListNode temp = groupPrev.next; // save the now tail of current group
            groupPrev.next = kth;           // this is now the new head of current group
            groupPrev = temp;               // this is now the tail of current group and the start boundary of next group
        }
        return dummy.next;
    }

    public ListNode getKth(ListNode cur, int k) {
        while (cur != null && k > 0) {
            cur = cur.next;
            k--;
        }
        return cur;
    }
}
