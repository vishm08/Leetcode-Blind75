public int maxProfit (int[] prices) {

    //brute-force - Time:O(n2) - Space: O(1)
    int maxProfit = 0;

    for (int i=0; i<prices.length; i++) {
        for(int j=i+1; j<prices.length; j++) {
            int profit = prices[j] - prices[i];

            if(profit > maxProfit)
                maxProfit = profit;
        }
    }

    return maxProfit;

    //one-pass - Time: O(n) - Space: O(1)
    int minPrice = Integer.MAX_VALUE;
    int maxProfit = 0;

    for (int i=0; i<prices.length; i++) {
        if(prices[i] < minPrice)
            minPrice = prices[i];
        else if(prices[i] - minPrice > maxProfit)
            maxProfit = prices[i] - minPrice;
    }

    return maxProfit;
}