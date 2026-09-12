class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // how many days you have to wait until you reach a day that is warmer than today
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {

            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // pop the index (represents the amount of days it took to reach a day warmer)
                int prev = stack.pop();
                result[prev] = i - prev;
            }
            stack.push(i);
        }

        return result;
    }
}
