class MedianFinder {
    // we could create a global array and do the calculations every time
    // but that is too many calculations
    // instead we can make a minheap and maxheap and get the first values of each
    // to calculate the median

    PriorityQueue<Integer> minHeap; // for the right side of array
    PriorityQueue<Integer> maxHeap; // for the left side of array

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if (maxHeap.isEmpty() || num > minHeap.peek()) {
            minHeap.add(num);
        } else {
            maxHeap.add(num);
        }
        // int sizeDiff = minHeap.size() - maxHeap.size();
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        } else if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            double median = (double) (minHeap.peek() + maxHeap.peek()) / 2;
            return median;
        } else if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else {
            return maxHeap.peek();
        }
    }
}
