class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        
        // put numbers and their frequencies in a map
        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        // make a min heap that will store values based on frequency (values) and not keys
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> mp.get(a) - mp.get(b)
        );

        // iterate through the keys and add them to the min heap (it will sort based on freq)
        // if size gets bigger than k, kick out the number with least frequency
        for (int num : mp.keySet()) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            result[i] = pq.poll();
        }

        return result;
    }
}
