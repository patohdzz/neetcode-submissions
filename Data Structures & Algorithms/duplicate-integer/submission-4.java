class Solution {
    public boolean hasDuplicate(int[] nums) {
        // use set to filter out duplicates
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        return set.size() != nums.length;
        // this is an O(n) operation
    }
}