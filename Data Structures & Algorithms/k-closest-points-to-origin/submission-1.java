class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> 
            (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));
        
        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        // now we have the k closest points
        int n = maxHeap.size();
        int[][] result = new int[n][2];
        for (int i = 0; i < n; i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }
}
