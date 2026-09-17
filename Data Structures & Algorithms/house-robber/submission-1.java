class Solution {

    int[] cache;

    public int rob(int[] nums) {
        // dp problem
        cache = new int[nums.length];
        Arrays.fill(cache, -1);
        return dfs(0, nums);
    }

    public int dfs(int index, int[] nums) {
        if (index >= nums.length) return 0;

        if (cache[index] != -1) return cache[index];

        // we havent computed this case
        // whats the higher value, this house plus the one two ahead or the next house
        cache[index] = Math.max(nums[index] + dfs(index + 2, nums), dfs(index + 1, nums));

        return cache[index];
    }
}
