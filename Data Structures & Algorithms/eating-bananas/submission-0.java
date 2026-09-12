class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        // our max value is the max piles in array
        for (int i : piles) {
            right = Math.max(right, i);
        }
        // the return result, if we can't find a smaller one this is the answer
        int result = right;

        while (left <= right) {
            int mid = (left + right) / 2;
            // check the total time it will take to all bananas with a time of mid
            long timeToEat = 0;
            for (int i : piles) {
                timeToEat += Math.ceil((double) i / mid);
            }

            // if we were able to eat all bananas, record the mid time, and check if we
            // can eat in less time
            if (timeToEat <= h) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return result;
        
    }
}
