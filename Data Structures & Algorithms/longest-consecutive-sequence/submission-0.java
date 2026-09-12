class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>(); // use set to get rid of dupes
        for (int num : nums) {
            set.add(num);
        }

        int maxLength = 0; // will have the max number of consecutive values

        for (int num : nums) {
            // if current num is the start of a sequence
            if (!set.contains(num - 1)) {
                int curLength = 1;
                // while the set has more numbers in a sequence
                while (set.contains(num + curLength)) {
                    curLength++;
                }

                maxLength = Math.max(maxLength, curLength);
            }
        }

        return maxLength;
    }
}
