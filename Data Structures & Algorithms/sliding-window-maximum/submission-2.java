class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        // to get max value of a window, use a max heap to get that instantly
        // store (value, index) to quickly see if index is still within window
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]); // standard is min
        int indexOfResult = 0;
        for (int i = 0; i < nums.length; i++) {
            // add current value + index into heap
            maxHeap.offer(new int[]{nums[i], i});
            // add current max to result only if we have a full window made
            if (i >= k - 1) {
                // check if old values are still in heap before adding a max value
                while (maxHeap.peek()[1] <= i - k) {
                    maxHeap.poll();
                }
                result[indexOfResult] = maxHeap.peek()[0];
                indexOfResult++;
            }
        }

        return result;
    }
}
