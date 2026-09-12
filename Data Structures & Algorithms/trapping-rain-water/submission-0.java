class Solution {
    public int trap(int[] height) {
        // water area will depend on the shorter of the walls from left to right
        // if left wall is shorter, move it right, vice versa
        // keep track of the highest wall on each side
        int l = 0;
        int r = height.length - 1;
        int leftMax = height[l];
        int rightMax = height[r];
        int water = 0;

        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                // make sure leftMax is at least as tall as the current bar
                leftMax = Math.max(leftMax, height[l]);
                water += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                water += rightMax - height[r];
            }
        }

        return water;
    }
}
