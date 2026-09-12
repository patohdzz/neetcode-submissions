class KthLargest {

    PriorityQueue<Integer> heap;
    int k;

    public KthLargest(int k, int[] nums) {
        heap = new PriorityQueue<>();
        this.k = k;
        // add to the queue
        for (int num : nums) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll(); // will only take out elements that can never be k
            }
        }

    }
    
    public int add(int val) {
        heap.offer(val);
        if (heap.size() > k) {
            heap.poll();
        }
        return heap.peek();
    }
}
