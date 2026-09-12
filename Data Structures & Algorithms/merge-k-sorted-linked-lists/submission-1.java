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
        // use a min heap, add all values from the lists into the min heap
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            pq.offer(node);
        }
        // put the start of each list in the pq sorted in ascending order

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (!pq.isEmpty()) {
            // Gets the smallest available node.
            ListNode node = pq.poll();
            cur.next = node;
            cur = cur.next;
            node = node.next;
            
            // Moves to the next node from the list that the smallest node came from.
            if (node != null) {
                pq.offer(node);
            }
        }
        return dummy.next;
    }
}
