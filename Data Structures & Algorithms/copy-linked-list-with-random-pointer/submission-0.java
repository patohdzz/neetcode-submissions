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
        Map<Node, Node> oldToNew = new HashMap<>();
        Node cur = head;
        // first pass
        while(cur != null) {
            Node copy = new Node(cur.val);
            oldToNew.put(cur, copy);
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            Node copy = oldToNew.get(cur);
            copy.next = oldToNew.get(cur.next);
            copy.random = oldToNew.get(cur.random);
            cur = cur.next;
        }
        return oldToNew.get(head);

    }
}
