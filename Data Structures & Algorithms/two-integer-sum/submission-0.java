class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i]; // 4 // 5 // 6
            int diff = target - num; // 10 - 4 = 6 // 10 - 5 = 5 // 10 - 6 = 4
            if (map.containsKey(diff)) {
                res[0] = map.get(diff); // (4, 0!)
                res[1] = i; // 2
            }
            map.put(num, i); // (4, 0)
        }
        return res;
    }
}
