class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // stack
        // make an array to pair each cars position and speed
        int[][] pairs = new int[position.length][2];
        for (int i = 0; i < position.length; i++){
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }     

        // since pairs is 2D, we have to define how to sort
        // we sort by postion, furthest car goes first
        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));
        // make a stack to hold in the value of the time it takes to reach the target
        Stack<Double> stack = new Stack<>();
        for (int[] car : pairs) {
            // calculate car speed
            stack.push((double) (target - car[0]) / car[1]);
            // if the speed of the current car is <= the speed of the prev car, it will turn into
            // a fleet
            if (stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)) {
                stack.pop();
            }
        }
        return stack.size();

    }
}
