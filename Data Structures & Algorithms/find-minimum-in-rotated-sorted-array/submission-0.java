class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        // we don't equal them because once both indexes point to the same value, 
        // we found the number
        while (left < right) {
            int mid = (left + right) / 2;

            // we are looking for the smallest value in the array,
            // so if the number at mid is greater that the right, the smallest 
            // value should lie on the right side
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // we know value has to be on the left side, but it can also be
                // at the place of mid, we want to check
                right = mid;
            }
        }
        return nums[left]; // or right, they are the same value
    }
}
