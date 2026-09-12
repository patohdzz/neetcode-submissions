class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;  // track lowest price so far
        int maxProfit = 0;                // track best profit

        for (int price : prices) {
            // update minimum price if lower found
            if (price < minPrice) {
                minPrice = price;
            }
            // calculate profit if sold today
            int profit = price - minPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }
}
