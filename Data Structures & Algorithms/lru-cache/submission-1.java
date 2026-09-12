class Node {
    int key;
    int val;
    Node next;
    Node prev;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
// our doubly linked node class to keep track of least recently used node

class LRUCache {
    HashMap<Integer, Node> cache;
    int capacity;
    Node left;
    Node right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        left = new Node(0, 0);
        right = new Node(0, 0);

        // left is for least recent, right is for most recent
        this.left.next = right;
        this.right.prev = left;
    }

    public void insert(Node node) {
        // insert at the rightmost postion, before right pointer
        Node prev = right.prev;

        // connecting
        prev.next = node;
        node.prev = prev;
        node.next = right;
        right.prev = node;
    }

    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            // we want to take this node out of list, then reinsert at rightmost postion
            // since its our most recently used 
            remove(node);
            insert(node);
            return node.val;
        } 
        return -1;
    }
    
    public void put(int key, int value) {
        // if already in cache, then node already exists
        // we need to remove it in order to insert it again
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
        }
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);
        
        // we have to check capacity
        if (cache.size() > capacity) {
            // remove from list and delete the lru from the cache
            Node lru = left.next;
            remove(lru);
            cache.remove(lru.key);

        }
    }
}
