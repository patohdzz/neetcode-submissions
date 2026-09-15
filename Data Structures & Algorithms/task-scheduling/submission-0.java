class Solution {
    public int leastInterval(char[] tasks, int n) {
        // store the frequencies
        // process more frequent letter first, due to overall less time in idle state

        int[] frequencies = new int[26];
        for (char task : tasks) {
            frequencies[task - 'A']++;
        }
        // each entry is the remaining count of a task, we want to pop the highest one first
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); 
        // will store updated task numbers along with the next available time in which they can be done again
        Queue<int[]> queue = new LinkedList<>();
        // add frequencies with most frequent first
        for (int freq : frequencies) {
            if (freq > 0) {
                maxHeap.add(freq);
            }
        }
        int time = 0;
        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++;

            if (!maxHeap.isEmpty()) {
                int doTask = maxHeap.poll() - 1;
                // check if by doing current task we finish or not
                if (doTask > 0) {
                    queue.add(new int[] {doTask, time + n});
                }
            } else {
                time = queue.peek()[1];
            }
            // check if the current task has stayed enough time in idle and is ready to work again
            if (!queue.isEmpty() && queue.peek()[1] == time) {
                maxHeap.add(queue.poll()[0]);
            }
        }
        return time;
    }
}
