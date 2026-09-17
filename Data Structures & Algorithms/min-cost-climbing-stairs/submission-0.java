class Solution {

    int[] cache;

    public int minCostClimbingStairs(int[] cost) {
        cache = new int[cost.length];
        Arrays.fill(cache, -1);
        return Math.min(dfs(0, cost), dfs(1, cost));
    }
    
    public int dfs(int index, int[] cost) {
        if (index >= cache.length) return 0;

        if (cache[index] != -1) return cache[index];

        cache[index] = cost[index] + Math.min(dfs(index + 1, cost), dfs(index + 2, cost));

        return cache[index];
    }
}
