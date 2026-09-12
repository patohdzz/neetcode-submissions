class Solution {
    public int largestRectangleArea(int[] heights) {
        // stack
        // for each index, search for the leftmost and rightmost heights that are lower
        // this will be the width in our formula to get area = height * width

        int[] leftMost = new int[heights.length];
        int[] rightMost = new int[heights.length];
        // use a stack, or else we will have to scan left and right one by one
        // stack will store the indexes, so we can use heights[stack.peek()] to get the heights at index
        Stack<Integer> stack = new Stack<>();

        // this will be used to fill out the leftMost array
        for (int i = 0; i < heights.length; i++) {
            // no smaller bar on the starting point
            leftMost[i] = -1;
            // now from this point, we will backtrack the array until we find a height less than ours
            // "While the stack top is taller than or equal to the current bar, remove it."
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            // after we pop all the taller/equal heights, the pop is now the closest smaller height on left
            // save its index.
            if (!stack.isEmpty()) {
                leftMost[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        // now we do the same but for the right side
        for (int i = heights.length - 1; i >= 0; i--) {
            // finds the closest smaller bar to the right of each bar.
            rightMost[i] = heights.length;
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                rightMost[i] = stack.peek();
            }
            stack.push(i);
        }
        // now we finally calculate the area and find the max
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            // But the rectangle cannot include those smaller bars.
            // so we adjust the indexes
            leftMost[i]++;
            rightMost[i]--;
            int curWidth = rightMost[i] - leftMost[i] + 1;
            maxArea = Math.max(maxArea, heights[i] * curWidth);
        }

        return maxArea;
    }
}
