class Solution {
    public int lastStoneWeight(int[] stones) {
        // sorts from biggest to smallest
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int num1 = maxHeap.poll();
            int num2 = maxHeap.poll();
            if (num1 > num2) {
                maxHeap.offer(num1 - num2);
            } 
        }

        if (maxHeap.isEmpty()) {
            return 0;
        } else {
            return maxHeap.poll();
        }
    }
}
