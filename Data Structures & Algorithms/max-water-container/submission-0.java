class Solution {
    public int maxArea(int[] height) {
        // grab the two pointers
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        // while l and r pointers dont cross
        while (left < right) {
            // grab the width length
            int width = right - left;
            // graph the lower height of two
            int h = Math.min(height[left], height[right]);
            // check if max num changes in this iterating
            max = Math.max(max, width * h);

            // if left pointer is smaller, increase it by one and vice versa
            if (height[left] < height[right]) {
                left++;
            } else if (height[right] < height[left]) {
                right--;
            } else { // if both heights are equal, move both
                left++;
                right--;
            }
        }
        return max;
    }
}
