class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        boolean duplicate = true;
        if (set.size() == nums.length) {
            duplicate = false;
        }
        return duplicate;
    }
}
