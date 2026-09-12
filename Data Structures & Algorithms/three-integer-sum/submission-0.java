class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // map of list ints??
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // if current number is greater than 0, stop
            if (nums[i] > 0) break;
            // if current number is equal to prev number (dupes) skip iteration
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // make left and right pointers
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    left++;
                    right--;

                    // skip dupes
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }

        return res;
    }
}
